package com.masai.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.app.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

	Optional<User> findByMobileNumber(String mobileNumber);
	
}
