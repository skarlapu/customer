package org.sks.customer.exception;

import org.springframework.stereotype.Component;

@Component
public class ExceptionMessage {
	private String errorMessage;
	private int errorMessageCode;
	private String description;
	private int statusCode;

	public ExceptionMessage(int errorMessageCode, int statusCode, String errorMessage, String description) {
		this.description = description;
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
		this.errorMessageCode = errorMessageCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorMessageCode() {
		return errorMessageCode;
	}

	public void setErrorMessageCode(int errorMessageCode) {
		this.errorMessageCode = errorMessageCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
