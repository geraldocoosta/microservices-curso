package br.com.geraldo.bookservice.proxy;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.geraldo.bookservice.responses.Cambio;

@FeignClient(name = "cambio-service")
public interface CambioProxy {
	@GetMapping("/cambio-service/{amount}/{from}/{to}")
	public Cambio getCambio(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to);
}
