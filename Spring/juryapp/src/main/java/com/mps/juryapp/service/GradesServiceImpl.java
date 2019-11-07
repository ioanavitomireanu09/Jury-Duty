package com.mps.juryapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.juryapp.dto.GradeTypeDto;
import com.mps.juryapp.dto.GradesDto;
import com.mps.juryapp.model.GradeType;
import com.mps.juryapp.model.Grades;
import com.mps.juryapp.repository.GradeTypeRepository;
import com.mps.juryapp.repository.GradesRepository;
import com.mps.juryapp.util.BuilderDto;

@Service
@Transactional
public class GradesServiceImpl implements GradesService {

	@Autowired
	GradesRepository gradesRepository;
	
	@Autowired
	BuilderDto builderDto;
	
}
