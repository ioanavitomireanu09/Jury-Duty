package com.mps.juryapp.service;

import java.util.List;

import com.mps.juryapp.dto.GradesDto;
import com.mps.juryapp.model.Grades;

public interface GradesService {
	public Grades SetGrades(VoteTeam vote);
}
