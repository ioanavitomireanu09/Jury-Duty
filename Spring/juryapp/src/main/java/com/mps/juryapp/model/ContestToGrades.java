package com.mps.juryapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contest_to_grades")
public class ContestToGrades {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "contest_id")
	private Integer contestId;
	
	@Column(name = "grade_type_id")
	private String gradeTypeId;

	@Column(name = "grade_weight")
	private Integer gradeWeight;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContestId() {
		return contestId;
	}

	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}

	public String getGradeTypeId() {
		return gradeTypeId;
	}

	public void setGradeTypeId(String gradeTypeId) {
		this.gradeTypeId = gradeTypeId;
	}

	public Integer getGradeWeight() {
		return gradeWeight;
	}

	public void setGradeWeight(Integer gradeWeight) {
		this.gradeWeight = gradeWeight;
	}

	public ContestToGrades(Integer id, Integer contestId, String gradeTypeId, Integer gradeWeight) {
		super();
		this.id = id;
		this.contestId = contestId;
		this.gradeTypeId = gradeTypeId;
		this.gradeWeight = gradeWeight;
	}
	
	public ContestToGrades() {}

}
