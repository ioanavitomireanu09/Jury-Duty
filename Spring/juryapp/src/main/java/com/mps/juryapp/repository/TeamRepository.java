package com.mps.juryapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.juryapp.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
	Team findByName(String name);
}
