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
public class Linha {
	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@Size (max = 30)
    private String prefixo;
	
	//@NotEmpty
	@Size (max = 255)
    private String nome;
	
	@Size (max = 100)
    private String tipo;
	
	
	private double tarifa;
	private double outros_valores;
	
	
	@Size (max = 100)
    private String nr_registro;
	
	@Size (max = 1024)
    private String informacoes;
	

	private Long inquilino_id;
	
	



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrefixo() {
		return prefixo;
	}
	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
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
	public double getTarifa() {
		return tarifa;
	}
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	public double getOutros_valores() {
		return outros_valores;
	}
	public void setOutros_valores(double outros_valores) {
		this.outros_valores = outros_valores;
	}
	public String getNr_registro() {
		return nr_registro;
	}
	public void setNr_registro(String nr_registro) {
		this.nr_registro = nr_registro;
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
		Linha other = (Linha) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	 
	 
	

	 
	 


}

