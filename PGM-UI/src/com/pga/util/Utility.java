package com.pga.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {

	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("pgajpa");
//		System.out.println("factory" +factory);
		EntityManager em = factory.createEntityManager();
//		System.out.println("entity object" +em);
		return em;
	}
	
	public static byte[] getImage(String filename){
		File file=new File("WebContent/image/"+filename);
		byte[] data = new byte[(int) file.length()];
		 ByteArrayOutputStream bos = new ByteArrayOutputStream();
		 
	        try {
	        	FileInputStream fis = new FileInputStream(file);
				for (int readNum; (readNum = fis.read(data)) != -1;) {
	                //Writes to this byte array output stream
	                bos.write(data, 0, readNum); 
	                System.out.println("read " + readNum + " bytes,");
	            }
	        } catch (Exception ex) {
	            //Logger.getLogger(ConvertImage.class.getName()).log(Level.SEVERE, null, ex);
	        }
	 
	        byte[] bytes = bos.toByteArray();
		 System.out.println(data.length);
		 
		 return bytes;
		
		
		
	}
	public static boolean isNull(String s) {
		if(s == null || s.equals("")) {
			return true;
		}
		return false;
	}
	
	public static Timestamp getTimestampForDeltaDays(int daysAfter) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.DAY_OF_MONTH, daysAfter);
		Timestamp date = new Timestamp(calendar.getTimeInMillis());
		return date;
	}
	public static Date getBackDate(int month, int day) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1 * month);
		Date d = c.getTime();
		d.setDate(day);
		return d;
	}
	public static Date getFirstDayOfMonth(int startMonth, int startYear) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, startYear);
		cal.set(Calendar.MONTH,startMonth);
		cal.set(Calendar.DAY_OF_MONTH,01);
		Date date = cal.getTime();
		System.out.println("ayesha"+date);
		return date;
	}
	
	public static Date getLastDayOfMonth(int endMonth, int endYear) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, endYear);
		cal.set(Calendar.MONTH,endMonth);
		setDayOfMonth(cal,endMonth);
		Date date = cal.getTime();
		System.out.println("ayesha"+date);
		return date;
	}
	
	public static Calendar setDayOfMonth(Calendar cal,int month) {
		if(month==0 || month==2 || month==4 || month==6 || month==8 || month==10 || month==12)
		cal.set(Calendar.DAY_OF_MONTH, 31);
		
		else cal.set(Calendar.DAY_OF_MONTH, 30);
		
		return cal;
	}
	
	
//	int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);


}
