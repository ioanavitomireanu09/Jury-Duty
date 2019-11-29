package com.mps.juryapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.juryapp.model.UsersInTeams;

@Repository
public interface UsersInTeamsRepository extends JpaRepository<UsersInTeams, Integer> {
	List<UsersInTeams> findByTeamId(Integer teamId);
	List<UsersInTeams> findByUserId(Integer userId);
}
