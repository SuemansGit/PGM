package com.pga.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import com.pga.eo.OccupantHistoryEO;
import com.pga.eo.RoomEO;
import com.pga.ro.BedRO;
import com.pga.ro.RoomRO;
import com.pga.ro.UserRO;
import com.pga.util.Utility;

public class RoomDAO {

	public static RoomRO createRoom(EntityManager em, RoomRO room) {
		RoomEO roomeo = room.getEntityObject();
		em.persist(roomeo);
		room.setRoomId(roomeo.getRoomId());
		return room;
	}

	public static void deleteRoom(EntityManager em, int roomId) {
		RoomEO roomeo = em.find(RoomEO.class, roomId);
		em.refresh(roomeo);
		em.remove(roomeo);
		//System.out.print("here"+roomeo);
	}

	public static RoomRO getRoomById(EntityManager em, int roomId) {
		RoomEO roomeo = em.find(RoomEO.class, roomId);
		RoomRO room = null;
		if(roomeo!= null){
			room = new RoomRO(roomeo);
		}
		return room;
	}

	public static List<RoomRO> getRoomInPg(EntityManager em ,int pgId) {
		RoomRO room = null;		
		TypedQuery<RoomEO> query = em.createNamedQuery("FIND_ROOM_IN_PG",
				RoomEO.class);
		query.setParameter("pgId", pgId);
		List<RoomEO> results = query.getResultList();
		List<RoomRO> output = new ArrayList<RoomRO>();
		if (results != null && results.size() > 0) {
			for(RoomEO eo : results){
			room = new RoomRO(eo);
			output.add(room);
			}
		}
		return output;
	}
	
	
		public static List<RoomEO> getRecentRoom(EntityManager em,
				int daysAfter) {
			TypedQuery<RoomEO> query = em.createNamedQuery(
					"FIND_RECENT_ROOM", RoomEO.class);
			Timestamp date = Utility.getTimestampForDeltaDays(-1 * daysAfter);
			query.setParameter("date_Created", date, TemporalType.TIMESTAMP);
			List<RoomEO> results = query.getResultList();
			if (results != null) {
				for (RoomEO room : results) {
					System.out.println(room);
				}
			}
			return results;
		}

}
