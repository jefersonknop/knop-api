package br.com.knopsistemas.knop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.knopsistemas.knop.entities.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
   
	Usuario findByEmail (String email);
}
