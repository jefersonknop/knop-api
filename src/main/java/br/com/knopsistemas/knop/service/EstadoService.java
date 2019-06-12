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

import br.com.knopsistemas.knop.entities.Estado;
import br.com.knopsistemas.knop.entities.ResponseModel;
import br.com.knopsistemas.knop.repository.EstadoRepository;

@RestController
@RequestMapping("/estados")
@CrossOrigin(origins = "*")

public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Estado estado){ 
 
		try { 
			this.estadoRepository.save(estado); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Estado estado){
 
		try {
 
			this.estadoRepository.save(estado);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Estado> estado = estadoRepository.findById(id);
		if (!estado.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				estadoRepository.delete(estado.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	
	/**
	 * BUSCAR UM REGISTRO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
/*	@GetMapping("/{id}")	
	public @ResponseBody Estado findById(@PathVariable("id") Long id){ 
		Optional <Estado> estado = estadoRepository.findById(id);
		if (!estado.isPresent()) {				
			return estado.get();					
		
		}
		else { 		
			return null;
		}
	}
	**/
	
	@GetMapping("/{id}")
	public ResponseEntity<Estado> findById (@PathVariable Long id){
		Optional<Estado> estado = estadoRepository.findById(id);
		
		if (estado == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(estado.get());
					
	}
	

	@GetMapping
	public @ResponseBody List<Estado> findAll(){ 
		return this.estadoRepository.findAll();
	}
	
	
	
 

}
