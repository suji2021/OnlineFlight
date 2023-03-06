package com.flightbooking.exception;

@SuppressWarnings("serial")
public class BookingAlreadyExistsException extends Exception {
	 private final String message;
	    
	    public BookingAlreadyExistsException() {
	        this.message = null;
	    }
	    
	    public BookingAlreadyExistsException(String message) {
	        this.message = message;
	    }
	    
	    @Override
	    public String getMessage() {
	        return this.message;
	    }
}
