package com.mps.juryapp.dto;

public class GradeWeight {
	String gradeType;
	Integer gradeWeight;
	
	public String getGradeType() {
		return gradeType;
	}
	public void setGradeType(String gradeType) {
		this.gradeType = gradeType;
	}
	public Integer getGradeWeight() {
		return gradeWeight;
	}
	public void setGradeWeight(Integer gradeWeight) {
		this.gradeWeight = gradeWeight;
	}
	public GradeWeight(String gradeType, Integer gradeWeight) {
		super();
		this.gradeType = gradeType;
		this.gradeWeight = gradeWeight;
	}
	public GradeWeight() {
	}	
	
}
