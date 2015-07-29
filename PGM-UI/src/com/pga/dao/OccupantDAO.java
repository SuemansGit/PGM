package com.pga.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import com.pga.eo.AccountEO;
import com.pga.eo.BedEO;
import com.pga.eo.OccupantHistoryEO;
import com.pga.eo.OccupantEO;
import com.pga.ro.AccountRO;
import com.pga.ro.OccupantHistoryRO;
import com.pga.ro.OccupantRO;
import com.pga.util.Utility;

public class OccupantDAO {
	// TODO occupant without food
	// TODO occupant stay for one day

	public static OccupantRO createOccupant(EntityManager em,
			OccupantRO occupant) {
		OccupantEO occupanteo = occupant.getEntityObject();
		BedEO bed= em.find(BedEO.class, occupant.getBedId());
		occupanteo.setBed(bed);
		em.persist(occupanteo);
		System.out.println(occupanteo);
		occupant.setOccupantId(occupanteo.getOccupantId());
		return occupant;
	}

	public static void deleteOccupant(EntityManager em, int occupantId) {
		OccupantEO occupanteo = em.find(OccupantEO.class, occupantId);
		em.remove(occupanteo);
	}

	public static OccupantRO getOccupantById(EntityManager em, int occupantId) {
		OccupantEO occupanteo = em.find(OccupantEO.class, occupantId);
		 OccupantRO occupant = null;
		 if(occupanteo!=null){
			 occupant = new OccupantRO(occupanteo);
		 }
		return occupant;
	}

	public static OccupantRO getOccupantByName(EntityManager em, String name) {
		OccupantRO occupant = null;
		TypedQuery<OccupantEO> query = em.createNamedQuery("FIND_OCCUPANT_BY_NAME", OccupantEO.class);
		query.setParameter("name", name);
		List<OccupantEO> results = query.getResultList();
		if(results!=null){
		for (OccupantEO occupanteo : results) {
			occupant = new OccupantRO(occupanteo);
			}
		}
		return occupant;
	}

	public static List<OccupantRO> getOccupantsOfPg(EntityManager em,int pgId){
		List<OccupantRO> occupants = new ArrayList<OccupantRO>();
		TypedQuery<OccupantEO> query=em.createNamedQuery("FIND_OCCUPANTS_BY_PGID",OccupantEO.class);
		query.setParameter("pgId", pgId);
		List<OccupantEO> results = query.getResultList();
		if(results!=null){
		for (OccupantEO occupanteo : results) {
			System.out.println(occupanteo);
			OccupantRO occupant = new OccupantRO(occupanteo);
			occupants.add(occupant);
			}
		}
		return occupants;
		
	}
	public static AccountRO createAccount(EntityManager em, AccountRO account) {
		AccountEO accounteo = account.getEntityObject();
		em.persist(accounteo);
		accounteo.setAccountId(accounteo.getAccountId());
		return account;
	}

	public static void deleteAccount(EntityManager em, AccountRO account) {
		AccountEO accounteo = em.find(AccountEO.class, account);
		em.remove(accounteo);
	}

	public static AccountRO getAccountById(EntityManager em, int accountId) {
		AccountEO accounteo = em.find(AccountEO.class, accountId);
		AccountRO account = null;
		if(accounteo!= null){
			account = new AccountRO(accounteo);
		}
		return account;
	}

	public static OccupantHistoryRO createOccupantHistory(EntityManager em,
			OccupantHistoryRO occupantHistory) {
		OccupantHistoryEO occupantHistoryeo = occupantHistory.getEntityObject();
		em.persist(occupantHistoryeo);
		occupantHistoryeo.setHistoryId(occupantHistoryeo.getHistoryId());
		return occupantHistory;
	}

	public static void deleteHistory(EntityManager em, int historyId) {
		OccupantHistoryEO historyeo = em.find(OccupantHistoryEO.class,
				historyId);
		em.remove(historyeo);
	}

	public static OccupantHistoryRO getOccupantHistoryById(EntityManager em,int historyId) {
		OccupantHistoryEO occupantHistoryeo = em.find(OccupantHistoryEO.class, historyId);
		OccupantHistoryRO occupantHistory = null;
		if(occupantHistoryeo!= null){
			occupantHistory = new OccupantHistoryRO(occupantHistoryeo);
		}
		return occupantHistory;
	}
	
	public static OccupantHistoryRO getOccupantHistory(EntityManager em, int occupantId) {
		OccupantHistoryRO occupantHistory = null;
		TypedQuery<OccupantHistoryEO> query = em.createNamedQuery("GET_OCCUPANT_HISTORY", OccupantHistoryEO.class);
		query.setParameter("occupantId", occupantId);
		List<OccupantHistoryEO> results = query.getResultList();
		if(results!=null){
		for (OccupantHistoryEO occupantHistoryeo : results) {
			occupantHistory = new OccupantHistoryRO(occupantHistoryeo);
			}
		}
		return occupantHistory;
	}
	
	public static OccupantHistoryRO getVaccantBed(EntityManager em, int pgId) {
		OccupantHistoryRO occupantHistory = null;
		TypedQuery<OccupantHistoryEO> query = em.createNamedQuery("GET_VACCANT_BED", OccupantHistoryEO.class);
		query.setParameter("pgId", pgId);
		List<OccupantHistoryEO> results = query.getResultList();
		if(results!=null){
		for (OccupantHistoryEO occupantHistoryeo : results) {
			occupantHistory = new OccupantHistoryRO(occupantHistoryeo);
			}
		}
		return occupantHistory;
	}
	
	public static AccountRO getOccupantAccountDetails(EntityManager em, int occupantId) {
		AccountRO account = null;
		TypedQuery<AccountEO> query = em.createNamedQuery("GET_OCCUPANT_ACCOUNT_DETAILS", AccountEO.class);
		query.setParameter("occupantId", occupantId);
		List<AccountEO> results = query.getResultList();
		if(results!=null){
		for (AccountEO accounteo : results) {
			account = new AccountRO(accounteo);
			}
		}
		return account;
	}


	public static List<OccupantHistoryEO> getRecentOccupants(EntityManager em,
			int daysAfter) {
		TypedQuery<OccupantHistoryEO> query = em.createNamedQuery(
				"FIND_RECENT_OCCUPANT", OccupantHistoryEO.class);
		Timestamp date = Utility.getTimestampForDeltaDays(-1 * daysAfter);
		query.setParameter("entry_date", date, TemporalType.TIMESTAMP);
		List<OccupantHistoryEO> results = query.getResultList();
		if (results != null) {
			for (OccupantHistoryEO history : results) {
				System.out.println(history);
			}
		}
		return results;
	}
}
