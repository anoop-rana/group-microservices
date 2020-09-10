package com.userinfo.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7311582634037510127L;

	public UserNotFoundException(String msg) {
		super(msg);
	}
	
}
