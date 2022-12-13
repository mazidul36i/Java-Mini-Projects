package com.masai.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.model.Student;

import jakarta.validation.Valid;

@RestController
public class MyController {

	List<Student> students = new ArrayList<>();
	
	@PostMapping("/students")
	public ResponseEntity<String> registerStudent(@Valid @RequestBody Student student) {
		
		students.add(student);
		return new ResponseEntity<String>("Student registered successfully!", HttpStatus.ACCEPTED);
		
	}
	
	
}
