package br.com.geraldo.bookservice.services;

import br.com.geraldo.bookservice.models.Book;

public interface BookService {

	Book findBook(Long id, String currency);

}
