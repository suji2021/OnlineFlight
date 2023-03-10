package com.flightbooking.serviceimpl;

import java.util.Optional;

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

	
	public Admin updateAdmin(Admin admin, long adminId) throws InvalidAdminException {
		// TODO Auto-generated method stub
		Optional<Admin> a= repoAdmin.findById(adminId);
		if(a.isPresent()) {
			Admin ad = repoAdmin.getOne(adminId);
			ad.setPassword(admin.getPassword());
			return this.repoAdmin.save(ad);
		}
		throw new InvalidAdminException();
	}


	

}
