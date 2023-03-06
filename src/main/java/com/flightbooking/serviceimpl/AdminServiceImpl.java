package com.flightbooking.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.exception.InvalidAdminException;
import com.flightbooking.model.Admin;
import com.flightbooking.repository.AdminRepository;
import com.flightbooking.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository repoAdmin;
	
	public Admin registerAdmin(Admin admin) {
		return repoAdmin.save(admin);
	}
	
	public String loginAdmin(Admin admin) throws InvalidAdminException {
		if(repoAdmin.validateAdmin(admin.getEmailId(),admin.getPassword()).isEmpty()) {
			throw new InvalidAdminException();
		}
		return "Login Successful";
	}

}
