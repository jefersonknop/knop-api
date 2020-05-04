package  br.com.knopsistemas.knop.operacional.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import  br.com.knopsistemas.knop.operacional.entities. Produto;





public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query(value = "SELECT * FROM  Produto T WHERE T.INQUILINO_ID =?1", nativeQuery = true)	  
	List< Produto> findByInquilino(Long id);
	 
	 
	//List<ProdutoMarca> findByNomeStartingWith(String nome);
}

