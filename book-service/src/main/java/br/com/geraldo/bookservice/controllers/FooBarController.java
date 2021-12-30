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

	private static final String FOO_BAR_ERROR = "Foo-bar Error!";

	@GetMapping("/foo-bar")
//	@Retry(name = "default") // Tenta realizar a requisição 2 vezes, instancia default -> ver application.yml
	@Retry(name = "foo-bar", fallbackMethod = "errorInFooBar") // aqui vamos tentar 5 vezes
	public String fooBar() {
		log.info("Request to foo-bar is received!");
		var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
		return response.getBody();
	}
	
	// Método com o mesmo nome do fallbackMethod em cima mencionado (na annotation @Retry)
	// ao acontecer um erro, retorna o método com mesmo nome do mencionado no valor de fallbackMethod
	// Preciso tomar uma Exception, e posso sobrecarregar com outras Exceptions especificas
	// Também preciso receber os mesmos atributos que meu controller que tomou a exception
	// A exception deve ser o ultimo argumento
	public String errorInFooBar(Exception ex) {
		log.info("Exception recebida: {}", ex.getMessage());
		return FOO_BAR_ERROR;
	}
	
}
