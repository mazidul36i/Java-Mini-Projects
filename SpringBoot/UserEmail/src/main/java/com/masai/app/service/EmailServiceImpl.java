package com.masai.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.exception.EmailException;
import com.masai.app.exception.UserException;
import com.masai.app.model.Email;
import com.masai.app.model.User;
import com.masai.app.repository.EmailDao;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailDao emailDao;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Email createEmail(Integer userId, Email email) throws EmailException {
		Optional<Email> check = emailDao.findByEmail(email.getEmail());
		if (check.isPresent()) throw new EmailException("The given email already exists!");		
		
		User user = userService.getUser(userId);
		if (user.getEmail() != null) throw new EmailException("You have already created an email!");
		email.setUser(user);
		return emailDao.save(email);
	}

	@Override
	public Email getEmail(Integer userId, String email) throws UserException, EmailException {
		User user = userService.getUser(userId);
		if (user.getEmail() == null) throw new EmailException("No email created for the user with id: " + userId);
		return user.getEmail();
	}

}
