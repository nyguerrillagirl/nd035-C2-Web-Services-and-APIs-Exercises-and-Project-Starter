package com.udacity.vehicles.client.prices;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestPriceClient {

	@LocalServerPort
	private int port;
	
	@Autowired
	private PriceClient priceClient;
	
	@Value("${run.integration.tests}")
	private String doIT;
	
	@Test
	public void test() {
		if (doIT != null && doIT.equals("true")) {
			String price = priceClient.getPrice(1L);
			System.out.println("price: " + price);
			assertNotNull(price);	
		} else {
			System.out.println("Did not run the test TestMapsWebClient.test()");
		}
	}
}
