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
	private Integer idConcurs;

	@Column(name = "FIRST_NAM")
	private String firstNam;

	@Column(name = "LAST_NAM")
	private String lastNam;

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

	public Integer getIdConcurs() {
		return idConcurs;
	}

	public void setIdConcurs(Integer idConcurs) {
		this.idConcurs = idConcurs;
	}

	public String getFirstNam() {
		return firstNam;
	}

	public void setFirstNam(String firstNam) {
		this.firstNam = firstNam;
	}

	public String getLastNam() {
		return lastNam;
	}

	public void setLastNam(String lastNam) {
		this.lastNam = lastNam;
	}

	public User(Integer id, String usrNam, String usrGroup, String usrPass, String usrToken, Integer idConcurs,
			String firstNam, String lastNam) {
		super();
		this.id = id;
		this.usrNam = usrNam;
		this.usrGroup = usrGroup;
		this.usrPass = usrPass;
		this.usrToken = usrToken;
		this.idConcurs = idConcurs;
		this.firstNam = firstNam;
		this.lastNam = lastNam;
	}

	public User() {
	}
}
