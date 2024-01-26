package com.tech552.springbootactuatordemo.custom;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom")
public class CustomActuatorEndpoint {

	@ReadOperation
	public Map<String, String> customEndpoint(String id) {
		final var map = new HashMap<String, String>();
		map.put("id", id);
		return map;
	}

}
