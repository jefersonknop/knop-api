package br.com.knopsistemas.knop.tributacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.knopsistemas.knop.tributacao.entities.TributIcmsCustomCab;








public interface TributIcmsCustomCabRepository extends JpaRepository<TributIcmsCustomCab, Long> {

	@Query(value = "SELECT * FROM TRIBUT_ICMS_CUSTOM_CAB T WHERE T.INQUILINO_ID =?1", nativeQuery = true)	  
	List<TributIcmsCustomCab> findByInquilino(Long id);
	 
	 
	//List<ProdutoMarca> findByNomeStartingWith(String nome);
}

