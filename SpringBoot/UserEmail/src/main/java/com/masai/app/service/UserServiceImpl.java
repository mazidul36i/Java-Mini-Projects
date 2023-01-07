package com.masai.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.exception.UserException;
import com.masai.app.model.User;
import com.masai.app.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User createUser(User user) throws UserException {
		return userDao.save(user);
	}

	@Override
	public User getUser(Integer id) throws UserException {
		return userDao.findById(id).orElseThrow(() -> new UserException("User doesn't exist with id: " + id));
	}

	@Override
	public List<User> getAllUsers() throws UserException {
		List<User> users = userDao.findAll();
		if (users.isEmpty()) throw new UserException("No users found to load!");
		return users;
	}

	@Override
	public User deleteUser(Integer id) throws UserException {
		User user = userDao.findById(id).orElseThrow(() -> new UserException("User doesn't exist with id: " + id));
		userDao.delete(user);
		return user;
	}

}
