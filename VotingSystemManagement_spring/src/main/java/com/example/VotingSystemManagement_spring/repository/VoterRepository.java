package com.example.VotingSystemManagement_spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.VotingSystemManagement_spring.entity.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Integer> {

	Optional<Voter> findByusername(String username);

	 Optional<Voter> findById(int vid);
	 

	
	
}
