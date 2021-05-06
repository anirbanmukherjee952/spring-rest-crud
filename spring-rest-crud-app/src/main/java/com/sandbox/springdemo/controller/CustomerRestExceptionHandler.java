package com.sandbox.springdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// add exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException e){
		
		// create CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(
									HttpStatus.NOT_FOUND.value(),
									e.getMessage(),
									System.currentTimeMillis()
								 );		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	// add another exception handler for any exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception e){
		
		// create CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(
									HttpStatus.BAD_REQUEST.value(),
									e.getMessage(),
									System.currentTimeMillis()
								 );		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
}
