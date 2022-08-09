package com.cookbook.be.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cookbook.be.exception.CustomException;
import com.cookbook.be.model.dto.ExceptionResponseDTO;

@ControllerAdvice
public class CustomExceptionHandler {
@ExceptionHandler(CustomException.class)
public ResponseEntity<ExceptionResponseDTO> handleException(CustomException ex){
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponseDTO("404", ex.getMessage()));
}
}
