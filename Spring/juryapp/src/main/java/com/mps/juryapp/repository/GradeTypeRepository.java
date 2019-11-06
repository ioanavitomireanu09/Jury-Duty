package com.mps.juryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.juryapp.model.GradeType;

@Repository
public interface GradeTypeRepository extends JpaRepository<GradeType, Integer> {
	GradeType findByUsername(String name);
}
