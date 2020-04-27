package kontrol.operacional.service;

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
import kontrol.operacional.entities.Contador;
import kontrol.operacional.repository.ContadorRepository;



@RestController
@RequestMapping("/contadores")
@CrossOrigin(origins = "*")

public class ContadorService {
	
	@Autowired
	private ContadorRepository contadorRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Contador contador){ 
 
		try { 
			this.contadorRepository.save(contador); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Contador contador){
 
		try {
 
			this.contadorRepository.save(contador);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Contador> contador = contadorRepository.findById(id);
		if (!contador.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				contadorRepository.delete(contador.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Contador> findById (@PathVariable Long id){
		Optional<Contador> contador = contadorRepository.findById(id);
		
		if (contador == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(contador.get());
					
	}
	


	@GetMapping("/inquilino/{inquilino}")
	public @ResponseBody List<Contador> findAll(@PathVariable Long inquilino){
		return this.contadorRepository.findByInquilino(inquilino);
	}
	
	
	
 

}
