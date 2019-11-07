package com.mps.juryapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mps.juryapp.model.TempUser;
import com.mps.juryapp.repository.TempUserRepository;

@RestController
@CrossOrigin
public class UserController {
	@Autowired
	TempUserRepository tempUserRepository;

	@RequestMapping(value = "/tempUsers", method = RequestMethod.GET)
	public List<TempUser> getTempUsers() {
		return tempUserRepository.findAll();
	}
	
}
