package br.com.knopsistemas.knop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.knopsistemas.knop.entities.Cidade;


public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	//Estado findBySigla (String sigla);
}

