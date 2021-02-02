package com.udacity.vehicles.client.maps;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.udacity.vehicles.domain.Location;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestMapsWebClient {

	@LocalServerPort
	private int port;
	
	@Autowired
	private MapsClient mapsClient;
	
	@Value("${run.integration.tests}")
	private String doIT;
	
	@Test
	public void test() {
		if (doIT != null && doIT.equals("true")) {
			Location location = new Location(87d, -45d);
			location = mapsClient.getAddress(location);
			System.out.println("location: " + location.toString());
			assertNotNull(location.getAddress());	
		} else {
			System.out.println("Did not run the test TestMapsWebClient.test()");
		}
	}

}
