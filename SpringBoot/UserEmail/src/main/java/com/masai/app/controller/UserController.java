package com.masai.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.model.Email;
import com.masai.app.model.User;
import com.masai.app.service.EmailService;
import com.masai.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping
	public ResponseEntity<User> createUserHandler(@RequestBody User user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserHandler(@PathVariable("id") Integer id) {
		return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsersHandler() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUserHandler(@PathVariable("id") Integer id) {
		return new ResponseEntity<User>(userService.deleteUser(id), HttpStatus.OK);
	}
	
	@PostMapping("/{id}/mail")
	public ResponseEntity<Email> createEmailHandler(@PathVariable("id") Integer id, @RequestBody Email email) {
		return new ResponseEntity<>(emailService.createEmail(id, email), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}/mail/{mail_id}")
	public ResponseEntity<Email> getEmailHandler(@PathVariable("id") Integer id, @PathVariable("mail_id") String emailId) {
		return new ResponseEntity<>(emailService.getEmail(id, emailId), HttpStatus.OK);
	}
}
