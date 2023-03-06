package com.flightbooking.exception;


public class BookingNotFoundException  extends Exception {
	
	 private final String message;
	    
	    public BookingNotFoundException() {
	        this.message = null;
	    }
	    
	    public BookingNotFoundException(String message) {
	        this.message = message;
	    }
	    
	    @Override
	    public String getMessage() {
	        return this.message;
	    }

}
