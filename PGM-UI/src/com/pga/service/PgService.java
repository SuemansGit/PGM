package com.pga.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.pga.dao.BedDAO;
import com.pga.dao.OccupantDAO;
import com.pga.dao.PgDAO;
import com.pga.dao.RoomDAO;
import com.pga.eo.BedEO;
import com.pga.eo.BedPriceHistoryEO;
import com.pga.ro.AccountRO;
import com.pga.ro.BedPriceHistoryRO;
import com.pga.ro.BedRO;
import com.pga.ro.LogRO;
import com.pga.ro.OccupantHistoryRO;
import com.pga.ro.OccupantRO;
import com.pga.ro.PgRO;
import com.pga.ro.PriceRO;
import com.pga.ro.RoomRO;
import com.pga.ro.UserRO;
import com.pga.util.Utility;

public class PgService {
	

	public static PgRO createPG(PgRO pg) {
		EntityManager em = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			pg = PgDAO.createPg(em, pg);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return pg;
	}
	
	public static PgRO getPgByName(String name) {
		EntityManager em = null;
		PgRO pg = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			pg = PgDAO.getPgByName(em, name);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return pg;
	}
	
	public static PgRO getPgById(int pgId) {
		EntityManager em = null;
		PgRO pg = null;
		
		try {
//			System.out.println("I AM HERE");
			em = Utility.getEntityManager();
//			System.out.println("ENTITY MANAGER " + em);
			em.getTransaction().begin();
			pg = PgDAO.getPgById(em, pgId);
//			System.out.println("PG OBJECT " + pg);
			em.getTransaction().commit();
			System.out.println(pg);
		} finally {
			em.close();
		}
		return pg;
	}
	
	public static UserRO createUser(UserRO user) {
		EntityManager em = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			user = PgDAO.createUser(em, user);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return user;
	}
	
	public static UserRO getUserById(int userId) {
		EntityManager em = null;
		UserRO user = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			user = PgDAO.getUserById(em, userId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return user;
	}
	
	public static LogRO createLog(LogRO log) {
		EntityManager em = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			log = PgDAO.createLog(em, log);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return log;
	}
	
	public static LogRO getLogById(int logId) {
		EntityManager em = null;
		LogRO log = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			log = PgDAO.getLogById(em, logId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return log;
	}
	
	//TODO Should return PGRO
	public static boolean login(UserRO user) {
		boolean success = false;
		EntityManager em = null;
		if(user != null || !Utility.isNull(user.getName()) || 
				!Utility.isNull(user.getPassword())) {
			try {
				em = Utility.getEntityManager();
				em.getTransaction().begin();
				UserRO dbUser = PgDAO.getUserByName(em, user.getName());
				if(dbUser != null) {
					if(user.getPassword().equalsIgnoreCase(dbUser.getPassword())) {
						success = true;
					}
				}
				
				em.getTransaction().commit();
			} finally {
				em.close();
			}	
		}
		return success;
	}
//	public static xxx xxxx(xxxx xxx) {
//		EntityManager em = null;
//		try {
//			em = Utility.getEntityManager();
//			em.getTransaction().begin();
//			
//			
//			
//			
//			em.getTransaction().commit();
//		} finally {
//			em.close();
//		}
//	}
}
