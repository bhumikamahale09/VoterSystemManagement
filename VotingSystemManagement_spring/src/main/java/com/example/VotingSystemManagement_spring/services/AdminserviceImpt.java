package com.example.VotingSystemManagement_spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VotingSystemManagement_spring.entity.Admin;
import com.example.VotingSystemManagement_spring.repository.AdminRepository;

@Service
public class AdminserviceImpt implements AdminService {

	@Autowired
	AdminRepository adminrepo;
	
	@Override
	public void saveAdmin(Admin admin) {
		
		adminrepo.save(admin);
		
	}
	
	@Override
	public List<Admin>adminlist()
	{
		List<Admin>find=adminrepo.findAll();
		return find;
	}
	
	

}
