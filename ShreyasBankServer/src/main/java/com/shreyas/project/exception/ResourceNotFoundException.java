package com.shreyas.project.exception;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**@Author Shreyas Purkar */

@ControllerAdvice
public class ResourceNotFoundException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler( value = {NoSuchElementException.class, SQLException.class})
	public ResponseEntity<Object> handleError(RuntimeException ex, WebRequest req) {
		String message = "Error!No Such Element Found.";
		return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.NOT_FOUND, req);
	}
}
