package com.flightbooking;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.flightbooking.controller.UserController;
import com.flightbooking.exception.UserNotFoundException;
import com.flightbooking.serviceimpl.UserServiceImpl;

@SpringBootTest
class FlightBookingApplicationTests {

	
	@Mock
    private UserServiceImpl userService;
	
	@InjectMocks
    private UserController userController;
	
	 @Test
	    public void testDeleteUser() throws UserNotFoundException {
	        doNothing().when(userService).deleteUser(1L);

	        ResponseEntity<String> result = userController.deleteUser(1L);
	        assertEquals("User Deleted", result.getBody());
	        assertEquals(HttpStatus.OK, result.getStatusCode());
	    }

}
