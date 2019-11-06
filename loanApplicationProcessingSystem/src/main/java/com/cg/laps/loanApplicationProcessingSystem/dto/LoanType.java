package com.cg.laps.loanApplicationProcessingSystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loantype")
public class LoanType {

	@Column(name = "loan_id")
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loanId;
	
	@Column(name = "loan_type")
	private String loanType;
	
	@Column(name = "salary_factor")
	private Integer salaryFactor;
	

	public LoanType() {
		// TODO Auto-generated constructor stub
	}
	
	public LoanType(Integer loanId, String loanType, Integer salaryFactor) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.salaryFactor = salaryFactor;
	}



	public Integer getLoanId() {
		return loanId;
	}



	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}



	public String getLoanType() {
		return loanType;
	}



	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}



	public Integer getSalarayFactor() {
		return salaryFactor;
	}



	public void setSalarayFactor(Integer salarayFactor) {
		this.salaryFactor = salarayFactor;
	}



}
