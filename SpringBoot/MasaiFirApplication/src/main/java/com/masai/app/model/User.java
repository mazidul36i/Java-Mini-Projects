package com.masai.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Pattern(regexp = "[a-zA-Z ]*", message = "First Name must contain only alphabetic characters and spaces!")
	private String firstName;
	@Pattern(regexp = "[a-zA-Z ]*", message = "Last Name must contain only alphabetic characters and spaces!")
	private String lastName;
	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile Number must contain exactly 10 digits!")
	@Column(unique = true)
	private String mobileNumber;
	private String address;
	@Min(value = 8, message = "Age must be 8 years or above!")
	private Integer age;
	@Pattern(regexp = "(male|female|transgender)", message = "Gender must be either male or female or transgender!")
	private String gender;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,12}$", message = "Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit.")
	private String password;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<FIR> firs;

}
