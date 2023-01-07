package com.masai.app.service;

import com.masai.app.exception.EmailException;
import com.masai.app.exception.UserException;
import com.masai.app.model.Email;

public interface EmailService {

	Email createEmail(Integer userId, Email email) throws EmailException;
	
	Email getEmail(Integer userId, String email) throws UserException, EmailException;
}
