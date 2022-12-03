package org.sks.customer.exception;

public class NoRecordFoundException extends RuntimeException {
	private static final long serialVersionUID = 4651051715984075475L;

	public NoRecordFoundException(String msg) {
		super(msg);
	}
}
