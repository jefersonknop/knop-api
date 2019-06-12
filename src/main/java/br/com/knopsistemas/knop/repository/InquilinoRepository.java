package br.com.knopsistemas.knop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.knopsistemas.knop.entities.Inquilino;




public interface InquilinoRepository extends JpaRepository<Inquilino, Long> {

	
}

