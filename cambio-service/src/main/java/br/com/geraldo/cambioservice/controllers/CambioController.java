package br.com.geraldo.cambioservice.controllers;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.geraldo.cambioservice.models.Cambio;
import br.com.geraldo.cambioservice.services.CambioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Cambio Service Api")
@RestController
@RequestMapping("/cambio-service")
@RequiredArgsConstructor
public class CambioController {
	
	private final CambioService cambioService;
	
	@Operation(summary = "Find the value of a currency in another country")
	@GetMapping("/{amount}/{from}/{to}")
	public Cambio getCambio(
			@PathVariable BigDecimal amount,
			@PathVariable String from,
			@PathVariable String to) {
		
		return cambioService.getCambio(amount, from, to);
	}

}
