package com.cg.laps.loanApplicationProcessingSystem.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan_request")
public class LoanRequest {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "application_id")
	private Integer applicationId;
	
	@Column(name = "applicant_name")
	private String applicantName;
	
	@Column(name = "aadhar_number")
	private String aadharNumber;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "salary")
	private Long salary;
	
	@Column(name = "loanSelected")
	private String loanSelected;
	
	@Column(name = "loan_amount")
	private Long loanAmount;
	
	@Column(name = "applicationStatus")
	private String applicationStatus;
	
	@Column(name = "loanStatus")
	private String loanStatus;
	
	@Column(name = "interview_date")
	private Date interviewDate;
	
	@Column(name="loan_approval_date")
	private Date loanApprovalDate;
	
	@ManyToOne
	@JoinColumn(name = "customer")
	private Customer customer;
	
	public LoanRequest() {
		// TODO Auto-generated constructor stub
	}


	public LoanRequest(Integer applicationId, String applicantName, String aadharNumber, String phoneNumber,
			Long salary, String loanSelected, Long loanAmount, String applicationStatus, String loanStatus,
			Date interviewDate, Date loanApprovalDate) {
		super();
		this.applicationId = applicationId;
		this.applicantName = applicantName;
		this.aadharNumber = aadharNumber;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.loanSelected = loanSelected;
		this.loanAmount = loanAmount;
		this.applicationStatus = applicationStatus;
		this.loanStatus = loanStatus;
		this.interviewDate = interviewDate;
		this.loanApprovalDate = loanApprovalDate;
	}


	public Integer getApplicationId() {
		return applicationId;
	}


	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}


	public String getApplicantName() {
		return applicantName;
	}


	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}


	public String getAadharNumber() {
		return aadharNumber;
	}


	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Long getSalary() {
		return salary;
	}


	public void setSalary(Long salary) {
		this.salary = salary;
	}


	public String getLoanSelected() {
		return loanSelected;
	}


	public void setLoanSelected(String loanSelected) {
		this.loanSelected = loanSelected;
	}


	public Long getLoanAmount() {
		return loanAmount;
	}


	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}


	public String getApplicationStatus() {
		return applicationStatus;
	}


	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}


	public String getLoanStatus() {
		return loanStatus;
	}


	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}


	public Date getInterviewDate() {
		return interviewDate;
	}


	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}


	public Date getLoanApprovalDate() {
		return loanApprovalDate;
	}


	public void setLoanApprovalDate(Date loanApprovalDate) {
		this.loanApprovalDate = loanApprovalDate;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}
