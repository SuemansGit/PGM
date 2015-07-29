package com.pga.main;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.pga.dao.PgDAO;
import com.pga.ro.AccountRO;
import com.pga.ro.BedPriceHistoryRO;
import com.pga.ro.BedRO;
import com.pga.ro.LogRO;
import com.pga.ro.OccupantHistoryRO;
import com.pga.ro.OccupantRO;
import com.pga.ro.PgRO;
import com.pga.ro.PriceRO;
import com.pga.ro.RegisteredUserRO;
import com.pga.ro.RoomRO;
import com.pga.ro.UserRO;
import com.pga.service.AccountService;
import com.pga.service.BedService;
import com.pga.service.OccupantService;
import com.pga.service.PgService;
import com.pga.service.RegisteredUserService;
import com.pga.service.RoomService;
import com.pga.service.UserService;
import com.pga.util.Utility;

public class PgController {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//createOccupant(15,1,"ayesha",77777,
				//"tcs","bnm", "idcard","img","jayanagar", "blore","abc@abc.com");
		//getRoomsInPg(1);
		//RoomService.deleteRoom(11);
	   // BedService.deleteBed(1);
		//createOccupant(15,"Sara",8767,"TCS","BNM","collegeid","bday.jpg","Indranagar","Bangalore");
		//createRegisteredUser("Ayesha","karim","ayesha@gmail.com","****","876677877");
		//createPg("ayesha","Arekere","Female");
		//createUser(3 ,"tooba", "admin","aliya123");
		//getAdminByPgId(3);
		//getOccupantsOfPg(1);
		//getBalanceSheet(1,0,2012,1,2012);
		getBalanceSheet(1,1,2012);
		//getPaymentHistory(1,2);
//		createPg("s1", "add1");
////		login("sadKLJLKD ", "kamal");
//		createUser(1,"kk","admin" ,"jha");
//		PgDAO.getUserByName(em, "gyan");
//		createLog( "jhsjfhkljf",1, "mannual");
//		getPgByName("s1");
//		getPgById(1);
//		getUserById(1);
//		getLogById(1);
//		getRoomById(1);
//		getPriceById(1);
//		getBedPriceHistoryById(1);
//		getBedById(1);
//		getOccupantById(1);
//		getAccountById(1);
//		getOccupantHistoryById(1);
//		getOccupantByName("kamal");
//		getOccupantHistory(2);
//		getOccupantAccountDetails(2);
//		getVaccantBed(1);
		getAccountDetails(1);
		//getOccupantDues(12);
		
	}
	private static void getBalanceSheet(int pgId, int startMonth, int startYear) {
		AccountService.getBalanceSheet(pgId, startMonth, startYear);
	}
	private static void getRoomsInPg(int id) {
		// TODO Auto-generated method stub
		List<RoomRO> rooms=RoomService.getRoomsByPgId(id);
		for(RoomRO room:rooms)
			System.out.println(room);
		
	}
	private static void createOccupant(int bedId,int pgId,String name, int mobile,
			String company, String college, String idCard, String image,
			String address, String city,String email){
		// TODO Auto-generated method stub
		byte[] img=Utility.getImage(image);
		System.out.println("occupant ayehsa");
		OccupantRO occupant=new OccupantRO(bedId,pgId,name,mobile,
				company,college, idCard,img,address, city,email);
		System.out.print(occupant.getAddress());
		OccupantService.createOccupant(occupant);
		
	}
	private static void getRegisteredUserById(int id) {
		RegisteredUserService.getUserById(id);
		
	}
	private static void createRegisteredUser(String firstName,String lastName,String email,String mobile,String password) {
		RegisteredUserRO user = new RegisteredUserRO(firstName,lastName,email, password, mobile);
	    user = RegisteredUserService.createRegisteredUser(user);
		//System.out.println(pg);
		
	}
	private static void createPgFromExcel(ArrayList<String> data) {	
		
		String name=data.get(0);
		String address=data.get(1);
		String category=data.get(2);
		createPg(name,address,category);
				
	}

	
	public static void readExcelSheet(String sheetName){
	try {
		FileInputStream	file=new FileInputStream("PgDetails.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		Iterator<Row> rowIterator = sheet.iterator();
		int count=0;
		while(rowIterator.hasNext()){
			ArrayList<String> values= new ArrayList<String>();
			count++;
			Row row = rowIterator.next();
			if(count==1)continue;
		    Iterator<Cell> cellIterator = row.cellIterator();
		    while(cellIterator.hasNext()){
		    Cell cell = cellIterator.next();
		    String cellValue = null;

		    switch(cell.getCellType()) {
		        case Cell.CELL_TYPE_BLANK:
		        cellValue=null;
				break;
				case Cell.CELL_TYPE_NUMERIC:
				cellValue=String.valueOf(cell.getNumericCellValue());
				break;
				case Cell.CELL_TYPE_STRING:
				cellValue=cell.getStringCellValue();
				break;
				}
		    values.add(cellValue);
		    
		  }
            if(sheetName.equals("PG")){
            	createPgFromExcel(values);
		    }
		    
		
		}
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		
	}
	private static void getOccupantsOfPg(int pgid) {
		
		OccupantService.getOccupantsOfPg(pgid);
	}
	private static void createRoom(String string, String string2) {
		// TODO Auto-generated method stub
		
	}
	private static void getAdminByPgId(int pgid){
		UserService.getAdminByPgId(3);
	}
	
	private static void getPaymentHistory(int pgId,int occupantId) {
		AccountService.getPaymentHistory(pgId, occupantId);
		
	}

	private static void getBalanceSheet(int pgId, int startMonth,int startYear,int endMonth,int endYear  ) {
		
		AccountService.getBalanceSheet(pgId, startMonth, startYear, endMonth, endYear);
	}
	
	private static void createPg(String name, String address,String category) {
		PgRO pg = new PgRO(name, address,category);
		pg = PgService.createPG(pg);
		System.out.println(pg);
	}
//	private static void getPgByName(String name) {
//		PgRO pg = new PgRO(name);
//		pg = PgService.getPgByName(name);
//		System.out.println(pg);
//	}
	private static void getPgById(int pgId) {
		PgRO pg = null;
		pg = PgService.getPgById(pgId);
		System.out.println(pg);
	}
	private static void getUserById(int userId) {
		UserRO user = null;
		user = PgService.getUserById(userId);
		System.out.println(user);
	}
	
	private static void getLogById(int logId) {
		LogRO log = null;
		log = PgService.getLogById(logId);
		System.out.println(log);
	}
	
	private static void getRoomById(int roomId) {
		RoomRO room = null;
		room = RoomService.getRoomById(roomId);
		System.out.println(room);
	}
	
	private static void getPriceById(int priceId) {
		PriceRO price = null;
		price = BedService.getPriceById(priceId);
		System.out.println(price);
	}
	
	private static void getBedPriceHistoryById(int bedPriceHistoryId) {
		BedPriceHistoryRO bedPriceHistory = null;
		bedPriceHistory = BedService.getBedPriceHistoryById(bedPriceHistoryId);
		System.out.println(bedPriceHistory);
	}
	
	private static void getBedById(int bedId) {
		BedRO bed = null;
		bed = BedService.getBedById(bedId);
		System.out.println(bed);
	}
	
	private static void getVaccantBed(int pgId) {
		List<BedRO> bed = null;
		bed = BedService.getVaccantBed(pgId);
		System.out.println(bed);
	}
	
	private static void getOccupantById(int occupantId) {
		OccupantRO occupant = null;
		occupant = OccupantService.getOccupantById(occupantId);
		System.out.println(occupant);
	}
	
	private static void getOccupantByName(String name) {
		OccupantRO occupant = null;
		occupant = OccupantService.getOccupantByName(name);
		System.out.println(occupant);
	}
	private static void getOccupantHistory(int occupantId) {
		OccupantHistoryRO occupantHistory = null;
		occupantHistory = OccupantService.getOccupantHistory(occupantId);
		System.out.println(occupantHistory);
	}
	
//	private static void getVaccantBed(int pgId) {
//		OccupantHistoryRO occupantHistory = null;
//		occupantHistory = OccupantService.getVaccantBed(pgId);
//		System.out.println(occupantHistory);
//	}
	
	private static void getAccountById(int accountId) {
		AccountRO account = null;
		account = OccupantService.getAccountById(accountId);
		System.out.println(account);
	}
	private static void getOccupantDues(int occupantId) {
		List<AccountRO> account = null;
		account = AccountService.getOccupantDues(occupantId);
		System.out.println(account);
	}
	
	
	private static void getOccupantAccountDetails(int occupantId) {
		AccountRO account = null;
		account = OccupantService.getOccupantAccountDetails(occupantId);
		System.out.println(account);
	}
	
	private static void getOccupantHistoryById(int occupantHistoryId) {
		OccupantHistoryRO occupantHistory = null;
		occupantHistory = OccupantService.getOccupantHistoryById(occupantHistoryId);
		System.out.println(occupantHistory);
	}
	
	private static void getAccountDetails(int pgId) {
		List<AccountRO> account = null;
		account = AccountService.getAccountDetails(pgId);
		
	}
	
	private static void createUser(int pgId ,String name, String role, String password) {
		UserRO user = new UserRO(pgId,name,role, password);
		user = PgService.createUser(user);
		System.out.println(user);
	}
	private static void createLog(String log, int pgId, String type, Date dateCreated) {
		LogRO logro = new LogRO(log,pgId,type,dateCreated);
		logro = PgService.createLog(logro);
		System.out.println(logro);
	}
	
	
	
	private static void login(String name , String password){
		UserRO userro = new UserRO();
		userro.setName(name);
		userro.setPassword(password);
		boolean user = PgService.login(userro);
		System.out.println(user);
	}
}
