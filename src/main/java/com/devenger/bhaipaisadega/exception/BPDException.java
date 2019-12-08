package com.devenger.bhaipaisadega.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED)
public class BPDException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	public BPDException(String message) {
		super(message);
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
