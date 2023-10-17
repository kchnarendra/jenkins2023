package com.narendra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BookIdNotAvailableException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	

	public BookIdNotAvailableException() {
		super();
	}
	
	public BookIdNotAvailableException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "BookIdNotAvailableException [message=" + message + "]";
	}
	
}