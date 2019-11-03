package com.mps.juryapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.juryapp.model.User;
import com.mps.juryapp.repository.AuthRepository;


@CrossOrigin(origins = "*")
@RequestMapping(value = "/auth")
@RestController
public class AuthController {
	
	@Autowired
	private AuthRepository authRepository;
	

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public List<User> home(){
        return authRepository.findAll();
    }
}
