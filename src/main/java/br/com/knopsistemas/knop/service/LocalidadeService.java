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

import br.com.knopsistemas.knop.entities.Linha;
import br.com.knopsistemas.knop.entities.Localidade;
import br.com.knopsistemas.knop.entities.ResponseModel;
import br.com.knopsistemas.knop.repository.LocalidadeRepository;


@RestController
@RequestMapping("/localidades")
@CrossOrigin(origins = "*")

public class LocalidadeService {
	
	@Autowired
	private LocalidadeRepository localidadeRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Localidade localidade){ 
 
		try { 
			this.localidadeRepository.save(localidade); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Localidade localidade){
 
		try {
 
			this.localidadeRepository.save(localidade);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Localidade> localidade = localidadeRepository.findById(id);
		if (!localidade.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				localidadeRepository.delete(localidade.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Localidade> findById (@PathVariable Long id){
		Optional<Localidade> localidade = localidadeRepository.findById(id);
		
		if (localidade == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(localidade.get());
					
	}
	


	@GetMapping("/inquilino/{inquilino}")
	public @ResponseBody List<Localidade> findAll(@PathVariable Long inquilino){
		return this.localidadeRepository.findByInquilino(inquilino);
	}
	
	
	
 

}
