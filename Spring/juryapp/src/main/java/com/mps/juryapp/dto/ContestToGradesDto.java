package com.mps.juryapp.dto;

public class ContestToGradesDto {

	private Integer id;
	private Integer contest_id;
	private String grade_type_id;
	private Integer grade_weight;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getContest_id() {
		return contest_id;
	}
	public void setContest_id(Integer contest_id) {
		this.contest_id = contest_id;
	}
	public String getGrade_type_id() {
		return grade_type_id;
	}
	public void setGrade_type_id(String grade_type_id) {
		this.grade_type_id = grade_type_id;
	}
	public Integer getGrade_weight() {
		return grade_weight;
	}
	public void setGrade_weight(Integer grade_weight) {
		this.grade_weight = grade_weight;
	}
	public ContestToGradesDto(Integer id, Integer contest_id, String grade_type_id, Integer grade_weight) {
		super();
		this.id = id;
		this.contest_id = contest_id;
		this.grade_type_id = grade_type_id;
		this.grade_weight = grade_weight;
	}
	
	public ContestToGradesDto() {}
	
}
