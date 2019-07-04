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
public class Secao {
	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	
    @JoinColumn(name = "linha_id", referencedColumnName = "id")
    @ManyToOne
	private Linha linha_id;
	
	
    @JoinColumn(name = "localidade1_id", referencedColumnName = "id")
    @ManyToOne
	private Localidade localidade1_id;
	
	
    @JoinColumn(name = "localidade2_id", referencedColumnName = "id")
    @ManyToOne
	private Localidade localidade2_id;
	
	@NotEmpty
	@Size (max = 255)
    private String descricao;
	
	@Size (max = 100)
    private String tipo;
	
	private boolean principal;
	
	
	private double tarifa;
	private double outros_valores;

	@Size (max = 1024)
    private String informacoes;
	
	
	
	private Long inquilino_id;
	

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Linha getLinha_id() {
		return linha_id;
	}
	public void setLinha_id(Linha linha_id) {
		this.linha_id = linha_id;
	}
	public Localidade getLocalidade1_id() {
		return localidade1_id;
	}
	public void setLocalidade1_id(Localidade localidade1_id) {
		this.localidade1_id = localidade1_id;
	}
	public Localidade getLocalidade2_id() {
		return localidade2_id;
	}
	public void setLocalidade2_id(Localidade localidade2_id) {
		this.localidade2_id = localidade2_id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isPrincipal() {
		return principal;
	}
	public void setPrincipal(boolean principal) {
		this.principal = principal;
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
		Secao other = (Secao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	 
	 
	

	 
	 


}

