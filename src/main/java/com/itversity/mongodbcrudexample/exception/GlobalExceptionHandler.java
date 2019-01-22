package com.itversity.mongodbcrudexample.exception;

/*
 * GlobalExceptionHandler will handle the exception which are marked in its method using ExceptionHadler method. 
 * It is a ControllerAdvice so will be used by all the controllers whenever that particular exception is thrown.
 */
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(OrderNotPresentException.class)
	public ResponseEntity<MongoDBCrudMessage> customExceptionHandler(
			OrderNotPresentException orderNotPresentException) {

		return new ResponseEntity<>(
				new MongoDBCrudMessage(orderNotPresentException.getErrorCode(), orderNotPresentException.getMessage()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<MongoDBCrudMessage> customIllegalArgumentExceptionHandler(
			IllegalArgumentException illegalArgumentException) {

		return new ResponseEntity<>(
				new MongoDBCrudMessage(MessageCode.ARGUMENT_MISMATCH, illegalArgumentException.getMessage()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseEntity<MongoDBCrudMessage> customDuplicateKeyEntryExceptionHandler(
			DuplicateKeyException duplicateKeyException) {

		return new ResponseEntity<>(
				new MongoDBCrudMessage(MessageCode.DUPLICATE_KEY_ENTRY, duplicateKeyException.getMessage()),
				HttpStatus.BAD_REQUEST);
	}
}
