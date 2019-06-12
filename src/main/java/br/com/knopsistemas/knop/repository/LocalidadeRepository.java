package br.com.knopsistemas.knop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import br.com.knopsistemas.knop.entities.Localidade;




public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {

	@Query(value = "SELECT * FROM LOCALIDADE l WHERE l.INQUILINO_ID =?1", nativeQuery = true)	  
	List<Localidade> findByInquilino(Long id);
	 
	 
	List<Localidade> findByNomeStartingWith(String nome);
}

