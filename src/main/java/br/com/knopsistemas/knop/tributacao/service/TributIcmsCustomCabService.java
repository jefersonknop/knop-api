package br.com.knopsistemas.knop.tributacao.service;

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
import br.com.knopsistemas.knop.tributacao.entities.TributIcmsCustomCab;
import br.com.knopsistemas.knop.tributacao.repository.TributIcmsCustomCabRepository;




@RestController
@RequestMapping("/tributIcmsCustomCabs")
@CrossOrigin(origins = "*")

public class TributIcmsCustomCabService {
	
	@Autowired
	private TributIcmsCustomCabRepository tributIcmsCustomCabRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody TributIcmsCustomCab tributIcmsCustomCab){ 
 
		try { 
			this.tributIcmsCustomCabRepository.save(tributIcmsCustomCab); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody TributIcmsCustomCab tributIcmsCustomCab){
 
		try {
 
			this.tributIcmsCustomCabRepository.save(tributIcmsCustomCab);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <TributIcmsCustomCab> tributIcmsCustomCab = tributIcmsCustomCabRepository.findById(id);
		if (!tributIcmsCustomCab.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				tributIcmsCustomCabRepository.delete(tributIcmsCustomCab.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<TributIcmsCustomCab> findById (@PathVariable Long id){
		Optional<TributIcmsCustomCab> tributIcmsCustomCab = tributIcmsCustomCabRepository.findById(id);
		
		if (tributIcmsCustomCab == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(tributIcmsCustomCab.get());
					
	}
	


	@GetMapping("/inquilino/{inquilino}")
	public @ResponseBody List<TributIcmsCustomCab> findAll(@PathVariable Long inquilino){
		return this.tributIcmsCustomCabRepository.findByInquilino(inquilino);
	}
	
	
	
 

}
