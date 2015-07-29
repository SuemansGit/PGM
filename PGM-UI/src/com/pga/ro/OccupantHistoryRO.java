package com.pga.ro;

import java.util.Date;

import com.pga.eo.OccupantHistoryEO;

public class OccupantHistoryRO {
	private int historyId;
	private int occupantId;
	private int roomId;
	private int bedId;
	private Date entryDate;
	private Date exitDate;

	public OccupantHistoryRO(OccupantHistoryEO history) {
		super();
		this.historyId = history.getHistoryId();
		this.occupantId = history.getOccupantId();
		this.entryDate = history.getEntryDate();
		this.exitDate = history.getExitDate();
	}
	
	public OccupantHistoryRO(){
		
	}

	public OccupantHistoryRO(int historyId, int occupantId, Date entryDate,
			Date exitDate) {
		super();
		this.historyId = historyId;
		this.occupantId = occupantId;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
	}
	
	public OccupantHistoryRO( int occupantId, Date entryDate,
			Date exitDate) {
		super();
		this.occupantId = occupantId;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
	}

	public OccupantHistoryEO getEntityObject() {
		OccupantHistoryEO history = new OccupantHistoryEO();
		history.setHistoryId(historyId);
		history.setOccupantId(occupantId);
		history.setEntryDate(entryDate);
		history.setExitDate(exitDate);
		return history;

	}

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public int getOccupantId() {
		return occupantId;
	}

	public void setOccupantId(int occupantId) {
		this.occupantId = occupantId;
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

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	@Override
	public String toString() {
		return "HistoryRO [historyId=" + historyId + ", occupantId="
				+ occupantId + ", entryDate=" + entryDate + ", exitDate="
				+ exitDate + "]";
	}
	
	

}
