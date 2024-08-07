package com.example.VotingSystemManagement_spring.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.VotingSystemManagement_spring.entity.Voter;

public interface VoterService {

	public Voter saveVoter(Voter voter);

	public List<Voter> voterlist();

	public void deleteById(int id);

	public Voter findById(int id);

	public Voter updateVoter(Voter voter,int id);

	public Voter updateVoter(int vid, Voter updatedVoter);   
	public Voter updateEmployee(@PathVariable int vid, @RequestBody Voter updatedVoter);
	  public Voter createVoter(@RequestBody Voter voter);
	   public List<Voter> getAllVoter();
	   public Voter getvoterById(@PathVariable int vid);
	
}
