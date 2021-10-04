package com.capgemini.OFDApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The CartIdException class is a custom exception extends Runtime Exception
 * throws exception related to CartId during the Runtime
 * @author Sreeraj R
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CartIdException extends RuntimeException {

	private static final long serialVersionUID = 0;
	
	public CartIdException() {
		super();
	}
	
	public CartIdException(String message) {
		super(message);
	}
}
