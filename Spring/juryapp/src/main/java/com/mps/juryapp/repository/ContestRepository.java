package com.mps.juryapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.juryapp.model.Contest;

@Repository
public interface ContestRepository extends JpaRepository<Contest, Integer> {
	Optional<Contest> findById(Integer id);
	Optional<Contest> findByName(String name);
}
