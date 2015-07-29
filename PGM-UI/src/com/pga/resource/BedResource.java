package com.pga.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//TODO pgId id need not be present

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.pga.ro.BedRO;
import com.pga.service.BedService;
@Path("/bed")
public class BedResource {
	@GET
	@Produces("text/plain")
	@Path("/set")
	public String setBed(@QueryParam("roomId") int roomId,@QueryParam("pgId") int pgId,@QueryParam("dateCreated") String dateCreated, @QueryParam("dateDeleted") String dateDeleted)
	{	
		Date date=new Date();
		BedRO bed=new BedRO(roomId,pgId,date, date);
		BedRO newBed=BedService.createBed(bed);
	return "Bed created Successfully";
	}
	
	@GET
	@Produces("application/json")
	@Path("/get")
	public List<BedRO> getAllBeds()
	{	
		System.out.println("in  bed");
		List<BedRO> bedList=BedService.getAllBeds();
		for(BedRO bed:bedList)
			System.out.println(bed);
		return bedList;
	}
	
	@GET
	@Produces("application/json")
	@Path("/getVacantBed")
	public List<BedRO> getVacantBeds(@QueryParam("pgId") int pgId)
	{	
		System.out.println("in vacant bed");
		List<BedRO> bedList=BedService.getVaccantBed(1); 
		for(BedRO bed:bedList)
			System.out.println(bed);
		return bedList;
	}
	
}
