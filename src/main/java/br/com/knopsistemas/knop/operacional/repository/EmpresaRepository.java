package  br.com.knopsistemas.knop.operacional.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import  br.com.knopsistemas.knop.operacional.entities.Empresa;





public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	@Query(value = "SELECT * FROM Empresa T WHERE T.INQUILINO_ID =?1", nativeQuery = true)	  
	List<Empresa> findByInquilino(Long id);
	 
	 
	//List<ProdutoMarca> findByNomeStartingWith(String nome);
}

