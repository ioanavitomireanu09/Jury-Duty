package com.mps.juryapp.dto;

public class ContestToTeamsDto {
	private Integer id;
	private Integer teamId;
	private Integer contestId;
	private Integer disqualified;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public Integer getContestId() {
		return contestId;
	}
	public void setContest_id(Integer contestId) {
		this.contestId = contestId;
	}
	public Integer getDisqualified() {
		return disqualified;
	}
	public void setDisqualified(Integer disqualified) {
		this.disqualified = disqualified;
	}
	public ContestToTeamsDto(Integer id, Integer teamId, Integer contestId, Integer disqualified) {
		super();
		this.id = id;
		this.teamId = teamId;
		this.contestId = contestId;
		this.disqualified = disqualified;
	}
	public ContestToTeamsDto() {}
	
	
}
