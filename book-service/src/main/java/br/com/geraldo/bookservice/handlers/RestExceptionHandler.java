package br.com.geraldo.bookservice.handlers;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.geraldo.bookservice.exception.model.ExceptionDetails;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ExceptionDetails exceptionDetails = ExceptionDetails.builder()
				.timestamp(LocalDateTime.now())
				.status(status.value())
				.title(ex.getCause().getMessage())
				.details(ex.getMessage())
				.developerMessage(ex.getClass().getName()).build();

		return new ResponseEntity<>(exceptionDetails, headers, status);
	}
}
