package com.mps.juryapp.dto;

import java.util.ArrayList;
import java.util.List;

public class Stats {
	String teamName;
	List<UserDto> users;
	List<RoundStats> roundStats;
	Float averageGrade;
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<UserDto> getUsers() {
		return users;
	}
	public void setUsers(List<UserDto> users) {
		this.users = users;
	}
	public List<RoundStats> getRoundStats() {
		return roundStats;
	}
	public void setRoundStats(List<RoundStats> roundStats) {
		this.roundStats = roundStats;
	}
	public Float getAverageGrade() {
		return averageGrade;
	}
	public void setAverageGrade(Float averageGrade) {
		this.averageGrade = averageGrade;
	}
	public Stats(String teamName, List<UserDto> users, List<RoundStats> roundStats, Float averageGrade) {
		super();
		this.teamName = teamName;
		this.users = users;
		this.roundStats = roundStats;
		this.averageGrade = averageGrade;
	}
	public Stats() {
		users = new ArrayList<UserDto>();
		roundStats = new ArrayList<RoundStats>();
	}
	
	
}
