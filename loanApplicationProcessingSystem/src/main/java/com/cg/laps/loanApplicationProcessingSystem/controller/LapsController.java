package com.cg.laps.loanApplicationProcessingSystem.controller;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.laps.loanApplicationProcessingSystem.dto.Customer;
import com.cg.laps.loanApplicationProcessingSystem.dto.LoanRequest;
import com.cg.laps.loanApplicationProcessingSystem.dto.LoanType;
import com.cg.laps.loanApplicationProcessingSystem.dto.User;
import com.cg.laps.loanApplicationProcessingSystem.exception.MyException;
import com.cg.laps.loanApplicationProcessingSystem.service.UserService;

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

	// admin function to add member
	@PostMapping("/addMember")
	public ResponseEntity<?> addMember(@ModelAttribute User user) throws MyException {

		List<User> members = userService.viewMembers();
		for (int i = 0; i < members.size(); i++) {
			if (user.getUsername().equalsIgnoreCase(members.get(i).getUsername())) {
				return new ResponseEntity<String>("Username Already in use!", HttpStatus.ALREADY_REPORTED);
			}
		}
		try {
			User member = userService.addMember(user);
			return new ResponseEntity<User>(member, HttpStatus.OK);

		} catch (MyException e) {
			return new ResponseEntity<String>("Member not added", HttpStatus.ALREADY_REPORTED);
		}

	}

	// add loanType
	@PostMapping("/addLoanType")
	public ResponseEntity<?> addLoantype(@ModelAttribute LoanType loantype) throws MyException {

		System.out.println("okay");
		LoanType loanType = new LoanType();
		try {

			loanType = userService.addLoanType(loantype);

		} catch (MyException e) {
			return new ResponseEntity<String>("Loan type could not be added", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<LoanType>(loanType, HttpStatus.OK);

	}

	// member/customer function to see types of loan
		@GetMapping(value = "/getLoanTypes")
		public ResponseEntity<?> getLoanTypes() {

			List<LoanType> loanTypes = userService.viewLoanTypes();
			if (loanTypes.size() == 0) {
				return new ResponseEntity<String>("No loan types exist", HttpStatus.NO_CONTENT);
			} else {

				return new ResponseEntity<List<LoanType>>(loanTypes, HttpStatus.OK);
			}
		}

	// add loan request
	@PostMapping("/addLoanRequest")
	public ResponseEntity<?> addLoanRequest(@ModelAttribute LoanRequest loanrequest) throws MyException {

		Long maxAmount = (loanrequest.getSalary()) * loanrequest.getLoanSelected().getSalaryFactor();
		if (maxAmount < loanrequest.getLoanAmount()) {
			loanrequest.setApplicationStatus("Declined");
			loanrequest.setInterviewDate(null);
			loanrequest.setLoanApprovalDate(null);
			loanrequest.setLoanStatus("Rejected");
			try {
				LoanRequest loanRequest = userService.addLoanRequest(loanrequest);
				return new ResponseEntity<LoanRequest>(loanRequest, HttpStatus.OK);
			} catch (MyException e) {
				return new ResponseEntity<String>("loanrequest not added", HttpStatus.BAD_REQUEST);
			}

		} else {
			LocalDate interviewDate = LocalDate.now().plusDays(2);
			System.out.println("date init");
			loanrequest.setApplicationStatus("Accepted");
			System.out.println("application status set");
			loanrequest.setLoanStatus("Pending");
			System.out.println("loan set");
			loanrequest.setInterviewDate(interviewDate);
			System.out.println("date set");
			Customer customer = new Customer();
			System.out.println("obj created");
			List<Customer> customers = userService.viewCustomers();
			System.out.println("getting customerss");
			for (int i = 0; i < customers.size(); i++) {
				System.out.println("our customers"+customers);
				System.out.println("list size"+customers.size());
				System.out.println("aadhar given"+loanrequest.getAadharNumber());
				System.out.println("in data aadhar number"+customers.get(i).getAadharNumber());
				if (loanrequest.getAadharNumber().contains(customers.get(i).getAadharNumber())) {
					System.out.println("inside aadhar verify");
					try {
						System.out.println("inside try ");
						loanrequest.setCustomer(customers.get(i));
						LoanRequest loanRequest = userService.addLoanRequest(loanrequest);
						System.out.println("added loan and retrieved");
						return new ResponseEntity<LoanRequest>(loanRequest, HttpStatus.OK);
					} catch (MyException e) {
						return new ResponseEntity<String>("Loan Request not added", HttpStatus.BAD_REQUEST);
					}
				}
			}
			customer.setCustomerName(loanrequest.getApplicantName());
			System.out.println("after set name");
			customer.setPhoneNumber(loanrequest.getPhoneNumber());
			System.out.println("set phone");
			customer.setAadharNumber(loanrequest.getAadharNumber());
			System.out.println("set aadhar");
			loanrequest.setCustomer(customer);
			System.out.println("set customer");
			try {
				System.out.println("again try adding customer");
				userService.addCustomer(customer);
				System.out.println("try add request");
				LoanRequest loanRequest = userService.addLoanRequest(loanrequest);
				return new ResponseEntity<LoanRequest>(loanRequest, HttpStatus.OK);
			} catch (MyException e) {
				return new ResponseEntity<String>("Loan Request not added", HttpStatus.BAD_REQUEST);
			}

		}

	}
	
	// admin/member function to see all loan requests
	@GetMapping(value = "/getLoanRequests")
	public ResponseEntity<?> getLoanRequests() {

		List<LoanRequest> loanRequests = userService.viewLoanRequests();
		if (loanRequests.size() == 0) {
			return new ResponseEntity<String>("No Loan Request", HttpStatus.NO_CONTENT);
		} else {

			return new ResponseEntity<List<LoanRequest>>(loanRequests, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/viewRequestsToBeApproved")
	public ResponseEntity<List<LoanRequest>> viewRequestsToBeApproved() {
		
		List<LoanRequest> requests = userService.getRequestsToApprove();
		return new ResponseEntity<List<LoanRequest>>(requests,HttpStatus.OK);
	}

	@PostMapping(value="/approveRequestStatus")
	public String approveRequestStatus(@RequestParam("applicationId") Integer applicationId,Map<String,Object> model) {
		
		try {
			userService.approveLoanStatus(applicationId);
			
		} catch (Exception e) {
			
			return "not done";
		}
		return "Done";
	}
	
	@PostMapping(value="/rejectRequestStatus")
	public String rejectRequestStatus(@RequestParam("applicationId") Integer applicationId,Map<String,Object> model) {
		
		try {
			userService.rejectLoanStatus(applicationId);
			
		} catch (Exception e) {
			
			return "not done";
		}
		return "Done";
	}
	
	// check loan request status
	@GetMapping(value = "/checkRequestStatus")
	public ResponseEntity<LoanRequest> checkRequestStatus(@RequestParam("applicationId") Integer requestId) {

		LoanRequest loanRequest = userService.checkApplicationStatus(requestId);
		if (loanRequest == null) {
			return new ResponseEntity<LoanRequest>(HttpStatus.NO_CONTENT);
		} else {

			return new ResponseEntity<LoanRequest>(loanRequest, HttpStatus.OK);
		}
	}
}
