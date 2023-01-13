package com.masai.mail.service;

import com.masai.mail.exception.LoginException;
import com.masai.mail.model.CurrentUserSession;
import com.masai.mail.model.LoginDTO;
import com.masai.mail.model.User;
import com.masai.mail.repository.CurrentUserSessionDao;
import com.masai.mail.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private CurrentUserSessionDao sessionDao;

    @Autowired
    private UserDao userDao;

    @Override
    public CurrentUserSession login(LoginDTO loginDTO) throws LoginException {
        User user = userDao.findById(loginDTO.getEmail()).orElseThrow(() -> new LoginException("User doesn't exists with the given email!"));
        if (!Objects.equals(user.getPassword(), loginDTO.getPassword())) throw new LoginException("Wrong password!");
        CurrentUserSession session = new CurrentUserSession();
        session.setUuid(UUID.randomUUID().toString());
        session.setEmail(user.getEmail());
        session.setDatetime(LocalDateTime.now());

        return sessionDao.save(session);
    }

    @Override
    public String logout(String uuid) throws LoginException {
        Optional<CurrentUserSession> session = sessionDao.findById(uuid);
        if (session.isEmpty()) throw new LoginException("Invalid operation!");
        sessionDao.deleteById(uuid);
        return "Logged out successfully!";
    }

}
