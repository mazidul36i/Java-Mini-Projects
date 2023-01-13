package com.masai.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.app.model.CurrentUserSession;

public interface CurrentSessionDao extends JpaRepository<CurrentUserSession, String> {

}
