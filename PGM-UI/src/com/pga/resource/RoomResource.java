package com.pga.resource;

import java.util.Date;
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
import com.pga.ro.RoomRO;
import com.pga.service.PgService;
import com.pga.service.RoomService;
//TODO handle date object
@Path("/room")
public class RoomResource {

	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {

        return "Hello Awsome";
    }
	
	@GET
	@Path("/set")
	@Produces(MediaType.TEXT_PLAIN)
	public String setRoom(@QueryParam("roomName") String name,@QueryParam("roomPgId") int pgId){
		Date date=new Date();
		RoomRO room=new RoomRO(pgId,name,date,null);
		RoomRO roomNew=RoomService.createRoom(room);
		return "room "+" created successfully";
	}
	
	@GET
	@Path("/get/pgId")
	@Produces("application/json")
	public List<RoomRO> getRoomsInPg(@QueryParam("pgId") int pgId){
		System.out.println("in room");
		List<RoomRO> rooms=RoomService.getRoomsByPgId(1);
		return rooms;
	}
	
	@GET
	@Path("delete/roomId")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteRoom(@QueryParam("roomId") int roomId){
		RoomService.deleteRoom(roomId);
		return "room deleted successfully";
	}

    
    
    
 // http://localhost:8080/rest/pg/bed/query?id=1
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoomById(@PathParam("id") int roomId) {
        System.out.println("Request received to get room with id " + roomId);
        RoomRO room=RoomService.getRoomById(roomId);       
        return Response.ok(room).build();
    }
}
