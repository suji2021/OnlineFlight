package com.flightbooking.exception;

public class InvalidAdminException extends Exception{
	 private final String message;
	    
	    public InvalidAdminException() {
	        this.message = null;
	    }
	    
	    public InvalidAdminException(String message) {
	        this.message = message;
	    }
	    
	    @Override
	    public String getMessage() {
	        return this.message;
	    }
	


}
