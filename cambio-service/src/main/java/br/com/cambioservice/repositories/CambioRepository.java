package br.com.cambioservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cambioservice.models.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

	Cambio findByFromAndTo(String from, String to);
}
