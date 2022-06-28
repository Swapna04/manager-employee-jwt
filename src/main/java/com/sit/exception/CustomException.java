package com.sit.exception;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final ErrorMessages errorCode;

	public CustomException(String message, Throwable e, ErrorMessages errorCode) {
		super(message, e);
		this.errorCode = errorCode;
	}

	public CustomException(String message, ErrorMessages errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public ErrorMessages getErrorCode() {
		return errorCode;
	}

}