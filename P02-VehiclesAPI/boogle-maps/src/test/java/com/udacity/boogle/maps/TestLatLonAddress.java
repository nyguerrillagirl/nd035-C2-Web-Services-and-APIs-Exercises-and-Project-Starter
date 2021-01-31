package com.udacity.boogle.maps;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLatLonAddress {

	@Test
	public void test1() {
		// Obtain a (lat,lon) Address twice -> they should be the same
		Double lat = 45.8;
		Double lon = 100.9;
		
		Address address1 = MockAddressRepository.getRandom(lat, lon);
		Address address2 = MockAddressRepository.getRandom(lat, lon);
		
		assertTrue(address1.equals(address2));
	}

	@Test
	public void test2() {
		// Obtain a (lat,lon) Address twice -> they should be the different
		Double lat1 = 45.8;
		Double lon1 = 100.9;
		Double lat2 = 45.1;
		Double lon2 = -100.9;
		
		Address address1 = MockAddressRepository.getRandom(lat1, lon1);
		Address address2 = MockAddressRepository.getRandom(lat2, lon2);
		
		assertFalse(address1.equals(address2));
	}
	
}
