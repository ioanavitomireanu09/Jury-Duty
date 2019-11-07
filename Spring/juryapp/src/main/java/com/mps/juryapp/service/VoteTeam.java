package com.mps.juryapp.service;

import java.util.ArrayList;

import com.mps.juryapp.model.GradeType;

public class VoteTeam {
	private Integer contestId;
	private Integer teamId;
	private GradeValue gradeValue;
	private Integer juryId;
	private Integer nrRound;
	
	public Integer getContestId() {
		return contestId;
	}
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public GradeValue getGradeValue() {
		return gradeValue;
	}
	public void setGradeValue(GradeValue gradeValue) {
		this.gradeValue = gradeValue;
	}
	public Integer getJuryId() {
		return juryId;
	}
	public void setJuryId(Integer juryId) {
		this.juryId = juryId;
	}
	public Integer getNrRound() {
		return nrRound;
	}
	public void setNrRound(Integer nrRound) {
		this.nrRound = nrRound;
	}
	public VoteTeam(Integer contestId, Integer teamId, GradeValue gradeValue, Integer juryId, Integer nrRound) {
		super();
		this.contestId = contestId;
		this.teamId = teamId;
		this.gradeValue = gradeValue;
		this.juryId = juryId;
		this.nrRound = nrRound;
	}
	
	public VoteTeam() {}
}
