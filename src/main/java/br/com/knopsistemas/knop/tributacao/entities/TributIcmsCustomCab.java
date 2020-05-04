package br.com.knopsistemas.knop.tributacao.entities;



import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import br.com.knopsistemas.knop.operacional.entities.Empresa;



@Entity
@Table(name = "TRIBUT_ICMS_CUSTOM_CAB")
public class TributIcmsCustomCab{

	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

	@Size (max = 100)
	@Column(name = "DESCRICAO")
    private String descricao;
	
    @Column(name = "ORIGEM_MERCADORIA")
    private String origemMercadoria;
    
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    
    private Empresa empresa;
    
    @Column(name = "INQUILINO_ID")
    private Long inquilino_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getOrigemMercadoria() {
		return origemMercadoria;
	}

	public void setOrigemMercadoria(String origemMercadoria) {
		this.origemMercadoria = origemMercadoria;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Long getInquilino_id() {
		return inquilino_id;
	}

	public void setInquilino_id(Long inquilino_id) {
		this.inquilino_id = inquilino_id;
	}

	@Override
	public String toString() {
		return "TributIcmsCustomCab [id=" + id + ", descricao=" + descricao + ", origemMercadoria=" + origemMercadoria
				+ ", empresa=" + empresa + ", inquilino_id=" + inquilino_id + "]";
	}
    
    




}
