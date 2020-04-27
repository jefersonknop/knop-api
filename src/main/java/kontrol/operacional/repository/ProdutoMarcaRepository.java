package kontrol.operacional.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import kontrol.operacional.entities.ProdutoMarca;





public interface ProdutoMarcaRepository extends JpaRepository<ProdutoMarca, Long> {

	@Query(value = "SELECT * FROM PRODUTO_MARCA T WHERE T.INQUILINO_ID =?1", nativeQuery = true)	  
	List<ProdutoMarca> findByInquilino(Long id);
	 
	 
	//List<ProdutoMarca> findByNomeStartingWith(String nome);
}

