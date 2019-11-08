package com.mps.juryapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.juryapp.model.UserToContest;

@Repository
public interface UserToContestRepository extends JpaRepository<UserToContest, Integer> {
	
	public List<UserToContest> findByUsername(String username);
}
