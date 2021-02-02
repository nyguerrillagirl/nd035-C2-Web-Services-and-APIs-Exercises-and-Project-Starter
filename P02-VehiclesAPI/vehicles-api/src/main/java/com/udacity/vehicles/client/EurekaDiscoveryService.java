package com.udacity.vehicles.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

/**
 * Obtains the http://HOST:PORT for the microservice registered with Eureka Service
 * @author lafig
 *
 */
@Service
public class EurekaDiscoveryService {
	
	@Autowired
	private EurekaClient eurekaClient;

	// Cache the service URLs
	private static Map<String, String> serviceMap;
	
	static {
		serviceMap = new HashMap<String, String>();
	}
	public String obtainServiceHostAndPort(String serviceName) {
		// First check if we have seen this serviceName already
		if (serviceMap.containsKey(serviceName)) {
			// return cached URI
			return serviceMap.get(serviceName);
		}
		Application application = eurekaClient.getApplication(serviceName);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String hostname = instanceInfo.getHostName();
		int port = instanceInfo.getPort();
		String uri = "http://" + hostname + ":" + String.valueOf(port);
		serviceMap.put(serviceName, uri);
		return uri;
	}
}
