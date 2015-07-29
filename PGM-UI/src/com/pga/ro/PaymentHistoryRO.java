package com.pga.ro;

import java.util.Date;

import com.pga.eo.AccountEO;

public class PaymentHistoryRO {
	private Date date;
	private int bill;
	private int payment;
	private int balance;
	
	public PaymentHistoryRO(){
		
	}

	public PaymentHistoryRO(Date date, int bill, int payment, int balance) {
		super();
		this.date = date;
		this.bill = bill;
		this.payment = payment;
		this.balance = balance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "PaymentHistory [date=" + date + ", bill=" + bill + ", payment="
				+ payment + ", balance=" + balance + "]";
	}
	
	

}
