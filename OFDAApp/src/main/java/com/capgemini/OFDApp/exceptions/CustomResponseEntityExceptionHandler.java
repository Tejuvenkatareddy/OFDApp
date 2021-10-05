package com.capgemini.OFDApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javassist.tools.rmi.RemoteException;



@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectException(CartIdException ex, WebRequest request){
		CartIdExceptionResponse exceptionResponse = new CartIdExceptionResponse(ex.getMessage());
		return new ResponseEntity <Object> (exceptionResponse, HttpStatus.BAD_REQUEST);
	
	}
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectException(OrderIdException ex, WebRequest request){
		OrderIdExceptionResponse exceptionResponse = new OrderIdExceptionResponse(ex.getMessage());
		return new ResponseEntity <Object> (exceptionResponse, HttpStatus.BAD_REQUEST);
	
	}
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectException(ItemIdException ex, WebRequest request){
		ItemIdExceptionResponse exceptionResponse = new ItemIdExceptionResponse(ex.getMessage());
		return new ResponseEntity <Object> (exceptionResponse, HttpStatus.BAD_REQUEST);
	
	}
	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectException(RestaurantIdIdException ex, WebRequest request){
		RestaurantIdExceptionResponse exceptionResponse = new RestaurantIdExceptionResponse(ex.getMessage());
		return new ResponseEntity <Object> (exceptionResponse, HttpStatus.BAD_REQUEST);
	
	}
	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectException(CategoryIdException ex, WebRequest request){
		CategoryIdExceptionResponse exceptionResponse = new CategoryIdExceptionResponse(ex.getMessage());
		return new ResponseEntity <Object> (exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectException(CustomerIdException ex, WebRequest request){
		CustomerIdExceptionResponse exceptionResponse = new CustomerIdExceptionResponse(ex.getMessage());
		return new ResponseEntity <Object> (exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
}