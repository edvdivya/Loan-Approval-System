package com.cg.laps.loanApplicationProcessingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.laps.loanApplicationProcessingSystem.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	

}
