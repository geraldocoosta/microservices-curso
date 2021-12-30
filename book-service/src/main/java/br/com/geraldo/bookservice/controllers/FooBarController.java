package br.com.geraldo.bookservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-service")
public class FooBarController {

	@GetMapping("/foo-bar")
	public String fooBar() {
		return "FooBar!!!";
	}
	
}
