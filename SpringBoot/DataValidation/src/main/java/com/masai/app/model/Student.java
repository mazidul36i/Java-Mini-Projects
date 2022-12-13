package com.masai.app.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Student {

	@NotNull(message = "{roll.null}")
	private Integer roll;
	@NotNull(message = "Name is mandatory!")
	@NotBlank(message = "Please enter a valid name!")
//	@NotEmpty(message = "Please enter a valid name!")
	@Size(min=3, max=20, message = "Name length must be in 3-20 characters!")
	private String name;
	private String address;
	@NotNull(message = "Email is mandatory!")
	@Email(message = "Invalid email!")
	private String email;
	
	public Integer getRoll() {
		return roll;
	}
	public void setRoll(Integer roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
