package com.cg.laps.loanApplicationProcessingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.laps.loanApplicationProcessingSystem.dto.LoanRequest;

@Repository
public interface LoanRequestRepository extends JpaRepository<LoanRequest, Integer>{

}
