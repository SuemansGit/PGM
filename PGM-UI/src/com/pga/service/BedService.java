package com.pga.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.pga.dao.BedDAO;
import com.pga.ro.BedPriceHistoryRO;
import com.pga.ro.BedRO;
import com.pga.ro.PriceRO;
import com.pga.util.Utility;

public class BedService {
	
	public static BedRO createBed(BedRO bed) {
		EntityManager em = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			bed = BedDAO.createBed(em,bed);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return bed;
	}
	
	public static BedRO getBedById(int bedId) {
		EntityManager em = null;
		BedRO bed = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			bed = BedDAO.getBedById(em,bedId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return bed;
	}
	
	public static void deleteBed(int bedId){
		EntityManager em = null;
		
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			BedDAO.deleteBed(em, bedId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		
	}
	public static List<BedRO> getAllBeds(){
		EntityManager em = null;
		List<BedRO> bed = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			bed = BedDAO.getAllBeds(em);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return bed;
	}

	/*public static BedRO getOccupantByBedId(int bedId) {
		EntityManager em = null;
		BedRO bed = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			//bed = BedDAO.getOccupantByBedId(em,bedId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return bed;
	}*/
	
	/*public static List<BedRO> getBedInRoom(int roomId) {
		EntityManager em = null;
		List<BedRO> bedList=null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			//bedList = BedDAO.getBedInRoom(em,roomId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return bedList;
	}*/
	
	public static List<BedRO> getVaccantBed(int pgId) {
		EntityManager em = null;
	    List<BedRO> bedList=null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			bedList = BedDAO.getVaccantBed(em,pgId);
			
			System.out.println("size is"+bedList.size());
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return bedList;
	}
	
	
	public static PriceRO createPrice(PriceRO price) {
		EntityManager em = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			price = BedDAO.createPrice(em,price);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return price;
	}
	
	public static PriceRO getPriceById(int  priceId) {
		EntityManager em = null;
		PriceRO price = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			price = BedDAO.getPriceById(em,priceId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return price;
	}
	
	public static BedPriceHistoryRO createBedPriceHistory(BedPriceHistoryRO bedPriceHistory) {
		EntityManager em = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			bedPriceHistory = BedDAO.createBedPriceHistory(em,bedPriceHistory);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return bedPriceHistory;
	}
	
	
	public static BedPriceHistoryRO getBedPriceHistoryById(int bedPriceHistoryId) {
		EntityManager em = null;
		BedPriceHistoryRO bedPriceHistory = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			bedPriceHistory = BedDAO.getBedPriceHistoryById(em,bedPriceHistoryId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return bedPriceHistory;
	}
}
