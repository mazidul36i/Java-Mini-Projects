package com.masai.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.model.Student;
import com.masai.app.model.StudentDTO;
import com.masai.app.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService sService;
	
	@PostMapping("/students")
	public ResponseEntity<Student> registerStudentHandler(@RequestBody Student student) {
		Student savedStudent = sService.registerStudent(student);
		return new ResponseEntity<Student>(savedStudent, HttpStatus.ACCEPTED);
	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudentListHandler() {
		List<Student> students = sService.getAllStudent();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentByRollHandler(@PathVariable("roll") Integer roll) {
		Student student = sService.getStudentByRoll(roll);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@DeleteMapping("/students/{roll}")
	public ResponseEntity<Student> deleteStudentByRollHandler(@PathVariable("roll") Integer roll) {
		Student student = sService.deleteStudentByRoll(roll);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudentByRollHandler(@RequestBody Student student) {
		Student updatedStudent = sService.updateStudentDetails(student);
		return new ResponseEntity<Student>(updatedStudent, HttpStatus.OK);
	}
	
	@GetMapping("/students/search")
	public ResponseEntity<List<Student>> getStudentListByNameHandler(@RequestParam("name") String name) {
		List<Student> students = sService.getStudentsByName(name);
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	@GetMapping("/students/name/{roll}")
	public ResponseEntity<String> getStudentNameByRollHandler(@PathVariable("roll") Integer roll) {
		String name = sService.getNameByRoll(roll);
		return new ResponseEntity<String>(name, HttpStatus.OK);
	}
	
	@GetMapping("/studentsDTO/{name}")
	public ResponseEntity<List<StudentDTO>> getStudentDTOByNameHandler(@PathVariable("name") String name) {
		List<StudentDTO> studentDTOs = sService.getStudentDTOByName(name);
		return new ResponseEntity<List<StudentDTO>>(studentDTOs, HttpStatus.OK);
	}
	
}
