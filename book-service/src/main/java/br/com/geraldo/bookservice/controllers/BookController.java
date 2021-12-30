package br.com.geraldo.bookservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.geraldo.bookservice.models.Book;
import br.com.geraldo.bookservice.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Book Service Api")
@RestController
@RequestMapping("/book-service")
@RequiredArgsConstructor
public class BookController {
	
	private final BookService service;
	
	@Operation(summary = "Find a specific book by your ID, with their local currency")
	@GetMapping("/{id}/{currency}")
	public Book findBook(@PathVariable Long id, @PathVariable String currency) {
		return service.findBook(id, currency);
	}

}
