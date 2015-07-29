package com.pga.eo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "BED_PRICE_HISTORY")
@XmlRootElement
public class BedPriceHistoryEO {
	private int bedPriceId;
	private int pgId;
	private int bedId;
	private int priceId;
	private Date effectiveFrom;
	private Date effectiveTo;

	@Id
	@Column(name = " BED_PRICE_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getBedPriceId() {
		return bedPriceId;
	}

	public void setBedPriceId(int bedPriceId) {
		this.bedPriceId = bedPriceId;
	}
	
	@Column(name = " PG_ID")
	public int getPgId() {
		return pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
	}

	@Column(name = "BED_ID")
	public int getBedId() {
		return bedId;
	}

	public void setBedId(int bedId) {
		this.bedId = bedId;
	}

	@Column(name = " PRICE_ID")
	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	@Column(name = "EFFECTIVE_FROM")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(Date effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	@Column(name = "EFFECTIVE_TO")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEffectiveTo() {
		return effectiveTo;
	}

	public void setEffectiveTo(Date effectiveTo) {
		this.effectiveTo = effectiveTo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("BedPriceHistoryEO [bedPriceId=" + bedPriceId)
				.append(", pgId=" + pgId)
				.append(", bedId=" + bedId).append(", priceId=" + priceId)
				.append(", effectiveFrom=" + effectiveFrom)
				.append(", effectiveTo=" + effectiveTo + "]").append("\n");
		return sb.toString();
	}

}
