package com.masai.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.app.model.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer>{

	
	
}
