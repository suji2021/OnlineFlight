package com.flightbooking.service;

import java.util.List;

import com.flightbooking.exception.DuplicateUserException;
import com.flightbooking.exception.UserNotFoundException;
import com.flightbooking.model.User;

public interface UserService {
	
	//methods performed for the user model
	
		public List<User> getAllUsers();
		
		public User getUserById(long userId)throws UserNotFoundException;
		
		public User registerUser(User user) throws DuplicateUserException;
		
		public User updateUser(User user, long userId)throws UserNotFoundException;
		
		public void deleteUser(long userId )throws UserNotFoundException;
		
		public String loginUser(User user) throws UserNotFoundException;
		
			
}
