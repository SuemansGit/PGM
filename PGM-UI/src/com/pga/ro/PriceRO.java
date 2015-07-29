package com.pga.ro;

import com.pga.eo.PriceEO;

public class PriceRO {

	private int priceId;
	private int price;
	private String occurance;

	public PriceRO(PriceEO pricero) {
		super();
		this.priceId = pricero.getPriceId();
		this.price = pricero.getPrice();
		this.occurance = pricero.getOccurance();
	}

	public PriceRO(int priceId, int price, String occurance) {
		super();
		this.priceId = priceId;
		this.price = price;
		this.occurance = occurance;
	}
	
	public PriceRO( int price, String occurance) {
		super();
		this.price = price;
		this.occurance = occurance;
	}
	
	public PriceEO getEntityObject() {
		PriceEO pricero = new PriceEO();
		pricero.setPriceId(priceId);
		pricero.setPrice(price);
		pricero.setOccurance(occurance);
		return pricero;
	}

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOccurance() {
		return occurance;
	}

	public void setOccurance(String occurance) {
		this.occurance = occurance;
	}

	@Override
	public String toString() {
		return "PriceRO [priceId=" + priceId + ", price=" + price
				+ ", occurance=" + occurance + "]";
	}
	
	

}
