package  br.com.knopsistemas.knop.operacional.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;



import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "PRODUTO_SUB_GRUPO")
public class ProdutoSubGrupo {
	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	
	private Integer id;
    @Column(name = "NOME")
    
    @Size (max = 100)
    private String nome;
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @JoinColumn(name = "ID_GRUPO", referencedColumnName = "ID")
    @ManyToOne(optional = false)    
    private ProdutoGrupo produtoGrupo;
	
    @Column(name = "INQUILINO_ID")
    private Long inquilino_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public ProdutoGrupo getProdutoGrupo() {
		return produtoGrupo;
	}

	public void setProdutoGrupo(ProdutoGrupo produtoGrupo) {
		this.produtoGrupo = produtoGrupo;
	}

	public Long getInquilino_id() {
		return inquilino_id;
	}

	public void setInquilino_id(Long inquilino_id) {
		this.inquilino_id = inquilino_id;
	}

	@Override
	public String toString() {
		return "ProdutoSubGrupo [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", produtoGrupo="
				+ produtoGrupo + ", inquilino_id=" + inquilino_id + "]";
	}
    
    
    
    
    
}
