package com.masai.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountNo;
	@NotNull(message = "Name is mandatory!")
	private String name;
	@NotNull(message = "Address is mandatory!")
	private String address;
	@NotNull(message = "Email is mandatory!")
	private String email;
	@NotNull(message = "Balance is mandatory!")
	@Min(value = 10000, message = "Opening balance must be at least 10000")
	private Integer balance;
	@NotNull(message = "Mobile is mandatory!")
	private String mobile;

}
