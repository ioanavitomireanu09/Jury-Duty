package com.mps.juryapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.juryapp.model.Grades;

@Repository
public interface GradesRepository extends JpaRepository<Grades, Integer> {
	List<Grades> findByTeamId(Integer teamId);
}
