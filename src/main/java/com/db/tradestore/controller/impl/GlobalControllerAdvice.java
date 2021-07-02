package com.db.tradestore.controller.impl;

import com.db.tradestore.exception.BadRequestException;
import com.db.tradestore.exception.ExceptionResponse;
import com.db.tradestore.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Gangadi Kiran Kumar
 *
 */
@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

	/*
	 *this function throws 404 status code 
	 */
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException ex) {
		return new ResponseEntity<ExceptionResponse>(
				new ExceptionResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
	}

	/*
	 *this function throws 400 status code 
	 */
	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(BadRequestException ex) {
		return new ResponseEntity<ExceptionResponse>(
				new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
	}
}
