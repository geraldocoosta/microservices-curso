package br.com.geraldo.bookservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/book-service")
@Log4j2
public class FooBarController {

	@GetMapping("/foo-bar")
//	@Retry(name = "default") // Tenta realizar a requisição 2 vezes, instancia default -> ver application.yml
	@Retry(name = "foo-bar") // aqui vamos tentar 5 vezes
	public String fooBar() {
		log.info("Request to foo-bar is received!");
		var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
		return response.getBody();
	}
	
}
