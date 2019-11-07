package com.cg.laps.loanApplicationProcessingSystem.controller;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cg.laps.loanApplicationProcessingSystem.dto.LoanRequest;
import com.cg.laps.loanApplicationProcessingSystem.dto.LoanType;
import com.cg.laps.loanApplicationProcessingSystem.dto.User;
import com.cg.laps.loanApplicationProcessingSystem.exception.MyException;
import com.cg.laps.loanApplicationProcessingSystem.service.UserService;

@ComponentScan
@RestController
public class LapsController {


	@Autowired
	private UserService userService;

	@GetMapping(value = "/adminpage")
	public String adminPage() {
		return "Admin Page..";
	}

	@GetMapping(value = "/memberpage")
	public String memberPage() {
		return "Member Page..";
	}

	// member/customer function to see types of loan
	@GetMapping(value = "/getLoanTypes")
	public ResponseEntity<List<LoanType>> getLoanTypes() {

		List<LoanType> loanTypes = userService.viewLoanTypes();
		if (loanTypes.size() == 0) {
			return new ResponseEntity<List<LoanType>>(HttpStatus.NO_CONTENT);
		} else {

			return new ResponseEntity<List<LoanType>>(loanTypes, HttpStatus.OK);
		}
	}

	// admin/member function to see all loan requests
	@GetMapping(value = "/getLoanRequests")
	public ResponseEntity<List<LoanRequest>> getLoanRequests() {

		List<LoanRequest> loanRequests = userService.viewLoanRequests();
		if (loanRequests.size() == 0) {
			return new ResponseEntity<List<LoanRequest>>(HttpStatus.NO_CONTENT);
		} else {

			return new ResponseEntity<List<LoanRequest>>(loanRequests, HttpStatus.OK);
		}
	}
	
	//admin function to add member
	@PostMapping("/addMember")
	public ResponseEntity<?> addMember(@ModelAttribute User user) throws MyException {

		User member = userService.addMember(user);

		//tally usernames here
		
		if (member.getUsername() == "yyy") {
			return new ResponseEntity<String>("Member not added", HttpStatus.ALREADY_REPORTED);
		} else {
			return new ResponseEntity<User>(member, HttpStatus.OK);
		}
	}
	
	//add loanType
	@PostMapping("/addLoanType")
	public ResponseEntity<?> addLoantype(@ModelAttribute LoanType loantype) throws MyException {

		LoanType loanType=userService.addLoanType(loantype);
		//tally usernames here
		
			return new ResponseEntity<LoanType>(loanType, HttpStatus.OK);
		
	}
	
	//add loan request
	@PostMapping("/addLoanRequest")
	public ResponseEntity<?> addLoanRequest(@ModelAttribute LoanRequest loanrequest) throws MyException {

		LoanRequest loanRequest=userService.addLoanRequest(loanrequest);
		
		
			return new ResponseEntity<LoanRequest>(loanRequest, HttpStatus.OK);
		
	}
	
	// update loan request
	@PostMapping("/updateLoanRequest")
	public ResponseEntity<?> updateLoanRequest(@ModelAttribute LoanRequest loanrequest) throws MyException {

		//set loan status approved or rejected
		
			return new ResponseEntity<LoanRequest>(loanrequest, HttpStatus.OK);
		
	}
	
	// check loan request status
	@GetMapping(value = "/checkRequestStatus")
	public ResponseEntity<LoanRequest> checkRequestStatus(@RequestParam("applicationId") String requestId) {

		Integer requestid=Integer.parseInt(requestId);
		LoanRequest loanRequest = userService.checkApplicationStatus(requestid);
		if (loanRequest == null) {
			return new ResponseEntity<LoanRequest>(HttpStatus.NO_CONTENT);
		} else {

			return new ResponseEntity<LoanRequest>(loanRequest, HttpStatus.OK);
		}
	}
}
