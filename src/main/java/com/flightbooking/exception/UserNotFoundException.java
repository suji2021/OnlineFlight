package com.flightbooking.exception;

public class UserNotFoundException extends Exception{
	
	    private final String message;
	    
	    public UserNotFoundException() {
	        this.message = null;
	    }
	    
	    public UserNotFoundException(String message) {
	        this.message = message;
	    }
	    
	    @Override
	    public String getMessage() {
	        return this.message;
	    }
	}


