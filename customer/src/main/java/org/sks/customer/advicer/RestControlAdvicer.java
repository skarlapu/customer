package org.sks.customer.advicer;

import org.sks.customer.exception.ExceptionMessage;
import org.sks.customer.exception.NoRecordFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControlAdvicer {
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> handleNOCustomerFoundException(NoRecordFoundException exception) {
		return new ResponseEntity<ExceptionMessage>(
				new ExceptionMessage(302, 302, exception.getMessage(), exception.getMessage()), HttpStatus.OK);
	}
}
