package com.udacity.boogle.maps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestMapsController {

	
	@Autowired
	private MapsController controller;
	
	
	private Double testLat = 40.785091;
	private Double testLon = 90.34567;
	
//	@Before
//	public void setup() {
//		testUrl = "http://localhost:" + port + "/maps?lat=40.785091&lon=90.34567";
//	}
	
	@Test
	public void testSimpleQuery() {
		Address response = controller.get(testLat, testLon);
		
		assertNotNull(response);
	}

	@Test
	public void testSimpleQuery2() {
		Address response1 = controller.get(testLat, testLon);
		Address response2 = controller.get(testLat, testLon);
		
		assertNotNull(response1);
		assertNotNull(response2);
		assertTrue(response1.equals(response2));
	}
	
}
