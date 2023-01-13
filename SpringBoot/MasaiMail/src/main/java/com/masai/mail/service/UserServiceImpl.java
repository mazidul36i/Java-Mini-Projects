package com.masai.mail.service;

import com.masai.mail.exception.EmailException;
import com.masai.mail.exception.UserException;
import com.masai.mail.model.CurrentUserSession;
import com.masai.mail.model.Email;
import com.masai.mail.model.User;
import com.masai.mail.model.UserDTO;
import com.masai.mail.repository.CurrentUserSessionDao;
import com.masai.mail.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CurrentUserSessionDao sessionDao;

    @Override
    public User register(User user) throws UserException {
        Optional<User> optionalUser = userDao.findById(user.getEmail());
        if (optionalUser.isPresent())
            throw new UserException("Someone already claimed that email.\nPlease with a different email!");
        return userDao.save(user);
    }

    @Override
    public User getUserByUuid(String uuid) throws UserException {
        CurrentUserSession session = sessionDao.findById(uuid).orElseThrow(() -> new UserException("Invalid authentication!"));
        return userDao.findById(session.getEmail()).orElseThrow(() -> new UserException("Invalid credential!"));
    }

    @Override
    public User updateUser(String uuid, UserDTO userDTO) throws UserException {
        User savedUser = getUserByUuid(uuid);
        if (userDTO.getFirstName() != null)
            savedUser.setFirstName(userDTO.getFirstName());
        if (userDTO.getLastName() != null)
            savedUser.setLastName(userDTO.getLastName());
        if (userDTO.getMobileNumber() != null)
            savedUser.setMobileNumber(userDTO.getMobileNumber());
        if (userDTO.getDateOfBirth() != null)
            savedUser.setDateOfBirth(userDTO.getDateOfBirth());
        if (userDTO.getPassword() != null)
            savedUser.setPassword(userDTO.getPassword());

        return userDao.save(savedUser);
    }

    @Override
    public List<Email> getAllEmails(String uuid) throws UserException, EmailException {
        User user = getUserByUuid(uuid);
        List<Email> emails = user.getReceivedEmails();
        emails.addAll(user.getSentEmails());

        emails.sort((e1, e2) -> {
            Duration duration = Duration.between(e1.getDatetime(), e2.getDatetime());
            return duration.toSecondsPart();
        });

        return emails;
    }

    @Override
    public List<Email> getStaredEmails(String uuid) throws UserException, EmailException {
        User user = getUserByUuid(uuid);
        return user.getStartedEmails();
    }
}
