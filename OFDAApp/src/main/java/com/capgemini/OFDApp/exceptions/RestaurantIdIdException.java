package com.capgemini.OFDApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RestaurantIdIdException extends RuntimeException{
 
	
private static final long serialVersionUID = 0;
	
	public RestaurantIdIdException() {
		super();
	}
	
	public RestaurantIdIdException(String message) {
		super(message);
	}
}
