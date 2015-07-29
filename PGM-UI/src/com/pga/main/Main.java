package com.pga.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.pga.dao.AccountDAO;
import com.pga.dao.OccupantBedDAO;
import com.pga.dao.OccupantDAO;
import com.pga.dao.PgDAO;
import com.pga.eo.AccountEO;
import com.pga.eo.BedEO;
import com.pga.eo.BedPriceHistoryEO;
import com.pga.eo.LogEO;
import com.pga.eo.OccupantBedEO;
import com.pga.eo.OccupantEO;
import com.pga.eo.OccupantHistoryEO;
import com.pga.eo.PgEO;
import com.pga.eo.PriceEO;
import com.pga.eo.RoomEO;
import com.pga.eo.RuleEO;
import com.pga.eo.UserEO;
import com.pga.util.Utility;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("pgajpa");
		EntityManager em = factory.createEntityManager();

		try {
			EntityTransaction entr = em.getTransaction();
			entr.begin();
					
//			initialize(em);
//			get(em);
//			OccupantBedDAO.getOccupantById(em, 1);
// 			OccupantDAO .getRecentOccupants(em, 7);
//			PgDAO.getPgById(em, 1);
//			PgDAO.getUserByRole(em, "admin");
//			RoomDAO.getRoomInPg(em);
//			RoomDAO.getRecentRoom(em, 1);
//			BedDAO.getBedInPg(em);
//			PgDAO.getPgByName(em, "s1 ");
//			OccupantBedDAO.getOccupantBedById(em, 7);
//			OccupantDAO.getOccupantByName(em, "kamal");
//			AccountDAO.getAccountDetails(em, 2);
//			AccountDAO.getOccupantDues(em, 12);
//			AccountDAO.getPaymentHistory(em, 2, 12);
			AccountDAO.getBalanceSheet(em,1,0,2014,5,2014);
//			Utility.convertIntToDate(4, 2014);
//			Utility.getLastDayOfMonth(1, 2012);
			entr.commit();
		} finally {
			em.close();
			factory.close();
		}
	}
	
	private static void get(EntityManager em){
//		PgEO pg = PgDAO.getPgById(em, 1);
//		System.out.println(pg);
//		UserEO user = PgDAO.getUserByID(em,1);
//		System.out.println("user detail" +user);
//		LogEO log = PgDAO.getLogByID(em, 1);
//		System.out.println("log detail" +log);
//		RoomEO room = RoomDAO.getRoomByID(em, 1);
//		System.out.println("room detail" +room);
//		BedEO bed = BedDAO.getBedByID(em, 1);
//		System.out.println(" bed detail " +bed);
//		PriceEO price = BedDAO.getPriceByID(em, 1);
//		System.out.println(" price detail " +price);
//		OccupantEO occupant = OccupantDAO.getOccupantByID(em, 1);
//		System.out.println("occupant detail " +occupant);
//		AccountEO account = OccupantDAO.getAccountByID(em, 1);
//		System.out.println("account details" +account);
//		OccupantHistoryEO history = OccupantDAO.getHistoryByID(em, 1);
//		System.out.println("history detail" +history);
//		BedPriceHistoryEO bedPriceHistory = BedDAO.getBedPriceHistoryByID(em, 1);
//		System.out.println("bedPriceHistory detail" +bedPriceHistory);
	}
	private static void initialize(EntityManager em) {
		PgEO pg = createPg(em, "RamJiAashram", "Lapata Ganj");
		OccupantEO occupant = createOccupant(em, "Kamal", 93929929, "IBM", "IIT", "PAN", null, "suncity", "Bangalore", "kk@gmail.com",pg.getPgId());
		UserEO user = createUser(em, pg, "gyan", "admin", "gyan123");
		LogEO log = createLog(em, "jhsjfhkljf", "mannual",pg);
		RoomEO room = createRoom(em, "A101", pg);
		BedEO bed = createBed(em , room);
		List<BedEO> list = new ArrayList<BedEO>();
		list.add(bed);
		PriceEO price = createPrice(em, 3000, "monthly", pg.getPgId(), list);
		BedPriceHistoryEO bedPriceHistory = createBedPriceHistory(em, 1, 1);
		
		OccupantBedEO occupantBed = createOccupantBed(em, occupant, bed, price.getPriceId());
//		AccountEO account = createAccount(em,  1000, 2000, 6, "j",occupant);
//		OccupantHistoryEO history = createHistory(em,pg.getPgId(),room.getRoomId(),bed.getBedId(), occupant);
	}
	
	private static PgEO createPg(EntityManager em, String name, String address) {
		PgEO pg = new PgEO();
		pg.setName(name);
		pg.setAddress(address);
		em.persist(pg);
		em.flush();
		return pg;
	}
	
	private static RoomEO createRoom(EntityManager em, String name, PgEO pg) {
		RoomEO room = new RoomEO();
		room.setName(name);
		room.setPgId(1);
		Calendar cal = Calendar.getInstance();
		room.setDateCreated(cal.getTime());
		room.setPgId(pg.getPgId());
		em.persist(room);
		em.flush();
		return room;
	}
	
	private static BedEO createBed(EntityManager em , RoomEO room) {
		BedEO bed = new BedEO();
		Calendar cal = Calendar.getInstance();
		bed.setDateCreated(cal.getTime());
		bed.setRoomId(room.getRoomId());
		bed.setPgId(room.getPgId());
		em.persist(bed);
		em.flush();
		return bed;
	}
	
	private static UserEO createUser(EntityManager em, PgEO pg, String name, String role, String password) {
		UserEO user = new UserEO();
		user.setPgId(pg.getPgId());
		user.setName(name);
		user.setRole(role);
		user.setPassword(password);
		em.persist(user);
		em.flush();
		return user;
	}
	
	private static PriceEO createPrice(EntityManager em, int priceValue, String occurance, 
			int pgId, List<BedEO> bedList) {
		PriceEO price = new PriceEO();
		price.setPrice(priceValue);
		price.setOccurance(occurance);
		price.setBedList(bedList);
		price.setPgId(pgId);
		em.persist(price);
		em.flush();
		return price;
	}
	
	private static BedPriceHistoryEO createBedPriceHistory(EntityManager em , int bedId,int priceId) {
		BedPriceHistoryEO bedPriceHistory = new BedPriceHistoryEO();
		Calendar cal = Calendar.getInstance();
		bedPriceHistory.setEffectiveFrom(cal.getTime());
		bedPriceHistory.setEffectiveTo(cal.getTime());
		bedPriceHistory.setBedId(bedId);
		bedPriceHistory.setPriceId(priceId);
		em.persist(bedPriceHistory);
		em.flush();
		return bedPriceHistory;
		
		
	}
	private static OccupantEO createOccupant(EntityManager em, String name,int mobile, String company, String college, String idCard,
			String image, String address, String city, String email,int pgId) {
		OccupantEO occupant = new OccupantEO();
		occupant.setName(name);
		occupant.setMobile(mobile);
		occupant.setCompany(company);
		occupant.setCollege(college);
		occupant.setIdCard(idCard);
		//occupant.setImage(image);
		occupant.setAddress(address);
		occupant.setCity(city);
		occupant.setEmail(email);
		occupant.setPgId(pgId);
//		occupant.setOccupantBed(occupantBed);
		em.persist(occupant);
		em.flush();
		return occupant;
	}
	private static OccupantBedEO createOccupantBed(EntityManager em, OccupantEO occupant,BedEO bed,int priceId){
		OccupantBedEO occupantBed = new OccupantBedEO();
		occupantBed.setBedId(bed.getBedId());
		occupantBed.setPriceId(priceId);
		occupantBed.setOccupantId(occupant.getOccupantId());
		occupantBed.setBed(bed);
		occupantBed.setOccupant(occupant);
		em.persist(occupantBed);
		em.flush();
		return occupantBed;
	}

	private static LogEO createLog(EntityManager em, String logTxt, String type, PgEO pg) {
		LogEO log = new LogEO();
		log.setLog(logTxt);
		Calendar cal = Calendar.getInstance();
		log.setDateCreated(cal.getTime());
		log.setType(type);
		log.setPgId(pg.getPgId());
		em.persist(log);
		em.flush();
		return log;
	}
	
	private static AccountEO createAccount(EntityManager em, int dues, int payment,int pgId, String notification, OccupantEO occupant) {
		AccountEO account = new AccountEO();
		Calendar cal = Calendar.getInstance();
		account.setFromDate(cal.getTime());
		account.setToDate(cal.getTime());
		account.setPaymentDate(cal.getTime());
		account.setDues(dues);
		account.setPayment(payment);
		account.setPgId(occupant.getPgId());
		account.setNotification(notification);
		account.setOccupantId(occupant.getOccupantId());
		em.persist(account);
		em.flush();
		return account;
	}
	
	private static OccupantHistoryEO createHistory(EntityManager em,int roomId,int bedId,int pgId, OccupantEO occupant) {
		OccupantHistoryEO history = new OccupantHistoryEO();
		Calendar cal = Calendar.getInstance();
		history.setEntryDate(cal.getTime());
		history.setBedId(bedId);
		history.setRoomId(roomId);
		history.setPgId(pgId);
		history.setOccupantId(occupant.getOccupantId());
		em.persist(history);
		em.flush();
		return history;
	}
	


	private static void deletePg(EntityManager em, int pgId) {
		PgEO pg = em.find(PgEO.class, pgId);
		em.remove(pg);
	}

	private static void deleteRoom(EntityManager em, int roomId) {
		RoomEO roomeo = em.find(RoomEO.class, roomId);
		em.remove(roomeo);
	}

	private static void deleteBed(EntityManager em, int bedId) {
		BedEO bedeo = em.find(BedEO.class, bedId);
		em.remove(bedeo);
	}

	private static void deleteUser(EntityManager em, int userId) {
		UserEO usereo = em.find(UserEO.class, userId);
		em.remove(usereo);
	}

	private static void getUserByID(EntityManager em, int userId) {
		UserEO usereo = em.find(UserEO.class, userId);
		System.out.println("Room Details is : " + usereo);
	}
	
	private static void deletePrice(EntityManager em, int priceId) {
		PriceEO priceeo = em.find(PriceEO.class, priceId);
		em.getTransaction().begin();
		em.remove(priceeo);
		em.getTransaction().commit();
	}

	private static void deleteOccupant(EntityManager em, int occupantId) {
		OccupantEO occupanteo = em.find(OccupantEO.class, occupantId);
		em.remove(occupanteo);
	}

	private static void deleteLog(EntityManager em, int logId) {
		LogEO logeo = em.find(LogEO.class, logId);
		em.remove(logeo);
	}

	private static void createRule(EntityManager em, PgEO pg) {
		RuleEO rule = new RuleEO();
		rule.setPg(pg);
	}

	private static void deleteRule(EntityManager em, int ruleId) {
		RuleEO ruleeo = em.find(RuleEO.class, ruleId);
		em.remove(ruleeo);
	}

	private static void deleteAccount(EntityManager em, int accountId) {
		AccountEO accounteo = em.find(AccountEO.class, accountId);
		em.remove(accounteo);
	}

	private static void deleteHistory(EntityManager em, int historyId) {
		OccupantHistoryEO historyeo = em.find(OccupantHistoryEO.class, historyId);
		em.remove(historyeo);
	}
	

}
