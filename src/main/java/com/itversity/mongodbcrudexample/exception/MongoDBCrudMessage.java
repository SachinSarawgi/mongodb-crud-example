package com.itversity.mongodbcrudexample.exception;

/*
 * MongoDBCrudMessage will be used as a custom message which will be used to send response in case of exception 
 * or some other specific case.
 */

public class MongoDBCrudMessage {

	private MessageCode errorCode;
	private String message;

	public MongoDBCrudMessage(MessageCode errorCode, String message) {
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
	public String toString() {
		return "MongoDBCrudMessage [errorCode=" + errorCode + ", message=" + message + "]";
	}
}
