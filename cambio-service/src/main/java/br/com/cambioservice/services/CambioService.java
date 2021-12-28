package br.com.cambioservice.services;

import java.math.BigDecimal;

import br.com.cambioservice.models.Cambio;

public interface CambioService {
	Cambio getCambio(BigDecimal amount, String from, String to);
}
