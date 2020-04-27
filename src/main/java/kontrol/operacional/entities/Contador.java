package kontrol.operacional.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CONTADOR")
public class Contador {
	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

	@Size (max = 150)
    @Column(name = "NOME")
    private String nome;
    
	@Size (max = 30)
    @Column(name = "CPF")
    private String cpf;
    
	@Size (max = 30)
    @Column(name = "CNPJ")
    private String cnpj;
	
	@Size (max = 30)
    @Column(name = "INSCRICAO_CRC")
    private String inscricaoCrc;
    
	@Size (max = 2)
	@Column(name = "UF_CRC")
    private String ufCrc;
    
	@Size (max = 30)
	@Column(name = "FONE")
    private String fone;
    
	@Size (max = 30)
    @Column(name = "FAX")
    private String fax;
    
	@Size (max = 100)
	@Column(name = "LOGRADOURO")
    private String logradouro;
    
	@Size (max = 10)
	@Column(name = "NUMERO")
    private String numero;
    
	@Size (max = 100)
	@Column(name = "COMPLEMENTO")
    private String complemento;
    
	@Size (max = 60)
	@Column(name = "BAIRRO")
    private String bairro;
    
	@Size (max = 60)
    @Column(name = "CIDADE")
    private String cidade;
    
	@Size (max = 30)
    @Column(name = "CEP")
    private String cep;
    	
    @Column(name = "MUNICIPIO_IBGE")
    private Integer municipioIbge;
    
    @Size (max = 2)
    @Column(name = "UF")
    private String uf;
    
    @Size (max = 250)
    @Column(name = "EMAIL")
    private String email;
    
    @Size (max = 250)
    @Column(name = "SITE")
    private String site;
    
    @Column(name = "INQUILINO_ID")
    private Long inquilino_id;
    
    
    

    public Contador() {
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoCrc() {
        return inscricaoCrc;
    }

    public void setInscricaoCrc(String inscricaoCrc) {
        this.inscricaoCrc = inscricaoCrc;
    }

    public String getUfCrc() {
        return ufCrc;
    }

    public void setUfCrc(String ufCrc) {
        this.ufCrc = ufCrc;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

	public Long getInquilino_id() {
		return inquilino_id;
	}

	public void setInquilino_id(Long inquilino_id) {
		this.inquilino_id = inquilino_id;
	}

	@Override
	public String toString() {
		return "Contador [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", cnpj=" + cnpj + ", inscricaoCrc="
				+ inscricaoCrc + ", ufCrc=" + ufCrc + ", fone=" + fone + ", fax=" + fax + ", logradouro=" + logradouro
				+ ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", cep=" + cep + ", municipioIbge=" + municipioIbge + ", uf=" + uf + ", email=" + email + ", site="
				+ site + ", inquilino_id=" + inquilino_id + "]";
	}
    
    
    
}
