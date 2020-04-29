package br.com.knopsistemas.knop.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.knopsistemas.knop.system.entities.Estado;


public interface EstadoRepository extends JpaRepository<Estado, Long> {

	Estado findBySigla (String sigla);
}

