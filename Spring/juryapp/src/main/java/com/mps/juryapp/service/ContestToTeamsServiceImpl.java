package com.mps.juryapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.juryapp.dto.ContestToTeamsDto;
import com.mps.juryapp.dto.ContestTypeDto;
import com.mps.juryapp.dto.RoundStats;
import com.mps.juryapp.dto.Stats;
import com.mps.juryapp.dto.TeamDto;
import com.mps.juryapp.dto.UserDto;
import com.mps.juryapp.dto.UsersInTeamsDto;
import com.mps.juryapp.model.ContestToTeams;
import com.mps.juryapp.model.ContestType;
import com.mps.juryapp.model.Grades;
import com.mps.juryapp.model.User;
import com.mps.juryapp.model.UsersInTeams;
import com.mps.juryapp.repository.ContestToTeamsRepository;
import com.mps.juryapp.repository.ContestTypeRepository;
import com.mps.juryapp.repository.GradesRepository;
import com.mps.juryapp.repository.UserRepository;
import com.mps.juryapp.util.BuilderDto;

@Service
@Transactional
public class ContestToTeamsServiceImpl implements ContestToTeamsService {

	@Autowired
	ContestToTeamsRepository contestToTeamsRepository;
	@Autowired 
	TeamServiceImpl teamServiceImpl;
	@Autowired
	UsersInTeamsServiceImpl usersInTeamsServiceImpl;

	@Autowired
	UserRepository userRepository;
	@Autowired
	GradesRepository gradesRepository;
	
	@Autowired
	BuilderDto builderDto;
	
	public List<ContestToTeamsDto> getContestToTeams() {
		List<ContestToTeamsDto> contestToTeamsDtoList = new ArrayList<ContestToTeamsDto>();
		List<ContestToTeams> contestToTeamsList = contestToTeamsRepository.findAll();
		
		for(ContestToTeams contestToTeams : contestToTeamsList) {
			contestToTeamsDtoList.add(this.builderDto.contestToTeamsToDto(contestToTeams));
		}
		
		return contestToTeamsDtoList;
	}
	
	public List<Stats> getStats(Integer contestId) {

		List<Stats> stats = new ArrayList<Stats>();
		List<ContestToTeamsDto> contestToTeamsDtoList = getContestToTeams();
		List<TeamDto> teams = teamServiceImpl.getTeams();
		List<UsersInTeamsDto> usersInTeams = usersInTeamsServiceImpl.getUsersInTeams();
		
		for (ContestToTeamsDto contestToTeams : contestToTeamsDtoList) {	
			//should get just this contest, but there can be more teams
			if (contestToTeams.getContestId() == contestId) {
				
				//search all the teams from this contest and compare the id within the teams list
				for (TeamDto team : teams) {
					if (team.getId() == contestToTeams.getId()) {
						//now we have a match
						Stats currentStats = new Stats();
						
						currentStats.setTeamName(team.getName());
						
						//add specific users
						for (UsersInTeamsDto user : usersInTeams) {
							if (user.getTeamId() == team.getId()) {
								currentStats.getUsers().add(
										builderDto.userToDto(userRepository.findById(
												user.getUserId()).orElse(null)));
							}
						}
						
						List<Grades> grades = gradesRepository.findByTeamId(team.getId());
						
						float averageGrade = 0;
						int count = 0;
						
						for (Grades grade : grades) {
							if (grade.getContestId() == contestId) {
								currentStats.getRoundStats().add(new RoundStats(grade.getRoundId(), grade.getValue()));
								averageGrade += grade.getValue();
								count++;
							}
						}
						
						if (contestToTeams.getDisqualified() == 1)
							currentStats.setAverageGrade((float)0);
						else
							currentStats.setAverageGrade(averageGrade);
						stats.add(currentStats);
					}
				}
			}
		}
		return stats;
	}
	
}
