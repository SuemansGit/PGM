package com.pga.dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.text.html.HTMLDocument.Iterator;
import com.pga.eo.AccountEO;
import com.pga.eo.OccupantBedEO;
import com.pga.eo.OccupantEO;
import com.pga.eo.OccupantHistoryEO;
import com.pga.ro.AccountRO;
import com.pga.ro.OccupantHistoryRO;
import com.pga.ro.PaymentHistoryRO;
import com.pga.util.Utility;
import com.rest.ro.BillSheetRO;


public class AccountDAO {
	

	public static List<AccountRO> getAccountDetails(EntityManager em,int pgId) {
		AccountRO account = null;
		TypedQuery<AccountEO> query = em.createNamedQuery("GET_ACCOUNT_DETAILS",AccountEO.class);
		query.setParameter("pgId", pgId);
		List<AccountEO> results = query.getResultList();
		List<AccountRO> output = new ArrayList<AccountRO>();
		if (results != null && results.size() > 0) {
			for(AccountEO ac:results){
			account = new AccountRO(ac);
			output.add(account);
			System.out.println(account);
			}
		}
		return output;
	}
	
	public static List<AccountRO> getOccupantDues(EntityManager em,int occupantId) {
		AccountRO account = null;
		TypedQuery<AccountEO> query = em.createNamedQuery("GET_OCCUPANT_DUES",AccountEO.class);
		query.setParameter("occupantId", occupantId);
		List<AccountEO> results = query.getResultList();
		List<AccountRO> output = new ArrayList<AccountRO>();
		if (results != null && results.size() > 0) {
	         for(AccountEO eo : results) {
			 account = new AccountRO();
			 account.setAccountId(eo.getAccountId());
			 account.setDues(eo.getDues());
			 account.setFromDate(eo.getFromDate());
			 account.setPayment(eo.getPayment());
			 output.add(account);
			 }
		}
		return output;
	}
	
	public static List<PaymentHistoryRO> getPaymentHistory (EntityManager em,int pgId,int occupantId) {
		PaymentHistoryRO paymentHistory = null;
		TypedQuery<AccountEO> query = em.createNamedQuery("GET_PAYMENT_HISTORY",AccountEO.class);
		query.setParameter("pgId" ,pgId);
		query.setParameter("occupantId" ,occupantId);
		List<AccountEO> results = query.getResultList();
		List<PaymentHistoryRO> output = new ArrayList<PaymentHistoryRO>();
		if (results != null && results.size() > 0) {
	         for(AccountEO eo : results) {
	        paymentHistory = new PaymentHistoryRO();
	        paymentHistory.setDate(eo.getPaymentDate());
	        paymentHistory.setBalance(eo.getPayment() + eo.getDues());
	        paymentHistory.setPayment(eo.getPayment());
	        paymentHistory.setBill(eo.getPayment());
	        
	        
	        output.add(paymentHistory);
			 }
	         for(PaymentHistoryRO ph :output){
	        	 System.out.println(ph);
	         }
		}
		return  output;
	}
	//NEW
	public static List<BillSheetRO> getBalanceSheet(EntityManager em,int pgId, int startMonth, int startYear, int endMonth, int endYear) {
		BillSheetRO billSheet = null;
		TypedQuery<AccountEO> query = em.createNamedQuery("GET_BALANCE_SHEET",AccountEO.class);
		query.setParameter("pgId",pgId);
		query.setParameter("fromDate",Utility.getFirstDayOfMonth(startMonth, startYear));
		query.setParameter("toDate",Utility.getLastDayOfMonth(endMonth, endYear));
		TypedQuery<OccupantBedEO> query2 = em.createNamedQuery("GET_OCCUPANT_DETAIL",OccupantBedEO.class);
		List<AccountEO> results = query.getResultList();
	    List<BillSheetRO> output = new ArrayList<BillSheetRO>();
	    List<OccupantBedEO> oResult=new ArrayList<OccupantBedEO>();
		if (results != null && results.size() > 0) {
			 for(AccountEO eo : results) {
				billSheet = new BillSheetRO();
				billSheet.setPgId(eo.getPgId());
				billSheet.setFromDate(eo.getFromDate());
			    billSheet.setToDate(eo.getToDate());
		        billSheet.setDues(eo.getDues());
			    billSheet.setOccupantName(eo.getOccupant().getName());
			    billSheet.setPayment(eo.getPayment());
			    query2.setParameter("occupant_id", eo.getOccupantId());
			   /* oResult=query2.getResultList();
			    if (oResult != null && oResult.size() > 0){
			    for(OccupantBedEO beo:oResult){
			    	billSheet.setBedId(beo.getBedId());
			    	billSheet.setRoomId(beo.getBed().getRoomId());
			    }
			    }*/
			    output.add(billSheet);
				
				}
			 for(BillSheetRO bs :output){
					System.out.println(bs);
				}
		}
	
		return output;
	}
	
	public static List<BillSheetRO> getBalanceSheet(EntityManager em,int pgId, int startMonth, int startYear) {
		BillSheetRO billSheet = null;
		TypedQuery<AccountEO> query = em.createNamedQuery("GET_BALANCE_SHEET",AccountEO.class);
		query.setParameter("pgId",pgId);
		//query.setParameter("fromDate",Utility.getFirstDayOfMonth(startMonth, startYear));
		//query.setParameter("toDate",Utility.getLastDayOfMonth(startMonth, startYear));
		List<AccountEO> results = query.getResultList();
	    List<BillSheetRO> output = new ArrayList<BillSheetRO>();
	    System.out.println(results.size());
		if (results != null && results.size() > 0) {
			 for(AccountEO eo : results) {
				billSheet = new BillSheetRO();
				billSheet.setPgId(eo.getPgId());
				billSheet.setFromDate(eo.getFromDate());
			    billSheet.setToDate(eo.getToDate());
		        billSheet.setDues(eo.getDues());
			    billSheet.setOccupantName(eo.getOccupant().getName());
			    billSheet.setPayment(eo.getPayment());
			   
			    output.add(billSheet);				
				}
			 for(BillSheetRO bs :output){
					System.out.println(bs);
				}
		}
	
		return output;
	}
	
	
}
