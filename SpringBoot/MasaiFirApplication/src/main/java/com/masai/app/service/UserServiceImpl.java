package com.masai.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.exception.UserException;
import com.masai.app.model.CurrentUserSession;
import com.masai.app.model.User;
import com.masai.app.repository.CurrentSessionDao;
import com.masai.app.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	CurrentSessionDao sessionDao;

	@Override
	public User register(User user) throws UserException {
		Optional<User> check = userDao.findByMobileNumber(user.getMobileNumber());
		if (check.isPresent())
			throw new UserException("An user already exists with the given mobile number!");
		return userDao.save(user);
	}

	@Override
	public User getUserByUuid(String uuid) throws UserException {
		CurrentUserSession session = sessionDao.findById(uuid).orElseThrow(() -> new UserException("Invalid operation!"));
		return userDao.findById(session.getUserId()).orElseThrow(() -> new UserException("Invalid operation!"));
	}

}
