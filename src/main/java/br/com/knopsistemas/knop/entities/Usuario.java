package br.com.knopsistemas.knop.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.knopsistemas.knop.enums.ProfileEnum;




@Entity
public class Usuario{
	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@NotEmpty(message = "Informar nome do usuário")	
	private String nome;
	


	@Column(unique=true)
	@NotEmpty(message = "Email requerido")
	@Email(message = "Email inválido")
	private String email;
	
	@NotEmpty(message = "Senha requerida")	
	private String password;
	
	
	
    @JoinColumn(name = "inquilino_id", referencedColumnName = "id")
    @ManyToOne
	private Inquilino inquilino_id;
	
	
	private ProfileEnum profile;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Inquilino getInquilino_id() {
		return inquilino_id;
	}


	public void setInquilino_id(Inquilino inquilino_id) {
		this.inquilino_id = inquilino_id;
	}


	public ProfileEnum getProfile() {
		return profile;
	}


	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	
	

}
