package com.pga.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

//import com.pga.eo.OccupantBedEO;
import com.pga.eo.OccupantEO;
import com.pga.ro.OccupantBedRO;
import com.pga.ro.OccupantRO;

public class OccupantBedDAO {

	/*public static OccupantBedRO createOccupantBed(EntityManager em,OccupantBedRO occupantBed) {
		OccupantBedEO occupantBedeo = occupantBed.getEntityObject();
		em.persist(occupantBedeo);
		occupantBedeo.setOccupantBedId(occupantBedeo.getOccupantBedId());
		return occupantBed;
	}
	
	public static void getOccupantById(EntityManager em, int id) {
		TypedQuery<OccupantBedEO> query = em.createNamedQuery("GET_OCCUPANT_DETAIL", OccupantBedEO.class);
		query.setParameter("id", id);
		List<OccupantBedEO> results = query.getResultList();
		for (OccupantBedEO occupantBed : results) {
			System.out.println(occupantBed);
		}
	}
	public static OccupantBedRO getOccupantBedById(EntityManager em, int occupantBedId) {
		OccupantBedEO occupantBedeo = em.find(OccupantBedEO.class, occupantBedId);
		 OccupantBedRO occupantBed = null;
		 if(occupantBedeo!=null){
			 occupantBed = new OccupantBedRO(occupantBedeo);
		 }
		return occupantBed;
	}*/


}
