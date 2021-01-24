package com.udacity.pricing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import com.udacity.pricing.service.PricingService;

@Component
public class PriceCommandLineRunner implements CommandLineRunner {
	private static Logger logger = LoggerFactory.getLogger(PriceCommandLineRunner.class);
	
	private static final int MAX_VECHICLES = 20;
	private static final String APP_CURRENCY = "USD";
	
	@Autowired
	private PriceRepository priceRepository;
		
	@Override
	public void run(String... args) throws Exception {
		// Generate random prices for vehicles 1-20
		logger.debug("===> PriceCommandLineRunner invoked.");
		for (int i=1; i<MAX_VECHICLES; i++) {
			Price price = PricingService.getPrice((long)i);
			logger.debug("Saving the Price item: " + price.toString());
			priceRepository.save(price);
		}
	}

}
