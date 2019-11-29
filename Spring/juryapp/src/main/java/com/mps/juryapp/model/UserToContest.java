package com.mps.juryapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_to_contest")
public class UserToContest {
	
	@Id
	@Column(name = "id")
	Integer id;
	
	
	@Column(name = "contest_id")
	Integer contestId;
	
	@Column(name = "username")
	String username;

	

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserToContest(Integer contest_id, String username) {
		super();
		this.contestId = contest_id;
		this.username = username;
	}
	
	public UserToContest() {}
	
}
