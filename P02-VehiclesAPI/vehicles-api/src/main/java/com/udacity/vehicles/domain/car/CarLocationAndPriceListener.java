package com.udacity.vehicles.domain.car;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.udacity.vehicles.client.maps.MapsClient;
import com.udacity.vehicles.client.prices.PriceClient;
import com.udacity.vehicles.domain.Location;

public class CarLocationAndPriceListener {
	private static final Logger logger = LoggerFactory.getLogger(CarLocationAndPriceListener.class);

	@Autowired
	private PriceClient priceClient;

	@Autowired
	private MapsClient mapsClient;

	@PostLoad
	@PostPersist
	@PostUpdate
	public void populateCarLocationAndPrice(Car car) {
		if (car.getId() == null) {
			return;
		}
		logger.debug("===> CarLocationAndPriceListener.populateCarLocationAndPrice");
		// Obtain the car price from price-service
		String carPrice = priceClient.getPrice(car.getId());
		logger.debug("===> CarLocationAndPriceListener.populateCarLocationAndPrice - car price: " + carPrice);
		car.setPrice(carPrice);

		// Obtain the car location address from boogle-maps-service
		Location location = new Location(car.getLocation().getLat(), car.getLocation().getLon());
		location = mapsClient.getAddress(location);
		logger.debug("===> CarLocationAndPriceListener.populateCarLocationAndPrice - location: " + location.toString());
		car.setLocation(location);

	}
}
