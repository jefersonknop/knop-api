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
@Table(name = "SINDICATO")
public class Sindicato{

	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")	
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
	
	@Size (max = 100)
    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "CODIGO_BANCO")
    private Integer codigoBanco;
    
    @Column(name = "CODIGO_AGENCIA")
    private Integer codigoAgencia;
    
    @Size (max = 130)
    @Column(name = "CONTA_BANCO")
    private String contaBanco;
    
    @Size (max = 30)
    @Column(name = "CODIGO_CEDENTE")
    private String codigoCedente;
    
    @Size (max = 100)
    @Column(name = "LOGRADOURO")
    private String logradouro;
    
    @Size (max = 10)
    @Column(name = "NUMERO")
    private String numero;
    
    @Size (max = 100)
    @Column(name = "BAIRRO")
    private String bairro;
    
    @Column(name = "MUNICIPIO_IBGE")
    private Integer municipioIbge;
    
    @Size (max = 2)
    @Column(name = "UF")
    private String uf;
    
    @Size (max = 30)
    @Column(name = "FONE1")
    private String fone1;
    
    @Size (max = 30)
    @Column(name = "FONE2")
    private String fone2;
    
    @Size (max = 100)    
    @Column(name = "EMAIL")
    private String email;
    
    @Size (max = 1)
    @Column(name = "TIPO_SINDICATO")
    private String tipoSindicato;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_BASE")    
    private Date dataBase;
    @Column(name = "PISO_SALARIAL")
    
    private BigDecimal pisoSalarial;
    @Column(name = "CNPJ")
    
    
    @Size (max = 30)
    private String cnpj;
    @Column(name = "CLASSIFICACAO_CONTABIL_CONTA")
    private String classificacaoContabilConta;

  
    @Column(name = "INQUILINO_ID")
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

    public Integer getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(Integer codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public Integer getCodigoAgencia() {
        return codigoAgencia;
    }

    public void setCodigoAgencia(Integer codigoAgencia) {
        this.codigoAgencia = codigoAgencia;
    }

    public String getContaBanco() {
        return contaBanco;
    }

    public void setContaBanco(String contaBanco) {
        this.contaBanco = contaBanco;
    }

    public String getCodigoCedente() {
        return codigoCedente;
    }

    public void setCodigoCedente(String codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getMunicipioIbge() {
        return municipioIbge;
    }

    public void setMunicipioIbge(Integer municipioIbge) {
        this.municipioIbge = municipioIbge;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getFone1() {
        return fone1;
    }

    public void setFone1(String fone1) {
        this.fone1 = fone1;
    }

    public String getFone2() {
        return fone2;
    }

    public void setFone2(String fone2) {
        this.fone2 = fone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoSindicato() {
        return tipoSindicato;
    }

    public void setTipoSindicato(String tipoSindicato) {
        this.tipoSindicato = tipoSindicato;
    }

    public Date getDataBase() {
        return dataBase;
    }

    public void setDataBase(Date dataBase) {
        this.dataBase = dataBase;
    }

    public BigDecimal getPisoSalarial() {
        return pisoSalarial;
    }

    public void setPisoSalarial(BigDecimal pisoSalarial) {
        this.pisoSalarial = pisoSalarial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getClassificacaoContabilConta() {
        return classificacaoContabilConta;
    }

    public void setClassificacaoContabilConta(String classificacaoContabilConta) {
        this.classificacaoContabilConta = classificacaoContabilConta;
    }

	public Long getInquilino_id() {
		return inquilino_id;
	}

	public void setInquilino_id(Long inquilino_id) {
		this.inquilino_id = inquilino_id;
	}

	@Override
	public String toString() {
		return "Sindicato [id=" + id + ", nome=" + nome + ", codigoBanco=" + codigoBanco + ", codigoAgencia="
				+ codigoAgencia + ", contaBanco=" + contaBanco + ", codigoCedente=" + codigoCedente + ", logradouro="
				+ logradouro + ", numero=" + numero + ", bairro=" + bairro + ", municipioIbge=" + municipioIbge
				+ ", uf=" + uf + ", fone1=" + fone1 + ", fone2=" + fone2 + ", email=" + email + ", tipoSindicato="
				+ tipoSindicato + ", dataBase=" + dataBase + ", pisoSalarial=" + pisoSalarial + ", cnpj=" + cnpj
				+ ", classificacaoContabilConta=" + classificacaoContabilConta + ", inquilino_id=" + inquilino_id + "]";
	}


    

}
