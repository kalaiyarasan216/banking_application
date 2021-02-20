package com.bankapplication.model;

import java.sql.Timestamp;

public class Transfer {
	private String fromAccount;
	private String toAccount;
	private Double amount;
	private String type;
	private Timestamp Date_time;

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getDate_time() {
		return Date_time;
	}

	public void setDate_time(Timestamp date_time) {
		Date_time = date_time;
	}

}
