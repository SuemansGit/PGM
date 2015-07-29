package com.pga.dao;

import javax.persistence.EntityManager;

import com.pga.eo.RegisteredUserEO;
import com.pga.ro.RegisteredUserRO;

public class RegisteredUserDAO {
	public static RegisteredUserRO createUser(EntityManager em, RegisteredUserRO user) {
		RegisteredUserEO usereo = user.getEntityObject();
		em.persist(usereo);
		usereo.setUserId(user.getUserId());
		return user;
		
	}

	public static void deleteUser(EntityManager em, int userId) {
		RegisteredUserEO usereo = em.find(RegisteredUserEO.class, userId);
		em.remove(usereo);
	}

	public static RegisteredUserRO getUserById(EntityManager em, int userId) {
		RegisteredUserEO usereo = em.find(RegisteredUserEO.class, userId);
		RegisteredUserRO user = null;
		if(usereo!= null){
			user = new RegisteredUserRO(usereo);
		}
		return user;
	}
	
}
