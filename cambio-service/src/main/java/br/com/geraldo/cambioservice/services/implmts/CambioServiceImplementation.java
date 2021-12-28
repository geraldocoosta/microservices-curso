package br.com.geraldo.cambioservice.services.implmts;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.geraldo.cambioservice.exception.CurrencyUnsupportedException;
import br.com.geraldo.cambioservice.models.Cambio;
import br.com.geraldo.cambioservice.repositories.CambioRepository;
import br.com.geraldo.cambioservice.services.CambioService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CambioServiceImplementation implements CambioService {

	private final CambioRepository repository;
	private final Environment environment;

	@Override
	public Cambio getCambio(BigDecimal amount, String from, String to) {
		var cambio = repository.findByFromAndTo(from, to);
		if (cambio == null) {
			throw new CurrencyUnsupportedException("Currency Unsupported");
		}
		var port = environment.getProperty("local.server.port");
		cambio.setEnvironment(port);
		BigDecimal conversionFactor = cambio.getConversionFactor();
		BigDecimal convertedValue = conversionFactor.multiply(amount);
		cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
		return cambio;
	}

	
	
}
