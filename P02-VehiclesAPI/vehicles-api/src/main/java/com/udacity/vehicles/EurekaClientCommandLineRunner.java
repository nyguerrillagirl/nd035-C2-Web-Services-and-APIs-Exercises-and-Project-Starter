package com.udacity.vehicles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.udacity.vehicles.client.EurekaDiscoveryService;

//@Component
public class EurekaClientCommandLineRunner implements CommandLineRunner {
	private static Logger logger = LoggerFactory.getLogger(EurekaClientCommandLineRunner.class);
	
	@Autowired
	private EurekaDiscoveryService eds;
	
	@Value("${boogle-maps.service.name}")
	private String boogleMapsServiceName;
	
	@Value("${pricing.service.name}")
	private String pricingServiceName;
	
	// Check that required services are  up and running

	@Override
	public void run(String... args) throws Exception {
		logger.info("===> EurekaClientCommandLineRunner started...");
		
		logger.info("===> boogleMapsServiceName: " + boogleMapsServiceName);
		logger.info("===> pricinServiceName: " + pricingServiceName);
		
		// Now see if you can find the endpoint
		String boogleServiceHostPort = eds.obtainServiceHostAndPort(boogleMapsServiceName);
		logger.info("===> boogle-maps URI: " + boogleServiceHostPort);
		String pricingServiceHostPort = eds.obtainServiceHostAndPort(pricingServiceName);
		logger.info("===> pricingServiceHostPort URI: " + pricingServiceHostPort);
	}

	
}
