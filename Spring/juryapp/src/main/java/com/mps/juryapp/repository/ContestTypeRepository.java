package com.mps.juryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.juryapp.model.ContestType;

@Repository
public interface ContestTypeRepository extends JpaRepository<ContestType, Integer> {
	ContestType findByName(String name);
}
