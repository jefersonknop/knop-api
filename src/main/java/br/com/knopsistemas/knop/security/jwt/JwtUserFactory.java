package br.com.knopsistemas.knop.security.jwt;

import java.util.ArrayList;
import java.util.List;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.knopsistemas.knop.system.entities.Usuario;
import br.com.knopsistemas.knop.system.enums.ProfileEnum;

public class JwtUserFactory {
	
	private JwtUserFactory() {
		
	}
	
	
	public static JwtUser create (Usuario usuario) {
		return new JwtUser(
				usuario.getId(),
				usuario.getEmail(),
				usuario.getPassword(),
				mapToGrantedAuthorities(usuario.getProfile())
	    );
				
	}
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
		
	}

}
