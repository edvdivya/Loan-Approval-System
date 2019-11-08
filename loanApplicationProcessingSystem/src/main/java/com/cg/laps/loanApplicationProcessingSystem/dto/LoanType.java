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
@Table(name = "loantype")
public class LoanType {

	@Column(name = "loan_id")
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loanId;
	
	@Column(name = "loan_name")
	private String loanName;
	
	@Column(name = "salary_factor")
	private Integer salaryFactor;
	
	@JsonIgnore
	@OneToMany(mappedBy = "loanSelected")
	List<LoanRequest> requestsList;
	

	public LoanType() {
		// TODO Auto-generated constructor stub
	}


	public LoanType(Integer loanId, String loanName, Integer salaryFactor, List<LoanRequest> requestsList) {
		super();
		this.loanId = loanId;
		this.loanName = loanName;
		this.salaryFactor = salaryFactor;
		this.requestsList = requestsList;
	}


	public Integer getLoanId() {
		return loanId;
	}


	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}


	public String getLoanName() {
		return loanName;
	}


	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}


	public Integer getSalaryFactor() {
		return salaryFactor;
	}


	public void setSalaryFactor(Integer salaryFactor) {
		this.salaryFactor = salaryFactor;
	}


	public List<LoanRequest> getRequestsList() {
		return requestsList;
	}


	public void setRequestsList(List<LoanRequest> requestsList) {
		this.requestsList = requestsList;
	}
	
	
	

}
