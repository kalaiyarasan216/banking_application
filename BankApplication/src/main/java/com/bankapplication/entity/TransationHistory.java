package com.bankapplication.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class TransationHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sno;
	@Column(name = "sender")
	private String sender;
	@Column(name = "receiver")
	private String receiver;
	@Column(name = "transactiontype")
	private String transactiontype;
	@Column(name = "amount")
	private double amount;
	@Column(name = "date_time")
	private Timestamp date_time;

	public String getSender() {
		return sender;
	}

	public Timestamp getDate_time() {
		return date_time;
	}

	public void setDate_time(Timestamp date_time) {
		this.date_time = date_time;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
