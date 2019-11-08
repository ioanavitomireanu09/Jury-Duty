package com.mps.juryapp.util;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.juryapp.dto.GradesDto;
import com.mps.juryapp.dto.TeamDto;
import com.mps.juryapp.dto.TieBreakerTypeDto;
import com.mps.juryapp.dto.UserDto;
import com.mps.juryapp.dto.UserGroupDto;
import com.mps.juryapp.model.Grades;
import com.mps.juryapp.model.Team;
import com.mps.juryapp.model.TieBreakerType;
import com.mps.juryapp.model.User;
import com.mps.juryapp.model.UserGroup;
import com.mps.juryapp.dto.ContestDto;
import com.mps.juryapp.dto.ContestToGradesDto;
import com.mps.juryapp.dto.ContestToTeamsDto;
import com.mps.juryapp.dto.ContestTypeDto;
import com.mps.juryapp.dto.GradeTypeDto;
import com.mps.juryapp.dto.UserDto;
import com.mps.juryapp.dto.UsersInTeamsDto;
import com.mps.juryapp.model.Contest;
import com.mps.juryapp.model.ContestToGrades;
import com.mps.juryapp.model.ContestToTeams;
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

	public GradesDto gradesToDto(Grades grades) {
		GradesDto gradesDto = new GradesDto();

		gradesDto.setId(grades.getId());
		gradesDto.setContestId(grades.getContestId());
		gradesDto.setJuryId(grades.getJuryId());
		gradesDto.setRoundId(grades.getRoundId());
		gradesDto.setTeamId(grades.getTeamId());
		gradesDto.setValue(grades.getValue());

		return gradesDto;
	}
	
	public TeamDto teamToDto(Team team) {
		TeamDto teamDto = new TeamDto();

		teamDto.setId(team.getId());
		teamDto.setName(team.getName());
		teamDto.setNumOfParticipants(team.getNumOfParticipants());
		teamDto.setPassword(team.getPassword());

		return teamDto;
	}
	
	public TieBreakerTypeDto tieBreakerTypeToDto(TieBreakerType tieBreakerType) {
		TieBreakerTypeDto tieBreakerTypeDto = new TieBreakerTypeDto();

		tieBreakerTypeDto.setId(tieBreakerType.getId());
		tieBreakerTypeDto.setName(tieBreakerType.getName());
		tieBreakerTypeDto.setDescription(tieBreakerType.getDescription());

		return tieBreakerTypeDto;
	}
	
	public UserGroupDto userGroupToDto(UserGroup userGroup) {
		UserGroupDto userGroupDto = new UserGroupDto();

		userGroupDto.setGroupId(userGroup.getGroupId());
		userGroupDto.setDescription(userGroup.getDescription());

		return userGroupDto;
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
	
	public ContestToTeamsDto contestToTeamsToDto(ContestToTeams contestToTeams) {
		ContestToTeamsDto contestToTeamsDto = new ContestToTeamsDto();
		
		contestToTeamsDto.setContest_id(contestToTeams.getContestId());
		contestToTeamsDto.setId(contestToTeams.getId());
		contestToTeamsDto.setDisqualified(contestToTeams.getDisqualified());
		contestToTeamsDto.setTeamId(contestToTeams.getTeamId());
		
		return contestToTeamsDto;
	}
}
