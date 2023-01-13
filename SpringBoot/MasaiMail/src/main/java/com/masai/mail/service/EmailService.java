package com.masai.mail.service;

import com.masai.mail.exception.EmailException;
import com.masai.mail.exception.UserException;
import com.masai.mail.model.Email;

import java.util.List;

public interface EmailService {

    public String sendMail(String uuid, List<String> emails, Email email) throws EmailException, UserException;

    public Email starEmail(String uuid, Integer emailId) throws UserException, EmailException;

    public Email deleteEmail(String uuid, Integer emailId) throws EmailException, UserException;

}
