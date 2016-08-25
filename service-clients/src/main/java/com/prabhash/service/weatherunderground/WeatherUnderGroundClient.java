package com.prabhash.service.weatherunderground;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST client to connect to Weather Underground API
 * 
 * @author Prabhash Rathore
 *
 */
public class WeatherUnderGroundClient {
	
	private static final String API_KEY = "YOUR_API_KEY";
	
	/**
	 * Get weather details for given state and city.
	 * 
	 * @param state
	 * @param city
	 * @return String stringified response
	 */
	public String getWeatherDetails(String state, String city) {
		if(state == null || city == null) {
			throw new NullPointerException();
		}
		
		if(state.isEmpty() || city.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		
		StringBuilder path = new StringBuilder();
		path.append("/api/").append(API_KEY).
							append("/conditions/q/").append(state).append("/")
							.append(city).append(".json");
		System.out.println("Service path: " + path);
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://api.wunderground.com")
									.path(path.toString());
		
		Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
					
		if(response == null) {
			System.out.println("Service sent NULL response");
			return null;
		}
		
		if(response.getStatus() != Response.Status.OK.getStatusCode()) {
			System.out.println("Non 200 response");
		} else {
			System.out.println("200 Response");
		}
		
		String stringifiedResponse = response.readEntity(String.class);
		System.out.println("Service response: " + stringifiedResponse);
		return stringifiedResponse;
	}

	public static void main(String[] args) {
		WeatherUnderGroundClient client = new WeatherUnderGroundClient();
		client.getWeatherDetails("CA", "San_Jose");
	}
}
