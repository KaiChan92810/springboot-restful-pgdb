package com.example.demo.exception;

import java.util.Date;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorResponse {
	@ExceptionHandler(MethodArgumentNotValidException.class) // catch MethodArgumentNotValidException
	public ResponseEntity<ErrorMessage> methodArgument(MethodArgumentNotValidException ex, WebRequest request) {
		String errorMsg = ex.getBindingResult().getFieldErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).findFirst().orElse(ex.getMessage());
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), errorMsg);
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}
}
