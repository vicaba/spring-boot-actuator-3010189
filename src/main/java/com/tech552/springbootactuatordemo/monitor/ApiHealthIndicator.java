package com.tech552.springbootactuatordemo.monitor;

import java.util.Random;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ApiHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		if (isDBUp()) {
			return Health.up().withDetail("External Db Service", "Healthy").build();
		}
		return Health.down().withDetail("External Db Service", "Not healthy").build();
	}

	// Mimic a call to an external database
	private boolean isDBUp() {
		final var random = new Random();
		return random.nextBoolean();
	}

}
