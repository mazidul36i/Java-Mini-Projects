package com.masai.app.service;

import com.masai.app.exception.UserException;
import com.masai.app.model.User;

public interface UserService {

	User register(User user) throws UserException;

	User getUserByUuid(String uuid) throws UserException;

}
