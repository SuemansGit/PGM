package com.pga.eo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "OCCUPANT")
@NamedQueries({ 
@NamedQuery(name = "FIND_OCCUPANT_BY_NAME", query = "SELECT occupant FROM OccupantEO occupant where occupant.name = :name"),
@NamedQuery(name = "FIND_OCCUPANTS_BY_PGID", query ="SELECT occupant FROM OccupantEO occupant where occupant.pgId = :pgId")
// "SELECT occupant FROM OccupantEO occupant JOIN HistoryEO h where h.exitDate IS NULL")
})
@XmlRootElement
public class OccupantEO {

	private int occupantId;
	private int bedId;
	private int pgId;
	private String name;
	private long mobile;
	private String company;
	private String college;
	private String idCard;
	private long idNum;
	private byte[] image;
	private String address;
	private String city;
	private String email;
	private BedEO bed; 
	private List<OccupantHistoryEO> historyList;
	private List<AccountEO> accountList;
	//private OccupantBedEO occupantBed;

	@Id
	// signifies the primary key
	@Column(name = "OCCUPANT_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getOccupantId() {
		return occupantId;
	}

	public void setOccupantId(int occupantId) {
		this.occupantId = occupantId;
	}
	
	@Column(name="BED_ID")
	public int getBedId() {
		return bedId;
	}
	
	public void setBedId(int bedId) {
		this.bedId = bedId;
	}
	
	@OneToOne(optional=false)
    @JoinColumn(name ="BED_ID",insertable=false, updatable=false)
		public BedEO getBed() {
		return bed;
	}
		
		
	public void setBed(BedEO bed) {
		this.bed = bed;
	}	         


//	@Column(name = "OCCUPANT_BED_ID")
//	public int getOccupantBedId() {
//		return occupantBedId;
//	}
//
//	public void setOccupantBedId(int occupantBedId) {
//		this.occupantBedId = occupantBedId;
//	}

	

	@Column(name = "PG_ID")
	public int getPgId() {
		return pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "MOBILE")
	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	@Column(name = "COMPANY")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "COLLEGE")
	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	@Column(name = "IDCARD")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "ID_NUM")
	public long getIdNum() {
		return idNum;
	}

	public void setIdNum(long idNum) {
		this.idNum = idNum;
	}

	@Lob
	@Column(name = "IMAGE")
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "occupant", targetEntity = OccupantHistoryEO.class, fetch = FetchType.LAZY)
	public List<OccupantHistoryEO> getHistoryList() {
		return historyList;
	}

	public void setHistoryList(List<OccupantHistoryEO> historyList) {
		this.historyList = historyList;
	}

	@OneToMany(mappedBy = "occupant", targetEntity = AccountEO.class, fetch = FetchType.LAZY)
	public List<AccountEO> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<AccountEO> accountList) {
		this.accountList = accountList;
	}

	/*@OneToOne(mappedBy = "occupant", targetEntity = OccupantBedEO.class, fetch = FetchType.EAGER)
	public OccupantBedEO getOccupantBed() {
		return occupantBed;
	}

	public void setOccupantBed(OccupantBedEO occupantBed) {
		this.occupantBed = occupantBed;
	}*/

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("OccupantEO [occupantId=" + occupantId)
				.append(", pgId=" + pgId)
				.append(", name=" + name)
				.append(", occupantBedId=" + bedId)
				.append(", mobile=" + mobile).append(", company=" + company)
				.append(", college=" + college).append(", idCard=" + idCard)
				.append(", idNum=" + idNum).append(", image=" + image)
				.append(", address=" + address).append(", city=" + city)
				.append(", email=" + email + "]").append("\n");

		/*if (this.getHistoryList() != null) {
			int index = 1;
			for (OccupantHistoryEO history : this.getHistoryList()) {
				sb.append("HistoryEO " + index++).append("-\n").append(history)
						.append("\n");
			}
		}

		if (this.getAccountList() != null) {
			int index = 1;
			for (AccountEO account : this.getAccountList()) {
				sb.append("AccountEO " + index++).append("-\n").append(account)
						.append("\n");
			}
		}*/

		return sb.toString();
	}

}
