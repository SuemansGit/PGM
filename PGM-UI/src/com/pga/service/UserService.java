package com.pga.service;

import javax.persistence.EntityManager;

import com.pga.dao.RoomDAO;
import com.pga.dao.UserDAO;
import com.pga.ro.RoomRO;
import com.pga.util.Utility;

public class UserService {

	public static void getAdminByPgId(int pgid){
		EntityManager em = null;
		
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			UserDAO.getAdminByPgId(em, pgid);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		
	}
	
	
}
