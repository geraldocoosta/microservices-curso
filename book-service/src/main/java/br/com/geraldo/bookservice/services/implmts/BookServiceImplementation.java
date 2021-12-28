package br.com.geraldo.bookservice.services.implmts;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.geraldo.bookservice.models.Book;
import br.com.geraldo.bookservice.services.BookService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImplementation implements BookService {

	private final Environment environment;
	
	@Override
	public Book findBook(Long id, String currency) {
		var port = environment.getProperty("local.server.port");
		return new Book(id, "Geraldo", "Aprendendo microserviços", LocalDateTime.now(), BigDecimal.valueOf(22.22), currency, port);
	}

}
