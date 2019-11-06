package com.mps.juryapp.dto;

public class ContestDto {
	private Integer id;
	private String name;
	private Integer contest_type_id;
	private Integer state;
	private Integer current_round;
	private Integer round_state;
	private Integer num_of_participants;
	private Integer is_private;
	private Integer tie_breaker_id;
	private Integer num_of_jurys;
	private String password;
	private Integer num_of_rounds;
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
	public Integer getContest_type_id() {
		return contest_type_id;
	}
	public void setContest_type_id(Integer contest_type_id) {
		this.contest_type_id = contest_type_id;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getCurrent_round() {
		return current_round;
	}
	public void setCurrent_round(Integer current_round) {
		this.current_round = current_round;
	}
	public Integer getRound_state() {
		return round_state;
	}
	public void setRound_state(Integer round_state) {
		this.round_state = round_state;
	}
	public Integer getNum_of_participants() {
		return num_of_participants;
	}
	public void setNum_of_participants(Integer num_of_participants) {
		this.num_of_participants = num_of_participants;
	}
	public Integer getIs_private() {
		return is_private;
	}
	public void setIs_private(Integer is_private) {
		this.is_private = is_private;
	}
	public Integer getTie_breaker_id() {
		return tie_breaker_id;
	}
	public void setTie_breaker_id(Integer tie_breaker_id) {
		this.tie_breaker_id = tie_breaker_id;
	}
	public Integer getNum_of_jurys() {
		return num_of_jurys;
	}
	public void setNum_of_jurys(Integer num_of_jurys) {
		this.num_of_jurys = num_of_jurys;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getNum_of_rounds() {
		return num_of_rounds;
	}
	public void setNum_of_rounds(Integer num_of_rounds) {
		this.num_of_rounds = num_of_rounds;
	}
	public ContestDto(Integer id, String name, Integer contest_type_id, Integer state, Integer current_round,
			Integer round_state, Integer num_of_participants, Integer is_private, Integer tie_breaker_id,
			Integer num_of_jurys, String password, Integer num_of_rounds) {
		super();
		this.id = id;
		this.name = name;
		this.contest_type_id = contest_type_id;
		this.state = state;
		this.current_round = current_round;
		this.round_state = round_state;
		this.num_of_participants = num_of_participants;
		this.is_private = is_private;
		this.tie_breaker_id = tie_breaker_id;
		this.num_of_jurys = num_of_jurys;
		this.password = password;
		this.num_of_rounds = num_of_rounds;
	}
	
	public ContestDto() {}
}
