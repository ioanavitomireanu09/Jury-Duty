package com.mps.juryapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contest_to_teams")
public class ContestToTeams {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "contest_id")
	private Integer contestId;

	@Column(name = "team_id")
	private Integer teamId;
	
	@Column(name = "disqualified")
	private Integer disqualified;

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

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeam_id(Integer teamId) {
		this.teamId = teamId;
	}

	public Integer getDisqualified() {
		return disqualified;
	}

	public void setDisqualified(Integer disqualified) {
		this.disqualified = disqualified;
	}

	public ContestToTeams(Integer id, Integer contestId, Integer teamId, Integer disqualified) {
		super();
		this.id = id;
		this.contestId = contestId;
		this.teamId = teamId;
		this.disqualified = disqualified;
	}

	public ContestToTeams() {	}
	
}
