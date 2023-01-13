package com.masai.mail.controller;

import com.masai.mail.model.CurrentUserSession;
import com.masai.mail.model.LoginDTO;
import com.masai.mail.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/masaimail")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<CurrentUserSession> loginHandler(@RequestBody @Valid LoginDTO loginDTO) {
        return new ResponseEntity<>(loginService.login(loginDTO), HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutHandler(@RequestParam String uuid) {
        return new ResponseEntity<>(loginService.logout(uuid), HttpStatus.OK);
    }

}
