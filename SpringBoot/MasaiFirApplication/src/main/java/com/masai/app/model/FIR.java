package com.masai.app.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class FIR {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String crimeDetail;
	private LocalDateTime timeStamp;
	private String policeStation;
	
	@JsonIgnore
	@ManyToOne
	private User user;

}
