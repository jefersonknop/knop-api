package kontrol.administrativo.service;

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

import br.com.knopsistemas.knop.entities.Cidade;
import br.com.knopsistemas.knop.entities.ResponseModel;
import kontrol.administrativo.entities.AdmModulo;
import kontrol.administrativo.repository.AdmModuloRepository;




@RestController
@RequestMapping("/admModulos")
@CrossOrigin(origins = "*")

public class AdmModuloService {
	
	@Autowired
	private AdmModuloRepository admModuloRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody AdmModulo admModulo){ 
 
		try { 
			this.admModuloRepository.save(admModulo); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody AdmModulo admModulo){
 
		try {
 
			this.admModuloRepository.save(admModulo);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <AdmModulo> admModulo = admModuloRepository.findById(id);
		if (!admModulo.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				admModuloRepository.delete(admModulo.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<AdmModulo> findById (@PathVariable Long id){
		Optional<AdmModulo> produtoMarca = admModuloRepository.findById(id);
		
		if (produtoMarca == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(produtoMarca.get());
					
	}
	


	@GetMapping
	public @ResponseBody List<AdmModulo> findAll(){
		return this.admModuloRepository.findAll();
	}
	

	
 

}
