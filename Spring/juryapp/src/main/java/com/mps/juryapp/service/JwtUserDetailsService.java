package com.mps.juryapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mps.juryapp.repository.UserRepository;
import com.mps.juryapp.model.User;
import com.mps.juryapp.dto.UserDto;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsrNam(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsrNam(), user.getUsrPass(),
				new ArrayList<>());
	}
	
	public User save(UserDto user) {
		User newUser = new User();
		newUser.setUsrNam(user.getUsername());
		newUser.setUsrPass(bcryptEncoder.encode(user.getPassword()));
		newUser.setFirstNam(user.getFirstName());
		newUser.setIdConcurs(user.getIdConcurs());
		newUser.setLastNam(user.getLastName());
		newUser.setUsrGroup(user.getGroup());

		return userRepository.save(newUser);
	}
}