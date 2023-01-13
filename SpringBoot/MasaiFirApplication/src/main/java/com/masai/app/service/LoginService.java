package com.masai.app.service;

import com.masai.app.exception.LoginException;
import com.masai.app.exception.UserException;
import com.masai.app.model.CurrentUserSession;
import com.masai.app.model.LoginDTO;

public interface LoginService {

	CurrentUserSession login(LoginDTO loginDTO) throws UserException;

	String logout(String uuid) throws LoginException;

}
