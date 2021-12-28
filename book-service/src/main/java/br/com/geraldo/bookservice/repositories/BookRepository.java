package br.com.geraldo.bookservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geraldo.bookservice.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
