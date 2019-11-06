package com.cg.laps.loanApplicationProcessingSystem.service;
import java.util.List;

import com.cg.laps.loanApplicationProcessingSystem.dto.Customer;
import com.cg.laps.loanApplicationProcessingSystem.dto.LoanRequest;
import com.cg.laps.loanApplicationProcessingSystem.dto.LoanType;
import com.cg.laps.loanApplicationProcessingSystem.dto.User;
import com.cg.laps.loanApplicationProcessingSystem.exception.MyException;

public interface IUser {

	// admin functions
	public User addMember(User user) throws MyException;
	public LoanType addLoanType(LoanType loantype);
	//member functions
	public List<LoanType> viewLoanTypes();
	public List<LoanRequest> viewLoanRequests();
	public LoanRequest updateLoanStatus(Integer applicationId);
	//customer function
	public Customer addCustomer(Customer customer) throws MyException;
	public LoanRequest addLoanRequest(LoanRequest loanrequest) throws MyException;
	public LoanRequest checkApplicationStatus(Integer applicationId);
	
}
