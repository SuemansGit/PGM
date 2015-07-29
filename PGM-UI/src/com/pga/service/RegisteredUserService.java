package com.pga.service;

import javax.persistence.EntityManager;

import com.pga.dao.BedDAO;
import com.pga.dao.RegisteredUserDAO;
import com.pga.ro.BedRO;
import com.pga.ro.RegisteredUserRO;
import com.pga.util.Utility;

public class RegisteredUserService {

	public static RegisteredUserRO createRegisteredUser(RegisteredUserRO user) {
		EntityManager em = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			user=RegisteredUserDAO.createUser(em, user);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return user;
	}
	
	public static RegisteredUserRO getUserById(int userId) {
		EntityManager em = null;
		RegisteredUserRO user = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			user=RegisteredUserDAO.getUserById(em, userId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		System.out.print(user);
		return user;
	}
}
