package com.masai.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.exceptions.StudentException;
import com.masai.app.model.Student;
import com.masai.app.model.StudentDTO;
import com.masai.app.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao sdao;
	
	@Override
	public Student registerStudent(Student student) {
		return sdao.save(student);
	}

	@Override
	public Student getStudentByRoll(Integer roll) throws StudentException {
		return sdao.findById(roll).orElseThrow(() -> new StudentException("Stduent not found with roll: " + roll));
	}

	@Override
	public List<Student> getAllStudent() throws StudentException {
		List<Student> slist = sdao.findAll();
		if (slist.size() == 0) throw new StudentException("No student found to be load");
		return slist;
	}

	@Override
	public Student deleteStudentByRoll(Integer roll) throws StudentException {
		Student student = sdao.findById(roll).orElseThrow(() -> new StudentException("Stduent not found with roll: " + roll));
		sdao.deleteById(roll);
		return student;
	}

	@Override
	public Student updateStudentDetails(Student student) throws StudentException {
		Optional<Student> opt = sdao.findById(student.getRoll());
		if (opt.isPresent()) {
			return sdao.save(student);
		} else throw new StudentException("Invalid student details..");
	}

	@Override
	public List<Student> getStudentsByName(String name) throws StudentException {
		List<Student> students = new ArrayList<>();
		students = sdao.findByName(name);
		if (students.isEmpty()) throw new StudentException("No student found to be load");
		return students;
		
	}
 
	@Override
	public String getNameByRoll(Integer roll) throws StudentException {
		String name = sdao.getStudentNameByRoll(roll);
		if (name != null) return name;
		throw new StudentException("No student found with roll: " + roll);
	}

	@Override
	public List<StudentDTO> getStudentDTOByName(String name) throws StudentException {
		List<StudentDTO> studentDTOs = sdao.getStudentDTOByName(name);
		if (studentDTOs.isEmpty()) throw new StudentException("No student exists with name: " + name);
		return studentDTOs;
	}	

}
