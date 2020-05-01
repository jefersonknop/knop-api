package  br.com.knopsistemas.knop.operacional.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import  br.com.knopsistemas.knop.operacional.entities.ProdutoSubGrupo;





public interface ProdutoSubGrupoRepository extends JpaRepository<ProdutoSubGrupo, Long> {

	@Query(value = "SELECT * FROM Produto_Sub_Grupo T WHERE T.INQUILINO_ID =?1", nativeQuery = true)	  
	List<ProdutoSubGrupo> findByInquilino(Long id);
	 
	 
	//List<ProdutoMarca> findByNomeStartingWith(String nome);
}

