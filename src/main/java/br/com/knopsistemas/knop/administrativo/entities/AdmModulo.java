package br.com.knopsistemas.knop.administrativo.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "ADM_MODULO")
public class AdmModulo {
	
	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
	
	
	@Size (max = 3)
    @Column(name = "CODIGO")
    private String codigo;
	
	@Size (max = 100)
	@Column(name = "NOME")
    private String nome;
    
    @Column(name = "DESCRICAO")
    private String descricao;
    
    
    
    
    
    
  
	public Long getId() {
		return id;
	}







	public void setId(Long id) {
		this.id = id;
	}







	public String getCodigo() {
		return codigo;
	}







	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}







	public String getNome() {
		return nome;
	}







	public void setNome(String nome) {
		this.nome = nome;
	}







	public String getDescricao() {
		return descricao;
	}







	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}







	@Override
	public String toString() {
		return "AdmModulo [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + "]";
	}






}

