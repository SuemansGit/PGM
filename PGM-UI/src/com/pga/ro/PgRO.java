package com.pga.ro;

import javax.xml.bind.annotation.XmlRootElement;

import com.pga.eo.PgEO;

@XmlRootElement
public class PgRO {
	private int pgId;
	private String name;
	private String address;
	private String category;

	
	public PgRO(PgEO pg) {
		super();
		this.pgId = pg.getPgId();
		this.name = pg.getName();
		this.address = pg.getAddress();
		this.category=pg.getCategory();
			}

	public PgRO(int pgId, String name, String address,String category) {
		super();
		this.pgId = pgId;
		this.name = name;
		this.address = address;
		this.category=category;
	}
	
	public PgRO(String name, String address,String category) {
		super();
		this.name = name;
		this.address = address;
		this.category=category;
	}	
	

	public PgEO getEntityObject() {
		PgEO pg = new PgEO();
		//pg.setPgId(pgId);
		pg.setName(name);
		pg.setAddress(address);
		pg.setCategory(category);
		return pg;
	}
	public PgRO(){
		
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "PgRO [pgId=" + pgId + ", name=" + name + ", address=" + address
				+", category="+category+ "]";
	}
	
	

}
