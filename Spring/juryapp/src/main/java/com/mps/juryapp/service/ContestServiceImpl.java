package com.mps.juryapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.juryapp.dto.ContestDto;
import com.mps.juryapp.dto.ContestToInsert;
import com.mps.juryapp.dto.GradeWeight;
import com.mps.juryapp.dto.ContestToTeamsDto;
import com.mps.juryapp.dto.Stats;
import com.mps.juryapp.model.Contest;
import com.mps.juryapp.model.ContestToGrades;
import com.mps.juryapp.model.User;
import com.mps.juryapp.model.UserToContest;
import com.mps.juryapp.repository.ContestRepository;
import com.mps.juryapp.repository.ContestToGradesRepository;
import com.mps.juryapp.repository.UserRepository;
import com.mps.juryapp.repository.UserToContestRepository;
import com.mps.juryapp.repository.ContestToTeamsRepository;
import com.mps.juryapp.util.BuilderDto;

@Service
@Transactional
public class ContestServiceImpl implements ContestService {

	@Autowired
	ContestRepository contestRepository;
	@Autowired
	UserRepository 	userRepository;
	@Autowired
	UserToContestRepository userToContestRepository;
	@Autowired
	ContestToGradesRepository contestToGradesRepository; 

	ContestToTeamsService contestToTeamsService;
	@Autowired
	ContestToTeamsServiceImpl contestToTeamsServiceImpl;
	@Autowired
	ContestToTeamsRepository contestToTeamsRepository;
	
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
	
	public String createContest(ContestToInsert contestToInsert) {
		String respose = "";
		Contest contest = new Contest();
		contest.setName(contestToInsert.getName());
		contest.setContestTypeId(1);
		contest.setIsPrivate(contestToInsert.getIsPrivate());
		contest.setTieBreakerId(1);
		contest.setNumOfJurys(contestToInsert.getNumOfJurys());
		contest.setPassword(contestToInsert.getPassword());
		contest.setNumOfRounds(contestToInsert.getNumOfRounds());
		contest.setRoundState(0);
		contest.setState(0);
		contest.setCurrentRound(0);
		contest.setRoundState(0);
		contest.setTieBreakerId(1);
		contest.setNumOfParticipants(0);
		
		try {
			contestRepository.save(contest);
			Contest createdContest = contestRepository.findByName(contestToInsert.getName()).orElse(null);
			
			if (createdContest != null) {
				for(GradeWeight item : contestToInsert.getGradeWeightList()) {
					ContestToGrades contestToGrades = new ContestToGrades();
					contestToGrades.setContestId(createdContest.getId());
					contestToGrades.setGradeTypeId(item.getGradeType());
					contestToGrades.setGradeWeight(item.getGradeWeight());
					
					contestToGradesRepository.save(contestToGrades);
				}
			}		
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
	
	public String updateContest(ContestToInsert contestToInsert) {
		String respose = "";
		Contest contest = contestRepository.findByName(contestToInsert.getName()).orElse(null);
		if (contest != null) {
			contest.setName(contestToInsert.getName());
			contest.setIsPrivate(contestToInsert.getIsPrivate());
			contest.setNumOfJurys(contestToInsert.getNumOfJurys());
			contest.setPassword(contestToInsert.getPassword());
			contest.setNumOfRounds(contestToInsert.getNumOfRounds());	
			try {
				contestRepository.save(contest);
				Contest createdContest = contestRepository.findByName(contestToInsert.getName()).orElse(null);
				
				if (createdContest != null) {
					for(GradeWeight item : contestToInsert.getGradeWeightList()) {
						ContestToGrades contestToGrades = new ContestToGrades();
						contestToGrades.setContestId(createdContest.getId());
						contestToGrades.setGradeTypeId(item.getGradeType());
						contestToGrades.setGradeWeight(item.getGradeWeight());
						
						contestToGradesRepository.save(contestToGrades);
					}
				}		
				respose = "SUCCESS";
			} catch (Exception e) {
				// TODO: handle exception
				respose = "ERROR";
			}	
		}
		return respose;
	}

	@Override
	public List<ContestDto> getContests(String username) {
		User user = userRepository.findByUsername(username);
		List<ContestDto> contestsDtoList = new ArrayList<ContestDto>();
		List<Contest> contestList = new ArrayList<Contest>();
		if(user.getGroupId() == "JRT") {
			List<Integer> contestForUser = (List<Integer>) userToContestRepository.findByUsername(username).stream().map(contestToUser -> {
				return contestToUser.getContest_id();
			});
			contestList = (List<Contest>) contestRepository.findAll().stream().filter((contest) -> contestForUser.indexOf(contest.getId()) != -1);
			for(Contest contest : contestList) {
				contestsDtoList.add(this.builderDto.contestToDto(contest));
			}			
		} else if (user.getGroupId() == "ORG") {
			contestList = (List<Contest>) contestRepository.findAll().stream().filter((contest) -> contest.getOrgUsername().equals(username));
			for(Contest contest : contestList) {
				contestsDtoList.add(this.builderDto.contestToDto(contest));
			}			
		} else if (user.getGroupId() == "ADM"){
			contestList = contestRepository.findAll();
			for(Contest contest : contestList) {
				contestsDtoList.add(this.builderDto.contestToDto(contest));
			}
		}
		return contestsDtoList;
	}

	@Override
	public String addUserToContest(UserToContest userToContest) {
		String response = "";
		try {
			userToContestRepository.save(userToContest);
			response = "SUCCESS";
		} catch (Exception e) {
			// TODO: handle exception
			response = "ERROR";
		}
		return response;
	}

	@Override
	public ContestDto startContest(Integer contestId) {
		return modifyState(contestId, 1);
	}
	
	@Override
	public ContestDto stopContest(Integer contestId) {
		return modifyState(contestId, 2);
	}
	
	@Override
	public ContestDto modifyState (Integer contestId, Integer state) {
		ContestDto returnedContest = new ContestDto();
		List<Contest> contestList = contestRepository.findAll();
		for (Contest contest : contestList) {
			if (contest.getId() == contestId) {
				contest.setState(state);
				returnedContest.setState(state);
				try {
					updateContest(contest);
				} catch (Exception e) {
				}
			}
		}
		return returnedContest;
	}

	@Override
	public ContestDto startRound(Integer contestId) {
		ContestDto returnedContest = new ContestDto();
		List<Contest> contestList = contestRepository.findAll();
		for (Contest contest : contestList) {
			if (contest.getId() == contestId) {
				contest.setRoundState(1);
				returnedContest.setRound_state(1);
				try {
					updateContest(contest);
				} catch (Exception e) {
				}
			}
		}
		return returnedContest;
	}

	class GradeComparator implements Comparator<Stats> {
		
		@Override
	    public int compare(Stats a, Stats b) {
	        if (a.getAverageGrade() > b.getAverageGrade())
	        	return -1;
	        return 1;
	    }
	}
	
	@Override
	public ContestDto stopRound(Integer contestId) {

		ContestDto returnedContest = new ContestDto();
		List<Contest> contestList = contestRepository.findAll();
		for (Contest contest : contestList) {
			if (contest.getId() == contestId) {
				contest.setCurrentRound(contest.getCurrentRound() + 1);
				returnedContest.setCurrent_round(returnedContest.getCurrent_round() + 1);
				if (contest.getCurrentRound() == contest.getNumOfRounds()) {
					contest.setRoundState(2);
					returnedContest.setRound_state(2);
				} else {
					contest.setRoundState(0);
					returnedContest.setRound_state(0);
				}
				try {
					int elim = contest.getNumOfParticipants() / (contest.getNumOfRounds() - contest.getCurrentRound());
					if (elim > contest.getNumOfParticipants()) {
						contest.setCurrentRound(contest.getNumOfRounds());
					} else {
						contest.setNumOfParticipants(contest.getNumOfParticipants() - elim);
						List<Stats> stats = contestToTeamsService.getStats(contestId);
						//suppose grades are already submitted
						Collections.sort(stats, new GradeComparator());
						//TODO: delete
					}
					
					updateContest(contest);
				} catch (Exception e) {
					//TODO: nothing again :)
				}
			}
		}
		return returnedContest;
	}
}
