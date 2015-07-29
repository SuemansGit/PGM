package com.pga.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.pga.eo.LogEO;
import com.pga.eo.PgEO;
import com.pga.eo.RoomEO;
import com.pga.eo.RuleEO;
import com.pga.eo.UserEO;
import com.pga.ro.LogRO;
import com.pga.ro.PgRO;
import com.pga.ro.RuleRO;
import com.pga.ro.UserRO;

public class PgDAO {

	public static PgRO createPg(EntityManager em, PgRO pg) {
		PgEO pgeo = pg.getEntityObject();
		em.persist(pgeo);
		pg.setPgId(pgeo.getPgId());
		return pg;
	}

	public static void deletePg(EntityManager em, int pgId) {
		PgEO pgeo = em.find(PgEO.class, pgId);
		em.remove(pgeo);
	}

	public static PgRO getPgById(EntityManager em, int pgId) {
		PgEO pgeo = em.find(PgEO.class, pgId);
		PgRO pg = null;
		if (pgeo != null) {
			pg = new PgRO(pgeo);
		}
		return pg;
	}

	public static PgRO getPgByName(EntityManager em, String name) {
		PgRO pg = null;
		TypedQuery<PgEO> query = em.createNamedQuery("FIND_PG_BY_NAME",PgEO.class);
		query.setParameter("name", name);
		List<PgEO> results = query.getResultList();
		if (results != null && results.size() > 0) {
			pg = new PgRO(results.get(0));
			System.out.println(pg);
		
		}
		return pg;
	}
    
	
	public static UserRO createUser(EntityManager em, UserRO user) {
		UserEO usereo = user.getEntityObject();		
		em.persist(usereo);
		user.setUserId(usereo.getUserId());
		return user;
	}

	public static void deleteUser(EntityManager em, UserRO user) {
		UserEO usereo = em.find(UserEO.class, user);
		em.remove(usereo);
	}

	public static UserRO getUserById(EntityManager em, int userId) {
		UserEO usereo = em.find(UserEO.class, userId);
		UserRO user = null; 
		if(usereo!= null){
			user = new UserRO(usereo);
		}
		return user;
	}

	public static UserRO getUserByName(EntityManager em, String name) {
		UserRO user = null;
		TypedQuery<UserEO> query = em.createNamedQuery("FIND_USER_BY_NAME",
				UserEO.class);
		query.setParameter("name", name);
		List<UserEO> results = query.getResultList();
		if (results != null && results.size() > 0) {
			user = new UserRO(results.get(0));
			System.out.println(user);
		}
		return user;
	}
    
	public static UserRO getUserByRole(EntityManager em, String role) {
		UserRO user = null;
		TypedQuery<UserEO> query = em.createNamedQuery("FIND_USER_BY_ROLE",
				UserEO.class);
		query.setParameter("role", role);
		List<UserEO> results = query.getResultList();
		if (results != null && results.size() > 0) {
			user = new UserRO(results.get(0));
			System.out.println(user);
		}
		return user;
	}

	public static LogRO createLog(EntityManager em, LogRO log) {
		LogEO logeo = log.getEntityObject();
		em.persist(logeo);
		logeo.setLogId(logeo.getLogId());
		return log;
	}

	public static void deleteLog(EntityManager em, LogRO log) {
		LogEO logeo = em.find(LogEO.class, log);
		em.remove(logeo);
	}

	public static LogRO getLogById(EntityManager em, int logId) {
		LogEO logeo = em.find(LogEO.class, logId);
		LogRO log = null;
		if(logeo!=null){
			log = new LogRO(logeo);
		}
		return log;
	}

	public static RuleRO createRULE(EntityManager em, RuleRO rule) {

		RuleEO ruleeo = rule.getEntityObject();
		em.persist(ruleeo);
		ruleeo.setRuleId(ruleeo.getRuleId());
		return rule;
	}

	public static void deleteRule(EntityManager em, RuleRO rule) {
		RuleEO ruleeo = em.find(RuleEO.class, rule);
		em.remove(ruleeo);
	}

	public static RuleRO getRuleById(EntityManager em, int ruleId) {
		RuleEO ruleeo = em.find(RuleEO.class, ruleId);
		RuleRO rule = null;
		if(ruleeo!=null){
			rule = new RuleRO(ruleeo);
		}
		return rule;
	}

}
