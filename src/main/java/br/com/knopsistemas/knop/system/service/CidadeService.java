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

import br.com.knopsistemas.knop.system.entities.Cidade;
import br.com.knopsistemas.knop.system.entities.Linha;
import br.com.knopsistemas.knop.system.entities.ResponseModel;
import br.com.knopsistemas.knop.system.repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
@CrossOrigin(origins = "*")

public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Cidade cidade){ 
 
		try { 
			this.cidadeRepository.save(cidade); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Cidade cidade){
 
		try {
 
			this.cidadeRepository.save(cidade);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Cidade> cidade = cidadeRepository.findById(id);
		if (!cidade.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				cidadeRepository.delete(cidade.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> findById (@PathVariable Long id){
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		
		if (cidade == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(cidade.get());
					
	}
	

	@GetMapping
	public @ResponseBody List<Cidade> findAll(){ 
		return this.cidadeRepository.findAll();
	}
	
	
	
	@GetMapping("/estado/{estado_id}")
	public @ResponseBody List<Cidade> findByEstado_id(@PathVariable Long estado_id){
		return this.cidadeRepository.findByEstado_id(estado_id);
	}
	
	@GetMapping("/estado/nome/{nome}")
	public @ResponseBody List<Cidade> findByEstado(@PathVariable String nome){
		return this.cidadeRepository.findByEstado(nome);
	}
	
	
	@GetMapping("/estado/sigla/{sigla}")
	public @ResponseBody List<Cidade> findBySiglaEstado(@PathVariable String sigla){
		return this.cidadeRepository.findBySiglaEstado(sigla);
	}

	
	
	
	
 

}
