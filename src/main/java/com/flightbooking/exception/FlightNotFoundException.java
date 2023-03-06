package com.flightbooking.exception;

public class FlightNotFoundException extends Exception {
	 private final String message;
	    
	    public FlightNotFoundException() {
	        this.message = null;
	    }
	    
	    public FlightNotFoundException(String message) {
	        this.message = message;
	    }
	    
	    @Override
	    public String getMessage() {
	        return this.message;
	    }


}
