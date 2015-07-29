package com.pga.ro;

import com.pga.eo.OccupantBedEO;

public class OccupantBedRO {

	private int occupantBedId;
	private int occupantId;
	private int bedId;
	private int priceId;
	
	public OccupantBedRO(OccupantBedEO occupantBed){
		super();
		this.occupantBedId = occupantBed.getOccupantBedId();
		this.occupantId = occupantBed.getOccupantId();
		this.bedId = occupantBed.getBedId();
		this.priceId = occupantBed.getPriceId();
		}

	public OccupantBedRO(int occupantBedId, int occupantId, int bedId,
			int priceId) {
		super();
		this.occupantBedId = occupantBedId;
		this.occupantId = occupantId;
		this.bedId = bedId;
		this.priceId = priceId;
	}
	
	public OccupantBedRO( int occupantId, int bedId,
			int priceId) {
		super();
		this.occupantId = occupantId;
		this.bedId = bedId;
		this.priceId = priceId;
	}
	
	public OccupantBedEO getEntityObject() {
		OccupantBedEO occupantBed = new OccupantBedEO();
		occupantBed.setOccupantBedId(occupantBedId);
		occupantBed.setOccupantId(occupantId);
		occupantBed.setBedId(bedId);
		occupantBed.setPriceId(priceId);
		return occupantBed;
	}
	

	public int getOccupantBedId() {
		return occupantBedId;
	}

	public void setOccupantBedId(int occupantBedId) {
		this.occupantBedId = occupantBedId;
	}

	public int getOccupantId() {
		return occupantId;
	}

	public void setOccupantId(int occupantId) {
		this.occupantId = occupantId;
	}

	public int getBedId() {
		return bedId;
	}

	public void setBedId(int bedId) {
		this.bedId = bedId;
	}

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	@Override
	public String toString() {
		return "OccupantBedRO [occupantBedId=" + occupantBedId
				+ ", occupantId=" + occupantId + ", bedId=" + bedId
				+ ", priceId=" + priceId + "]";
	}
	
	

}
