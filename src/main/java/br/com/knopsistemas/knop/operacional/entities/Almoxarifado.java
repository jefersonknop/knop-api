package  br.com.knopsistemas.knop.operacional.entities;

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

@Entity
@Table(name = "ALMOXARIFADO")
public class Almoxarifado {
		@Id
		@GeneratedValue(generator = "increment")
	    @GenericGenerator(name = "increment", strategy = "increment")
		
	    @Basic(optional = false)
	    @Column(name = "ID")
	    private Long id;
	
		@Size (max = 50)
	    @Column(name = "NOME")
	    private String nome;
	    
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

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
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
			return "Almoxarifado [id=" + id + ", nome=" + nome + ", empresa=" + empresa + ", inquilino_id="
					+ inquilino_id + "]";
		}





	}
