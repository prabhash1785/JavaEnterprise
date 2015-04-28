package com.prabhash.java.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/HiRestEasy")
public class HelloWorld {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/hello")
	public String sayHello() {
		return "Hello Rest Easy!!";
	}

}
