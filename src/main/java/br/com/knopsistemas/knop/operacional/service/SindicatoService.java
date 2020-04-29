package  br.com.knopsistemas.knop.operacional.service;

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
import br.com.knopsistemas.knop.operacional.entities.Sindicato;
import br.com.knopsistemas.knop.operacional.repository.SindicatoRepository;



@RestController
@RequestMapping("/sindicatos")
@CrossOrigin(origins = "*")

public class SindicatoService {
	
	@Autowired
	private SindicatoRepository sindicatoRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Sindicato sindicato){ 
 
		try { 
			this.sindicatoRepository.save(sindicato); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Sindicato sindicato){
 
		try {
 
			this.sindicatoRepository.save(sindicato);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Sindicato> sindicato = sindicatoRepository.findById(id);
		if (!sindicato.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				sindicatoRepository.delete(sindicato.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Sindicato> findById (@PathVariable Long id){
		Optional<Sindicato> sindicato = sindicatoRepository.findById(id);
		
		if (sindicato == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(sindicato.get());
					
	}
	


	@GetMapping("/inquilino/{inquilino}")
	public @ResponseBody List<Sindicato> findAll(@PathVariable Long inquilino){
		return this.sindicatoRepository.findByInquilino(inquilino);
	}
	
	
	
 

}
