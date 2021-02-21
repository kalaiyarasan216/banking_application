
package com.bankapplication.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapplication.entity.CustEntity;
import com.bankapplication.entity.TransationHistory;
import com.bankapplication.helper.CustomerHelper;
import com.bankapplication.model.Customer;
import com.bankapplication.model.Transfer;
import com.bankapplication.respository.CustomerRepository;
import com.bankapplication.respository.TransactionRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerHelper customerHelper;

	@Autowired
	private TransactionRepository transactionRepository;

	public List<CustEntity> findAll() {
		return customerRepository.findAll();
	}

	public CustEntity save(CustEntity customer) {
		return customerRepository.save(customer);
	}

	public Customer getCustomerId(int id) {
		Customer customer = new Customer();
		Optional<CustEntity> custEntity = customerRepository.findById(id);
		if (custEntity.isPresent()) {
			customer = customerHelper.populateCustomerDetailes(custEntity.get());
		} else {
			customer.setMessage("id not found");
		}

		return customer;
	}

	@Transactional
	public boolean transferAmount(Transfer transfer) {
		boolean status = Boolean.FALSE;

		List<CustEntity> sender = customerRepository.findAll();
		CustEntity fromAcc = getCustomerById(sender, transfer.getFromAccount());
		CustEntity toAcc = getCustomerById(sender, transfer.getToAccount());
		if (fromAcc != null && toAcc != null) {
			if (validateAmount(transfer.getAmount(), fromAcc)) {
				toAcc.setAmount(toAcc.getAmount() + transfer.getAmount());
				fromAcc.setAmount(fromAcc.getAmount() - transfer.getAmount());

				customerRepository.save(fromAcc);
				customerRepository.save(toAcc);
				transactionRepository.save(transactionHistory(transfer, "Dr"));
				status = true;
			}
		}
		return status;
	}

	private TransationHistory transactionHistory(Transfer transfer, String type) {
		
		Timestamp ts=new Timestamp(System.currentTimeMillis());  
		TransationHistory trnHis = new TransationHistory();
		trnHis.setSender(transfer.getFromAccount());
		trnHis.setReceiver(transfer.getToAccount());
		trnHis.setAmount(transfer.getAmount());
		trnHis.setDate_time(ts);
		trnHis.setTransactiontype(type);
		return trnHis;

	}

	private boolean validateAmount(Double amount, CustEntity fromAcc) {
		if (amount > 0 && amount <= fromAcc.getAmount()) {
			return true;
		}
		return false;
	}

	private CustEntity getCustomerById(List<CustEntity> list, String emailId) {
		CustEntity entity = null;
		if (!list.isEmpty()) {
			entity = list.stream().filter(cust -> emailId.equals(cust.getEmail_id()))
					.findAny().orElse(null);
		}
		return entity;
	}

	public List<TransationHistory> findAllHistory() {
		
		return transactionRepository.findAll();
	}

}
