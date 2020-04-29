package  br.com.knopsistemas.knop.operacional.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import br.com.knopsistemas.knop.base.entities.Fpas;





@Entity
@Table(name = "EMPRESA")
public class Empresa {
	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

	@Size (max = 150)
	 @Column(name = "RAZAO_SOCIAL")
    private String razaoSocial;
	
	@Size (max = 150)
    @Column(name = "NOME_FANTASIA")
    private String nomeFantasia;
    
	@Size (max = 30)
    @Column(name = "CNPJ")
    private String cnpj;
	
	@Size (max = 30)
    @Column(name = "INSCRICAO_ESTADUAL")
    private String inscricaoEstadual;
	
	@Size (max = 30)
    @Column(name = "INSCRICAO_ESTADUAL_ST")
    private String inscricaoEstadualSt;
	
	@Size (max = 30)
    @Column(name = "INSCRICAO_MUNICIPAL")
    private String inscricaoMunicipal;
	
	@Size (max = 30)
    @Column(name = "INSCRICAO_JUNTA_COMERCIAL")
    private String inscricaoJuntaComercial;
	
	
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_INSC_JUNTA_COMERCIAL")
    private Date dataInscJuntaComercial;
    
    @Size (max = 1)
    @Column(name = "TIPO")
    private String tipo;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_CADASTRO")
    private Date dataCadastro;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_INICIO_ATIVIDADES")
    private Date dataInicioAtividades;
    
    @Size (max = 30)
    @Column(name = "SUFRAMA")
    private String suframa;
    
    @Size (max = 250)
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "IMAGEM_LOGOTIPO")
    private String imagemLogotipo;
    
    @Size (max = 1)
    @Column(name = "CRT")
    private String crt;
    
    @Size (max = 1)
    @Column(name = "TIPO_REGIME")
    private String tipoRegime;
    
    @Column(name = "ALIQUOTA_PIS")
    private BigDecimal aliquotaPis;
    
    @Size (max = 50)
    @Column(name = "CONTATO")
    private String contato;
    
    @Column(name = "ALIQUOTA_COFINS")
    private BigDecimal aliquotaCofins;
    
    @Column(name = "CODIGO_IBGE_CIDADE")
    private Integer codigoIbgeCidade;
    
    @Column(name = "CODIGO_IBGE_UF")
    private Integer codigoIbgeUf;
    
    @Column(name = "CODIGO_TERCEIROS")
    private Integer codigoTerceiros;
    
    @Column(name = "CODIGO_GPS")
    private Integer codigoGps;
    
    @Column(name = "ALIQUOTA_SAT")
    private BigDecimal aliquotaSat;
    
    @Size (max = 30)
    @Column(name = "CEI")
    private String cei;
    
    @Size (max = 30)
    @Column(name = "CODIGO_CNAE_PRINCIPAL")
    private String codigoCnaePrincipal;
    
    @Size (max = 1)
    @Column(name = "TIPO_CONTROLE_ESTOQUE")
    private String tipoControleEstoque;
    
    
    @Column(name = "INQUILINO_ID")
    private Long inquilino_id;
    
    @JoinColumn(name = "ID_CONTADOR", referencedColumnName = "ID")
    @ManyToOne
    private Contador contador;
    
    @JoinColumn(name = "ID_FPAS", referencedColumnName = "ID")
    @ManyToOne
    private Fpas fpas;
    
    @JoinColumn(name = "ID_SINDICATO_PATRONAL", referencedColumnName = "ID")
    @ManyToOne
    private Sindicato sindicato;
    
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID")
    @ManyToOne
    private Empresa empresa;
    

   
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoEstadualSt() {
        return inscricaoEstadualSt;
    }

    public void setInscricaoEstadualSt(String inscricaoEstadualSt) {
        this.inscricaoEstadualSt = inscricaoEstadualSt;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getInscricaoJuntaComercial() {
        return inscricaoJuntaComercial;
    }

    public void setInscricaoJuntaComercial(String inscricaoJuntaComercial) {
        this.inscricaoJuntaComercial = inscricaoJuntaComercial;
    }

    public Date getDataInscJuntaComercial() {
        return dataInscJuntaComercial;
    }

    public void setDataInscJuntaComercial(Date dataInscJuntaComercial) {
        this.dataInscJuntaComercial = dataInscJuntaComercial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataInicioAtividades() {
        return dataInicioAtividades;
    }

    public void setDataInicioAtividades(Date dataInicioAtividades) {
        this.dataInicioAtividades = dataInicioAtividades;
    }

    public String getSuframa() {
        return suframa;
    }

    public void setSuframa(String suframa) {
        this.suframa = suframa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagemLogotipo() {
        return imagemLogotipo;
    }

    public void setImagemLogotipo(String imagemLogotipo) {
        this.imagemLogotipo = imagemLogotipo;
    }

    public String getCrt() {
        return crt;
    }

    public void setCrt(String crt) {
        this.crt = crt;
    }

    public String getTipoRegime() {
        return tipoRegime;
    }

    public void setTipoRegime(String tipoRegime) {
        this.tipoRegime = tipoRegime;
    }

    public BigDecimal getAliquotaPis() {
        return aliquotaPis;
    }

    public void setAliquotaPis(BigDecimal aliquotaPis) {
        this.aliquotaPis = aliquotaPis;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public BigDecimal getAliquotaCofins() {
        return aliquotaCofins;
    }

    public void setAliquotaCofins(BigDecimal aliquotaCofins) {
        this.aliquotaCofins = aliquotaCofins;
    }

    public Integer getCodigoIbgeCidade() {
        return codigoIbgeCidade;
    }

    public void setCodigoIbgeCidade(Integer codigoIbgeCidade) {
        this.codigoIbgeCidade = codigoIbgeCidade;
    }

    public Integer getCodigoIbgeUf() {
        return codigoIbgeUf;
    }

    public void setCodigoIbgeUf(Integer codigoIbgeUf) {
        this.codigoIbgeUf = codigoIbgeUf;
    }

    public Integer getCodigoTerceiros() {
        return codigoTerceiros;
    }

    public void setCodigoTerceiros(Integer codigoTerceiros) {
        this.codigoTerceiros = codigoTerceiros;
    }

    public Integer getCodigoGps() {
        return codigoGps;
    }

    public void setCodigoGps(Integer codigoGps) {
        this.codigoGps = codigoGps;
    }

    public BigDecimal getAliquotaSat() {
        return aliquotaSat;
    }

    public void setAliquotaSat(BigDecimal aliquotaSat) {
        this.aliquotaSat = aliquotaSat;
    }

    public String getCei() {
        return cei;
    }

    public void setCei(String cei) {
        this.cei = cei;
    }

    public String getCodigoCnaePrincipal() {
        return codigoCnaePrincipal;
    }

    public void setCodigoCnaePrincipal(String codigoCnaePrincipal) {
        this.codigoCnaePrincipal = codigoCnaePrincipal;
    }

    public String getTipoControleEstoque() {
        return tipoControleEstoque;
    }

    public void setTipoControleEstoque(String tipoControleEstoque) {
        this.tipoControleEstoque = tipoControleEstoque;
    }

    public Contador getContador() {
        return contador;
    }

    public void setContador(Contador contador) {
        this.contador = contador;
    }

    public Fpas getFpas() {
        return fpas;
    }

    public void setFpas(Fpas fpas) {
        this.fpas = fpas;
    }

    public Sindicato getSindicato() {
        return sindicato;
    }

    public void setSindicato(Sindicato sindicato) {
        this.sindicato = sindicato;
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
		return "Empresa [id=" + id + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", cnpj="
				+ cnpj + ", inscricaoEstadual=" + inscricaoEstadual + ", inscricaoEstadualSt=" + inscricaoEstadualSt
				+ ", inscricaoMunicipal=" + inscricaoMunicipal + ", inscricaoJuntaComercial=" + inscricaoJuntaComercial
				+ ", dataInscJuntaComercial=" + dataInscJuntaComercial + ", tipo=" + tipo + ", dataCadastro="
				+ dataCadastro + ", dataInicioAtividades=" + dataInicioAtividades + ", suframa=" + suframa + ", email="
				+ email + ", imagemLogotipo=" + imagemLogotipo + ", crt=" + crt + ", tipoRegime=" + tipoRegime
				+ ", aliquotaPis=" + aliquotaPis + ", contato=" + contato + ", aliquotaCofins=" + aliquotaCofins
				+ ", codigoIbgeCidade=" + codigoIbgeCidade + ", codigoIbgeUf=" + codigoIbgeUf + ", codigoTerceiros="
				+ codigoTerceiros + ", codigoGps=" + codigoGps + ", aliquotaSat=" + aliquotaSat + ", cei=" + cei
				+ ", codigoCnaePrincipal=" + codigoCnaePrincipal + ", tipoControleEstoque=" + tipoControleEstoque
				+ ", inquilino_id=" + inquilino_id + ", contador=" + contador + ", fpas=" + fpas + ", sindicato="
				+ sindicato + ", empresa=" + empresa + "]";
	}

   
    
    

}
