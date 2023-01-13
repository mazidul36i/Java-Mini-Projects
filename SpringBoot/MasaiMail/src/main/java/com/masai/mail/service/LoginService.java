package com.masai.mail.service;

import com.masai.mail.exception.LoginException;
import com.masai.mail.model.CurrentUserSession;
import com.masai.mail.model.LoginDTO;

public interface LoginService {

    public CurrentUserSession login(LoginDTO loginDTO) throws LoginException;

    public String logout(String uuid) throws LoginException;

}
