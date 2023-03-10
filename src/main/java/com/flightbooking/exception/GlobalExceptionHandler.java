package com.flightbooking.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Value(value="${message1}")
	private String message1;
	
	@Value(value="${message2}")
	private String message2;
	
	@Value(value="${message3}")
	private String message3;
	
	@Value(value="${message4}")
	private String message4;
	
	@Value(value="${message5}")
	private String message5;
	
	@Value(value="${message6}")
	private String message6;
	
	@ExceptionHandler(value=DuplicateUserException.class)
	public ResponseEntity<String> duplicateUserException(DuplicateUserException ex) {
		return new ResponseEntity<>(message1,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=FlightNotFoundException.class)
	public ResponseEntity<String>  flightNotFoundException(FlightNotFoundException ex) {
		return new ResponseEntity<>(message2,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=InvalidAdminException.class)
	public ResponseEntity<String>  invalidAdminException(InvalidAdminException ex) {
		return new ResponseEntity<>(message3,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=BookingNotFoundException.class)
	public ResponseEntity<String>  seatsNotAvailableException(BookingNotFoundException ex) {
		return new ResponseEntity<>(message4,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<String>  userNotFoundException(UserNotFoundException ex) {
		return new ResponseEntity<>(message5,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=AirportNotFoundException.class)
	public ResponseEntity<String> airportNotFoundException(AirportNotFoundException ex) {
		return new ResponseEntity<>(message6,HttpStatus.CONFLICT);
	}
	
}
