package com.pga.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.pga.ro.OccupantRO;
import com.pga.service.OccupantService;
import com.pga.util.Utility;

@Path("/occupant")
public class OccupantResource {

	@GET
	@Produces("text/plain")
	@Path("/set")
	public String setOccupant(@QueryParam("occupantBedId") int bedId, @QueryParam("occupantPgId") int pgId,@QueryParam("occupantName") String name,@QueryParam("occupantMobile") long mobile,@QueryParam("occupantEmail") String email,
			@QueryParam("occupantCompany") String company, @QueryParam("occupantCollege") String college, @QueryParam("occupantIdCard") String idCard,@QueryParam("occupantIdNo") long idNo,@QueryParam("image") String image,
			@QueryParam("occupantAddress") String address, @QueryParam("occupantCity") String city){
		
		byte[] img=Utility.getImage(image);
		OccupantRO occupant=new OccupantRO(bedId,pgId,name,mobile,company,college, idCard,img,address, city,email);
		System.out.print(occupant);
		OccupantService.createOccupant(occupant);
		
		System.out.print("ayesha in occupant");
		return("occupant created successfully");
	}
	
	@GET
	@Produces("application/json")
	@Path("/get/pgId")
	public List<OccupantRO> getOccupants(){
	List<OccupantRO> occupants=OccupantService.getOccupantsOfPg(1);
	return occupants;
	}
	
	
}
