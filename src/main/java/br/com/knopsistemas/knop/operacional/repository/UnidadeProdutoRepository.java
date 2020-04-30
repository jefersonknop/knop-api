package  br.com.knopsistemas.knop.operacional.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import  br.com.knopsistemas.knop.operacional.entities.UnidadeProduto;





public interface UnidadeProdutoRepository extends JpaRepository<UnidadeProduto, Long> {

	@Query(value = "SELECT * FROM UNIDADE_PRODUTO T WHERE T.INQUILINO_ID =?1", nativeQuery = true)	  
	List<UnidadeProduto> findByInquilino(Long id);
	 
	 
	//List<ProdutoMarca> findByNomeStartingWith(String nome);
}

