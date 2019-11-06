package com.mps.juryapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.juryapp.dto.UserDto;
import com.mps.juryapp.dto.UsersInTeamsDto;
import com.mps.juryapp.model.User;
import com.mps.juryapp.model.UsersInTeams;
import com.mps.juryapp.repository.UserRepository;
import com.mps.juryapp.repository.UsersInTeamsRepository;
import com.mps.juryapp.util.BuilderDto;

@Service
@Transactional
public class UsersInTeamsServiceImpl implements UsersInTeamsService {

	@Autowired
	UsersInTeamsRepository usersInTeamsRepository;
	
	@Autowired
	BuilderDto builderDto;
	
	public List<UsersInTeamsDto> getUsersInTeams() {
		List<UsersInTeamsDto> userInTeamsDtoList = new ArrayList<UsersInTeamsDto>();
		
		List<UsersInTeams> userInTeamsList = usersInTeamsRepository.findAll();
		for(UsersInTeams userInTeams : userInTeamsList) {
			userInTeamsDtoList.add(this.builderDto.usersInTeamsToDto(userInTeams));
		}
		return userInTeamsDtoList;
	}
	
}
