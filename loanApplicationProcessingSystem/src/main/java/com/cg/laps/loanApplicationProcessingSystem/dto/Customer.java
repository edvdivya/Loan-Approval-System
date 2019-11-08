package com.cg.laps.loanApplicationProcessingSystem.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "customer")
public class Customer {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Integer customerId;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "aadhar_number")
	private String aadharNumber;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<LoanRequest> loanRequests;

	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer customerId, String customerName, String phoneNumber, String aadharNumber,
			List<LoanRequest> loanRequests) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.aadharNumber = aadharNumber;
		
		this.loanRequests = loanRequests;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}


	public List<LoanRequest> getLoanRequests() {
		return loanRequests;
	}

	public void setLoanRequests(List<LoanRequest> loanRequests) {
		this.loanRequests = loanRequests;
	}
	

}
