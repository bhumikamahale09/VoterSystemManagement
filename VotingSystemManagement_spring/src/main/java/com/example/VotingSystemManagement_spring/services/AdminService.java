package com.example.VotingSystemManagement_spring.services;

import java.util.List;

import com.example.VotingSystemManagement_spring.entity.Admin;

public interface AdminService {

	public void saveAdmin(Admin admin);
	public List<Admin> adminlist();
}
