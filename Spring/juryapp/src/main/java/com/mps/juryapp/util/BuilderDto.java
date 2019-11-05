package com.mps.juryapp.util;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.juryapp.dto.UserDto;
import com.mps.juryapp.model.User;

@Service
@Transactional
public class BuilderDto {

	public UserDto userToDto(User user) {
		UserDto userDto = new UserDto();

		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setGroupId(user.getGroupId());

		return userDto;
	}

}
