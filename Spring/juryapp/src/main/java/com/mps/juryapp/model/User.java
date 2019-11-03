package com.mps.juryapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "USR_NAM")
	private String usrNam;

	@Column(name = "USR_GROUP")
	private String usrGroup;

	@Column(name = "USR_PASS")
	private String usrPass;

	@Column(name = "USR_TOKEN")
	private String usrToken;

	@Column(name = "ID_CONCURS")
	private String idConcurs;

	@Column(name = "NICKNAME")
	private String nickname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsrNam() {
		return usrNam;
	}

	public void setUsrNam(String usrNam) {
		this.usrNam = usrNam;
	}

	public String getUsrGroup() {
		return usrGroup;
	}

	public void setUsrGroup(String usrGroup) {
		this.usrGroup = usrGroup;
	}

	public String getUsrPass() {
		return usrPass;
	}

	public void setUsrPass(String usrPass) {
		this.usrPass = usrPass;
	}

	public String getUsrToken() {
		return usrToken;
	}

	public void setUsrToken(String usrToken) {
		this.usrToken = usrToken;
	}

	public String getIdConcurs() {
		return idConcurs;
	}

	public void setIdConcurs(String idConcurs) {
		this.idConcurs = idConcurs;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public User(Integer id, String usrNam, String usrGroup, String usrPass, String usrToken, String idConcurs,
			String nickname) {
		super();
		this.id = id;
		this.usrNam = usrNam;
		this.usrGroup = usrGroup;
		this.usrPass = usrPass;
		this.usrToken = usrToken;
		this.idConcurs = idConcurs;
		this.nickname = nickname;
	}

	public User() {}
}
