package com.masai.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.app.model.Student;
import com.masai.app.model.StudentDTO;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{
	
	public List<Student> findByName(String name);
	
	@Query("SELECT s.name from Student s WHERE s.roll = :roll") // s.roll = ?1
	public String getStudentNameByRoll(@Param("roll") Integer roll);
	
	@Query("SELECT new com.masai.app.model.StudentDTO(s.name, s.roll) FROM Student s WHERE name= :name")
	public List<StudentDTO> getStudentDTOByName(@Param("name") String name);
}
