package com.pga.ro;

import com.pga.eo.RuleEO;

public class RuleRO {

	private int ruleId;
	private int pgId;

	public RuleRO(RuleEO rule) {
		super();
		this.ruleId = rule.getRuleId();
		this.pgId = rule.getPgId();
	}

	public RuleRO(int ruleId, int pgId) {
		super();
		this.ruleId = ruleId;
		this.pgId = pgId;
	}
	
	public RuleRO( int pgId) {
		super();
		this.pgId = pgId;
	}

	public RuleEO getEntityObject() {
		RuleEO rule = new RuleEO();
		rule.setRuleId(ruleId);
		rule.setRuleId(ruleId);
		return rule;
	}

	public int getRuleId() {
		return ruleId;
	}

	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}

	public int getPgId() {
		return pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
	}

	@Override
	public String toString() {
		return "RuleRO [ruleId=" + ruleId + ", pgId=" + pgId + "]";
	}
	
	

}
