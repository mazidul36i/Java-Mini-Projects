package com.masai.app.exception;

public class InsufficientFundException extends AccountException {

	public InsufficientFundException() {
		super();
	}

	public InsufficientFundException(String message) {
		super(message);
	}

}
