package br.com.knopsistemas.knop.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import br.com.knopsistemas.knop.security.jwt.JwtUserFactory;
import br.com.knopsistemas.knop.system.entities.Usuario;
import br.com.knopsistemas.knop.system.service.UsuarioService;


@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UsuarioService usuarioService;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.findByEmail(email);
		if (usuario == null) {
			throw new UsernameNotFoundException(String.format("Não foi encontrado nenhum usuário identificado por '%s", email));
		}else {
			return JwtUserFactory.create(usuario);
		}
		
		
	}
	

}
