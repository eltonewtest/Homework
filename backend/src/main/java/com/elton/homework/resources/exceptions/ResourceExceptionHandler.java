package com.elton.homework.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;import org.springframework.web.bind.annotation.RequestMapping;

import com.elton.homework.services.exceptions.DatabaseException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandarError> entityNotFound(DatabaseException e, HttpServletRequest httpServletRequest){
		StandarError error = new StandarError();
		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setError("Resource not found");
		error.setMessage(e.getMessage());
		error.setPath(httpServletRequest.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
