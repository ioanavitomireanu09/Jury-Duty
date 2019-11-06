package com.mps.juryapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.juryapp.dto.ContestDto;
import com.mps.juryapp.dto.ContestToGradesDto;
import com.mps.juryapp.model.Contest;
import com.mps.juryapp.model.ContestToGrades;
import com.mps.juryapp.repository.ContestRepository;
import com.mps.juryapp.repository.ContestToGradesRepository;
import com.mps.juryapp.util.BuilderDto;

@Service
@Transactional
public class ContestToGradesServiceImpl implements ContestToGradesService {

	@Autowired
	ContestToGradesRepository contestToGradesRepository;
	
	@Autowired
	BuilderDto builderDto;
	
	public List<ContestToGradesDto> getContestToGrades() {
		List<ContestToGradesDto> contestToGradesDtoList = new ArrayList<ContestToGradesDto>();
		
		List<ContestToGrades> contestToGradesList = contestToGradesRepository.findAll();
		for(ContestToGrades contestToGrades : contestToGradesList) {
			contestToGradesDtoList.add(this.builderDto.contestToGradesToDto(contestToGrades));
		}
		return contestToGradesDtoList;
	}
	
}
