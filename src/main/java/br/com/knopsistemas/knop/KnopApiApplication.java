package br.com.knopsistemas.knop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.knopsistemas.knop.system.entities.Inquilino;
import br.com.knopsistemas.knop.system.entities.Usuario;
import br.com.knopsistemas.knop.system.enums.ProfileEnum;
import br.com.knopsistemas.knop.system.repository.UsuarioRepository;

@SpringBootApplication
public class KnopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnopApiApplication.class, args);
		System.out.print(new BCryptPasswordEncoder().encode("302001"));
	}
	
	@Bean
	CommandLineRunner init(UsuarioRepository usuarioRepository, PasswordEncoder passwordEnconder) {
		return args ->{
			initUsers(usuarioRepository, passwordEnconder);
		};
	}
	
	
	private void initUsers (UsuarioRepository usuarioRepository, PasswordEncoder passwordEnconder) {
		
		Inquilino inquilino;
		//*******************************************
		inquilino = new Inquilino();
		long id = 1;
		inquilino.setId(id);
		inquilino.setNome("Teste");
		
		Usuario admin = new Usuario();
		admin.setNome("Jeferson Knop");
		admin.setEmail("jefersonknop@gmail.com");
		admin.setPassword(passwordEnconder.encode("30jk2001"));
	
	
		admin.setProfile(ProfileEnum.ROLE_ADMIN);
		admin.setInquilino_id(inquilino);
		
		Usuario find = usuarioRepository.findByEmail("jefersonknop@gmail.com");
		if (find == null) {
		    usuarioRepository.save(admin);
		}
		
		
		//*******************************************		
		inquilino = new Inquilino();
	    id = 2;
		inquilino.setId(id);
		inquilino.setNome("Knop Sistemas");
		
		Usuario usuario = new Usuario();
		usuario.setNome("Jeferson Knop");
		usuario.setEmail("jeferson@knopsistemas.com.br");
		usuario.setPassword(passwordEnconder.encode("30jk2001"));
	
	
		usuario.setProfile(ProfileEnum.ROLE_ADMIN);
		usuario.setInquilino_id(inquilino);
		
		Usuario find2 = usuarioRepository.findByEmail("jeferson@knopsistemas.com.br");
		if (find2 == null) {
		    usuarioRepository.save(usuario);
		}
		
		
		
		//*******************************************	
		
		inquilino = new Inquilino();
	    id = 3;
		inquilino.setId(id);
		inquilino.setNome("Coletivo Santa Cruz");
		
		usuario = new Usuario();
		usuario.setNome("Recepção");
		usuario.setEmail("recepcao@coletivosantacruz.com.br");
		usuario.setPassword(passwordEnconder.encode("coletivo"));
	
	
		usuario.setProfile(ProfileEnum.ROLE_CUSTOMER);
		usuario.setInquilino_id(inquilino);
		
		Usuario find3 = usuarioRepository.findByEmail("recepcao@coletivosantacruz.com.br");
		if (find3 == null) {
		    usuarioRepository.save(usuario);
		}
		
		

		
		
		
	}
	
	
	

}
