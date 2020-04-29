package  br.com.knopsistemas.knop.base.entities;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "FPAS")
public class Fpas {


	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")	
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
	
    @Column(name = "CODIGO")
    private Integer codigo;
    
    @Size (max = 30)
    @Column(name = "CNAE")
    private String cnae;
    
    @Column(name = "ALIQUOTA_SAT")
    private BigDecimal aliquotaSat;
    
    @Size (max = 250)
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @Column(name = "PERCENTUAL_INSS_PATRONAL")
    private BigDecimal percentualInssPatronal;
    
    @Column(name = "CODIGO_TERCEIRO")
    private String codigoTerceiro;
    
    @Column(name = "PERCENTUAL_TERCEIROS")
    private BigDecimal percentualTerceiros;

    public Fpas() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

    public BigDecimal getAliquotaSat() {
        return aliquotaSat;
    }

    public void setAliquotaSat(BigDecimal aliquotaSat) {
        this.aliquotaSat = aliquotaSat;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPercentualInssPatronal() {
        return percentualInssPatronal;
    }

    public void setPercentualInssPatronal(BigDecimal percentualInssPatronal) {
        this.percentualInssPatronal = percentualInssPatronal;
    }

    public String getCodigoTerceiro() {
        return codigoTerceiro;
    }

    public void setCodigoTerceiro(String codigoTerceiro) {
        this.codigoTerceiro = codigoTerceiro;
    }

    public BigDecimal getPercentualTerceiros() {
        return percentualTerceiros;
    }

    public void setPercentualTerceiros(BigDecimal percentualTerceiros) {
        this.percentualTerceiros = percentualTerceiros;
    }

	@Override
	public String toString() {
		return "Fpas [id=" + id + ", codigo=" + codigo + ", cnae=" + cnae + ", aliquotaSat=" + aliquotaSat
				+ ", descricao=" + descricao + ", percentualInssPatronal=" + percentualInssPatronal
				+ ", codigoTerceiro=" + codigoTerceiro + ", percentualTerceiros=" + percentualTerceiros + "]";
	}


   

}

