package br.com.knopsistemas.knop.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.knopsistemas.knop.system.entities.Usuario;
import br.com.knopsistemas.knop.security.entities.CurrentUser;
import br.com.knopsistemas.knop.security.jwt.JwtAuthenticationRequest;
import br.com.knopsistemas.knop.security.jwt.JwtTokenUtil;
import br.com.knopsistemas.knop.system.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationRestController {
	
	
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping(value="/api/auth")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest){
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						authenticationRequest.getEmail(),
						authenticationRequest.getPassword()
				)
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		final String token = jwtTokenUtil.generateToken(userDetails);
		final Usuario usuario = usuarioService.findByEmail(authenticationRequest.getEmail());
		usuario.setPassword(null);
		return ResponseEntity.ok(new CurrentUser(token, usuario));
		
	}
	
	
	
	@PostMapping(value="/api/refresh")
	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request){		
		String token =request.getHeader("Authorization");	                                 
		String username =jwtTokenUtil.getUsernameFromToken(token);		
		final Usuario usuario = usuarioService.findByEmail(username);

		if (jwtTokenUtil.canTokenBeRefreshed(token)) {
			String refreshedToken = jwtTokenUtil.refreshToken(token);
			return ResponseEntity.ok(new CurrentUser(refreshedToken, usuario));
		}
		else {
			return ResponseEntity.badRequest().body(null);
		}
		
		
		
	}
	
	

}
