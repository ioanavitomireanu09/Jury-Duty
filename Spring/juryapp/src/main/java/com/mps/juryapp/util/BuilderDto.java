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
		userGroupDto.setName(userGroup.getName());
		userGroupDto.setDescription(userGroup.getDescription());

		return userGroupDto;
	}
}
