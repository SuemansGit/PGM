package com.pga.resource;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pga.ro.PgRO;
import com.pga.service.PgService;
import com.rest.ro.AwsomeRO;

@Path("/pg")
public class PgResource {
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
		System.out.println("ayes :");
        return "Hello Awsome";
    }
	
	@GET
	@Path("/set")
	@Produces(MediaType.TEXT_PLAIN)
	public String setPg(@QueryParam("name") String name,@QueryParam("address") String address,@QueryParam("category") String category){
		System.out.println("ayes :"+name+address+category);
		PgRO pg=new PgRO(name,address,category);
		PgRO pgNew=PgService.createPG(pg);
		return "pg created successfully";
	}

    
    
    
 // http://localhost:8080/rest/pg/bed/query?id=1
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPgById(@PathParam("id") int id) {
        System.out.println("Request received to get pg with id " + id);
        PgRO pg = PgService.getPgById(id);
        return Response.ok(pg).build();
    }
}
