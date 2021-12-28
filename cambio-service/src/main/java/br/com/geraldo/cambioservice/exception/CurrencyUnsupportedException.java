package br.com.geraldo.cambioservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CurrencyUnsupportedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CurrencyUnsupportedException(String message, Throwable cause) {
		super(message, cause);
	}

	public CurrencyUnsupportedException(String message) {
		super(message);
	}

	
}
