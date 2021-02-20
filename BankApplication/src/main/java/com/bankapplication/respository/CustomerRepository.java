package com.bankapplication.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapplication.entity.CustEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustEntity,Integer> {

	
}

