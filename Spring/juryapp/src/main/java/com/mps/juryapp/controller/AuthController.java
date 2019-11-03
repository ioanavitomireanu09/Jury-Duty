package com.mps.juryapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.juryapp.dto.UserDto;
import com.mps.juryapp.service.UserServiceImpl;


@CrossOrigin(origins = "*")
@RequestMapping(value = "/auth")
@RestController
public class AuthController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public List<UserDto> home(){
        return userServiceImpl.getUsers();
    }
}
