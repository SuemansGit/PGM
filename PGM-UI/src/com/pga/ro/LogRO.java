package com.pga.ro;
import java.util.Date;

import com.pga.eo.LogEO;
public class LogRO {
	
	private int logId;
	private String log;
	private int pgId;
	private String type;
	private Date dateCreated;
	
	public LogRO(LogEO logro) {
		super();
		this.logId = logro.getLogId();
		this.log = logro.getLog();
		this.pgId = logro.getPgId();
		this.type = logro.getType();
		this.dateCreated = logro.getDateCreated();
		}
	
	
	public LogRO(int logId, String log, int pgId, String type, Date dateCreated) {
		super();
		this.logId = logId;
		this.log = log;
		this.pgId = pgId;
		this.type = type;
		this.dateCreated = dateCreated;
	}
	
	public LogRO( String log, int pgId, String type, Date dateCreated) {
		super();
		this.log = log;
		this.pgId = pgId;
		this.type = type;
		this.dateCreated = dateCreated;
	}


	public LogEO getEntityObject(){
		LogEO logro = new LogEO();
		logro.setPgId(pgId);
		logro.setLogId(logId);
		logro.setLog(log);
		logro.setPgId(pgId);
		logro.setType(type);
		logro.setDateCreated(dateCreated);
		return logro;
	}
	
	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}

	public int getPgId() {
		return pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	@Override
	public String toString() {
		return "LogRO [logId=" + logId + ", log=" + log + ", pgId=" + pgId
				+ ", type=" + type + ", dateCreated=" + dateCreated + "]";
	}

	
	
	
	

}
