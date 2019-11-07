package com.mps.juryapp.service;

import com.mps.juryapp.model.GradeType;

public class GradeValue {
	private GradeType gradeType;
	private Integer value;
	
	public GradeType getGradeType() {
		return gradeType;
	}
	public void setGradeType(GradeType gradeType) {
		this.gradeType = gradeType;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public GradeValue(GradeType gradeType, Integer value) {
		super();
		this.gradeType = gradeType;
		this.value = value;
	}
	public GradeValue() {}
}
