package com.mps.juryapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grades")
public class Grades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "team_id")
	private Integer teamId;

	@Column(name = "value")
	private Integer value;

	@Column(name = "contest_id")
	private Integer contestId;

	@Column(name = "round_id")
	private Integer roundId;

	@Column(name = "jury_id")
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

	public Grades(Integer id, Integer teamId, Integer value, Integer contestId, Integer roundId, Integer juryId) {
		super();
		this.id = id;
		this.teamId = teamId;
		this.value = value;
		this.contestId = contestId;
		this.roundId = roundId;
		this.juryId = juryId;
	}

	public Grades() {
	}

}
