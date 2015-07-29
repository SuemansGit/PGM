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
@Table(name = "LOG")
// @NamedQueries({
// @NamedQuery(name = "FIND_PG_BY_ADDRESS", query =
// "SELECT pg FROM PG pg where pg.name = :name")
// })
@XmlRootElement
public class LogEO {

	private int logId;
	private String log;
	private int pgId;
	private String type;
	private Date dateCreated;
	private PgEO pg;

	@Id
	// signifies the primary key
	@Column(name = "LOG_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	@Column(name = "LOG")
	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	@Column(name = "PG_ID")
	public int getPgId() {
		return pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "PG_ID", referencedColumnName = "PG_ID", insertable = false, updatable = false)
	public PgEO getPg() {
		return pg;
	}

	public void setPg(PgEO pg) {
		this.pg = pg;
	}

	@Column(name = "TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "DATE_CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("LogEO [logId=" + logId).append(", log=" + log)
				.append(", pgId=" + pgId).append(", type=" + type)
				.append(", dateCreated=" + dateCreated + "]").append("\n");
		return sb.toString();
	}

}
