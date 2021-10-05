package com.capgemini.OFDApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * The OrderIdException class is a custom exception extends Runtime Exception
 * throws exception related to OrderId during the Runtime
 * @author Sreeraj R
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrderIdException extends RuntimeException{
 
	
private static final long serialVersionUID = 0;
	
	public OrderIdException() {
		super();
	}
	
	public OrderIdException(String message) {
		super(message);
	}
}
