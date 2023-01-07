package com.masai.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdatePassDTO {

	private String email;
	private String oldPassword;
	private String newPassword;
	
}
