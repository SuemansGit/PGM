package com.pga.eo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "OCCUPANT_HISTORY")
// @NamedNativeQueries({
// @NamedNativeQuery(name = "FIND_RECENT_OCCUPANT", query =
// "SELECT h FROM HistoryEO h where h.entryDate BETWEEN :?1 AND :?2"),
// @NamedNativeQuery(name = "FIND_RECENT_OCCUPANT", query = "SELECT h FROM HistoryEO h where h.occupantId = ?1")
// })
 @NamedQueries({
 @NamedQuery(name = "GET_OCCUPANT_HISTORY", query ="SELECT oh FROM OccupantHistoryEO oh where oh.occupantId= :occupantId")
 })
@XmlRootElement
public class OccupantHistoryEO {

	private int historyId;
	private int pgId;
	private int occupantId;
	private int roomId;
	private int bedId;
	private Date entryDate;
	private Date exitDate;
	private OccupantEO occupant;

	@Id
	// signifies the primary key
	@Column(name = "HISTORY_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
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

	@Column(name = "ROOM_ID")
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	@Column(name = "BED_ID")
	public int getBedId() {
		return bedId;
	}

	public void setBedId(int bedId) {
		this.bedId = bedId;
	}

	@Column(name = "ENTRY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	@Column(name = "EXIT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
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
		sb.append("OccupantHistoryEO [historyId=" + historyId)
				.append(", pgId=" + pgId)
				.append(", occupantId=" + occupantId)
				.append(", roomId=" + roomId).append(", bedId=" + bedId)
				.append(", entryDate=" + entryDate)
				.append(", exitDate=" + exitDate).append("]");
		return sb.toString();
	}

}
