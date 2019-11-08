package com.mps.juryapp.dto;

public class GradeWeight {
	Integer gradeType;
	Integer gradeWeight;
	public Integer getGradeType() {
		return gradeType;
	}
	public void setGradeType(Integer gradeType) {
		this.gradeType = gradeType;
	}
	public Integer getGradeWeight() {
		return gradeWeight;
	}
	public void setGradeWeight(Integer gradeWeight) {
		this.gradeWeight = gradeWeight;
	}
	public GradeWeight(Integer gradeType, Integer gradeWeight) {
		super();
		this.gradeType = gradeType;
		this.gradeWeight = gradeWeight;
	}
	public GradeWeight() {
	}	
	
}
