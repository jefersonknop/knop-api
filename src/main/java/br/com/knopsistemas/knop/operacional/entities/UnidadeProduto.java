package  br.com.knopsistemas.knop.operacional.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "UNIDADE_PRODUTO")
public class UnidadeProduto{

	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")	
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
	
	@Size (max = 10)
	 @Column(name = "SIGLA")
    private String sigla;
	
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @Size (max = 1)
    @Column(name = "PODE_FRACIONAR")
    private String podeFracionar;
    
    
    @Column(name = "INQUILINO_ID")
    private Long inquilino_id;
    

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPodeFracionar() {
        return podeFracionar;
    }

    public void setPodeFracionar(String podeFracionar) {
        this.podeFracionar = podeFracionar;
    }

	public Long getInquilino_id() {
		return inquilino_id;
	}

	public void setInquilino_id(Long inquilino_id) {
		this.inquilino_id = inquilino_id;
	}

	@Override
	public String toString() {
		return "UnidadeProduto [id=" + id + ", sigla=" + sigla + ", descricao=" + descricao + ", podeFracionar="
				+ podeFracionar + ", inquilino_id=" + inquilino_id + "]";
	}


}
