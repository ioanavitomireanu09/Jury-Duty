package com.mps.juryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.juryapp.model.UserGroup;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, String> {

}
