package br.com.cambioservice.controllers;

import java.math.BigDecimal;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cambioservice.models.Cambio;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cambio-service")
@RequiredArgsConstructor
public class CambioController {
	
	private final Environment environment;
	
	@GetMapping("/{amount}/{from}/{to}")
	public Cambio getCambio(
			@PathVariable BigDecimal amount,
			@PathVariable String from,
			@PathVariable String to) {
		return new Cambio(1l, from, to, BigDecimal.ONE,amount, environment.getProperty("local.server.port"));	
	}
}
