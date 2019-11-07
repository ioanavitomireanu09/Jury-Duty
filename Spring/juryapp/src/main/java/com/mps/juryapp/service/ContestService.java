package com.mps.juryapp.service;

import java.util.List;

import com.mps.juryapp.dto.ContestDto;
import com.mps.juryapp.model.Contest;

public interface ContestService {
	public List<ContestDto> getContests();
	public String createContest(Contest contest);
	public String deleteContest(Integer idContest);
	public String updateContest(Contest contest);
	public ContestDto startContest(Integer constestId);
	public ContestDto stopContest(Integer constestId);
	public ContestDto modifyState(Integer contestId, Integer state);
	public ContestDto startRound(Integer contestId);
	public ContestDto stopRound(Integer contestId);
	
}
