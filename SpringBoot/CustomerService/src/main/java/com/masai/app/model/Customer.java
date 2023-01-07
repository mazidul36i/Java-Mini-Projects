package com.masai.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	@NotNull(message = "Customer name is mandatory!")
	@Size(min = 3, max = 10, message = "Name must be between 3 to 10 characters!")
	private String customerName;
	@NotNull(message = "Address is mandatory!")
	@Size(min = 3, max = 15, message = "Address must be between 3 to 15 characters!")
	private String address;
	@Min(value = 18, message = "You must be at least 18 years old!")
	@NotNull(message = "Age is mandatory!")
	private Integer age;
	@Column(unique = true)
	@NotNull(message = "Email is mandatory!")
	@Email(message = "Invalid email format!")
	private String email;
	@NotNull(message = "Mobile is mandatory!")
	@Size(min = 10, max = 10, message = "Invalid phone number!")
	private String mobile;
	@NotNull(message = "Password is mandatory!")
	@Size(min = 8, max = 15, message = "Password must be between 8 to 15 characters!")
	private String password;

}
