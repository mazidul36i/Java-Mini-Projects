package com.masai.mail.controller;

import com.masai.mail.model.Email;
import com.masai.mail.model.User;
import com.masai.mail.model.UserDTO;
import com.masai.mail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/masaimail")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerHandler(@RequestBody @Valid User user) {
        return new ResponseEntity<>(userService.register(user), HttpStatus.CREATED);
    }

    @GetMapping("/mail")
    public ResponseEntity<List<Email>> getAllEmailsHandler(@RequestParam("uuid") String uuid) {
        return new ResponseEntity<>(userService.getAllEmails(uuid), HttpStatus.OK);
    }

    @GetMapping("/starred")
    public ResponseEntity<List<Email>> getAllStarredEmailsHandler(@RequestParam("uuid") String uuid) {
        return new ResponseEntity<>(userService.getStaredEmails(uuid), HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<User> userUpdateHandler(@RequestBody UserDTO userDTO, @RequestParam("uuid") String uuid) {
        return new ResponseEntity<>(userService.updateUser(uuid, userDTO), HttpStatus.OK);
    }

}
