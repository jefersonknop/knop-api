package br.com.knopsistemas.knop.tributacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.knopsistemas.knop.tributacao.entities.TributGrupoTributario;








public interface TributGrupoTributarioRepository extends JpaRepository<TributGrupoTributario, Long> {

	@Query(value = "SELECT * FROM TRIBUT_GRUPO_TRIBUTARIO T WHERE T.INQUILINO_ID =?1", nativeQuery = true)	  
	List<TributGrupoTributario> findByInquilino(Long id);
	 
	 
	//List<ProdutoMarca> findByNomeStartingWith(String nome);
}

