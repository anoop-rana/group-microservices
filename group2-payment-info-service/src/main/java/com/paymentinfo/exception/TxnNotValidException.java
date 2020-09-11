package com.paymentinfo.exception;

public class TxnNotValidException extends RuntimeException {

	private static final long serialVersionUID = -7311582634037510127L;

	public TxnNotValidException(String msg) {
		super(msg);
	}
	
}
