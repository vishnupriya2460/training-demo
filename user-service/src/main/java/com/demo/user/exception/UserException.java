package com.demo.user.exception;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = 3291473686813059267L;

	public String message;

	public UserException() {
		super();
	}

	public UserException(String message) {
		super(message);
		this.message = message;
	}
}
