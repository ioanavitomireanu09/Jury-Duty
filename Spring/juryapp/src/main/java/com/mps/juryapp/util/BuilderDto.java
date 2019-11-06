package com.mps.juryapp.util;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.juryapp.dto.ContestDto;
import com.mps.juryapp.dto.ContestToGradesDto;
import com.mps.juryapp.dto.ContestTypeDto;
import com.mps.juryapp.dto.GradeTypeDto;
import com.mps.juryapp.dto.UserDto;
import com.mps.juryapp.dto.UsersInTeamsDto;
import com.mps.juryapp.model.Contest;
import com.mps.juryapp.model.ContestToGrades;
import com.mps.juryapp.model.ContestType;
import com.mps.juryapp.model.GradeType;
import com.mps.juryapp.model.User;
import com.mps.juryapp.model.UsersInTeams;

@Service
@Transactional
public class BuilderDto {

	public UserDto userToDto(User user) {
		UserDto userDto = new UserDto();

		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setGroupId(user.getGroupId());

		return userDto;
	}
	
	public ContestDto contestToDto(Contest contest) {
		ContestDto contestDto = new ContestDto();
		
		contestDto.setContest_type_id(contest.getContestTypeId());
		contestDto.setCurrent_round(contest.getCurrentRound());
		contestDto.setId(contest.getId());
		contestDto.setIs_private(contest.getIsPrivate());
		contestDto.setName(contest.getName());
		contestDto.setNum_of_jurys(contest.getNumOfJurys());
		contestDto.setNum_of_participants(contest.getNumOfParticipants());
		contestDto.setNum_of_rounds(contest.getNumOfRounds());
		contestDto.setRound_state(contest.getRoundState());
		contestDto.setState(contest.getState());
		contestDto.setTie_breaker_id(contest.getTieBreakerId());
		
		return contestDto;
	}

	public ContestToGradesDto contestToGradesToDto(ContestToGrades contestToGrades) {
		ContestToGradesDto contestToGradesDto = new ContestToGradesDto();
		
		contestToGradesDto.setContest_id(contestToGrades.getContestId());
		contestToGradesDto.setGrade_type_id(contestToGrades.getGradeTypeId());
		contestToGradesDto.setGrade_weight(contestToGrades.getGradeWeight());
		contestToGradesDto.setId(contestToGrades.getId());
		
		return contestToGradesDto;
	}
	
	public ContestTypeDto contestTypeToDto(ContestType contestType) {
		ContestTypeDto contestTypeDto = new ContestTypeDto();
		
		contestTypeDto.setDescription(contestType.getDescription());
		contestTypeDto.setId(contestType.getId());
		contestTypeDto.setName(contestType.getName());
	
		return contestTypeDto;
	}
	
	public GradeTypeDto gradeTypeToDto(GradeType gradeType) {
		GradeTypeDto gradeTypeDto = new GradeTypeDto();
		
		gradeTypeDto.setDescription(gradeType.getDescription());
		gradeTypeDto.setId(gradeType.getId());
		gradeTypeDto.setName(gradeType.getName());
		
		return gradeTypeDto;
	}
	
	public UsersInTeamsDto usersInTeamsToDto(UsersInTeams usersInTeams) {
		UsersInTeamsDto usersInTeamsDto = new UsersInTeamsDto();
		
		usersInTeamsDto.setId(usersInTeams.getId());
		usersInTeamsDto.setTeamId(usersInTeams.getTeamId());
		usersInTeamsDto.setUserId(usersInTeams.getUserId());
		
		return usersInTeamsDto;
	}
}
