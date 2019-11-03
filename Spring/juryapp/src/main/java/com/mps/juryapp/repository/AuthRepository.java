package com.mps.juryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.juryapp.model.User;


@Repository
public interface AuthRepository extends JpaRepository<User, Integer> {

}
