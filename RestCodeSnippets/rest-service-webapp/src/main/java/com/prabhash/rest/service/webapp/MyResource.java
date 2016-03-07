package com.prabhash.rest.service.webapp;

import java.util.Map;
import java.util.Set;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Root resource (exposed at "myresource" path)
 * 
 * To run below end point, use this URL: http://localhost:8080/rest-service-webapp/webapi/myresource
 */
@Path("/myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hellorest")
    public String getIt() {
        return "Hello REST service!!";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/demo/{name}")
    public String getMessage(@PathParam("name") String name,
    		@QueryParam("foo") int foo,
    		@DefaultValue("10") @QueryParam("bar") int bar,
    		@HeaderParam("header") String headerParam,
    		@Context HttpHeaders httpHeaders) {
    	
    	System.out.println("Path parameter received is: " + name);
    	
    	System.out.println("Query Parameters: foo = " + foo + " <==> bar = " + bar);
    	
    	System.out.println("Header Param: " + headerParam);
    	
    	// Headers and Cookies from Context based HTTP Headers
    	MultivaluedMap<String, String> requestHeaders = httpHeaders.getRequestHeaders();
    	Map<String, Cookie> cookies = httpHeaders.getCookies();
    	
    	System.out.println("Request Headers from Context:");
    	Set<String> headerKeySet = requestHeaders.keySet();
    	for(String headerKey : headerKeySet) {
    		System.out.println(headerKey + " :: " + requestHeaders.get(headerKey));
    	}
    	
    	System.out.println("Request Cookies from Context:");
    	Set<String> cookieKeySet = cookies.keySet();
    	for(String cookieKey : cookieKeySet) {
    		System.out.println(cookieKey + " :: " + cookies.get(cookieKey));
    	}
    	
    	return "Hello " + name + "!";
    }
}
