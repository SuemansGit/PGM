 package com.pga.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.pga.dao.AccountDAO;
import com.pga.ro.AccountRO;
import com.pga.ro.PaymentHistoryRO;
import com.pga.util.Utility;
import com.rest.ro.BillSheetRO;

public class AccountService {
	
	public static List<AccountRO> getAccountDetails(int pgId) {
		EntityManager em = null;
		List<AccountRO> account = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			account = AccountDAO.getAccountDetails(em,pgId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return account;
	}
	
	public static List<AccountRO> getOccupantDues(int occupantId) {
		EntityManager em = null;
		List<AccountRO> account = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			account = AccountDAO.getOccupantDues(em, occupantId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return account;
	}
	
	public static List<BillSheetRO> getBalanceSheet(int pgId,int startMonth,int startYear,int endMonth,int endYear){
		EntityManager em = null;
		List<BillSheetRO> billSheet = null;
		try{
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			billSheet=AccountDAO.getBalanceSheet(em, pgId, startMonth, startYear, endMonth, endYear);
		}
		finally {
			em.close();
		}
		
		return  billSheet;
	}
	
	public static List<BillSheetRO> getBalanceSheet(int pgId,int startMonth,int startYear){
		EntityManager em = null;
		List<BillSheetRO> billSheet = null;
		try{
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			billSheet=AccountDAO.getBalanceSheet(em, pgId, startMonth, startYear);
		}
		finally {
			em.close();
		}
		
		return  billSheet;
	}
	
	public static List<PaymentHistoryRO>  getPaymentHistory(int pgId,int occupantId){
		EntityManager em = null;
		List<PaymentHistoryRO> paymentHistory=null;
		try{
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			paymentHistory=AccountDAO.getPaymentHistory(em, pgId, occupantId);
			
		}
		finally {
			em.close();
		}
		return paymentHistory;
		
		
	}
	

}
