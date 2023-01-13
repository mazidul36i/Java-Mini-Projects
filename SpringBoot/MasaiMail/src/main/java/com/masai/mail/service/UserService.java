package com.masai.mail.service;

import com.masai.mail.exception.EmailException;
import com.masai.mail.exception.UserException;
import com.masai.mail.model.Email;
import com.masai.mail.model.User;
import com.masai.mail.model.UserDTO;

import java.util.List;

public interface UserService {

    public User register(User user) throws UserException;

    public User getUserByUuid(String uuid) throws UserException;

    public User updateUser(String uuid, UserDTO userDTO) throws UserException;

    public List<Email> getAllEmails(String uuid) throws UserException, EmailException;

    public List<Email> getStaredEmails(String uuid) throws UserException, EmailException;

}
