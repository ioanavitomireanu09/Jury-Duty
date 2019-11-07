package com.mps.juryapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.juryapp.dto.GradeTypeDto;
import com.mps.juryapp.dto.GradesDto;
import com.mps.juryapp.dto.TeamDto;
import com.mps.juryapp.model.GradeType;
import com.mps.juryapp.model.Grades;
import com.mps.juryapp.model.Team;
import com.mps.juryapp.repository.GradeTypeRepository;
import com.mps.juryapp.repository.GradesRepository;
import com.mps.juryapp.repository.TeamRepository;
import com.mps.juryapp.util.BuilderDto;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	BuilderDto builderDto;
	
	public List<TeamDto> getTeams() {
		List<TeamDto> teamsDtoList = new ArrayList<TeamDto>();
		
		List<Team> teamsList = teamRepository.findAll();
		for(Team team : teamsList) {
			teamsDtoList.add(this.builderDto.teamToDto(team));
		}
		return teamsDtoList;
	}
	
}
