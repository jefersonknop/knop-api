package br.com.knopsistemas.knop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import br.com.knopsistemas.knop.entities.Cidade;
import br.com.knopsistemas.knop.entities.Estado;
import br.com.knopsistemas.knop.entities.Secao;


public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	
	@Query(value = "SELECT * FROM CIDADE c WHERE c.ESTADO_ID =?1", nativeQuery = true)	  
	List<Cidade> findByEstado_id (Long estado_id);
	
	
	@Query(value = "SELECT c.* FROM CIDADE c JOIN ESTADO e ON c.ESTADO_ID = e.ID WHERE e.NOME =?1", nativeQuery = true)	  
	List<Cidade> findByEstado (String nome);
	
	
	@Query(value = "SELECT c.* FROM CIDADE c JOIN ESTADO e ON c.ESTADO_ID = e.ID WHERE e.SIGLA =?1", nativeQuery = true)	  
	List<Cidade> findBySiglaEstado (String sigla);
}



