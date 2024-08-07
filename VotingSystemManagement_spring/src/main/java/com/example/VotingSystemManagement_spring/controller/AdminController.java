package com.example.VotingSystemManagement_spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.VotingSystemManagement_spring.entity.Admin;
import com.example.VotingSystemManagement_spring.repository.AdminRepository;
import com.example.VotingSystemManagement_spring.services.AdminService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@Controller("/")
public class AdminController {
	
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	AdminService adminService;
	
	@GetMapping("saveAdmin")
	public String saveAdmin(Model model)
	{
		model.addAttribute("admin", new Admin());
		return "adminregister";
	}
	@PostMapping("goadminregister")
	public String getadminstatus(@Valid @ModelAttribute Admin admin,BindingResult bindingresult)
	{
		if(bindingresult.hasErrors())
		{
			return "adminregister";
		}
		adminService.saveAdmin(admin);
		return "adminlogin";
	}

	@GetMapping("goadminlogin")
    public String handleAdminLogin1(@ModelAttribute Admin admin, Model model) {

        Optional<Admin> existingAdminOpt1 = adminRepository.findByusername(admin.getUsername());

        if (existingAdminOpt1.isPresent()) {
            Admin existingAdmin = existingAdminOpt1.get(); 
            System.out.println();
            System.out.println(admin.getPass());
            System.out.println(existingAdmin.getPass());
            
            if (existingAdmin.getPass().equals(admin.getPass())) {
                return "dashboard";
            }
        }

        model.addAttribute("error", true);
        return "adminlogin";
    }
	
}
