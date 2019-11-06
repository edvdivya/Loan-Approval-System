package com.cg.laps.loanApplicationProcessingSystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.laps.loanApplicationProcessingSystem.dto.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	

}
