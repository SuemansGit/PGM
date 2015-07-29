package com.pga.ro;

import java.util.Date;

import com.pga.eo.AccountEO;

public class AccountRO {

	private int accountId;
	private int occupantId;
	private Date fromDate;
	private Date toDate;
	private int pgId;
	private int dues;
	private int payment;
	private Date paymentDate;
	private String notification;

	public AccountRO(AccountEO account) {
		super();
		this.accountId = account.getAccountId();
		this.pgId = account.getPgId();
		this.occupantId = account.getOccupantId();
		this.fromDate = account.getFromDate();
		this.toDate = account.getToDate();
		this.dues = account.getDues();
		this.payment = account.getPayment();
		this.notification = account.getNotification();
	}
	public AccountRO(){
		
	}

	public AccountRO(int accountId, int occupantId, Date fromDate, Date toDate,
			int dues, int payment, String notification) {
		super();
		this.accountId = accountId;
		this.occupantId = occupantId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.dues = dues;
		this.payment = payment;
		this.notification = notification;
	}

	public AccountRO(int occupantId, Date fromDate, Date toDate, int dues,
			int payment, String notification) {
		super();
		this.occupantId = occupantId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.dues = dues;
		this.payment = payment;
		this.notification = notification;
	}

	

	public AccountEO getEntityObject() {
		AccountEO account = new AccountEO();
		account.setAccountId(accountId);
		account.setOccupantId(occupantId);
		account.setFromDate(fromDate);
		account.setToDate(toDate);
		account.setDues(dues);
		account.setPayment(payment);
		account.setNotification(notification);
		return account;

	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getOccupantId() {
		return occupantId;
	}

	public void setOccupantId(int occupantId) {
		this.occupantId = occupantId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getDues() {
		return dues;
	}

	public void setDues(int dues) {
		this.dues = dues;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	@Override
	public String toString() {
		return "AccountRO [accountId=" + accountId + ", occupantId="
				+ occupantId + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", dues=" + dues + ", payment=" + payment + ", paymentDate="
				+ paymentDate + ", notification=" + notification + "]";

	}

}
