package com.mps.juryapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "num_of_participants")
	private Integer numOfParticipants;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getNumOfParticipants() {
		return numOfParticipants;
	}

	public void setNumOfParticipants(Integer numOfParticipants) {
		this.numOfParticipants = numOfParticipants;
	}

	public Team(Integer id, String name, String password, Integer numOfParticipants) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.numOfParticipants = numOfParticipants;
	}

	public Team() {
	}

}
