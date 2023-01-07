package com.masai.app.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 
	private String name;
	private String phoneNo;
	private LocalDate dateOfBirth;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private Email email;
	
}
