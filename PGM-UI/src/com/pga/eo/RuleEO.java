package com.pga.eo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "RULE")
//@NamedQueries({
//@NamedQuery(name = "FIND_PG_BY_ADDRESS", query = "SELECT pg FROM PG pg where pg.name = :name")
//})
@XmlRootElement
public class RuleEO {
	
	private int ruleId;
	private int pgId;
	private PgEO pg;
	
	@Id //signifies the primary key
    @Column(name = "RULE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getRuleId() {
		return ruleId;
	}
	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}
	
	@Column(name = "PG_ID")
	public int getPgId() {
		return pgId;
	}
	public void setPgId(int pgId) {
		this.pgId = pgId;
	}
	
	@ManyToOne(optional=false)
	@JoinColumn(name="PG_ID",referencedColumnName="PG_ID", insertable=false, updatable=false)
	public PgEO getPg() {
		return pg;
	}
	public void setPg(PgEO pg) {
		this.pg = pg;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("RuleEO [ruleId=" + ruleId ).append(", pgId=" + pgId )
		.append("\n");
	return sb.toString();
	}
	
	

}
