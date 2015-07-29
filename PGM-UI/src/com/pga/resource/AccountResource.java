package com.pga.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.pga.ro.AccountRO;
import com.pga.ro.BedRO;
import com.pga.service.AccountService;
import com.pga.service.BedService;

@Path("/account")
public class AccountResource {
	

	@GET
    @Path("/account/{pgId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccount(@PathParam("pgId") int pgId) {
        System.out.println("Request received to get bed with id " + pgId);
        List<AccountRO> account = AccountService.getAccountDetails(pgId);
        return Response.ok(account).build();
    }
	
	@GET
	@Produces("application/json")
	@Path("/getAccounts")
	public List<AccountRO> getAccountsByPgId(@QueryParam("pgId") int pgId)
	{	
		System.out.println("Request received to get account with id " + pgId);
        List<AccountRO> account = AccountService.getAccountDetails(pgId);
		for(AccountRO ac:account)
			System.out.println(ac);
		return account;
	}
	
	@GET
    @Path("/occupant/{occupantId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOccupantDues(@PathParam("occupantId") int occupantId) {
        System.out.println("Request received to get bed with id " + occupantId);
        List<AccountRO> account = AccountService.getAccountDetails(occupantId);
        return Response.ok(account).build();
    }
	
}
