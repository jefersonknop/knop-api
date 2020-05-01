package br.com.knopsistemas.knop.operacional.service;

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

import br.com.knopsistemas.knop.system.entities.ResponseModel;
import br.com.knopsistemas.knop.operacional.entities.ProdutoGrupo;
import  br.com.knopsistemas.knop.operacional.repository.ProdutoGrupoRepository;



@RestController
@RequestMapping("/produtoGrupos")
@CrossOrigin(origins = "*")

public class ProdutoGrupoService {
	
	@Autowired
	private ProdutoGrupoRepository produtoGrupoRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody ProdutoGrupo produtoGrupo){ 
 
		try { 
			this.produtoGrupoRepository.save(produtoGrupo); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody ProdutoGrupo produtoGrupo){
 
		try {
 
			this.produtoGrupoRepository.save(produtoGrupo);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <ProdutoGrupo> produtoGrupo = produtoGrupoRepository.findById(id);
		if (!produtoGrupo.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				produtoGrupoRepository.delete(produtoGrupo.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoGrupo> findById (@PathVariable Long id){
		Optional<ProdutoGrupo> produtoGrupo = produtoGrupoRepository.findById(id);
		
		if (produtoGrupo == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(produtoGrupo.get());
					
	}
	


	@GetMapping("/inquilino/{inquilino}")
	public @ResponseBody List<ProdutoGrupo> findAll(@PathVariable Long inquilino){
		return this.produtoGrupoRepository.findByInquilino(inquilino);
	}
	
	
	
 

}
