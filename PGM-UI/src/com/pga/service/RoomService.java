package com.pga.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.pga.dao.RoomDAO;
import com.pga.ro.RoomRO;
import com.pga.util.Utility;

public class RoomService {
	
	public static RoomRO createRoom(RoomRO room) {
		EntityManager em = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			room = RoomDAO.createRoom(em,room);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return room;
	}
	
	public static void deleteRoom(int roomId){
		EntityManager em = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			RoomDAO.deleteRoom(em, roomId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		
	}
	
	public static RoomRO getRoomById(int roomId) {
		EntityManager em = null;
		RoomRO room = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			room = RoomDAO.getRoomById(em,roomId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return room;
	}
	
	public static List<RoomRO> getRoomsByPgId(int pgId){
		EntityManager em = null;
		List<RoomRO> rooms = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			rooms = RoomDAO.getRoomInPg(em, pgId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return rooms;
	}


}
