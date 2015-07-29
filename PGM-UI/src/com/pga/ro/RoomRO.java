package com.pga.ro;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.pga.eo.RoomEO;

@XmlRootElement
public class RoomRO {

	private int roomId;
	private int pgId;
	private String name;
	private Date dateCreated;
	private Date dateDeleted;

	public RoomRO(){
		
	}
	public RoomRO(RoomEO room) {
		super();
		this.roomId = room.getRoomId();
		this.pgId = room.getPgId();
		this.name = room.getName();
		this.dateCreated = room.getDateCreated();
		this.dateDeleted = room.getDateDeleted();
	}

	public RoomRO(int roomId, int pgId, String name, Date dateCreated,
			Date dateDeleted) {
		super();
		this.roomId = roomId;
		this.pgId = pgId;
		this.name = name;
		this.dateCreated = dateCreated;
		this.dateDeleted = dateDeleted;
	}
	
	public RoomRO(int pgId, String name, Date dateCreated,
			Date dateDeleted) {
		super();
		this.pgId = pgId;
		this.name = name;
		this.dateCreated = dateCreated;
		this.dateDeleted = dateDeleted;
	}

	public RoomEO getEntityObject() {
		RoomEO room = new RoomEO();
		room.setRoomId(roomId);
		room.setPgId(pgId);
		room.setName(name);
		room.setDateCreated(dateCreated);
		room.setDateDeleted(dateDeleted);
		return room;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getPgId() {
		return pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "RoomRO [roomId=" + roomId + ", pgId=" + pgId + ", name=" + name
				+ ", dateCreated=" + dateCreated + ", dateDeleted="
				+ dateDeleted + "]";
	}
	
	
}
