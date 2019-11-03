package com.mps.juryapp.util;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.juryapp.dto.UserDto;
import com.mps.juryapp.model.User;

@Service
@Transactional
public class BuilderDBtoDto {

	public UserDto userToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setFirstName(user.getFirstNam());
		userDto.setId(user.getId());
		userDto.setIdConcurs(user.getIdConcurs());
		userDto.setLastName(user.getLastNam());
		userDto.setPassword(user.getUsrPass());
		userDto.setToken(user.getUsrToken());
		userDto.setUsername(user.getUsrNam());
		userDto.setGroup(user.getUsrGroup());

		return userDto;
	}

}
