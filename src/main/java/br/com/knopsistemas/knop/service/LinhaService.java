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
import br.com.knopsistemas.knop.entities.ResponseModel;
import br.com.knopsistemas.knop.repository.LinhaRepository;


@RestController
@RequestMapping("/linhas")
@CrossOrigin(origins = "*")

public class LinhaService {
	
	@Autowired
	private LinhaRepository linhaRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Linha linha){ 
 
		try { 
			this.linhaRepository.save(linha); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage()+ " - - - - "+ linha.getInquilino_id());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Linha linha){
 
		try {
 
			this.linhaRepository.save(linha);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Linha> linha = linhaRepository.findById(id);
		if (!linha.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				linhaRepository.delete(linha.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Linha> findById (@PathVariable Long id){
		Optional<Linha> linha = linhaRepository.findById(id);
		
		if (linha == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(linha.get());
					
	}


	@GetMapping("/inquilino/{inquilino}")
	public @ResponseBody List<Linha> findAll(@PathVariable Long inquilino){
		return this.linhaRepository.findByInquilino(inquilino);
		//return this.linhaRepository.findAll();
	}
	
	
	
 

}
