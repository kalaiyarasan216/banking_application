package com.bankapplication.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapplication.entity.TransationHistory;

@Repository
public interface TransactionRepository extends JpaRepository<TransationHistory,Integer> {

	
}

