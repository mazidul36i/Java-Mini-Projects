package com.masai.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.model.CurrentUserSession;
import com.masai.app.model.LoginDTO;
import com.masai.app.service.LoginService;

@RestController
@RequestMapping("/masaifir/user")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> loginHandler(@RequestBody LoginDTO loginDTO) {
		return new ResponseEntity<CurrentUserSession>(loginService.login(loginDTO), HttpStatus.OK);
	}

	@PostMapping("/logout")
	public ResponseEntity<String> logoutHandler(@RequestParam("uuid") String uuid) {
		return new ResponseEntity<>(loginService.logout(uuid), HttpStatus.OK);
	}

}
