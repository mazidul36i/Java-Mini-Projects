package com.masai.app.exceptions;

public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException() {}
	
	public BookNotFoundException(String msg) {
		super(msg);
	}
	
}
