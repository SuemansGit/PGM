package com.pga.ro;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.pga.eo.BedEO;


@XmlRootElement
public class BedRO {
	
	private int bedId;
	private int occupantId;
	private int roomId;
	private int pgId;	
	private Date dateCreated;
	private Date dateDeleted;
	
	public BedRO(BedEO bed) {
		super();
		this.bedId = bed.getBedId();
		this.roomId = bed.getRoomId();
		this.pgId = bed.getPgId();
		if (bed.getOccupant()!=null){
		this.occupantId = bed.getOccupant().getOccupantId();
		}
		this.dateCreated = bed.getDateCreated();
		this.dateDeleted = bed.getDateDeleted();
	}
	public BedRO(int bedId, int roomId, int pgId,Date dateCreated, Date dateDeleted) {
		super();
		this.bedId = bedId;
		this.roomId = roomId;
		this.pgId=pgId;
		this.dateCreated = dateCreated;
		this.dateDeleted = dateDeleted;
	}
	
	public BedRO( int roomId, int pgId,Date dateCreated, Date dateDeleted) {
		super();
		this.roomId = roomId;
		this.pgId=pgId;
		this.dateCreated = dateCreated;
		this.dateDeleted = dateDeleted;
	}
	public BedEO getEntityObject(){
		BedEO bed = new BedEO();
		bed.setBedId(bedId);
		bed.setRoomId(roomId);
		bed.setPgId(pgId);
		bed.setDateCreated(dateCreated);
		bed.setDateDeleted(dateDeleted);
		return bed;
		}
	
	public int getBedId() {
		return bedId;
	}
	public void setBedId(int bedId) {
		this.bedId = bedId;
	}
	
	public int getPgId() {
		return pgId;
	}
	public void setPgId(int pgId) {
		this.pgId = pgId;
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
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateDeleted() {
		return dateDeleted;
	}
	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}
	@Override
	public String toString() {
		return "BedRO [bedId=" + bedId + ", roomId=" + roomId +" ,pgId ="+pgId
				+ ", dateCreated=" + dateCreated + ", dateDeleted="
				+ dateDeleted + "]";
	}
	
	

}
