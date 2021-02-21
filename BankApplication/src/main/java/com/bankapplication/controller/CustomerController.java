package com.bankapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapplication.entity.CustEntity;
import com.bankapplication.entity.TransationHistory;
import com.bankapplication.model.Customer;
import com.bankapplication.model.Transfer;
import com.bankapplication.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer")
	public List<CustEntity> getAllCustomer() {
		return customerService.findAll();

	}

	@PostMapping("/customer")
	public CustEntity createCustomer(@RequestBody CustEntity customer) {
		return customerService.save(customer);
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerId(@PathVariable int id) {		
		Customer cust = customerService.getCustomerId(id);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
		
	}
	@PostMapping("/transferMoney")
	public ResponseEntity<Boolean> transferAmount(@RequestBody Transfer transfer) {		
		
		boolean cust = customerService.transferAmount(transfer);
		
		return new ResponseEntity<Boolean>(cust,HttpStatus.OK);
		
	}
	@GetMapping("/history")
	public List<TransationHistory> getAllHistory(){
		return customerService.findAllHistory();
	}
}
