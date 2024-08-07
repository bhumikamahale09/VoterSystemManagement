package com.example.VotingSystemManagement_spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.VotingSystemManagement_spring.entity.Voter;
import com.example.VotingSystemManagement_spring.repository.VoterRepository;

@Service
public class VoterAdminImpt implements VoterService {
	@Autowired
	VoterRepository voterRepository;

    @Autowired
    private VoterService voterService;
	@Override
	public Voter saveVoter(Voter voter) {

		return voterRepository.save(voter);
	}

	@Override
	public List<Voter> voterlist() {
		List<Voter> find = voterRepository.findAll();
		return find;
	}

	@Override
	public void deleteById(int id) {
		voterRepository.deleteById(id);

	}

	@Override
	public Voter findById(int id) {
		Optional<Voter> findById = voterRepository.findById(id);
		Voter voter = findById.get();
		return voter;

	}

	@Override
	public Voter updateVoter(Voter voter, int id) {
		Optional<Voter> voterdatab = voterRepository.findById(id);
		if (voterdatab.isPresent()) {
			Voter newVoter = voterdatab.get();
			newVoter.setUsername(voter.getUsername());
			newVoter.setDOB(voter.getDOB());
			newVoter.setGender(voter.getGender());
			newVoter.setUsername(voter.getUsername());
			newVoter.setPassword(voter.getPassword());
			voterRepository.save(newVoter);
			return newVoter;
		}
		return null;

	}

	@Override
	public Voter updateVoter(int vid, Voter updatedVoter) {
		// TODO Auto-generated method stub
		return null;
	}
	

	    @PutMapping("/{vid}")
	    public Voter updateEmployee(@PathVariable int vid, @RequestBody Voter updatedVoter) {
	        return voterService.updateVoter(vid, updatedVoter);
	    }

	    @PostMapping
	    public Voter createVoter(@RequestBody Voter voter) {
	        return voterService.createVoter(voter);
	    }

	    @GetMapping
	    public List<Voter> getAllVoter() {
	        return voterService.getAllVoter();
	    }

	    @GetMapping("/{vid}")
	    public Voter getvoterById(@PathVariable int vid) {
	        return voterService.getvoterById(vid);
	    }

}