package com.masai.app.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MyErrorDetails {

	private String timestamp = LocalDateTime.now().toString();
	private String message;
	private String details;

}
