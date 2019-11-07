package com.mps.juryapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.juryapp.dto.ContestDto;
import com.mps.juryapp.model.Contest;
import com.mps.juryapp.repository.ContestRepository;
import com.mps.juryapp.util.BuilderDto;

@Service
@Transactional
public class ContestServiceImpl implements ContestService {

	@Autowired
	ContestRepository contestRepository;
	
	@Autowired
	BuilderDto builderDto;
	
	public List<ContestDto> getContests() {
		List<ContestDto> contestsDtoList = new ArrayList<ContestDto>();
		
		List<Contest> contestList = contestRepository.findAll();
		for(Contest contest : contestList) {
			contestsDtoList.add(this.builderDto.contestToDto(contest));
		}
		return contestsDtoList;
	}
	
	public String createContest(Contest contest) {
		String respose = "";
		try {
			contestRepository.save(contest);
			respose = "SUCCESS";
		} catch (Exception e) {
			// TODO: handle exception
			respose = "ERROR";
		}
		return respose;
	}
	
	public String deleteContest(Integer idContest) {
		String response = "";
		Contest contest = contestRepository.findById(idContest).orElse(null);
		if(contest != null) {
			contestRepository.delete(contest);
			response = "SUCCESS";
		} else {
			response = "ERROR";
		}
		return response;
	}
	
	public String updateContest(Contest contest) {
		String response = "";
		Contest updateContest = contestRepository.findById(contest.getId()).orElse(null);
		try {
			contestRepository.save(contest);
			response = "SUCCESS";
		} catch (Exception e) {
			// TODO: handle exception
			response = "ERROR";
		}
		return response;
	}
}
