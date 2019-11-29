package com.mps.juryapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.juryapp.dto.AddUserToContest;
import com.mps.juryapp.dto.ContestDto;
import com.mps.juryapp.dto.GradesDto;
import com.mps.juryapp.dto.ContestToInsert;
import com.mps.juryapp.dto.Stats;
import com.mps.juryapp.model.Contest;
import com.mps.juryapp.model.Grades;
import com.mps.juryapp.model.JwtRequest;
import com.mps.juryapp.model.Team;
import com.mps.juryapp.model.TempUser;
import com.mps.juryapp.model.UserGroup;
import com.mps.juryapp.model.UserToContest;
import com.mps.juryapp.model.UsersInTeams;
import com.mps.juryapp.repository.TempUserRepository;
import com.mps.juryapp.repository.UserGroupRepository;
import com.mps.juryapp.repository.UsersInTeamsRepository;
import com.mps.juryapp.service.ContestService;
import com.mps.juryapp.service.ContestToTeamsService;
import com.mps.juryapp.service.GradesService;
import com.mps.juryapp.service.UserService;
import com.mps.juryapp.service.VoteTeam;

@RestController
@CrossOrigin(origins = "*")
public class CoreController {
	@Autowired
	TempUserRepository tempUserRepository;
	@Autowired
	UserGroupRepository userGroupRepository; 
	@Autowired
	UsersInTeamsRepository usersInTeamsRepository;
	
	@Autowired
	UserService userService;
	@Autowired
	ContestService contestService;
	@Autowired
	ContestToTeamsService contestToTeamsService;
	@Autowired
	GradesService gradesService;
	
	@RequestMapping(value = "/user-requests", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<TempUser>> getUserRequests() {
		
		return ResponseEntity.ok(tempUserRepository.findAll());
	}
	
	@RequestMapping(value = "/accept-user", method = RequestMethod.POST, consumes=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public ResponseEntity<String> acceptUser(@RequestBody String username) {
		return ResponseEntity.ok(userService.acceptUser(username));
	}
	
	@RequestMapping(value = "/decline-user", method = RequestMethod.POST, consumes=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public ResponseEntity<String> declineUser(@RequestBody String username) {
		return ResponseEntity.ok(userService.declineUser(username));
	}
	
	@RequestMapping(value = "/user-groups", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<UserGroup>> getGroups() {
		
		return ResponseEntity.ok(userGroupRepository.findAll());
	}
	
	@RequestMapping(value = "/create-contest", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> createContest(@RequestBody ContestToInsert contestToInsert) {
		return ResponseEntity.ok(contestService.createContest(contestToInsert));
	}
	
	@RequestMapping(value = "/update-contest", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> updateContest(@RequestBody ContestToInsert contest) {
		return ResponseEntity.ok(contestService.updateContest(contest));
	}
	
	@RequestMapping(value = "/delete-contest", method = RequestMethod.POST, consumes=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public ResponseEntity<String> deleteContest(@RequestBody Integer idContests) {
		return ResponseEntity.ok(contestService.deleteContest(idContests));
	}
	
	@RequestMapping(value = "/get-contests", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<ContestDto>> getContests(@RequestParam(name = "username", required = false) String username) {
		if (username == null) {
			return ResponseEntity.ok(contestService.getContests());			
		} else {
			return ResponseEntity.ok(contestService.getContests(username));	
		}
	}
	
	@RequestMapping(value = "/add-user-contest", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> addUserToContest(@RequestBody UserToContest userToContest) {
		return ResponseEntity.ok(contestService.addUserToContest(userToContest));
	}
	
	@RequestMapping(value = "/add-user-team", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> addUserToContest(@RequestBody UsersInTeams usersInTeams) {
		String response = "";
		try {
			usersInTeamsRepository.save(usersInTeams);
			response = "SUCCESS";
		} catch (Exception e) {
			// TODO: handle exception
			response = "ERROR";
		}
		return ResponseEntity.ok(response);
	}
	
//	@RequestMapping(value = "/get-teams", method = RequestMethod.GET, produces = "application/json")
//	@ResponseBody
//	public ResponseEntity<List<Team>> getTeams(@RequestParam(name = "username", required = false) String username) {
//		if (username == null) {
//			return ResponseEntity.ok(contestService.getContests());			
//		} else {
//			return ResponseEntity.ok(contestService.getContests(username));	
//		}
//	}
	
	@RequestMapping(value = "/get-stats", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Stats>> getTeamsStats(@RequestBody Integer idContests) {
		
		return ResponseEntity.ok(contestToTeamsService.getStats(idContests));
	}

	@RequestMapping(value = "/start-contest", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<ContestDto> startContest(@RequestBody Integer contestId) {
		return ResponseEntity.ok(contestService.startContest(contestId));
	}
	
	@RequestMapping(value = "/stop-contest", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<ContestDto> stopContest(@RequestBody Integer contestId) {
		return ResponseEntity.ok(contestService.stopContest(contestId));
	}
	
	@RequestMapping(value = "/start-round", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<ContestDto> startRound(@RequestBody Integer contestId) {
		return ResponseEntity.ok(contestService.startRound(contestId));
	}
	
	@RequestMapping(value = "/stop-round", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<ContestDto> stopRound(@RequestBody Integer contestId) {
		return ResponseEntity.ok(contestService.stopRound(contestId));
	}
	
	@RequestMapping(value = "/set-grades", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Grades> SetGrades(@RequestBody VoteTeam vote) {
		return ResponseEntity.ok(gradesService.SetGrades(vote));
	}
	
}
