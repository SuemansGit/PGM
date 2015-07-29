package com.pga.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.pga.eo.PgEO;
import com.pga.eo.UserEO;

public class UserDAO {

	public static void getAdminByPgId(EntityManager em,int pgid){
		PgEO pg=em.find(PgEO.class, pgid);
		List<UserEO> userList=pg.getUserList();
		System.out.print("size is "+userList.size());
		for(UserEO u:userList){
			System.out.println(u);
			
		}
		
		
		
		
	}
	
	
	
}
