package com.mps.juryapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.juryapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
	Optional<User> findById(Integer id);
}
