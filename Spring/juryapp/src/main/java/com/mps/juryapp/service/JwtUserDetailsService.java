package com.mps.juryapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mps.juryapp.repository.TempUserRepository;
import com.mps.juryapp.repository.UserRepository;
import com.mps.juryapp.model.TempUser;
import com.mps.juryapp.model.User;
import com.mps.juryapp.dto.UserDto;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TempUserRepository tempUserRepository;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public User save(UserDto user) {
		User newUser = new User(user.getUsername(), bcryptEncoder.encode(user.getPassword()), user.getGroupId(),
				user.getFirstName(), user.getLastName());
		if (!userRepository.existsById(newUser.getId())) {
			if (newUser.getGroupId() == "ORG" || newUser.getGroupId() == "ADM") {
				TempUser tempUser = new TempUser(user.getUsername(), user.getPassword(),
						user.getGroupId(), user.getFirstName(), user.getLastName());
				try {
					tempUserRepository.save(tempUser);
					return newUser;
				} catch (Exception e) {
					return new User();
				}
			} else
				return userRepository.save(newUser);
		} else
			return new User();
	}
}