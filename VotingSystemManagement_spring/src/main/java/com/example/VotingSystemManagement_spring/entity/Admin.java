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
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int aid;
	@NotBlank(message="Name cannot be Empty")
	@Size(min=2,max=10,message="Name should have min 2 letters and max 10 letters")
	private String name;
	@Pattern(regexp="^[a-zA-Z]+$",message="only characters allowed")
	private String address;
	private Date dob;
	private String gender;
	private String username;
	private String pass;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", name=" + name + ", address=" + address + ", dob=" + dob + ", gender=" + gender
				+ ", username=" + username + ", pass=" + pass + "]";
	}
	public Admin(int aid,
			@NotBlank(message = "Name cannot be Empty") @Size(min = 2, max = 10, message = "Name should have min 2 letters and max 10 letters") String name,
			@Pattern(regexp = "^[a-zA-Z]+$", message = "only characters allowed") String address, Date dob,
			String gender, String username, String pass) {
		super();
		this.aid = aid;
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
		this.username = username;
		this.pass = pass;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
