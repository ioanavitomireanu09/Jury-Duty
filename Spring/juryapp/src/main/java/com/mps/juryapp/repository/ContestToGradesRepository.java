package com.mps.juryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.juryapp.model.ContestToGrades;

@Repository
public interface ContestToGradesRepository extends JpaRepository<ContestToGrades, Integer> {
	ContestToGrades findByContestToGrades (Integer contestId);
}
