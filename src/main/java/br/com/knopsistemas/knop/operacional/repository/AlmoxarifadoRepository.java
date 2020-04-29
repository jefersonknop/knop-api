package  br.com.knopsistemas.knop.operacional.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import  br.com.knopsistemas.knop.operacional.entities.Almoxarifado;





public interface AlmoxarifadoRepository extends JpaRepository<Almoxarifado, Long> {

	@Query(value = "SELECT * FROM Almoxarifado T WHERE T.INQUILINO_ID =?1", nativeQuery = true)	  
	List<Almoxarifado> findByInquilino(Long id);
	 
	 
	//List<ProdutoMarca> findByNomeStartingWith(String nome);
}

