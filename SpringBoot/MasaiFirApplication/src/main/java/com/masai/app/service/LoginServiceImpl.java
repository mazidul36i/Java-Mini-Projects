package com.masai.app.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.exception.LoginException;
import com.masai.app.exception.UserException;
import com.masai.app.model.CurrentUserSession;
import com.masai.app.model.LoginDTO;
import com.masai.app.model.User;
import com.masai.app.repository.CurrentSessionDao;
import com.masai.app.repository.UserDao;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CurrentSessionDao sessionDao;

	@Autowired
	private UserDao userDao;

	@Override
	public CurrentUserSession login(LoginDTO loginDTO) throws UserException {
		User user = userDao.findByMobileNumber(loginDTO.getMobileNumber())
				.orElseThrow(() -> new UserException("User doesn't found with the mobile number!"));
		if (!user.getPassword().equals(loginDTO.getPassword()))
			throw new UserException("Wrong password!");
		CurrentUserSession session = new CurrentUserSession();
		session.setUserId(user.getId());
		session.setUuid(UUID.randomUUID().toString());
		return sessionDao.save(session);
	}

	@Override
	public String logout(String uuid) throws LoginException {
		sessionDao.findById(uuid).orElseThrow(() -> new LoginException("Invalid operation!"));
		sessionDao.deleteById(uuid);
		return "Logged out successfully!";
	}

}
