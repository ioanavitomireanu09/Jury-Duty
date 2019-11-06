package com.mps.juryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.juryapp.model.Contest;

@Repository
public interface ContestRepository extends JpaRepository<Contest, Integer> {
	Contest findByName(String name);
}
