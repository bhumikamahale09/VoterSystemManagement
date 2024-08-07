package com.example.VotingSystemManagement_spring.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class AdminLogin {
	@Id
	private int id;
	@NotBlank(message="required")
	private String username;
	
	@NotBlank(message = "required")
	private String password;
	
	private LocalDateTime lastlogin;

	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminLogin(int id, @NotBlank(message = "required") String username,
			@NotBlank(message = "required") String password, LocalDateTime lastlogin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.lastlogin = lastlogin;
	}
	
	
}
