package com.mps.juryapp.service;

import java.util.List;

import com.mps.juryapp.dto.TeamDto;
import com.mps.juryapp.model.Team;

public interface TeamService {
	public List<TeamDto> getTeams();
	public String createTeam(Team team);
}
