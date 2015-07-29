package com.pga.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.pga.dao.OccupantBedDAO;
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
import com.pga.eo.UserEO;
import com.pga.util.Utility;

public class Seed {

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

			initialize(em);

			entr.commit();
		} finally {
			em.close();
			factory.close();
		}

	}

	private static void initialize(EntityManager em) {
		PgEO pg1 = createPg(em, "PG1", "Btm 1st Stage");
		PgEO pg2 = createPg(em, "PG2", "Btm 2nd Stage");
		OccupantEO occupant1 = createOccupant(em, "Kamal", 93929929, "IBM","IIT", "PAN", null, "suncity", "Bangalore", "kk@gmail.com",pg1.getPgId());
		OccupantEO occupant2 = createOccupant(em, "Ashu", 93929966, "IBM","VIT", "Licence", null, "suncity", "Patna", "ashu@gmail.com",pg1.getPgId());
		OccupantEO occupant3 = createOccupant(em, "montu", 93929977, "IBM","VTU", "voter", null, "suncity", "Bangalore","montu@gmail.com", pg1.getPgId());
		OccupantEO occupant4 = createOccupant(em, "tushant", 93929955, "IBM","IIT", "PAN", null, "suncity", "sarjapur", "tushant@gmail.com",pg1.getPgId());
		OccupantEO occupant5 = createOccupant(em, "quershi", 93929944, "IBM","BPUT", "licence", null, "suncity", "mugalsarai","quershi@gmail.com", pg1.getPgId());
		OccupantEO occupant6 = createOccupant(em, "faizan", 93929933, "IBM","VTU", "PAN", null, "suncity", "Bangalore", "faizan@gmail.com",pg1.getPgId());
		OccupantEO occupant7 = createOccupant(em, "pal", 93929922, "IBM","VTU", "voter", null, "suncity", "darbhanga", "pal@gmail.com",pg1.getPgId());
		OccupantEO occupant8 = createOccupant(em, "ram", 93929911, "IBM","IIT", "PAN", null, "suncity", "Bangalore", "ram@gmail.com",pg1.getPgId());
		OccupantEO occupant9 = createOccupant(em, "Montu", 93929929, "IBM","IIT", "PAN", null, "suncity", "Bangalore", "montu@gmail.com",pg2.getPgId());
		OccupantEO occupant10 = createOccupant(em, "Sunil", 93929966, "Wipro","VIT", "Licence", null, "suncity", "Patna", "sunil@gmail.com",pg2.getPgId());
		OccupantEO occupant11 = createOccupant(em, "Talha", 93929977, "IBM","VTU", "voter", null, "suncity", "Bangalore","talha@gmail.com", pg2.getPgId());
		OccupantEO occupant12 = createOccupant(em, "Salman", 93929955,"Accenture", "IIT", "PAN", null, "suncity", "sarjapur","salman@gmail.com", pg2.getPgId());
		OccupantEO occupant13 = createOccupant(em, "Sarukh", 93929944, "IBM","BPUT", "licence", null, "suncity", "mugalsarai","sarukh@gmail.com", pg2.getPgId());
		OccupantEO occupant14 = createOccupant(em, "Jha", 93929933, "Oracle","VTU", "PAN", null, "suncity", "Bangalore", "jha@gmail.com",pg2.getPgId());
		OccupantEO occupant15 = createOccupant(em, "Tommy", 93929922, "Nious","VTU", "voter", null, "suncity", "darbhanga","tommy@gmail.com", pg2.getPgId());
		OccupantEO occupant16 = createOccupant(em, "Tushant", 93929911, "pgi","IIT", "PAN", null, "suncity", "Bangalore","tushant@gmail.com", pg2.getPgId());
		OccupantEO occupant17 = createOccupant(em, "Lakulesh", 93929922,"carried", "VTU", "voter", null, "suncity", "darbhanga","lakulesh@gmail.com", pg2.getPgId());
		OccupantEO occupant18 = createOccupant(em, "Manish", 93929911, "IBM","IIT", "PAN", null, "suncity", "Bangalore", "manish@gmail.com",pg2.getPgId());
		UserEO user1 = createUser(em, pg1, "U1", "admin", "u112");
		UserEO user2 = createUser(em, pg2, "U1", "admin", "u112");
		// LogEO log = createLog(em, "jhsjfhkljf", "mannual",pg);
		RoomEO room1 = createRoom(em, "R1", pg1, 15, 1,0 ,0 );
		 RoomEO room2 = createRoom(em, "R2", pg1,15,1,0,0);
		 RoomEO room3 = createRoom(em, "R3", pg1,15,1,8,31);
		 RoomEO room4 = createRoom(em, "R4", pg2,15,6,0,0);
		 RoomEO room5 = createRoom(em, "R1", pg2,15,6,0,0);
		 RoomEO room6 = createRoom(em, "R2", pg2,15,6,8,30);
		 BedEO bed1 = createBed(em ,pg1.getPgId(),room1.getRoomId(),occupant1.getOccupantId(),15,1,0,0);
		 BedEO bed2 = createBed(em ,pg1.getPgId(),room1.getRoomId(),occupant3.getOccupantId(),15,1,0,0);
		 BedEO bed3 = createBed(em ,pg1.getPgId(),room1.getRoomId(),occupant4.getOccupantId(),15,1,0,0);
		 BedEO bed4 = createBed(em ,pg1.getPgId(),room2.getRoomId(),occupant5.getOccupantId(),15,1,0,0);
		 BedEO bed5 = createBed(em ,pg1.getPgId(),room2.getRoomId(),occupant6.getOccupantId(),15,1,0,0);
		 BedEO bed6 = createBed(em ,pg1.getPgId(),room2.getRoomId(),occupant7.getOccupantId(),15,1,10,31);
		 BedEO bed7 = createBed(em ,pg1.getPgId(),room3.getRoomId(),occupant8.getOccupantId(),15,1,9,31);
		 BedEO bed8 = createBed(em ,pg2.getPgId(),room4.getRoomId(),occupant9.getOccupantId(),15,6,0,0);
		 BedEO bed9 = createBed(em ,pg2.getPgId(),room4.getRoomId(),occupant11.getOccupantId(),15,6,0,0);
		 BedEO bed10 = createBed(em ,pg2.getPgId(),room4.getRoomId(),occupant12.getOccupantId(),15,6,0,0);
		 BedEO bed11 = createBed(em ,pg2.getPgId(),room4.getRoomId(),occupant13.getOccupantId(),15,1,0,0);
		 BedEO bed12 = createBed(em ,pg2.getPgId(),room5.getRoomId(),occupant14.getOccupantId(),15,6,0,0);
		 BedEO bed13 = createBed(em ,pg2.getPgId(),room5.getRoomId(),occupant15.getOccupantId(),15,6,10,6);
		 BedEO bed14 = createBed(em ,pg2.getPgId(),room6.getRoomId(),occupant18.getOccupantId(),15,6,9,30);
		 List<BedEO> list = new ArrayList<BedEO>();
		 list.add(bed1);
		 list.add(bed2);
		 list.add(bed3);
		 list.add(bed4);
		 list.add(bed5);
		 list.add(bed6);
		 list.add(bed7);
		 list.add(bed8);
		 list.add(bed9);
		 list.add(bed10);
		 list.add(bed11);
		 list.add(bed12);
		 list.add(bed13);
		 list.add(bed14);
		 PriceEO price1 = createPrice(em, 5000, "monthly", pg1.getPgId(),list);
		 PriceEO price2 = createPrice(em, 4000, "monthly", pg1.getPgId(), list);
		 PriceEO price3 = createPrice(em, 3500, "monthly", pg1.getPgId(), list);
		 PriceEO price4 = createPrice(em, 150, "daily", pg1.getPgId(),list);
		 PriceEO price5 = createPrice(em, 1000, "weekly", pg1.getPgId(), list);
		 PriceEO price6 = createPrice(em, 900, "weekly", pg1.getPgId(), list);
		 PriceEO price7 = createPrice(em, 5500, "monthly", pg1.getPgId(),list);
		 PriceEO price8 = createPrice(em, 4500, "monthly", pg1.getPgId(), list);
		 PriceEO price9 = createPrice(em, 4000, "monthly", pg1.getPgId(), list);
		 PriceEO price10 = createPrice(em, 200, "daily", pg1.getPgId(),list);
		 PriceEO price11 = createPrice(em, 1200, "weekly", pg1.getPgId(), list);
		 PriceEO price12 = createPrice(em, 1000, "weekly", pg1.getPgId(), list);
		 PriceEO price13 = createPrice(em, 3500, "monthly", pg2.getPgId(),list);
		 PriceEO price14 = createPrice(em, 3000, "monthly", pg2.getPgId(), list);
		 PriceEO price15 = createPrice(em, 5000, "monthly", pg2.getPgId(), list);
		 PriceEO price16 = createPrice(em, 100, "daily", pg2.getPgId(),list);
		 PriceEO price17 = createPrice(em, 700, "weekly", pg2.getPgId(), list);
		 PriceEO price18 = createPrice(em, 250, "daily", pg2.getPgId(), list);
		
		 OccupantHistoryEO history1 = createHistory(em,pg1.getPgId(),room1.getRoomId(),bed1.getBedId(),occupant1.getOccupantId(),15,1,0,0);
		 OccupantHistoryEO history2 = createHistory(em,pg1.getPgId(),room1.getRoomId(),bed2.getBedId(),occupant2.getOccupantId(),15,1,8,31);
		 OccupantHistoryEO history3 = createHistory(em,pg1.getPgId(),room1.getRoomId(),bed2.getBedId(),occupant3.getOccupantId(),7,1,0,0);
		 OccupantHistoryEO history4 = createHistory(em,pg1.getPgId(),room1.getRoomId(),bed3.getBedId(),occupant4.getOccupantId(),11,1,0,0);
		 OccupantHistoryEO history5 = createHistory(em,pg1.getPgId(),room2.getRoomId(),bed4.getBedId(),occupant5.getOccupantId(),15,1,0,0);
		 OccupantHistoryEO history6 = createHistory(em,pg1.getPgId(),room2.getRoomId(),bed5.getBedId(),occupant6.getOccupantId(),15,1,0,0);
		 OccupantHistoryEO history7 = createHistory(em,pg1.getPgId(),room2.getRoomId(),bed6.getBedId(),occupant7.getOccupantId(),15,1,10,31);
		 OccupantHistoryEO history8 = createHistory(em,pg1.getPgId(),room3.getRoomId(),bed7.getBedId(),occupant8.getOccupantId(),15,1,9,31);
		 OccupantHistoryEO history9 = createHistory(em,pg2.getPgId(),room4.getRoomId(),bed8.getBedId(),occupant9.getOccupantId(),15,1,0,0);
		 OccupantHistoryEO history10 = createHistory(em,pg2.getPgId(),room4.getRoomId(),bed9.getBedId(),occupant10.getOccupantId(),15,6,14,6);
		 OccupantHistoryEO history11 = createHistory(em,pg2.getPgId(),room4.getRoomId(),bed9.getBedId(),occupant11.getOccupantId(),14,2,0,0);
		 OccupantHistoryEO history12 = createHistory(em,pg2.getPgId(),room4.getRoomId(),bed10.getBedId(),occupant12.getOccupantId(),15,1,0,0);
		 OccupantHistoryEO history13 = createHistory(em,pg2.getPgId(),room4.getRoomId(),bed11.getBedId(),occupant13.getOccupantId(),15,1,0,0);
		 OccupantHistoryEO history14 = createHistory(em,pg2.getPgId(),room5.getRoomId(),bed12.getBedId(),occupant14.getOccupantId(),15,1,11,5);
		 OccupantHistoryEO history15 = createHistory(em,pg2.getPgId(),room5.getRoomId(),bed13.getBedId(),occupant15.getOccupantId(),15,1,0,0);
		 OccupantHistoryEO history16 = createHistory(em,pg2.getPgId(),room6.getRoomId(),bed14.getBedId(),occupant16.getOccupantId(),15,6,3,1);
		 OccupantHistoryEO history17 = createHistory(em,pg2.getPgId(),room6.getRoomId(),bed14.getBedId(),occupant17.getOccupantId(),15,1,15,16);
		 OccupantHistoryEO history18 = createHistory(em,pg2.getPgId(),room6.getRoomId(),bed14.getBedId(),occupant18.getOccupantId(),15,1,10,16);
		 
		 OccupantBedEO occupantBed1 = createOccupantBed(em, occupant1, bed1, price3.getPriceId());
		 OccupantBedEO occupantBed2 = createOccupantBed(em, occupant2, bed2, price3.getPriceId());
		 OccupantBedEO occupantBed3 = createOccupantBed(em, occupant3, bed2, price3.getPriceId());
		 OccupantBedEO occupantBed4 = createOccupantBed(em, occupant4, bed3, price3.getPriceId());
		 OccupantBedEO occupantBed5 = createOccupantBed(em, occupant5, bed4, price2.getPriceId());
		 OccupantBedEO occupantBed6 = createOccupantBed(em, occupant6, bed5, price2.getPriceId());
		 OccupantBedEO occupantBed7 = createOccupantBed(em, occupant7, bed6, price2.getPriceId());
		 OccupantBedEO occupantBed8 = createOccupantBed(em, occupant8, bed7, price1.getPriceId());
		 OccupantBedEO occupantBed9 = createOccupantBed(em, occupant9, bed8, price14.getPriceId());
		 OccupantBedEO occupantBed10 = createOccupantBed(em, occupant10, bed9, price14.getPriceId());
		 OccupantBedEO occupantBed11 = createOccupantBed(em, occupant11, bed9, price14.getPriceId());
		 OccupantBedEO occupantBed12 = createOccupantBed(em, occupant12, bed10, price14.getPriceId());
		 OccupantBedEO occupantBed13 = createOccupantBed(em, occupant13, bed11, price14.getPriceId());
		 OccupantBedEO occupantBed14 = createOccupantBed(em, occupant14, bed12, price13.getPriceId());
		 OccupantBedEO occupantBed15 = createOccupantBed(em, occupant15, bed13, price15.getPriceId());
		 OccupantBedEO occupantBed16 = createOccupantBed(em, occupant16, bed14, price17.getPriceId());
		 OccupantBedEO occupantBed17 = createOccupantBed(em, occupant17, bed14, price18.getPriceId());
		 OccupantBedEO occupantBed18 = createOccupantBed(em, occupant18, bed14, price15.getPriceId());
		 
		 
		 BedPriceHistoryEO bedPriceHistory1 = createBedPriceHistory(em,pg1.getPgId(), bed1.getBedId(), price3.getPriceId(),15,1,0,0);
		 BedPriceHistoryEO bedPriceHistory2 = createBedPriceHistory(em,pg1.getPgId(), bed2.getBedId(), price3.getPriceId(),15,1,7,31);
		 BedPriceHistoryEO bedPriceHistory3 = createBedPriceHistory(em,pg1.getPgId(), bed2.getBedId(), price3.getPriceId(),15,9,0,0);
		 BedPriceHistoryEO bedPriceHistory4 = createBedPriceHistory(em,pg1.getPgId(), bed3.getBedId(), price3.getPriceId(),15,4,0,0);
		 BedPriceHistoryEO bedPriceHistory5 = createBedPriceHistory(em,pg1.getPgId(), bed4.getBedId(), price2.getPriceId(),15,1,0,0);
		 BedPriceHistoryEO bedPriceHistory6 = createBedPriceHistory(em,pg1.getPgId(), bed5.getBedId(), price2.getPriceId(),15,1,0,0);
		 BedPriceHistoryEO bedPriceHistory7 = createBedPriceHistory(em,pg1.getPgId(), bed6.getBedId(), price2.getPriceId(),15,1,10,31);
		 BedPriceHistoryEO bedPriceHistory8 = createBedPriceHistory(em,pg1.getPgId(), bed7.getBedId(), price1.getPriceId(),15,1,8,31);
		 BedPriceHistoryEO bedPriceHistory9 = createBedPriceHistory(em,pg2.getPgId(), bed8.getBedId(), price14.getPriceId(),15,6,0,0);
		 BedPriceHistoryEO bedPriceHistory10 = createBedPriceHistory(em,pg2.getPgId(), bed9.getBedId(), price14.getPriceId(),15,6,14,6);
		 BedPriceHistoryEO bedPriceHistory11 = createBedPriceHistory(em,pg2.getPgId(), bed9.getBedId(), price14.getPriceId(),14,6,0,0);
		 BedPriceHistoryEO bedPriceHistory12 = createBedPriceHistory(em,pg2.getPgId(), bed10.getBedId(), price14.getPriceId(),14,6,0,0);
		 BedPriceHistoryEO bedPriceHistory13 = createBedPriceHistory(em,pg2.getPgId(), bed11.getBedId(), price14.getPriceId(),15,6,0,0);
		 BedPriceHistoryEO bedPriceHistory14 = createBedPriceHistory(em,pg2.getPgId(), bed12.getBedId(), price13.getPriceId(),15,6,10,6);
		 BedPriceHistoryEO bedPriceHistory16 = createBedPriceHistory(em,pg2.getPgId(), bed13.getBedId(), price15.getPriceId(),15,6,0,0);
		 BedPriceHistoryEO bedPriceHistory17 = createBedPriceHistory(em,pg2.getPgId(), bed14.getBedId(), price17.getPriceId(),15,6,15,13);
		 BedPriceHistoryEO bedPriceHistory18 = createBedPriceHistory(em,pg2.getPgId(), bed14.getBedId(), price18.getPriceId(),15,14,15,16);
		 BedPriceHistoryEO bedPriceHistory19 = createBedPriceHistory(em, pg2.getPgId(),bed14.getBedId(), price15.getPriceId(),15,17,9,16);
		 
		
		
		  AccountEO account1 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant1.getOccupantId(),14,1,15,1,14,1);
		  AccountEO account2 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant1.getOccupantId(),13,1,14,1,13,1);
		  AccountEO account3 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant1.getOccupantId(),12,1,13,1,12,1);
		  AccountEO account4 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant1.getOccupantId(),11,1,12,1,11,1);
		  AccountEO account5 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant1.getOccupantId(),10,1,11,1,10,1);
		  AccountEO account6 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant1.getOccupantId(),9,1,10,1,9,1);
		  AccountEO account7 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant1.getOccupantId(),8,1,9,1,8,1);
		  AccountEO account8 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant1.getOccupantId(),7,1,8,1,7,1);
		  AccountEO account9 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant1.getOccupantId(),6,1,7,1,6,1);
		  AccountEO account10 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant1.getOccupantId(),5,1,6,1,5,1);
		  AccountEO account11 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant1.getOccupantId(),4,1,5,1,4,1);
		  AccountEO account12 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant1.getOccupantId(),3,1,4,1,3,1);
		  AccountEO account13 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant1.getOccupantId(),2,1,3,1,2,1);
		  AccountEO account14 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant2.getOccupantId(),14,1,15,1,14,1);
		  AccountEO account15 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant2.getOccupantId(),13,1,14,1,13,1);
		  AccountEO account16 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant2.getOccupantId(),12,1,13,1,12,1);
		  AccountEO account17 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant2.getOccupantId(),11,1,12,1,11,1);
		  AccountEO account18 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant2.getOccupantId(),10,1,11,1,10,1);
		  AccountEO account19 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant2.getOccupantId(),9,1,10,1,9,1);
		  AccountEO account20 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant2.getOccupantId(),8,1,9,1,8,1);
		  AccountEO account21 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant2.getOccupantId(),7,1,8,1,7,1);
		  AccountEO account22 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant3.getOccupantId(),14,1,15,1,14,1);
		  AccountEO account23 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant3.getOccupantId(),13,1,14,1,13,1);
		  AccountEO account24 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant3.getOccupantId(),12,1,13,1,12,1);
		  AccountEO account25 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant3.getOccupantId(),11,1,12,1,11,1);
		  AccountEO account26 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant3.getOccupantId(),10,1,11,1,10,1);
		  AccountEO account27 = createAccount(em, 500, 3000, pg1.getPgId(), "500 dues",occupant4.getOccupantId(),11,1,12,1,11,1);
		  AccountEO account28 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant4.getOccupantId(),10,1,11,1,10,1);
		  AccountEO account29=  createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant4.getOccupantId(),9,1,10,1,9,1);
		  AccountEO account30 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant4.getOccupantId(),8,1,9,1,8,1);
		  AccountEO account31 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant4.getOccupantId(),7,1,8,1,7,1);
		  AccountEO account32 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant4.getOccupantId(),6,1,7,1,6,1);
		  AccountEO account33 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant4.getOccupantId(),5,1,6,1,5,1);
		  AccountEO account34 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant4.getOccupantId(),4,1,5,1,4,1);
		  AccountEO account35 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant4.getOccupantId(),3,1,4,1,3,1);
		  AccountEO account36 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant4.getOccupantId(),2,1,3,1,2,1);
		  AccountEO account37 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant5.getOccupantId(),14,1,15,1,14,1);
		  AccountEO account38 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant5.getOccupantId(),13,1,14,1,13,1);
		  AccountEO account39= createAccount(em, 300, 3200, pg1.getPgId(), "300 dues",occupant5.getOccupantId(),12,1,13,1,12,1);
		  AccountEO account40= createAccount(em, 0, 3800, pg1.getPgId(), "no dues",occupant5.getOccupantId(),11,1,12,1,11,1);
		  AccountEO account41 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant5.getOccupantId(),10,1,11,1,10,1);
		  AccountEO account42 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant5.getOccupantId(),9,1,10,1,9,1);
		  AccountEO account43 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant5.getOccupantId(),8,1,9,1,8,1);
		  AccountEO account44 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant5.getOccupantId(),7,1,8,1,7,1);
		  AccountEO account45 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant5.getOccupantId(),6,1,7,1,6,1);
		  AccountEO account46 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant5.getOccupantId(),5,1,6,1,5,1);
		  AccountEO account47 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant5.getOccupantId(),4,1,5,1,4,1);
		  AccountEO account48 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant5.getOccupantId(),3,1,4,1,3,1);
		  AccountEO account49 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant5.getOccupantId(),2,1,3,1,2,1);
		  AccountEO account50 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant5.getOccupantId(),14,1,15,1,14,1);
		  AccountEO account51 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant6.getOccupantId(),13,1,14,1,13,1);
		  AccountEO account52 = createAccount(em, 300,3200, pg1.getPgId(), "300 dues",occupant6.getOccupantId(),12,1,13,1,12,1);
		  AccountEO account53 = createAccount(em, 0, 3800, pg1.getPgId(), "no dues",occupant6.getOccupantId(),11,1,12,1,11,1);
		  AccountEO account54 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant6.getOccupantId(),10,1,11,1,10,1);
		  AccountEO account55 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant6.getOccupantId(),9,1,10,1,9,1);
		  AccountEO account56 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant6.getOccupantId(),8,1,9,1,8,1);
		  AccountEO account57 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant6.getOccupantId(),7,1,8,1,7,1);
		  AccountEO account58 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant6.getOccupantId(),6,1,7,1,6,1);
		  AccountEO account59 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant6.getOccupantId(),5,1,6,1,5,1);
		  AccountEO account60 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant6.getOccupantId(),4,1,5,1,4,1);
		  AccountEO account61 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant6.getOccupantId(),3,1,4,1,3,1);
		  AccountEO account62 = createAccount(em, 0, 4000, pg1.getPgId(), "no dues",occupant6.getOccupantId(),2,1,3,1,2,1);
		  AccountEO account63 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant7.getOccupantId(),14,1,15,1,14,1);
		  AccountEO account64 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant7.getOccupantId(),13,1,14,1,13,1);
		  AccountEO account65 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant7.getOccupantId(),12,1,13,1,12,1);
		  AccountEO account66 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant7.getOccupantId(),11,1,12,1,11,1);
		  AccountEO account67 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant8.getOccupantId(),14,1,15,1,14,1);
		  AccountEO account68 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant8.getOccupantId(),13,1,14,1,13,1);
		  AccountEO account69 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant8.getOccupantId(),12,1,13,1,12,1);
		  AccountEO account70 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant8.getOccupantId(),11,1,12,1,11,1);
		  AccountEO account71 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant8.getOccupantId(),10,1,11,1,10,1);
		  AccountEO account72 = createAccount(em, 0, 3500, pg1.getPgId(), "no dues",occupant8.getOccupantId(),9,1,10,1,9,1);
		  AccountEO account73 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant9.getOccupantId(),14,6,15,6,14,6);
		  AccountEO account74 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant9.getOccupantId(),13,6,14,6,13,6);
		  AccountEO account75 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant9.getOccupantId(),12,6,13,6,12,6);
		  AccountEO account76 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant9.getOccupantId(),11,6,12,6,11,6);
		  AccountEO account77 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant9.getOccupantId(),10,6,11,6,10,6);
		  AccountEO account78 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant9.getOccupantId(),9,6,10,6,9,6);
		  AccountEO account79 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant9.getOccupantId(),8,6,9,6,8,6);
		  AccountEO account80 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant9.getOccupantId(),7,6,8,6,7,6);
		  AccountEO account81 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant9.getOccupantId(),6,6,7,6,6,6);
		  AccountEO account82 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant9.getOccupantId(),5,6,6,6,5,6);
		  AccountEO account83 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant9.getOccupantId(),4,6,5,6,4,6);
		  AccountEO account84 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant9.getOccupantId(),3,6,4,6,3,6);
		  AccountEO account85 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant10.getOccupantId(),14,6,15,6,14,6);
		  AccountEO account86 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant11.getOccupantId(),13,6,14,6,13,6);
		  AccountEO account87 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant11.getOccupantId(),12,6,13,6,12,6);
		  AccountEO account88 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant11.getOccupantId(),11,6,12,6,11,6);
		  AccountEO account89 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant11.getOccupantId(),10,6,11,6,10,6);
		  AccountEO account90 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant11.getOccupantId(),9,6,10,6,9,6);
		  AccountEO account91 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant11.getOccupantId(),8,6,9,6,8,6);
		  AccountEO account92 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant11.getOccupantId(),7,6,8,6,7,6);
		  AccountEO account93 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant11.getOccupantId(),6,6,7,6,6,6);
		  AccountEO account94 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant11.getOccupantId(),5,6,6,6,5,6);
		  AccountEO account95 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant11.getOccupantId(),4,6,5,6,4,6);
		  AccountEO account96 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant11.getOccupantId(),3,6,4,6,3,6);
		  AccountEO account97 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant12.getOccupantId(),14,6,15,6,14,6);
		  AccountEO account98 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant12.getOccupantId(),13,6,14,6,13,6);
		  AccountEO account99 = createAccount(em, 500, 2500, pg2.getPgId(), "500 dues",occupant12.getOccupantId(),12,6,13,6,12,6);
		  AccountEO account100 = createAccount(em, 0, 3500, pg2.getPgId(), "no dues",occupant12.getOccupantId(),11,6,12,6,11,6);
		  AccountEO account101 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant12.getOccupantId(),10,6,11,6,10,6);
		  AccountEO account102 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant12.getOccupantId(),9,6,10,6,9,6);
		  AccountEO account103 = createAccount(em, 0, 000, pg2.getPgId(), "no dues",occupant12.getOccupantId(),8,6,9,6,8,6);
		  AccountEO account104 = createAccount(em, 1000,2000, pg2.getPgId(), "1000 dues",occupant12.getOccupantId(),7,6,8,6,7,6);
		  AccountEO account105 = createAccount(em, 0, 4000, pg2.getPgId(), "no dues",occupant12.getOccupantId(),6,6,7,6,6,6);
		  AccountEO account106 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant12.getOccupantId(),5,6,6,6,5,6);
		  AccountEO account107 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant12.getOccupantId(),4,6,5,6,4,6);
		  AccountEO account108 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant12.getOccupantId(),3,6,4,6,3,6);
		  AccountEO account109 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant13.getOccupantId(),14,6,15,6,14,6);
		  AccountEO account110 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant13.getOccupantId(),13,6,14,6,13,6);
		  AccountEO account111 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant13.getOccupantId(),12,6,13,6,12,6);
		  AccountEO account112 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant13.getOccupantId(),11,6,12,6,11,6);
		  AccountEO account113 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant13.getOccupantId(),10,6,11,6,10,6);
		  AccountEO account114 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant13.getOccupantId(),9,6,10,6,9,6);
		  AccountEO account115 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant13.getOccupantId(),8,6,9,6,8,6);
		  AccountEO account116 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant13.getOccupantId(),7,6,8,6,7,6);
		  AccountEO account117 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant13.getOccupantId(),6,6,7,6,6,6);
		  AccountEO account118 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant13.getOccupantId(),5,6,6,6,5,6);
		  AccountEO account119 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant13.getOccupantId(),4,6,5,6,4,6);
		  AccountEO account120 = createAccount(em, 0, 3000, pg2.getPgId(), "no dues",occupant13.getOccupantId(),3,6,4,6,3,6);
		  AccountEO account121 = createAccount(em, 0, 3500, pg2.getPgId(), "no dues",occupant14.getOccupantId(),14,6,15,6,14,6);
		  AccountEO account122 = createAccount(em, 0, 3500, pg2.getPgId(), "no dues",occupant14.getOccupantId(),13,6,14,6,13,6);
		  AccountEO account123 = createAccount(em, 0, 3500, pg2.getPgId(), "no dues",occupant14.getOccupantId(),12,6,13,6,12,6);
		  AccountEO account124 = createAccount(em, 0, 3500, pg2.getPgId(), "no dues",occupant14.getOccupantId(),11,6,12,6,11,6);
		  AccountEO account125 = createAccount(em, 0, 3500, pg2.getPgId(), "no dues",occupant15.getOccupantId(),14,6,15,6,14,6);
		  AccountEO account126 = createAccount(em, 0, 3500, pg2.getPgId(), "no dues",occupant15.getOccupantId(),13,6,14,6,13,6);
		  AccountEO account127 = createAccount(em, 0, 3500, pg2.getPgId(), "no dues",occupant15.getOccupantId(),12,6,13,6,12,6);
		  AccountEO account128 = createAccount(em, 0, 3500, pg2.getPgId(), "no dues",occupant15.getOccupantId(),11,6,12,6,11,6);
		  AccountEO account129 = createAccount(em, 0, 3500, pg2.getPgId(), "no dues",occupant15.getOccupantId(),10,6,11,6,10,6);
		  AccountEO account130 = createAccount(em, 0, 5000, pg2.getPgId(), "no dues",occupant15.getOccupantId(),9,6,10,6,9,6);
		  AccountEO account131 = createAccount(em, 0, 5000, pg2.getPgId(), "no dues",occupant15.getOccupantId(),8,6,9,6,8,6);
		  AccountEO account132 = createAccount(em, 0, 5000, pg2.getPgId(), "no dues",occupant15.getOccupantId(),7,6,8,6,7,6);
		  AccountEO account133 = createAccount(em, 0, 5000, pg2.getPgId(), "no dues",occupant15.getOccupantId(),6,6,7,6,6,6);
		  AccountEO account134 = createAccount(em, 0, 5000, pg2.getPgId(), "no dues",occupant15.getOccupantId(),5,6,6,6,5,6);
		  AccountEO account135 = createAccount(em, 0, 5000, pg2.getPgId(), "no dues",occupant15.getOccupantId(),4,6,5,6,4,6);
		  AccountEO account136 = createAccount(em, 0, 5000, pg2.getPgId(), "no dues",occupant15.getOccupantId(),3,6,4,6,3,6);
		  AccountEO account137 = createAccount(em, 0, 700, pg2.getPgId(), "no dues",occupant16.getOccupantId(),15,13,15,6,15,13);
		  AccountEO account138 = createAccount(em, 0, 500, pg2.getPgId(), "no dues",occupant17.getOccupantId(),15,16,15,14,15,16);
		  AccountEO account139 = createAccount(em, 0, 5000, pg2.getPgId(), "no dues",occupant18.getOccupantId(),14,6,15,6,14,6);
		  AccountEO account140 = createAccount(em, 0, 5000, pg2.getPgId(), "no dues",occupant18.getOccupantId(),13,6,14,6,13,6);
		  AccountEO account141 = createAccount(em, 0, 5000, pg2.getPgId(), "no dues",occupant18.getOccupantId(),12,6,13,6,12,6);
		  AccountEO account142 = createAccount(em, 0, 5000, pg2.getPgId(), "no dues",occupant18.getOccupantId(),11,6,12,6,11,6);
		  AccountEO account143 = createAccount(em, 0, 5000, pg2.getPgId(), "no dues",occupant18.getOccupantId(),10,6,11,6,10,6);
		 
		  
}

	private static PgEO createPg(EntityManager em, String name, String address) {
		PgEO pg = new PgEO();
		pg.setName(name);
		pg.setAddress(address);
		em.persist(pg);
		em.flush();
		return pg;
	}

	private static RoomEO createRoom(EntityManager em, String name, PgEO pg,int createdmonth, int createdday,int deletedmonth,int deletedday ) {
		RoomEO room = new RoomEO();
		room.setName(name);
		room.setDateCreated(Utility.getBackDate(createdmonth, createdday));
		room.setDateDeleted(Utility.getBackDate(deletedmonth, deletedday));
		room.setPgId(pg.getPgId());
		em.persist(room);
		em.flush();
		return room;
	}

	private static BedEO createBed(EntityManager em,int pgId,int roomId,int occupantId, int createdmonth, int createdday,int deletedmonth,int deletedday) {
		BedEO bed = new BedEO();
		bed.setDateCreated(Utility.getBackDate(createdmonth, createdday));
		if(deletedmonth != 0 && deletedday != 0) {
			bed.setDateDeleted(Utility.getBackDate(deletedmonth, deletedday));
		}
		bed.setRoomId(roomId);
		bed.setPgId(pgId);
		//bed.s
		em.persist(bed);
		em.flush();
		return bed;
	}

	private static UserEO createUser(EntityManager em, PgEO pg, String name,String role, String password) {
		UserEO user = new UserEO();
		user.setPgId(pg.getPgId());
		user.setName(name);
		user.setRole(role);
		user.setPassword(password);
		em.persist(user);
		em.flush();
		return user;
	}

	private static PriceEO createPrice(EntityManager em, int priceValue,String occurance, int pgId, List<BedEO> bedList) {
		PriceEO price = new PriceEO();
		price.setPrice(priceValue);
		price.setOccurance(occurance);
		price.setBedList(bedList);
		price.setPgId(pgId);
		em.persist(price);
		em.flush();
		return price;
	}

	private static BedPriceHistoryEO createBedPriceHistory(EntityManager em, int pgId,int bedId, int priceId,int createdmonth, int createdday,int deletedmonth,int deletedday) {
		BedPriceHistoryEO bedPriceHistory = new BedPriceHistoryEO();
		Calendar cal = Calendar.getInstance();
		bedPriceHistory.setEffectiveFrom(Utility.getBackDate(createdmonth, createdday));
		bedPriceHistory.setEffectiveTo(Utility.getBackDate(deletedmonth, deletedday));
		bedPriceHistory.setPgId(pgId);
		bedPriceHistory.setBedId(bedId);
		bedPriceHistory.setPriceId(priceId);
		em.persist(bedPriceHistory);
		em.flush();
		return bedPriceHistory;

	}

	private static OccupantEO createOccupant(EntityManager em, String name,int mobile, String company, String college, String idCard,String image, String address, String city, String email, int pgId) {
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
		em.persist(occupant);
		em.flush();
		return occupant;
	}

	private static OccupantBedEO createOccupantBed(EntityManager em,OccupantEO occupant, BedEO bed, int priceId) {
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

	private static LogEO createLog(EntityManager em, String logTxt,
			String type, PgEO pg) {
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

	private static AccountEO createAccount(EntityManager em, int dues,int payment, int pgId, String notification,int occupantId,int paymentMonth,int paymentDate, int createdmonth, int createdday,int deletedmonth,int deletedday) {
		AccountEO account = new AccountEO();
		account.setFromDate(Utility.getBackDate(createdmonth, createdday));
		account.setToDate(Utility.getBackDate(deletedmonth, deletedday));
		account.setPaymentDate(Utility.getBackDate(paymentMonth, paymentDate));
		account.setPgId(pgId);
		account.setDues(dues);
		account.setPayment(payment);
		account.setNotification(notification);
		account.setOccupantId(occupantId);
		em.persist(account);
		em.flush();
		return account;
	}

	private static OccupantHistoryEO createHistory(EntityManager em,int roomId, int bedId, int pgId, int occupantId,int createdmonth, int createdday,int deletedmonth,int deletedday) {
		OccupantHistoryEO history = new OccupantHistoryEO();
		history.setEntryDate(Utility.getBackDate(createdmonth, createdday));
		history.setExitDate(Utility.getBackDate(deletedmonth, deletedday));
		history.setBedId(bedId);
		history.setRoomId(roomId);
		history.setPgId(pgId);
		history.setOccupantId(occupantId);
		em.persist(history);
		em.flush();
		return history;
	}

}
