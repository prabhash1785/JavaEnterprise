package com.prabhash.rest.service.webapp;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MyResourceTest {
	
	private WebTarget webTarget;
	private static final String URI = "http://localhost:8080/rest-service-webapp/webapi";
	
	@Before
	public void setUp() {
		
		Client client = ClientBuilder.newClient();
		webTarget = client.target(URI);
	}
	
	@Test
	public void testGetIt() {
		
		String response = webTarget.path("myresource").request().get(String.class);
		
		assertEquals("Hello REST service!!", response, "Service response does not match");
	}

}
