package com.pga.ro;

import java.util.Date;

import com.pga.eo.AccountEO;
import com.pga.eo.BedPriceHistoryEO;

public class BedPriceHistoryRO {

	private int bedPriceId;
	private int bedId;
	private int priceId;
	private Date effectiveFrom;
	private Date effectiveTo;

	public BedPriceHistoryRO(BedPriceHistoryEO BedPriceHistory) {
		super();
		this.bedPriceId = BedPriceHistory.getBedPriceId();
		this.bedId = BedPriceHistory.getBedId();
		this.priceId = BedPriceHistory.getPriceId();
		this.effectiveFrom = BedPriceHistory.getEffectiveFrom();
		this.effectiveTo = BedPriceHistory.getEffectiveTo();
	}

	public BedPriceHistoryRO(int bedPriceId, int bedId, int priceId,
			Date effectiveFrom, Date effectiveTo) {
		super();
		this.bedPriceId = bedPriceId;
		this.bedId = bedId;
		this.priceId = priceId;
		this.effectiveFrom = effectiveFrom;
		this.effectiveTo = effectiveTo;
	}

	public BedPriceHistoryRO(int bedId, int priceId, Date effectiveFrom,
			Date effectiveTo) {
		super();
		this.bedId = bedId;
		this.priceId = priceId;
		this.effectiveFrom = effectiveFrom;
		this.effectiveTo = effectiveTo;
	}

	public BedPriceHistoryEO getEntityObject() {
		BedPriceHistoryEO BedPriceHistory = new BedPriceHistoryEO();
		BedPriceHistory.setBedPriceId(bedPriceId);
		BedPriceHistory.setBedId(bedId);
		BedPriceHistory.setBedPriceId(bedPriceId);
		BedPriceHistory.setEffectiveFrom(effectiveFrom);
		BedPriceHistory.setEffectiveTo(effectiveTo);
		return BedPriceHistory;
	}

	public int getBedPriceId() {
		return bedPriceId;
	}

	public void setBedPriceId(int bedPriceId) {
		this.bedPriceId = bedPriceId;
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

	public Date getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(Date effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	public Date getEffectiveTo() {
		return effectiveTo;
	}

	public void setEffectiveTo(Date effectiveTo) {
		this.effectiveTo = effectiveTo;
	}

	@Override
	public String toString() {
		return "BedPriceHistoryRO [bedPriceId=" + bedPriceId + ", bedId="
				+ bedId + ", priceId=" + priceId + ", effectiveFrom="
				+ effectiveFrom + ", effectiveTo=" + effectiveTo + "]";
	}

}
