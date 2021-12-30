package br.com.geraldo.bookservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;


/**
 * 
 * @author geraldo
 *
 * Classe para testar fault-tolerance
 * mais infos: https://resilience4j.readme.io/docs/getting-started-3
 */
@RestController
@RequestMapping("/book-service")
@Log4j2
public class FooBarController {

	private static final String FOO_BAR_ERROR = "Foo-bar Error!";

	
//	@Retry(name = "default") // Tenta realizar a requisição 2 vezes, instancia default -> ver application.yml
//	@Retry(name = "foo-bar", fallbackMethod = "errorInFooBar") // aqui vamos tentar 5 vezes

//	@CircuitBreaker(name = "default", fallbackMethod = "errorInFooBar")
	// serve para, quando acontecer um erro, em vez de ficar tentando novamente 
	// infinitas vezes, o @CircuitBreaker manda direto pro fallbackMethod
	// funciona em 3 estados: 
	// 	fechado     -> onde receber todas requisições
	// 	aberto      -> onde todas requisições vão para o fallbackMethod
	//  meio-aberto -> algumas chamadas vezes, ele vai tentar rodar o metodo normal
	//				   até ir elevando sua taxa de sucesso para ir para o estado fechado
	//				   se continuar no erro, volta pro aberto

//	@RateLimiter(name = "default") // , fallbackMethod = "errorInFooBar")
	// determina quantas requisições esse endpoint pode
	// receber em um perido de tempo, ex: 10000 chamadas a cada segundo 10 segundos
	// configuravel (assim como todas features de fault-tolerance) no application.yml
	// também aceita fullbackMethod
	
//	@Bulkhead(name = "default")  // , fallbackMethod = "errorInFooBar")
	// determina quantas execuções concorrentes vou ter
	// Mais informações, ver application.yml
	
//	@TimeLimiter(name = "default") // , fallbackMethod = "errorInFooBar")
	// define um tempo para timeout, configuravel pelo application.yml
	// Só funciona se o seu método retornar um Future ou seja reativo (Flux or Mono)
	
	@GetMapping("/foo-bar")
	public String fooBar() {
		log.info("Request to foo-bar is received!");
		
		// Comentado, parte utilizada para testar Retry e CircuitBreaker
		/*
		 * var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
		 * return response.getBody();
		 */
		 
		return "Foo-Bar";
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
