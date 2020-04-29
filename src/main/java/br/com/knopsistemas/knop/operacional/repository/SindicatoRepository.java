package  br.com.knopsistemas.knop.operacional.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import  br.com.knopsistemas.knop.operacional.entities.Sindicato;





public interface SindicatoRepository extends JpaRepository<Sindicato, Long> {

	@Query(value = "SELECT * FROM Sindicato T WHERE T.INQUILINO_ID =?1", nativeQuery = true)	  
	List<Sindicato> findByInquilino(Long id);
	 
	 
	//List<ProdutoMarca> findByNomeStartingWith(String nome);
}

