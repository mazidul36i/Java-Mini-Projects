package com.masai.mail.service;

import com.masai.mail.exception.EmailException;
import com.masai.mail.exception.UserException;
import com.masai.mail.model.Email;
import com.masai.mail.model.User;
import com.masai.mail.repository.EmailDao;
import com.masai.mail.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailDao emailDao;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Override
    public String sendMail(String uuid, List<String> emails, Email email) throws EmailException, UserException {
        User sender = userService.getUserByUuid(uuid);
        List<User> receivers = new ArrayList<>();

        List<String> sentTo = new ArrayList<>();
        List<String> failed = new ArrayList<>();

        for (String receiverEmail : emails) {
            Optional<User> receiver = userDao.findById(receiverEmail);
            if (receiver.isPresent()) {
                receivers.add(receiver.get());
                sentTo.add(receiverEmail);
            } else {
                failed.add(receiverEmail);
            }
        }

        email.setSender(sender);
        email.setReceivers(receivers);
        emailDao.save(email);

        String res = "";
        if (!sentTo.isEmpty()) {
            res += "Email sent successfully to: " + sentTo.toString();
        }
        if (!failed.isEmpty()) {
            res += "\nFailed to sent email to: " + failed.toString();
        }

        return res.trim();
    }

    @Override
    public Email starEmail(String uuid, Integer emailId) throws UserException, EmailException {
        User user = userService.getUserByUuid(uuid);
        Email email = emailDao.findById(emailId).orElseThrow(() -> new EmailException("Email doesn't with the given id!"));

        if (!Objects.equals(user.getEmail(), email.getSender().getEmail()) && !email.getReceivers().contains(user)) {
            throw new UserException("Access denied!");
        }

        user.getStartedEmails().add(email);
        userDao.save(user);
        return email;
    }

    @Override
    public Email deleteEmail(String uuid, Integer emailId) throws EmailException, UserException {
        User user = userService.getUserByUuid(uuid);
        Email email = emailDao.findById(emailId).orElseThrow(() -> new EmailException("Email doesn't with the given id!"));

        if (!Objects.equals(user.getEmail(), email.getSender().getEmail()) && !email.getReceivers().contains(user)) {
            throw new UserException("Access denied!");
        }

        emailDao.deleteById(emailId);
        return email;
    }
}
