package com.rest.ro;

import java.util.Date;

public class BillSheetRO {
	private int pgId;
	private int roomId;
	private int bedId;
	private String occupantName;
	private Date fromDate;
	private Date toDate;
	private int dues;
	private int payment;

	public int getPgId() {
		return pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getBedId() {
		return bedId;
	}

	public void setBedId(int bedId) {
		this.bedId = bedId;
	}

	public String getOccupantName() {
		return occupantName;
	}

	public void setOccupantName(String occupantName) {
		this.occupantName = occupantName;
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

	@Override
	public String toString() {
		return "BillSheetRO [pgId=" + pgId + ", roomId=" + roomId + ", bedId="
				+ bedId + ", occupantName=" + occupantName + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", dues=" + dues
				+ ", payment=" + payment + "]";
	}

}
