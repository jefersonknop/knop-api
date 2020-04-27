package kontrol.base.service;

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
import kontrol.base.entities.Fpas;
import kontrol.base.repository.FpasRepository;




@RestController
@RequestMapping("/fpass")
@CrossOrigin(origins = "*")

public class FpasService {
	
	@Autowired
	private FpasRepository fpasRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Fpas fpas){ 
 
		try { 
			this.fpasRepository.save(fpas); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Fpas fpas){
 
		try {
 
			this.fpasRepository.save(fpas);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Fpas> fpas = fpasRepository.findById(id);
		if (!fpas.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				fpasRepository.delete(fpas.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Fpas> findById (@PathVariable Long id){
		Optional<Fpas> produtoMarca = fpasRepository.findById(id);
		
		if (produtoMarca == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(produtoMarca.get());
					
	}
	


	@GetMapping
	public @ResponseBody List<Fpas> findAll(){
		return this.fpasRepository.findAll();
	}
	

	
 

}
