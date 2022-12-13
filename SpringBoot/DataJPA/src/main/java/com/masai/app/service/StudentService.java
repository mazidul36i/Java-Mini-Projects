package com.masai.app.service;

import java.util.List;

import com.masai.app.exceptions.StudentException;
import com.masai.app.model.Student;
import com.masai.app.model.StudentDTO;

public interface StudentService {

	public Student registerStudent(Student student);
	
	public Student getStudentByRoll(Integer roll) throws StudentException;
	
	public List<Student> getAllStudent() throws StudentException;
	
	public Student deleteStudentByRoll(Integer roll) throws StudentException;
	
	public Student updateStudentDetails(Student student) throws StudentException;
	
	public List<Student> getStudentsByName(String name) throws StudentException;
	
	public String getNameByRoll(Integer roll) throws StudentException;
	
	public List<StudentDTO> getStudentDTOByName(String name) throws StudentException;
}
