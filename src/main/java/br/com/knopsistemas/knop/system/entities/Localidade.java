package br.com.knopsistemas.knop.system.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Localidade {
	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	

	@NotEmpty
	@Size (max = 255)
    private String nome;
	
	@Size (max = 100)
    private String tipo;
	
	
    @JoinColumn(name = "cidade_id", referencedColumnName = "id")
    @ManyToOne
	private Cidade cidade_id;

	@Size (max = 30)
    private String latitude;
	
	@Size (max = 30)
    private String longitude;
	
	@Size (max = 1024)
    private String informacoes;
	
	


	private Long inquilino_id;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Cidade getCidade_id() {
		return cidade_id;
	}
	public void setCidade_id(Cidade cidade_id) {
		this.cidade_id = cidade_id;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getInformacoes() {
		return informacoes;
	}
	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}
	public Long getInquilino_id() {
		return inquilino_id;
	}
	public void setInquilino_id(Long inquilino_id) {
		this.inquilino_id = inquilino_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localidade other = (Localidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	 
	 
	

	 
	 


}

