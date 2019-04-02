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

import br.com.knopsistemas.knop.model.Inquilino;
import br.com.knopsistemas.knop.model.ResponseModel;
import br.com.knopsistemas.knop.repository.InquilinoRepository;

@RestController
@RequestMapping("/inquilinos")
@CrossOrigin(origins = "*")

public class InquilinoService {
	
	@Autowired
	private InquilinoRepository inquilinoRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Inquilino inquilino){ 
 
		try { 
			this.inquilinoRepository.save(inquilino); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Inquilino inquilino){
 
		try {
 
			this.inquilinoRepository.save(inquilino);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Inquilino> inquilino = inquilinoRepository.findById(id);
		if (!inquilino.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				inquilinoRepository.delete(inquilino.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Inquilino> findById (@PathVariable Long id){
		Optional<Inquilino> inquilino = inquilinoRepository.findById(id);
		
		if (inquilino == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(inquilino.get());
					
	}
	

	@GetMapping
	public @ResponseBody List<Inquilino> findAll(){ 
		return this.inquilinoRepository.findAll();
	}
	
	
	
 

}
