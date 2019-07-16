package br.com.knopsistemas.knop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

import br.com.knopsistemas.knop.entities.Email;
import br.com.knopsistemas.knop.entities.Linha;
import br.com.knopsistemas.knop.entities.ResponseModel;
import br.com.knopsistemas.knop.entities.Usuario;
import br.com.knopsistemas.knop.repository.UsuarioRepository;

@RestController
@RequestMapping("/email")
@CrossOrigin(origins = "*")

public class EmailService {

 /*   @Autowired private JavaMailSender mailSender;
    
    @PostMapping
	public @ResponseBody ResponseModel sendMail(@RequestBody Email email){ 
    	
    	 SimpleMailMessage message = new SimpleMailMessage();
    	 message.setSubject(email.getTitulo());
         message.setText(email.getTexto());
         message.setTo(email.getDestinatario());
         message.setFrom(email.getRemetente());
 
		try { 
		    mailSender.send(message);
			return new ResponseModel(1,"Email enviado para "+ email.getDestinatario());
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage()+ " - - - - Erro ao enviar email");			
		}
	}
    **/

}