package com.masai.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.app.model.Email;

public interface EmailDao extends JpaRepository<Email, Integer>{

	Optional<Email> findByEmail(String email);
	
}
