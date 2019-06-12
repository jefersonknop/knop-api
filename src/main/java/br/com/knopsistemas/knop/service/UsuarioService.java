package br.com.knopsistemas.knop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.knopsistemas.knop.entities.ResponseModel;
import br.com.knopsistemas.knop.entities.Usuario;
import br.com.knopsistemas.knop.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")

public class UsuarioService {
	
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Usuario Usuario){ 
 
		try { 
			this.UsuarioRepository.save(Usuario); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Usuario Usuario){
 
		try {
 
			this.UsuarioRepository.save(Usuario);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Usuario> Usuario = UsuarioRepository.findById(id);
		if (!Usuario.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				UsuarioRepository.delete(Usuario.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById (@PathVariable Long id){
		Optional<Usuario> Usuario = UsuarioRepository.findById(id);
		
		if (Usuario == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(Usuario.get());
					
	}
	
	
	
	
	
	

	@GetMapping
	public @ResponseBody List<Usuario> findAll(){ 
		return this.UsuarioRepository.findAll();
	}
	
	
	public Usuario findByEmail(String email){
		Usuario usuario = UsuarioRepository.findByEmail(email);
		return usuario;
					
	}
	
	
 

}
