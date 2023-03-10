package com.flightbooking.exception;

public class DuplicateUserException extends Exception {
	 private final String message;
	    
	    public DuplicateUserException() {
	        this.message = null;
	    }
	    
	    public DuplicateUserException(String message) {
	        this.message = message;
	    }
	    
	    @Override
	    public String getMessage() {
	        return this.message;
	    }
	   
}
