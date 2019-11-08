package com.mps.juryapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.juryapp.dto.ContestToGradesDto;
import com.mps.juryapp.dto.GradeTypeDto;
import com.mps.juryapp.dto.GradesDto;
import com.mps.juryapp.model.Contest;
import com.mps.juryapp.model.ContestToGrades;
import com.mps.juryapp.model.GradeType;
import com.mps.juryapp.model.Grades;
import com.mps.juryapp.repository.ContestRepository;
import com.mps.juryapp.repository.ContestToGradesRepository;
import com.mps.juryapp.repository.GradeTypeRepository;
import com.mps.juryapp.repository.GradesRepository;
import com.mps.juryapp.util.BuilderDto;

@Service
@Transactional
public class GradesServiceImpl implements GradesService {

	@Autowired
	GradesRepository gradesRepository;
	
	@Autowired
	ContestRepository contestRepository;
	
	@Autowired
	ContestToGradesRepository contestToGradesRepository;
	
	@Autowired
	BuilderDto builderDto;
	
	
	public Grades SetGrades(VoteTeam vote) {
		ArrayList<GradeValue> note = vote.getGradeValue();
		
		ArrayList<GradeType> gradeType = new ArrayList<GradeType>();
		ArrayList<Integer> valori = new ArrayList<Integer>();
		ArrayList<Integer> weightList = new ArrayList<Integer>();
		
		for (GradeValue nota : note) {
			gradeType.add(nota.getGradeType());
			valori.add(nota.getValue());
		}
		
		List<ContestToGrades> contestToGradesList = contestToGradesRepository.findAll();
		Integer weight = 0;
		Integer notaFinala = 0;
		
		for (GradeType grade : gradeType) {
			for (ContestToGrades contest: contestToGradesList) {
				if(contest.getGradeTypeId() == grade.getId()) {
					weight += contest.getGradeWeight();
					weightList.add(contest.getGradeWeight());
				}
			}
		}
		
		int weightPart = 0;
		for(int i = 0; i < valori.size(); i++) {
			weightPart = (10 * valori.get(i)) / weight;
			notaFinala += valori.get(i) * weightPart;
		}
		
		notaFinala = notaFinala / 10;
		
		Grades newGrade = new Grades();
		newGrade.setContestId(vote.getContestId());
		newGrade.setJuryId(vote.getJuryId());
		newGrade.setRoundId(vote.getNrRound());
		newGrade.setTeamId(vote.getTeamId());
		newGrade.setValue(notaFinala);
		
		gradesRepository.save(newGrade);

		return newGrade;
	}
}
