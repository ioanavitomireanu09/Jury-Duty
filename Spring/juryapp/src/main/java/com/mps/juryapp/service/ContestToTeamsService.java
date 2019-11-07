package com.mps.juryapp.service;

import java.util.List;

import com.mps.juryapp.dto.Stats;

public interface ContestToTeamsService {
	public List<Stats> getStats(Integer contestId);
}
