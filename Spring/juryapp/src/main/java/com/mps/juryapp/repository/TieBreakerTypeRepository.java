package com.mps.juryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.juryapp.model.TieBreakerType;

@Repository
public interface TieBreakerTypeRepository extends JpaRepository<TieBreakerType, Integer> {
	TieBreakerType findByName(String name);
}
