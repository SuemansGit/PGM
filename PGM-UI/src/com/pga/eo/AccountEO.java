package com.pga.eo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ACCOUNT")
 @NamedQueries({
 @NamedQuery(name = "GET_ACCOUNT_DETAILS", query = "SELECT a FROM AccountEO a where a.pgId= :pgId"),
 @NamedQuery(name = "GET_OCCUPANT_ACCOUNT_DETAILS", query ="SELECT a FROM AccountEO a where a.occupantId= :occupantId"),
 @NamedQuery(name = "GET_OCCUPANT_DUES", query ="SELECT a FROM AccountEO a where a.occupantId= :occupantId AND a.dues > 0 "),
 @NamedQuery(name = "GET_BALANCE_SHEET", query ="SELECT a FROM AccountEO a where a.pgId = :pgId AND a.fromDate BETWEEN '2012-01-01' AND '2012-01-31'"),
 @NamedQuery(name = "GET_PAYMENT_HISTORY", query ="SELECT a FROM AccountEO a where a.pgId= :pgId AND a.occupantId= :occupantId")
 })
@XmlRootElement
public class AccountEO {

	private int accountId;
	private int pgId;
	private int occupantId;
	private Date fromDate;
	private Date toDate;
	private int dues;
	private int payment;
	private Date paymentDate;
	private String notification;
	private OccupantEO occupant;

	@Id
	// signifies the primary key
	@Column(name = "ACCOUNT_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Column(name = "PG_ID")
	public int getPgId() {
		return pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
	}

	@Column(name = "OCCUPANT_ID")
	public int getOccupantId() {
		return occupantId;
	}

	public void setOccupantId(int occupantId) {
		this.occupantId = occupantId;
	}

	@Column(name = "FROM_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@Column(name = "TO_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Column(name = "DUES")
	public int getDues() {
		return dues;
	}

	public void setDues(int dues) {
		this.dues = dues;
	}

	@Column(name = "PAYMENT")
	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	@Column(name = "PAYMENT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Column(name = "NOTIFICATION")
	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "OCCUPANT_ID", referencedColumnName = "OCCUPANT_ID", insertable = false, updatable = false)
	public OccupantEO getOccupant() {
		return occupant;
	}

	public void setOccupant(OccupantEO occupant) {
		this.occupant = occupant;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("AccountEO [accountId=" + accountId)
				.append(", pgId=" + pgId)
				.append(", occupantId=" + occupantId)
				.append(", fromDate=" + fromDate).append(", toDate=" + toDate)
				.append(", dues=" + dues).append(", payment=" + payment)
				.append(", paymentDate=" + paymentDate)
				.append(", notification=" + notification).append("\n");
		return sb.toString();
	}

}
