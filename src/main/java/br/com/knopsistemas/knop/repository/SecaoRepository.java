package br.com.knopsistemas.knop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import br.com.knopsistemas.knop.entities.Secao;




public interface SecaoRepository extends JpaRepository<Secao, Long> {

	@Query(value = "SELECT * FROM SECAO s WHERE s.INQUILINO_ID =?1", nativeQuery = true)	  
	List<Secao> findByInquilino(Long id);
	 
	 
	List<Secao> findByDescricaoStartingWith(String nome);
}

