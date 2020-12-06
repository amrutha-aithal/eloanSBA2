package com.iiht.training.eloan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.dto.exception.ExceptionResponse;
import com.iiht.training.eloan.exception.CustomerNotFoundException;
import com.iiht.training.eloan.exception.LoanNotFoundException;
import com.iiht.training.eloan.repository.LoanRepository;
import com.iiht.training.eloan.repository.ProcessingInfoRepository;
import com.iiht.training.eloan.repository.SanctionInfoRepository;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.CustomerService;
import com.iiht.training.eloan.service.EMParser;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private ProcessingInfoRepository pProcessingInfoRepository;
	
	@Autowired
	private SanctionInfoRepository sanctionInfoRepository;
	
	@Transactional
	@Override
	public UserDto register(UserDto userDto) throws ExceptionResponse {
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
	public LoanOutputDto applyLoan(Long customerId, LoanDto loanDto) {
		LoanOutputDto loanOutputDto=new LoanOutputDto();
		if (loanDto!=null) {
			if(usersRepository.existsById(customerId)) {
				loanOutputDto.setCustomerId(customerId);
				loanOutputDto.setLoanDto(loanDto);			
				loanOutputDto=EMParser.parse1(loanRepository.save(EMParser.parse(loanOutputDto)),loanDto);
			}			
		}
		return loanOutputDto;
	}

	@Override
	public LoanOutputDto getStatus(Long loanAppId) {
		LoanDto loanDto=new LoanDto();
		if(!loanRepository.existsById(loanAppId)) {
			throw new LoanNotFoundException("Loan#"+ loanAppId+" does not exists");
		}		
		return EMParser.parse1(loanRepository.findById(loanAppId).get(), loanDto);
	}

	@Override
	public List<LoanOutputDto> getStatusAll(Long customerId) {
		// TODO Auto-generated method stub
		LoanDto loanDto=new LoanDto();
//		return loanRepository.findAll().stream().map(e->EMParser.parse(e)).collect(Collectors.toList());
		return null;
	}

}
