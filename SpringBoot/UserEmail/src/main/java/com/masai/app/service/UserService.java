package com.masai.app.service;

import java.util.List;

import com.masai.app.exception.UserException;
import com.masai.app.model.User;

public interface UserService {

	User createUser(User user) throws UserException;
	
	User getUser(Integer id) throws UserException;
	
	List<User> getAllUsers() throws UserException;
	
	User deleteUser(Integer id) throws UserException;
}
