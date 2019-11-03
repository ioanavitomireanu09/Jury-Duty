package com.mps.juryapp.dto;

public class UserDto {
	private Integer id;
	private String username;
	private String password;
	private String token;
	private Integer idConcurs;
	private String firstName;
	private String lastName;
	private String group;

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getIdConcurs() {
		return idConcurs;
	}

	public void setIdConcurs(Integer idConcurs) {
		this.idConcurs = idConcurs;
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

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public UserDto(Integer id, String username, String password, String token, Integer idConcurs, String firstName,
			String lastName, String group) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.token = token;
		this.idConcurs = idConcurs;
		this.firstName = firstName;
		this.lastName = lastName;
		this.group = group;
	}

	public UserDto() {

	}

}
