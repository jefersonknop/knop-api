package kontrol.operacional.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import kontrol.operacional.entities.Contador;





public interface ContadorRepository extends JpaRepository<Contador, Long> {

	@Query(value = "SELECT * FROM CONTADOR T WHERE T.INQUILINO_ID =?1", nativeQuery = true)	  
	List<Contador> findByInquilino(Long id);
	 
	 
	//List<ProdutoMarca> findByNomeStartingWith(String nome);
}

