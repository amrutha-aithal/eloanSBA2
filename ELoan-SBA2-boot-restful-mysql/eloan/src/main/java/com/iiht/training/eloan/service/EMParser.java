package com.iiht.training.eloan.service;

import com.iiht.training.eloan.entity.Loan;
import com.iiht.training.eloan.entity.ProcessingInfo;
import com.iiht.training.eloan.entity.SanctionInfo;
import com.iiht.training.eloan.entity.Users;
import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.ProcessingDto;
import com.iiht.training.eloan.dto.SanctionDto;
import com.iiht.training.eloan.dto.UserDto;

public class EMParser {
	
	public static UserDto parse(Users source) {
		UserDto target = new UserDto();
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setEmail(source.getEmail());
		target.setMobile(source.getMobile());
		target.setRole(source.getRole());
		return target;		
	}
	public static Users parse(UserDto source) {
		Users target = new Users();
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setEmail(source.getEmail());
		target.setMobile(source.getMobile());
		target.setRole(source.getRole());
		return target;		
	}
	public static LoanDto parse(Loan source) {
		LoanDto target = new LoanDto();
		target.setId(source.getId());
		target.setCustomerId(source.getCustomerId());
		target.setLoanName(source.getLoanName());
		target.setLoanAmount(source.getLoanAmount());
		target.setLoanApplicationDate(source.getLoanApplicationDate());
		target.setBusinessStructure(source.getBusinessStructure());
		target.setBillingIndicator(source.getBillingIndicator());
		target.setTaxIndicator(source.getTaxIndicator());
		target.setStatus(source.getStatus());
		target.setRemark(source.getRemark());
		return target;		
	}
	public static Loan parse(LoanDto source) {
		Loan target = new Loan();
		target.setId(source.getId());
		target.setCustomerId(source.getCustomerId());
		target.setLoanName(source.getLoanName());
		target.setLoanAmount(source.getLoanAmount());
		target.setLoanApplicationDate(source.getLoanApplicationDate());
		target.setBusinessStructure(source.getBusinessStructure());
		target.setBillingIndicator(source.getBillingIndicator());
		target.setTaxIndicator(source.getTaxIndicator());
		target.setStatus(source.getStatus());
		target.setRemark(source.getRemark());
		return target;		
	}
	public static ProcessingDto parse(ProcessingInfo source) {
		ProcessingDto target = new ProcessingDto();
		target.setId(source.getId());
		target.setLoanAppId(source.getLoanAppId());
		target.setLoanClerkId(source.getLoanClerkId());
		target.setAcresOfLand(source.getAcresOfLand());
		target.setLandValue(source.getLandValue());
		target.setAppraisedBy(source.getAppraisedBy());
		target.setValuationDate(source.getValuationDate());
		target.setAddressOfProperty(source.getAddressOfProperty());
		target.setSuggestedAmountOfLoan(source.getSuggestedAmountOfLoan());		
		return target;		
	}
	public static ProcessingInfo parse(ProcessingDto source) {
		ProcessingInfo target = new ProcessingInfo();
		target.setId(source.getId());
		target.setLoanAppId(source.getLoanAppId());
		target.setLoanClerkId(source.getLoanClerkId());
		target.setAcresOfLand(source.getAcresOfLand());
		target.setLandValue(source.getLandValue());
		target.setAppraisedBy(source.getAppraisedBy());
		target.setValuationDate(source.getValuationDate());
		target.setAddressOfProperty(source.getAddressOfProperty());
		target.setSuggestedAmountOfLoan(source.getSuggestedAmountOfLoan());		
		return target;		
	}
	public static SanctionDto parse(SanctionInfo source) {
		SanctionDto target = new SanctionDto();
		target.setId(source.getId());
		target.setLoanAppId(source.getLoanAppId());
		target.setManagerId(source.getManagerId());
		target.setLoanAmountSanctioned(source.getLoanAmountSanctioned());
		target.setTermOfLoan(source.getTermOfLoan());
		target.setPaymentStartDate(source.getPaymentStartDate());
		target.setLoanClosureDate(source.getLoanClosureDate());
		target.setMonthlyPayment(source.getMonthlyPayment());
		return target;		
	}
	public static SanctionInfo parse(SanctionDto source) {
		SanctionInfo target = new SanctionInfo();
		target.setId(source.getId());
		target.setLoanAppId(source.getLoanAppId());
		target.setManagerId(source.getManagerId());
		target.setLoanAmountSanctioned(source.getLoanAmountSanctioned());
		target.setTermOfLoan(source.getTermOfLoan());
		target.setPaymentStartDate(source.getPaymentStartDate());
		target.setLoanClosureDate(source.getLoanClosureDate());
		target.setMonthlyPayment(source.getMonthlyPayment());
		return target;		
	}
	public static Loan parse(LoanOutputDto source) {
		Loan target = new Loan();
//		target.setId(source.getId());
		target.setCustomerId(source.getLoanDto().getCustomerId());
		target.setLoanName(source.getLoanDto().getLoanName());
		target.setLoanAmount(source.getLoanDto().getLoanAmount());
		target.setLoanApplicationDate(source.getLoanDto().getLoanApplicationDate());
		target.setBusinessStructure(source.getLoanDto().getBusinessStructure());
		target.setBillingIndicator(source.getLoanDto().getBillingIndicator());
		target.setTaxIndicator(source.getLoanDto().getTaxIndicator());
		target.setStatus(source.getStatus());
		target.setRemark(source.getRemark());
		return target;
		
	}
	public static LoanOutputDto parse1(Loan source,LoanDto source1) {
		LoanOutputDto target = new LoanOutputDto();
//		target.setId(source.getId());
		target.setCustomerId(source.getCustomerId());
		target.setLoanAppId(source.getId());
		source1.setLoanName(source.getLoanName());
		source1.setLoanAmount(source.getLoanAmount());
		source1.setLoanApplicationDate(source.getLoanApplicationDate());
		source1.setBusinessStructure(source.getBusinessStructure());
		source1.setBillingIndicator(source.getBillingIndicator());
		source1.setTaxIndicator(source.getTaxIndicator());
		target.setStatus(source.getStatus());
		target.setRemark(source.getRemark());
		return target;
		
	}
		


}
