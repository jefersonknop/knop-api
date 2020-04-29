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
import br.com.knopsistemas.knop.operacional.entities.Empresa;
import br.com.knopsistemas.knop.operacional.repository.EmpresaRepository;



@RestController
@RequestMapping("/empresas")
@CrossOrigin(origins = "*")

public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Empresa empresa){ 
 
		try { 
			this.empresaRepository.save(empresa); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Empresa empresa){
 
		try {
 
			this.empresaRepository.save(empresa);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Empresa> empresa = empresaRepository.findById(id);
		if (!empresa.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				empresaRepository.delete(empresa.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Empresa> findById (@PathVariable Long id){
		Optional<Empresa> empresa = empresaRepository.findById(id);
		
		if (empresa == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(empresa.get());
					
	}
	


	@GetMapping("/inquilino/{inquilino}")
	public @ResponseBody List<Empresa> findAll(@PathVariable Long inquilino){
		return this.empresaRepository.findByInquilino(inquilino);
	}
	
	
	
 

}
