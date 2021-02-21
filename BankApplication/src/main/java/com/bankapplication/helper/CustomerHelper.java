package com.bankapplication.helper;

import org.springframework.stereotype.Component;

import com.bankapplication.entity.CustEntity;
import com.bankapplication.model.Customer;

@Component
public class CustomerHelper {

	public Customer populateCustomerDetailes(CustEntity custEntity) {
		
		Customer customer = new Customer();
		customer.setAmount(custEntity.getAmount());
		customer.setEmail_id(custEntity.getEmail_id());
		customer.setId(custEntity.getId());
		customer.setName(custEntity.getName());
		
		return customer;
	}

}
