package com.mps.juryapp.dto;

public class UserGroupDto {
	private String groupId;
	private String description;
	private String name;
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserGroupDto(String groupId, String description, String name) {
		super();
		this.groupId = groupId;
		this.description = description;
		this.name = name;
	}
	
	public UserGroupDto() {}
}
