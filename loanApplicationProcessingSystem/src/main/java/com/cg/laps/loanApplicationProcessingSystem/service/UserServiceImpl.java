package com.cg.laps.loanApplicationProcessingSystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.laps.loanApplicationProcessingSystem.dto.Customer;
import com.cg.laps.loanApplicationProcessingSystem.dto.LoanRequest;
import com.cg.laps.loanApplicationProcessingSystem.dto.LoanType;
import com.cg.laps.loanApplicationProcessingSystem.dto.User;
import com.cg.laps.loanApplicationProcessingSystem.exception.MyException;
import com.cg.laps.loanApplicationProcessingSystem.repository.CustomerRepository;
import com.cg.laps.loanApplicationProcessingSystem.repository.LoanRequestRepository;
import com.cg.laps.loanApplicationProcessingSystem.repository.LoanTypeRepository;
import com.cg.laps.loanApplicationProcessingSystem.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userrepository;
	
	@Autowired
	CustomerRepository customerrepository;
	
	@Autowired
	LoanTypeRepository loantyperepository;
	
	@Autowired
	LoanRequestRepository loanrequestrepository;
	
	
	@Override
	public User addMember(User user) throws MyException {
		// TODO Auto-generated method stub
		return userrepository.save(user);
	}

	@Override
	public LoanType addLoanType(LoanType loantype) {
		// TODO Auto-generated method stub
		return loantyperepository.save(loantype);
	}

	@Override
	public List<LoanType> viewLoanTypes() {
		// TODO Auto-generated method stub
		return loantyperepository.findAll();
	}

	@Override
	public List<LoanRequest> viewLoanRequests() {
		// TODO Auto-generated method stub
		return loanrequestrepository.findAll();
	}

	@Override
	public LoanRequest updateLoanStatus(Integer applicationId) {
		// TODO Auto-generated method stub
		LoanRequest loanrequest = loanrequestrepository.findById(applicationId).get();
		loanrequest.setLoanStatus("approved");
		return loanrequest;
	}

	@Override
	public Customer addCustomer(Customer customer) throws MyException {
		// TODO Auto-generated method stub
		return customerrepository.save(customer);
	}

	@Override
	public LoanRequest addLoanRequest(LoanRequest loanrequest) throws MyException {
		// TODO Auto-generated method stub
		return loanrequestrepository.save(loanrequest);
	}

	@Override
	public LoanRequest checkApplicationStatus(Integer applicationId) {
		// TODO Auto-generated method stub
		LoanRequest loanrequest=loanrequestrepository.findById(applicationId).get();
		if(loanrequest!=null) {
			return loanrequest;
		}
		else {
			return null;
		}
	}

	@Override
	public List<User> viewMembers() {
		// TODO Auto-generated method stub
		return userrepository.findAll();
	}

	@Override
	public List<Customer> viewCustomers() {
		// TODO Auto-generated method stub
		return customerrepository.findAll();
	}



}
