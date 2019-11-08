package com.mps.juryapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_to_contest")
public class UserToContest {
	
	@Id
	@Column(name = "contest_id")
	Integer contest_id;
	
	@Column(name = "username")
	String username;

	public Integer getContest_id() {
		return contest_id;
	}

	public void setContest_id(Integer contest_id) {
		this.contest_id = contest_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserToContest(Integer contest_id, String username) {
		super();
		this.contest_id = contest_id;
		this.username = username;
	}
	
	public UserToContest() {}
	
}
