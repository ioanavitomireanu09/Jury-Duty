package com.mps.juryapp.dto;

public class GradesDto {

	private Integer id;
	private Integer teamId;
	private Integer value;
	private Integer contestId;
	private Integer roundId;
	private Integer juryId;
	
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
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Integer getContestId() {
		return contestId;
	}
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}
	public Integer getRoundId() {
		return roundId;
	}
	public void setRoundId(Integer roundId) {
		this.roundId = roundId;
	}
	public Integer getJuryId() {
		return juryId;
	}
	public void setJuryId(Integer juryId) {
		this.juryId = juryId;
	}
	public GradesDto(Integer id, Integer teamId, Integer value, Integer contestId, Integer roundId, Integer juryId) {
		super();
		this.id = id;
		this.teamId = teamId;
		this.value = value;
		this.contestId = contestId;
		this.roundId = roundId;
		this.juryId = juryId;
	}
	
	public GradesDto() {}
}
