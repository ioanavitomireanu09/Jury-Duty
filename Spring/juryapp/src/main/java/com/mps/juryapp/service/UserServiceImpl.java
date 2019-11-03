package com.mps.juryapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.juryapp.dto.UserDto;
import com.mps.juryapp.model.User;
import com.mps.juryapp.repository.UserRepository;
import com.mps.juryapp.util.BuilderDBtoDto;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BuilderDBtoDto builderDBtoDto;
	
	public List<UserDto> getUsers() {
		List<UserDto> userDtoList = new ArrayList<UserDto>();
		
		List<User> userList = userRepository.findAll();
		for(User user : userList) {
			userDtoList.add(builderDBtoDto.userToUserDto(user));
		}
		return userDtoList;
	}
	
}
