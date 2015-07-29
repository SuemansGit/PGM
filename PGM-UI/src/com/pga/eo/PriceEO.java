package com.pga.eo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PRICE")
// @NamedQueries({
// @NamedQuery(name = "FIND_PG_BY_ADDRESS", query =
// "SELECT pg FROM PG pg where pg.name = :name")
// })
@XmlRootElement
public class PriceEO {

	private int priceId;
	private int pgId;
	private int price;
	private String occurance;
	private List<BedEO> bedList;

	@Id
	@Column(name = "PRICE_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	@Column(name = "PG_ID")
	public int getPgId() {
		return pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
	}

	@Column(name = "PRICE")
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Column(name = "OCCURANCE")
	public String getOccurance() {
		return occurance;
	}

	public void setOccurance(String occurance) {
		this.occurance = occurance;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "BED_PRICE", joinColumns = @JoinColumn(name = "PRICE_ID", referencedColumnName = "PRICE_ID"), inverseJoinColumns = @JoinColumn(name = "BED_ID", referencedColumnName = "BED_ID"))
	public List<BedEO> getBedList() {
		return bedList;
	}

	public void setBedList(List<BedEO> bedList) {
		this.bedList = bedList;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("PriceEO [priceId=" + priceId).append(",pgId=" + pgId)
				.append(", price=" + price)
				.append(", occurance=" + occurance + "]");

		return sb.toString();
	}

}
