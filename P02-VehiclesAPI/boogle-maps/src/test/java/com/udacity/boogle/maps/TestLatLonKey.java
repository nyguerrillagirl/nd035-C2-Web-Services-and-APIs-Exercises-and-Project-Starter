package com.udacity.boogle.maps;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestLatLonKey {

	@Test
	@SuppressWarnings("deprecation")
	public void test1() {
		// Test if two different LatLon are the same
		LatLonKey latLonKey1 = new LatLonKey(new Double(45), new Double(-75));
		LatLonKey latLonKey2 = new LatLonKey(new Double(45), new Double(-75));
		assertTrue(latLonKey1.equals(latLonKey2));
	}

	@Test
	@SuppressWarnings("deprecation")
	public void test2() {
		// Test if two different LatLon are different
		LatLonKey latLonKey1 = new LatLonKey(new Double(45), new Double(-75));
		LatLonKey latLonKey2 = new LatLonKey(new Double(-75), new Double(45));
		assertFalse(latLonKey1.equals(latLonKey2));
	}
	
}
