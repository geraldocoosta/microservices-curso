package br.com.geraldo.bookservice.services.implmts;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.geraldo.bookservice.exception.BookNotFoundException;
import br.com.geraldo.bookservice.models.Book;
import br.com.geraldo.bookservice.proxy.CambioProxy;
import br.com.geraldo.bookservice.repositories.BookRepository;
import br.com.geraldo.bookservice.responses.Cambio;
import br.com.geraldo.bookservice.services.BookService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImplementation implements BookService {

	private final Environment environment;
	private final BookRepository repository;
	private final CambioProxy cambioProxy;
	
//	@Override
//	public Book findBook(Long id, String currency) {
//		var book = repository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
//		book.setEnvironment(environment.getProperty("local.server.port"));
//		HashMap<String, String> params = new HashMap<>();
//		params.put("amount", book.getPrice().toString());
//		params.put("from", "USD");
//		params.put("to", currency);
//		
//		var cambio  = new RestTemplate().getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}" , Cambio.class, params).getBody();
//		book.setPrice(cambio.getConvertedValue());
//		return book;
//	}
	
	@Override
	public Book findBook(Long id, String currency) {
		var book = repository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
		book.setEnvironment(environment.getProperty("local.server.port"));
		Cambio cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);
		book.setPrice(cambio.getConvertedValue());
		return book;
	}

}
