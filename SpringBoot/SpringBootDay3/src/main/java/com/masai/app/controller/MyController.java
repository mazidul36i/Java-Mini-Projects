package com.masai.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.bean.Student;
import com.masai.app.exceptions.InvalidRollException;

import jakarta.annotation.PostConstruct;

@RestController
public class MyController {

	List<Student> studentsList = new ArrayList<>();
	
	@PostConstruct
	public void load() {
		studentsList.add(new Student(1, "Mazidul", "Barpeta Road"));
		studentsList.add(new Student(2, "Johirul", "Kokila"));
		studentsList.add(new Student(3, "Shohel", "Barpeta"));
		studentsList.add(new Student(4, "Fredi", "Dubai"));
		studentsList.add(new Student(5, "Amit", "Pune"));
	}
	
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentHandler(@PathVariable Integer roll) {
		Student student = null;
		for (Student st: studentsList) {
			if (st.getRoll() == roll) {
				student = st;
			}
		}
		if (student != null) {
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} else 
			throw new InvalidRollException("Student does not exists with roll number: " + roll);
		
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentHandler() {		
		return new ResponseEntity<List<Student>>(studentsList, HttpStatus.OK);
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudentHandler(@RequestBody Student student) {
		if (student == null) {
			throw new InvalidRollException("Cannot store empty student!");
		}
		
		for (Student std: studentsList) {
			if (std.getRoll() == student.getRoll()) {
				throw new InvalidRollException("A student alredy exists with roll number: " + std.getRoll());
			}
		}
		
		studentsList.add(student);
		
		HttpHeaders hh = new HttpHeaders();
		hh.add("auth", "jwttoken");
		
		return new ResponseEntity<Student>(student, hh, HttpStatus.CREATED);
	}
	
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudentHanlder(@RequestBody Student student) {
		if (student == null) {
			throw new InvalidRollException("Cannot update empty student!");
		}
		
		for (Student std: studentsList) {
			if (std.getRoll() == student.getRoll()) {
				std.setName(student.getName());
				std.setAddress(student.getAddress());
			}
		}
		
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@DeleteMapping("/students/{roll}")
	public ResponseEntity<String> deleteStudentHandler(@PathVariable("roll") Integer roll) {
		if (roll == null) {
			throw new InvalidRollException("Requied student roll number to be deleted!");
		}
		
		for (int i = 0; i < studentsList.size(); i++) {
			if (studentsList.get(i).getRoll() == roll) {
				studentsList.remove(i);
				return new ResponseEntity<String>("Student deleted successfully", HttpStatus.OK);
			}
		}

		throw new InvalidRollException("Student does not exists with roll number: " + roll);
	}
	
}
