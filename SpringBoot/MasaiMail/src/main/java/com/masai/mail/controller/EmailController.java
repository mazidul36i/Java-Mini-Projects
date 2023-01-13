package com.masai.mail.controller;

import com.masai.mail.model.Email;
import com.masai.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/masaimail")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/mail")
    public ResponseEntity<String> sendEmailHandler(@RequestParam("uuid") String uuid, @RequestParam("receivers") List<String> emails, @RequestBody Email email) {
        return new ResponseEntity<>(emailService.sendMail(uuid, emails, email), HttpStatus.OK);
    }

    @PostMapping("/starred/{id}")
    public ResponseEntity<Email> starredEmailHandler(@RequestParam("uuid") String uuid, @PathVariable("id") Integer id) {
        return new ResponseEntity<>(emailService.starEmail(uuid, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Email> deleteEmailHandler(@RequestParam("uuid") String uuid, @PathVariable("id") Integer id) {
        return new ResponseEntity<>(emailService.deleteEmail(uuid, id), HttpStatus.OK);
    }

}
