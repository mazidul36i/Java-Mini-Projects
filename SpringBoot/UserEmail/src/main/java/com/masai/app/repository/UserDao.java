package com.masai.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.app.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
