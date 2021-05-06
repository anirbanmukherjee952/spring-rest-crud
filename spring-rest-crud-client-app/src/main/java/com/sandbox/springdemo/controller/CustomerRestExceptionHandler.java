package com.sandbox.springdemo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// add exception handler for CustomerNotFoundException
	@ExceptionHandler
	public String handleException(CustomerNotFoundException e){	
		return "customer-not-found";
	}
	
	// add another exception handler for any exception
	@ExceptionHandler
	public String handleException(Exception e){	
		return "bad-request";
	}
	
}
