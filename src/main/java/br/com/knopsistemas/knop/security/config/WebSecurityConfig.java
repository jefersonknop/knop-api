package br.com.knopsistemas.knop.security.config;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.knopsistemas.knop.security.jwt.JwtAuthenticationEntryPoint;
import br.com.knopsistemas.knop.security.jwt.JwtAuthenticationTokenFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {


		@Autowired
		private UserDetailsService userDetailsService;
		
		@Autowired
		private JwtAuthenticationEntryPoint unauthorizedHandler;
	
		@Autowired
	    protected void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder)
	      throws Exception {
	       /* auth
	          .inMemoryAuthentication()
	          .withUser("jk")
	            .password("{noop}302001")
	            .roles("USER")
	            .and()
	          .withUser("knop")
	            .password("{noop}30jk2001")
	            .roles("USER", "ADMIN");
	            **/
	    	
			authenticationManagerBuilder.userDetailsService(this.userDetailsService)
	    	.passwordEncoder(passwordEncoder());
	    	
	    }
		
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
		
		 @Bean
		    @Override
		    protected AuthenticationManager authenticationManager() throws Exception {
		        return super.authenticationManager();
		    }

	
		
		
		
		@Bean
		public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception{
			return new JwtAuthenticationTokenFilter();
		}
		
		
		 @Override
		 protected void configure(HttpSecurity httpSecurity) throws Exception {
			 httpSecurity.csrf().disable()
			 	.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			 	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			 	.authorizeRequests()
			 	.antMatchers(			 			
			 			HttpMethod.GET,
			 			"/",			 			
			 			"/*.html",
			 			"/favicon.ico",
			 			"/**/*.css",
			 			"/**/*.js"
			 	).permitAll()
			 	.antMatchers("/api/auth/**").permitAll()
			 	.antMatchers("/cidades/**").permitAll()
			 	.antMatchers("/estados/**").permitAll()
			 	.antMatchers("/linhas/**").permitAll()
			 	.antMatchers("/localidades/**").permitAll()
			 	.antMatchers("/secoes/**").permitAll()
			 	.antMatchers("/inquilinos/**").permitAll()
			 	.antMatchers("/email/**").permitAll()		
			 	//operacional
			 	.antMatchers("/almoxarifados/**").permitAll()	 
			 	.antMatchers("/contadores/**").permitAll()	
			 	.antMatchers("/empresas/**").permitAll()	
			 	.antMatchers("/produtoGrupos/**").permitAll()	
			 	.antMatchers("/produtoMarcas/**").permitAll()	
			 	.antMatchers("/produtos/**").permitAll()	
			 	.antMatchers("/produtoSubGrupos/**").permitAll()	
			 	.antMatchers("/sindicatos/**").permitAll()	
			 	.antMatchers("/unidadeProdutos/**").permitAll()		
			 	//administrativo
			 	.antMatchers("/admModulos/**").permitAll()		
			 	//base
			 	.antMatchers("/fpas/**").permitAll()		
			 	//tributacao
			 	.antMatchers("/tributGrupoTributarios/**").permitAll()		
			 	.antMatchers("/tributIcmsCustomCabs/**").permitAll()		
			 	
			 	
			 	.anyRequest().authenticated();
			httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
			httpSecurity.headers().cacheControl();
			
			 	
			 			
		         
		  }
		
		//teste de atualizaçao
	 
	
	}