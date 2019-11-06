package com.cg.laps.loanApplicationProcessingSystem.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


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
	
	@Column(name = "address")
	private String address;
	
	@OneToMany(mappedBy = "customer")
	private List<LoanRequest> loanRequests;

	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

}
