package com.iiht.training.eloan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.dto.exception.ExceptionResponse;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.AdminService;
import com.iiht.training.eloan.service.EMParser;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Transactional
	@Override
	public UserDto registerClerk(UserDto userDto) throws ExceptionResponse {
		if (userDto!=null) {
			if(usersRepository.existsById(userDto.getId())) {
				throw new ExceptionResponse("User "+userDto.getId()+" already exists");				
			}
			userDto=EMParser.parse(usersRepository.save(EMParser.parse(userDto)));
			
		}
		return userDto;
	}
	@Transactional
	@Override
	public UserDto registerManager(UserDto userDto) throws ExceptionResponse {
		if (userDto!=null) {
			if(usersRepository.existsById(userDto.getId())) {
				throw new ExceptionResponse("User "+userDto.getId()+" already exists");				
			}
			userDto=EMParser.parse(usersRepository.save(EMParser.parse(userDto)));
			
		}
		return userDto;
	}

	@Override	
	public List<UserDto> getAllClerks(String role) throws ExceptionResponse{		
		return usersRepository.findAll().stream().map(e->EMParser.parse(e)).collect(Collectors.toList());
	}

	@Override
	public List<UserDto> getAllManagers() throws ExceptionResponse{
		return usersRepository.findAll().stream().map(e->EMParser.parse(e)).collect(Collectors.toList());
	}

}
