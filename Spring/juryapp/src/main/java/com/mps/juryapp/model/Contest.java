package com.mps.juryapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contest")
public class Contest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "contest_type_id")
	private Integer contestTypeId;

	@Column(name = "state")
	private Integer state;

	@Column(name = "current_round")
	private Integer currentRound;

	@Column(name = "round_sate")
	private Integer roundState;

	@Column(name = "num_of_participants")
	private Integer numOfParticipants;

	@Column(name = "is_private")
	private Integer isPrivate;

	@Column(name = "tie_breaker_id")
	private Integer tieBreakerId;

	@Column(name = "num_of_jurys")
	private Integer numOfJurys;

	@Column(name = "possword")
	private String password;

	@Column(name = "num_of_rounds")
	private Integer numOfRounds;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getCurrentRound() {
		return currentRound;
	}

	public void setCurrentRound(Integer currentRound) {
		this.currentRound = currentRound;
	}

	public Integer getRoundState() {
		return roundState;
	}

	public void setRoundState(Integer roundState) {
		this.roundState = roundState;
	}

	public Integer getNumOfParticipants() {
		return numOfParticipants;
	}

	public void setNumOfParticipants(Integer numOfParticipants) {
		this.numOfParticipants = numOfParticipants;
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

	public Contest(Integer id, String name, Integer contestTypeId, Integer state, Integer currentRound,
			Integer roundState, Integer numOfParticipants, Integer isPrivate, Integer tieBreakerId, Integer numOfJurys,
			String password, Integer numOfRounds) {
		super();
		this.id = id;
		this.name = name;
		this.contestTypeId = contestTypeId;
		this.state = state;
		this.currentRound = currentRound;
		this.roundState = roundState;
		this.numOfParticipants = numOfParticipants;
		this.isPrivate = isPrivate;
		this.tieBreakerId = tieBreakerId;
		this.numOfJurys = numOfJurys;
		this.password = password;
		this.numOfRounds = numOfRounds;
	}

	public Contest() {
	}

}
