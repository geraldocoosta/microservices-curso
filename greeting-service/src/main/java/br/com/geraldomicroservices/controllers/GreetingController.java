package br.com.geraldomicroservices.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.geraldomicroservices.configurations.GreetingConfiguration;
import br.com.geraldomicroservices.models.Greeting;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GreetingController {

	
	private static final String TEMPLATE = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	private final GreetingConfiguration configuration;
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
		if (name.isEmpty()) {
			name = configuration.getDefaulValue();
		}
		return new Greeting(counter.getAndIncrement(), String.format(TEMPLATE, configuration.getGreeting(), name));
	}
}
