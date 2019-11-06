package com.mps.juryapp.dto;

public class TeamDto {
	private Integer id;
	private String name;
	private String password;
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
	public TeamDto(Integer id, String name, String password, Integer numOfParticipants) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.numOfParticipants = numOfParticipants;
	}
	
	public TeamDto() {}
}
