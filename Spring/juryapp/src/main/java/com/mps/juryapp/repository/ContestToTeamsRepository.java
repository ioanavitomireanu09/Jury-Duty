package com.mps.juryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.juryapp.model.ContestToTeams;

@Repository
public interface ContestToTeamsRepository extends JpaRepository<ContestToTeams, Integer> {
	ContestToTeams findByContestId(Integer contestId);
}