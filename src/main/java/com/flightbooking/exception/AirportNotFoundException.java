package com.flightbooking.exception;

public class AirportNotFoundException extends Exception {
	  private final String message;
	    
	    public AirportNotFoundException() {
	        this.message = null;
	    }
	    
	    public AirportNotFoundException(String message) {
	        this.message = message;
	    }
	    
	    @Override
	    public String getMessage() {
	        return this.message;
	    }

}
