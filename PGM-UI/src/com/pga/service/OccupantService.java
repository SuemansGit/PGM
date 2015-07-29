package com.pga.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.pga.dao.OccupantDAO;
import com.pga.ro.AccountRO;
import com.pga.ro.OccupantHistoryRO;
import com.pga.ro.OccupantRO;
import com.pga.util.Utility;

public class OccupantService {
	
	public static OccupantRO createOccupant(OccupantRO occupant) {
		EntityManager em = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			occupant = OccupantDAO.createOccupant(em,occupant);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return occupant;
	}
	
	
	public static OccupantRO getOccupantById(int occupantId) {
		EntityManager em = null;
		OccupantRO occupant = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			occupant = OccupantDAO.getOccupantById(em,occupantId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return occupant;
	}
	
	public static OccupantRO getOccupantByName(String name) {
		EntityManager em = null;
		OccupantRO occupant = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			occupant = OccupantDAO.getOccupantByName(em,name);
			em.getTransaction().commit();
			} 
		finally {
			em.close();
		}
		return occupant;
	}
	
	public static List<OccupantRO> getOccupantsOfPg(int pgId){
		EntityManager em = null;
		List<OccupantRO> occupants = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			occupants = OccupantDAO.getOccupantsOfPg(em, pgId);
			em.getTransaction().commit();
			} 
		finally {
			em.close();
		}
		return occupants;
	}
	
	public static AccountRO createAccount(AccountRO account) {
		EntityManager em = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			account = OccupantDAO.createAccount(em,account);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return account;
	}
	
	public static AccountRO getAccountById(int accountId) {
		EntityManager em = null;
		AccountRO account = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			account = OccupantDAO.getAccountById(em,accountId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return account;
	}
	
	public static OccupantHistoryRO createOccupantHistory(OccupantHistoryRO occupantHistory) {
		EntityManager em = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			occupantHistory = OccupantDAO.createOccupantHistory(em,occupantHistory);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return occupantHistory;
	}
	
	public static OccupantHistoryRO getOccupantHistoryById(int occupantHistoryId) {
		EntityManager em = null;
		OccupantHistoryRO occupantHistory = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			occupantHistory = OccupantDAO.getOccupantHistoryById(em,occupantHistoryId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return occupantHistory;
	}
	
	public static OccupantHistoryRO getOccupantHistory(int occupantId) {
		EntityManager em = null;
		OccupantHistoryRO occupantHistory = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			occupantHistory = OccupantDAO.getOccupantHistory(em,occupantId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return occupantHistory;
	}
	public static OccupantHistoryRO getVaccantBed(int pgId) {
		EntityManager em = null;
		OccupantHistoryRO occupantHistory = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			occupantHistory = OccupantDAO.getVaccantBed(em,pgId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return occupantHistory;
	}
	
	public static AccountRO getOccupantAccountDetails(int occupantId) {
		EntityManager em = null;
		AccountRO account = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			account = OccupantDAO.getOccupantAccountDetails(em,occupantId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return account;
	}


}
