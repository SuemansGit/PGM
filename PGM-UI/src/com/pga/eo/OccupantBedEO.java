package com.pga.eo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "OCCUPANT_BED")
 @NamedQueries({
 @NamedQuery(name = "GET_OCCUPANT_DETAIL", query = "SELECT occupantBed FROM OccupantBedEO occupantBed where occupantBed.occupantId = :occupant_id")
 //@NamedQuery(name = "GET_OCCUPANT_DETAIL", query = "SELECT occupantBed FROM OccupantBedEO occupantBed where occupantBed.bedId = :bed_id AND  		occupant.occupantId =:occupant_id")
 })
@XmlRootElement
public class OccupantBedEO {

	private int occupantBedId;
	private int occupantId;
	private int bedId;
	private int priceId;
	private BedEO bed;
	private OccupantEO occupant;

	@Id
	@Column(name = "OCCUPANT_BED_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getOccupantBedId() {
		return occupantBedId;
	}

	public void setOccupantBedId(int occupantBedId) {
		this.occupantBedId = occupantBedId;
	}

	@Column(name = "OCCUPANT_ID")
	public int getOccupantId() {
		return occupantId;
	}

	public void setOccupantId(int occupantId) {
		this.occupantId = occupantId;
	}

	@Column(name = "BED_ID")
	public int getBedId() {
		return bedId;
	}

	public void setBedId(int bedId) {
		this.bedId = bedId;
	}

	@Column(name = "PRICE_ID")
	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	//@OneToOne(mappedBy = "occupantBed", targetEntity = BedEO.class, fetch = FetchType.EAGER)
	public BedEO getBed() {
		return bed;
	}

	public void setBed(BedEO bed) {
		this.bed = bed;
	}

	//@OneToOne(optional = false)
	//@JoinColumn(name = "OCCUPANT_ID", referencedColumnName = "OCCUPANT_ID", insertable = false, updatable = false)
	public OccupantEO getOccupant() {
		return occupant;
	}

	public void setOccupant(OccupantEO occupant) {
		this.occupant = occupant;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("OccupantBedEO [occupantBedId=" + occupantBedId)
				.append(", occupantId=" + occupantId)
				.append(", bedId=" + bedId).append(", priceId=" + priceId)
				.append(", bed=" + bed).append("\n");
		return sb.toString();
	}

}
