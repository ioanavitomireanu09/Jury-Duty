package com.mps.juryapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.juryapp.model.TempUser;
import com.mps.juryapp.repository.TempUserRepository;

@RestController
@CrossOrigin
public class CoreController {
	@Autowired
	TempUserRepository tempUserRepository;
	
	@RequestMapping(value = "/user-requests", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<TempUser>> getUserRequests() {
		
		return ResponseEntity.ok(tempUserRepository.findAll());
	}

}
