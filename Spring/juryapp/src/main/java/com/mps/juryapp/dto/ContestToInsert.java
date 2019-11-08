package com.mps.juryapp.dto;
import java.util.List;

import com.mps.juryapp.dto.GradeWeight;

public class ContestToInsert {
	private String name;
	private Integer contestTypeId;
	private Integer isPrivate;
	private Integer tieBreakerId;
	private Integer numOfJurys;
	private String password;
	private Integer numOfRounds;
	private List<GradeWeight> gradeWeightList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getContestTypeId() {
		return contestTypeId;
	}
	public void setContestTypeId(Integer contestTypeId) {
		this.contestTypeId = contestTypeId;
	}
	public Integer getIsPrivate() {
		return isPrivate;
	}
	public void setIsPrivate(Integer isPrivate) {
		this.isPrivate = isPrivate;
	}
	public Integer getTieBreakerId() {
		return tieBreakerId;
	}
	public void setTieBreakerId(Integer tieBreakerId) {
		this.tieBreakerId = tieBreakerId;
	}
	public Integer getNumOfJurys() {
		return numOfJurys;
	}
	public void setNumOfJurys(Integer numOfJurys) {
		this.numOfJurys = numOfJurys;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getNumOfRounds() {
		return numOfRounds;
	}
	public void setNumOfRounds(Integer numOfRounds) {
		this.numOfRounds = numOfRounds;
	}
	public List<GradeWeight> getGradeWeightList() {
		return gradeWeightList;
	}
	public void setGradeWeightList(List<GradeWeight> gradeWeightList) {
		this.gradeWeightList = gradeWeightList;
	}
	public ContestToInsert(String name, Integer contestTypeId, Integer isPrivate, Integer tieBreakerId,
			Integer numOfJurys, String password, Integer numOfRounds, List<GradeWeight> gradeWeightList) {
		super();
		this.name = name;
		this.contestTypeId = contestTypeId;
		this.isPrivate = isPrivate;
		this.tieBreakerId = tieBreakerId;
		this.numOfJurys = numOfJurys;
		this.password = password;
		this.numOfRounds = numOfRounds;
		this.gradeWeightList = gradeWeightList;
	}
	public ContestToInsert() {
	}	
}
