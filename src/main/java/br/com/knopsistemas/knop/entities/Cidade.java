package br.com.knopsistemas.knop.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Cidade {
	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	@NotEmpty
	@Size (max = 255)
    private String nome;
	private Integer codigo_ibge;	
	private Integer populacao_2010;	   
	private Integer densidade_demo;	    
    private String gentilico;
	private Integer area;
	@NotEmpty
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    @ManyToOne
	private Estado estado_id;
	


	
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
	public Integer getCodigo_ibge() {
		return codigo_ibge;
	}
	public void setCodigo_ibge(Integer codigo_ibge) {
		this.codigo_ibge = codigo_ibge;
	}
	public Integer getPopulacao_2010() {
		return populacao_2010;
	}
	public void setPopulacao_2010(Integer populacao_2010) {
		this.populacao_2010 = populacao_2010;
	}
	public Integer getDensidade_demo() {
		return densidade_demo;
	}
	public void setDensidade_demo(Integer densidade_demo) {
		this.densidade_demo = densidade_demo;
	}
	public String getGentilico() {
		return gentilico;
	}
	public void setGentilico(String gentilico) {
		this.gentilico = gentilico;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public Estado getEstado_id() {
		return estado_id;
	}
	public void setEstado_id(Estado estado_id) {
		this.estado_id = estado_id;
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
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	 
	 
	

	 
	 


}

