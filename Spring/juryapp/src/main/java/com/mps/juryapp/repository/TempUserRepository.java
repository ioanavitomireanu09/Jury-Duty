package com.mps.juryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.juryapp.model.TempUser;

@Repository
public interface TempUserRepository extends JpaRepository<TempUser, Integer> {

}
