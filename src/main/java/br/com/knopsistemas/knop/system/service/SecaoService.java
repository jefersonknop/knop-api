package br.com.knopsistemas.knop.system.service;

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

import br.com.knopsistemas.knop.system.entities.Secao;
import br.com.knopsistemas.knop.system.entities.Localidade;
import br.com.knopsistemas.knop.system.entities.ResponseModel;
import br.com.knopsistemas.knop.system.repository.SecaoRepository;


@RestController
@RequestMapping("/secoes")
@CrossOrigin(origins = "*")

public class SecaoService {
	
	@Autowired
	private SecaoRepository secaoRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Secao secao){ 
 
		try { 
			this.secaoRepository.save(secao); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Secao secao){
 
		try {
 
			this.secaoRepository.save(secao);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Secao> secao = secaoRepository.findById(id);
		if (!secao.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				secaoRepository.delete(secao.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Secao> findById (@PathVariable Long id){
		Optional<Secao> secao = secaoRepository.findById(id);
		
		if (secao == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(secao.get());
					
	}
	


	
	@GetMapping("/inquilino/{inquilino}")
	public @ResponseBody List<Secao> findAll(@PathVariable Long inquilino){
		return this.secaoRepository.findByInquilino(inquilino);
	}
	
 

}
