package com.mps.juryapp.dto;

public class UserDto {
	private Integer id;
	private String username;
	private String password;
	private Integer groupId;
	private String firstName;
	private String lastName;

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Integer getGroupId() {
		return groupId;
	}



	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserDto(Integer id, String username, String password, Integer groupId, String firstName, String lastName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.groupId = groupId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public UserDto() {
	}

}
