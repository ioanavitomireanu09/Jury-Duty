package com.mps.juryapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.juryapp.dto.GradeTypeDto;
import com.mps.juryapp.model.GradeType;
import com.mps.juryapp.repository.GradeTypeRepository;
import com.mps.juryapp.util.BuilderDto;

@Service
@Transactional
public class GradeTypeServiceImpl implements GradeTypeService {

	@Autowired
	GradeTypeRepository gradeTypeRepository;
	
	@Autowired
	BuilderDto builderDto;
	
	public List<GradeTypeDto> getGradeTypes() {
		List<GradeTypeDto> gradeTypeDtoList = new ArrayList<GradeTypeDto>();
		
		List<GradeType> gradeTypeList = gradeTypeRepository.findAll();
		for(GradeType gradeType : gradeTypeList) {
			gradeTypeDtoList.add(this.builderDto.gradeTypeToDto(gradeType));
		}
		return gradeTypeDtoList;
	}
	
}
