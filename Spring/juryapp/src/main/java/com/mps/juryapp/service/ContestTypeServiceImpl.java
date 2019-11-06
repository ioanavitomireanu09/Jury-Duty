package com.mps.juryapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.juryapp.dto.ContestTypeDto;
import com.mps.juryapp.dto.UserDto;
import com.mps.juryapp.model.ContestType;
import com.mps.juryapp.model.User;
import com.mps.juryapp.repository.ContestTypeRepository;
import com.mps.juryapp.repository.UserRepository;
import com.mps.juryapp.util.BuilderDto;

@Service
@Transactional
public class ContestTypeServiceImpl implements ContestTypeService {

	@Autowired
	ContestTypeRepository contestTypeRepository;
	
	@Autowired
	BuilderDto builderDto;
	
	public List<ContestTypeDto> getContestTypes() {
		List<ContestTypeDto> contestTypeDtoList = new ArrayList<ContestTypeDto>();
		
		List<ContestType> contestTypeList = contestTypeRepository.findAll();
		for(ContestType contestType : contestTypeList) {
			contestTypeDtoList.add(this.builderDto.contestTypeToDto(contestType));
		}
		return contestTypeDtoList;
	}
	
}
