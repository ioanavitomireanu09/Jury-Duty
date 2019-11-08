package com.mps.juryapp.dto;

public class AddUserToContest {

	public String username;
	public Integer contestId;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getContestId() {
		return contestId;
	}
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}
	public AddUserToContest(String username, Integer contestId) {
		super();
		this.username = username;
		this.contestId = contestId;
	}
	
	public AddUserToContest() {}
}
