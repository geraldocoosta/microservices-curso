package br.com.geraldo.bookservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.geraldo.bookservice.models.Book;
import br.com.geraldo.bookservice.services.BookService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/book-service")
@RestController
@RequiredArgsConstructor
public class BookController {
	
	private final BookService service;
	
	@GetMapping("/{id}/{currency}")
	public Book findBook(@PathVariable Long id, @PathVariable String currency) {
		return service.findBook(id, currency);
	}

}
