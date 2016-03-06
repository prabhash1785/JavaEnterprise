package com.prabhash.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * A simple Jersey based REST client to get response from a Real RESTful service.
 * 
 * This client connects to WUnderGround API to get weather data about San Francisco city.
 * 
 * @author prrathore
 *
 */
public class WeatherUndergroundAPIClient {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		WebTarget webTarget = client.target("http://api.wunderground.com/api").path("<your_api_key>/conditions/q/CA/San_Francisco.json");
		
		String response = webTarget.request(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println(response);
		
	}

}
