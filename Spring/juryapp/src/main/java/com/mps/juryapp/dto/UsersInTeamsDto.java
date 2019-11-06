package com.mps.juryapp.dto;

public class UsersInTeamsDto {
	private Integer id;
	private Integer userId;
	private Integer teamId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public UsersInTeamsDto(Integer id, Integer userId, Integer teamId) {
		super();
		this.id = id;
		this.userId = userId;
		this.teamId = teamId;
	}
	
	public UsersInTeamsDto() {}
	
}
