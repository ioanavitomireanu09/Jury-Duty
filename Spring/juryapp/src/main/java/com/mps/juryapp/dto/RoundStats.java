package com.mps.juryapp.dto;

public class RoundStats {
	Integer roundNumber;
	Integer grade;
	public Integer getRoundNumber() {
		return roundNumber;
	}
	public void setRoundNumber(Integer roundNumber) {
		this.roundNumber = roundNumber;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public RoundStats(Integer roundNumber, Integer grade) {
		super();
		this.roundNumber = roundNumber;
		this.grade = grade;
	}
	public RoundStats() {
	}
	
	
}
