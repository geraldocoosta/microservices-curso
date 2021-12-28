package br.com.geraldo.bookservice.services.implmts;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.geraldo.bookservice.exception.BookNotFoundException;
import br.com.geraldo.bookservice.models.Book;
import br.com.geraldo.bookservice.repositories.BookRepository;
import br.com.geraldo.bookservice.services.BookService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImplementation implements BookService {

	private final Environment environment;
	private final BookRepository repository;
	
	@Override
	public Book findBook(Long id, String currency) {
		var book = repository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
		book.setEnvironment(environment.getProperty("local.server.port"));
		return book;
	}

}
