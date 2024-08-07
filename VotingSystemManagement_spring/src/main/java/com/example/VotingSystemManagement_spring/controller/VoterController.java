package com.example.VotingSystemManagement_spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.VotingSystemManagement_spring.entity.Voter;
import com.example.VotingSystemManagement_spring.repository.VoterRepository;
import com.example.VotingSystemManagement_spring.services.VoterService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class VoterController {
@Autowired
	VoterRepository voterRepository;
	@Autowired
	VoterService voterService;

	@GetMapping("saveVoter")
	public String saveVoter(Voter voter) {
		return "voterRegister";
	}

	@PostMapping("goVoterRegister")
	public String getvoterstatus(@Valid @ModelAttribute Voter voter, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			return "voterRegister";
		}
		voterService.saveVoter(voter);
		return "voterlogin";
	}

	@GetMapping("govoterlogin")
	public String handleVoterLogin1(@ModelAttribute Voter voter, Model model) {

		Optional<Voter> existingVoterOpt1 = voterRepository.findByusername(voter.getUsername());

		if (existingVoterOpt1.isPresent()) {
			Voter existingVoter = existingVoterOpt1.get();
			System.out.println();
			System.out.println(voter.getPassword());
			System.out.println(existingVoter.getPassword());

			if (existingVoter.getPassword().equals(voter.getPassword())) {
				return "voterdashboard";
			}
		}

		model.addAttribute("error", true);
		return "voterlogin";
		
	}
	
	@PutMapping("vidupdate")
    public Voter updateEmployee(@PathVariable int vid, @RequestBody Voter updatedVoter) {
		
		 Optional<Voter> optionalVoter = voterRepository.findById(vid);
        if (optionalVoter.isPresent()) {
            Voter existingVoter = optionalVoter.get();
            existingVoter.setVoterName(updatedVoter.getVoterName());
            existingVoter.setDOB(updatedVoter.getDOB());
            existingVoter.setGender(updatedVoter.getGender());
            existingVoter.setUsername(updatedVoter.getUsername());
            existingVoter.setPassword(updatedVoter.getPassword());
            return voterRepository.save(existingVoter);
        }
        else
        {
            throw new RuntimeException("Employee not found with id " + vid);
        }
	}
        public Voter createVoter(Voter voter) {
            return voterRepository.save(voter);
        }

        public List<Voter> getAllvoter() {
            return voterRepository.findAll();
        }

        public Voter getVoterById(int  vid) {
            return voterRepository.findById(vid)
                    .orElseThrow(() -> new RuntimeException("Voter not found with id " + vid));
        }
		
        
    }


