package com.mps.juryapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.juryapp.dto.UserDto;
import com.mps.juryapp.model.TempUser;
import com.mps.juryapp.model.User;
import com.mps.juryapp.repository.TempUserRepository;
import com.mps.juryapp.repository.UserRepository;
import com.mps.juryapp.util.BuilderDto;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TempUserRepository tempUserRepository;

	
	@Autowired
	BuilderDto builderDto;

	public List<UserDto> getUsers() {
		List<UserDto> userDtoList = new ArrayList<UserDto>();

		List<User> userList = userRepository.findAll();
		for (User user : userList) {
			userDtoList.add(this.builderDto.userToDto(user));
		}
		return userDtoList;
	}

	public String acceptUser(String username) {
		String response = "";
		TempUser tempUser = tempUserRepository.findByUsername(username);
		if(tempUser != null) {
			User user = new User();
			user.setFirstName(tempUser.getFirstName());
			user.setLastName(tempUser.getLastName());
			user.setPassword(tempUser.getPassword());
			user.setUsername(tempUser.getUsername());
			user.setPassword(tempUser.getPassword());
			user.setGroupId(tempUser.getGroupId());
			userRepository.save(user);
			tempUserRepository.delete(tempUser);
			response = "SUCCESS";
		} else {
			response = "ERROR";
		}
		return response;
	}

	public String declineUser(String username) {
		String response = "";
		
		TempUser tempUser = tempUserRepository.findByUsername(username);
		if(tempUser != null) {
			tempUserRepository.delete(tempUser);
			response = "SUCCESS";
		} else {
			response = "ERROR";
		}
		
		return response;
	}

}
