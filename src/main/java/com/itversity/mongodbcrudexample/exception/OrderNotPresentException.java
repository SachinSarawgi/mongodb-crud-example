package com.itversity.mongodbcrudexample.exception;
/*
 * OrderNotPresentException is a custom exception which is thrown when the Order with received id is not present in DB.
 */

public class OrderNotPresentException extends RuntimeException {

	private static final long serialVersionUID = 823185007299341292L;

	public MessageCode errorCode;
	public String message;

	public OrderNotPresentException() {
	}

	public OrderNotPresentException(MessageCode errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public MessageCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(MessageCode errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}

	@Override
	public String toString() {
		return "CustomException [errorCode=" + errorCode + ", message=" + message + "]";
	}

}
