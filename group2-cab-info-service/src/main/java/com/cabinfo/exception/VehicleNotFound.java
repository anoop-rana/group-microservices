package com.cabinfo.exception;

public class VehicleNotFound extends RuntimeException {

	private static final long serialVersionUID = 982665641586385862L;

	public VehicleNotFound(String message) {
		super(message);
	}

}
