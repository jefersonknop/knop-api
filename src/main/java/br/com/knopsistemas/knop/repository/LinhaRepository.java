package br.com.knopsistemas.knop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import br.com.knopsistemas.knop.entities.Linha;




public interface LinhaRepository extends JpaRepository<Linha, Long> {

	@Query(value = "SELECT * FROM LINHA l WHERE l.INQUILINO_ID =?1", nativeQuery = true)	  
	List<Linha> findByInquilino(Long id);
	 
	 
	List<Linha> findByNomeStartingWith(String nome);
}

