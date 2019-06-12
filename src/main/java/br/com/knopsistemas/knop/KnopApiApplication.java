package br.com.knopsistemas.knop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.knopsistemas.knop.entities.Inquilino;
import br.com.knopsistemas.knop.entities.Usuario;
import br.com.knopsistemas.knop.enums.ProfileEnum;
import br.com.knopsistemas.knop.repository.UsuarioRepository;

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
		Inquilino inquilino = new Inquilino();
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
		
		
	}
	
	
	

}
