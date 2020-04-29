package br.com.knopsistemas.knop.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.knopsistemas.knop.system.entities.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
   
	Usuario findByEmail (String email);
}
