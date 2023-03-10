package com.flightbooking.service;

import com.flightbooking.exception.InvalidAdminException;
import com.flightbooking.model.Admin;

public interface AdminService {
	
	public Admin registerAdmin(Admin admin);
	
	public String loginAdmin(Admin admin) throws InvalidAdminException;
	public Admin updateAdmin(Admin admin,long adminId)throws InvalidAdminException;

	
}