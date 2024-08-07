package com.example.VotingSystemManagement_spring.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Voter {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vid;
	@NotBlank(message = "Name Cannot be Empty")
	@Size(min = 4, max = 8, message = "Name should have 4 to 8 characters")
	@Pattern(regexp = "[a-zA-Z]+$",message = "only character allowed")
	
	private String VoterName;
	private Date DOB;
	private String Gender;
	private String username;
	private String password;
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVoterName() {
		return VoterName;
	}
	public void setVoterName(String voterName) {
		VoterName = voterName;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Voter(int vid,
			@NotBlank(message = "Name Cannot be Empty") @Size(min = 4, max = 8, message = "Name should have 4 to 8 characters") @Pattern(regexp = "[a-zA-Z]+$", message = "only character allowed") String voterName,
			Date dOB, String gender, String username, String password) {
		super();
		this.vid = vid;
		VoterName = voterName;
		DOB = dOB;
		Gender = gender;
		this.username = username;
		this.password = password;
	}
	public Voter() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Voter [vid=" + vid + ", VoterName=" + VoterName + ", DOB=" + DOB + ", Gender=" + Gender + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
	
}
