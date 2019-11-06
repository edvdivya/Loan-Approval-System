package com.cg.laps.loanApplicationProcessingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.laps.loanApplicationProcessingSystem.dto.LoanType;

@Repository
public interface LoanTypeRepository extends JpaRepository<LoanType, Integer>{
	

}
