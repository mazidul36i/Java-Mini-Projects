package com.masai.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.model.User;
import com.masai.app.service.UserService;

@RestController
@RequestMapping("/masaifir/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUserHandler(@RequestBody @Valid User user) {
		return new ResponseEntity<User>(userService.register(user), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<User> getUserHandler(@RequestParam("uuid") String uuid) {
		return new ResponseEntity<User>(userService.getUserByUuid(uuid), HttpStatus.OK);
	}
	
}
