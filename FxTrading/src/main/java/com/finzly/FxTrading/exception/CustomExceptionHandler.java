package com.finzly.FxTrading.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(InvalidNameException.class)
	 public ResponseEntity<Object> handleCustomException(InvalidNameException ex) {
		return new ResponseEntity<>("Please enter valid name", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidAmountException.class)
	 public ResponseEntity<Object> handleCustomException(InvalidAmountException ex) {
		return new ResponseEntity<>("Please enter valid amount", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CurrencyNotFoundException.class)
	 public ResponseEntity<Object> handleCustomException(CurrencyNotFoundException ex) {
		return new ResponseEntity<>("Currencypair is not found please enter valid currencypair", HttpStatus.BAD_REQUEST);
	}

}
