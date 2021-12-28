package br.com.geraldo.cambioservice.services;

import java.math.BigDecimal;

import br.com.geraldo.cambioservice.models.Cambio;

public interface CambioService {
	Cambio getCambio(BigDecimal amount, String from, String to);
}
