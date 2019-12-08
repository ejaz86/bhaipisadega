package com.devenger.bhaipaisadega.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BPDExceptionHandler {

	@ExceptionHandler({BPDException.class})
	public void handleBPDException(RuntimeException ex) {
		 throw ex;
	}
}
