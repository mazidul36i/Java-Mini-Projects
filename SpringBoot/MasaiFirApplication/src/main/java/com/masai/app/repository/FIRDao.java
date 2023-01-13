package com.masai.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.app.model.FIR;

public interface FIRDao extends JpaRepository<FIR, Integer>{

}
