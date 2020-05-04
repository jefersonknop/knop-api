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

import br.com.knopsistemas.knop.tributacao.entities.TributGrupoTributario;
import br.com.knopsistemas.knop.tributacao.entities.TributIcmsCustomCab;

@Entity
@Table(name = "PRODUTO")
public class Produto {
	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
	
	@Size (max = 14)
	@Column(name = "GTIN")
    private String gtin;
	
	@Size (max = 60)
    @Column(name = "CODIGO_INTERNO")
    private String codigoInterno;
    
	@Size (max = 8)
    @Column(name = "NCM")
    private String ncm;
    
    @Size (max = 100)
    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @Size (max = 30)
    @Column(name = "DESCRICAO_PDV")
    private String descricaoPdv;
    
    @Column(name = "VALOR_COMPRA")
    private BigDecimal valorCompra;

    @Column(name = "VALOR_VENDA")
    private BigDecimal valorVenda;
    
    @Column(name = "PRECO_VENDA_MINIMO")
    private BigDecimal precoVendaMinimo;
    
    @Column(name = "PRECO_SUGERIDO")
    private BigDecimal precoSugerido;
    
    @Column(name = "CUSTO_MEDIO_LIQUIDO")
    private BigDecimal custoMedioLiquido;
    
    @Column(name = "PRECO_LUCRO_ZERO")
    private BigDecimal precoLucroZero;
    
    @Column(name = "PRECO_LUCRO_MINIMO")
    private BigDecimal precoLucroMinimo;
    
    @Column(name = "PRECO_LUCRO_MAXIMO")
    private BigDecimal precoLucroMaximo;
    
    @Column(name = "MARKUP")
    private BigDecimal markup;
    
    @Column(name = "QUANTIDADE_ESTOQUE")
    private BigDecimal quantidadeEstoque;
    
    @Column(name = "QUANTIDADE_ESTOQUE_ANTERIOR")
    private BigDecimal quantidadeEstoqueAnterior;
    
    @Column(name = "ESTOQUE_MINIMO")
    private BigDecimal estoqueMinimo;
    
    @Column(name = "ESTOQUE_MAXIMO")
    private BigDecimal estoqueMaximo;
    
    @Column(name = "ESTOQUE_IDEAL")
    private BigDecimal estoqueIdeal;
    
    @Size (max = 1)
    @Column(name = "EXCLUIDO")
    private String excluido;
    
    @Size (max = 1)
    @Column(name = "INATIVO")
    private String inativo;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_CADASTRO")
    private Date dataCadastro;
    
    @Column(name = "FOTO_PRODUTO")
    private String fotoProduto;
    
    @Size (max = 3)
    @Column(name = "EX_TIPI")
    private String exTipi;
    
    @Size (max = 4)
    @Column(name = "CODIGO_LST")
    private String codigoLst;
    
    @Size (max = 1)
    @Column(name = "CLASSE_ABC")
    private String classeAbc;
    
    @Size (max = 1)
    @Column(name = "IAT")
    private String iat;
    
    @Size (max = 1)
    @Column(name = "IPPT")
    private String ippt;
    
    @Size (max = 2)
    @Column(name = "TIPO_ITEM_SPED")
    private String tipoItemSped;
    
    @Column(name = "PESO")
    private BigDecimal peso;
    
    @Column(name = "PORCENTO_COMISSAO")
    private BigDecimal porcentoComissao;
    
    @Column(name = "PONTO_PEDIDO")
    private BigDecimal pontoPedido;
    
    @Column(name = "LOTE_ECONOMICO_COMPRA")
    private BigDecimal loteEconomicoCompra;
    
    @Column(name = "ALIQUOTA_ICMS_PAF")
    private BigDecimal aliquotaIcmsPaf;
    
    @Column(name = "ALIQUOTA_ISSQN_PAF")
    private BigDecimal aliquotaIssqnPaf;
    
    @Size (max = 10)
    @Column(name = "TOTALIZADOR_PARCIAL")
    private String totalizadorParcial;
    
    @Column(name = "CODIGO_BALANCA")
    private Integer codigoBalanca;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ALTERACAO")
    private Date dataAlteracao;
    
    @Size (max = 1)
    @Column(name = "TIPO")
    private String tipo;
    
    @JoinColumn(name = "ID_UNIDADE_PRODUTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UnidadeProduto unidadeProduto;
   
    @JoinColumn(name = "ID_SUB_GRUPO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ProdutoSubGrupo produtoSubGrupo;
    
    @JoinColumn(name = "ID_MARCA_PRODUTO", referencedColumnName = "ID")
    @ManyToOne
    private ProdutoMarca produtoMarca;
   
    @JoinColumn(name = "ID_GRUPO_TRIBUTARIO", referencedColumnName = "ID")
    @ManyToOne
    private TributGrupoTributario tributGrupoTributario;
   
    @JoinColumn(name = "ID_ALMOXARIFADO", referencedColumnName = "ID")
    @ManyToOne
    private Almoxarifado almoxarifado;
  
    @JoinColumn(name = "ID_TRIBUT_ICMS_CUSTOM_CAB", referencedColumnName = "ID")
    @ManyToOne
    private TributIcmsCustomCab tributIcmsCustomCab;
    
    
    @Column(name = "INQUILINO_ID")
    private Long inquilino_id;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getGtin() {
		return gtin;
	}


	public void setGtin(String gtin) {
		this.gtin = gtin;
	}


	public String getCodigoInterno() {
		return codigoInterno;
	}


	public void setCodigoInterno(String codigoInterno) {
		this.codigoInterno = codigoInterno;
	}


	public String getNcm() {
		return ncm;
	}


	public void setNcm(String ncm) {
		this.ncm = ncm;
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


	public String getDescricaoPdv() {
		return descricaoPdv;
	}


	public void setDescricaoPdv(String descricaoPdv) {
		this.descricaoPdv = descricaoPdv;
	}


	public BigDecimal getValorCompra() {
		return valorCompra;
	}


	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}


	public BigDecimal getValorVenda() {
		return valorVenda;
	}


	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}


	public BigDecimal getPrecoVendaMinimo() {
		return precoVendaMinimo;
	}


	public void setPrecoVendaMinimo(BigDecimal precoVendaMinimo) {
		this.precoVendaMinimo = precoVendaMinimo;
	}


	public BigDecimal getPrecoSugerido() {
		return precoSugerido;
	}


	public void setPrecoSugerido(BigDecimal precoSugerido) {
		this.precoSugerido = precoSugerido;
	}


	public BigDecimal getCustoMedioLiquido() {
		return custoMedioLiquido;
	}


	public void setCustoMedioLiquido(BigDecimal custoMedioLiquido) {
		this.custoMedioLiquido = custoMedioLiquido;
	}


	public BigDecimal getPrecoLucroZero() {
		return precoLucroZero;
	}


	public void setPrecoLucroZero(BigDecimal precoLucroZero) {
		this.precoLucroZero = precoLucroZero;
	}


	public BigDecimal getPrecoLucroMinimo() {
		return precoLucroMinimo;
	}


	public void setPrecoLucroMinimo(BigDecimal precoLucroMinimo) {
		this.precoLucroMinimo = precoLucroMinimo;
	}


	public BigDecimal getPrecoLucroMaximo() {
		return precoLucroMaximo;
	}


	public void setPrecoLucroMaximo(BigDecimal precoLucroMaximo) {
		this.precoLucroMaximo = precoLucroMaximo;
	}


	public BigDecimal getMarkup() {
		return markup;
	}


	public void setMarkup(BigDecimal markup) {
		this.markup = markup;
	}


	public BigDecimal getQuantidadeEstoque() {
		return quantidadeEstoque;
	}


	public void setQuantidadeEstoque(BigDecimal quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}


	public BigDecimal getQuantidadeEstoqueAnterior() {
		return quantidadeEstoqueAnterior;
	}


	public void setQuantidadeEstoqueAnterior(BigDecimal quantidadeEstoqueAnterior) {
		this.quantidadeEstoqueAnterior = quantidadeEstoqueAnterior;
	}


	public BigDecimal getEstoqueMinimo() {
		return estoqueMinimo;
	}


	public void setEstoqueMinimo(BigDecimal estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}


	public BigDecimal getEstoqueMaximo() {
		return estoqueMaximo;
	}


	public void setEstoqueMaximo(BigDecimal estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}


	public BigDecimal getEstoqueIdeal() {
		return estoqueIdeal;
	}


	public void setEstoqueIdeal(BigDecimal estoqueIdeal) {
		this.estoqueIdeal = estoqueIdeal;
	}


	public String getExcluido() {
		return excluido;
	}


	public void setExcluido(String excluido) {
		this.excluido = excluido;
	}


	public String getInativo() {
		return inativo;
	}


	public void setInativo(String inativo) {
		this.inativo = inativo;
	}


	public Date getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public String getFotoProduto() {
		return fotoProduto;
	}


	public void setFotoProduto(String fotoProduto) {
		this.fotoProduto = fotoProduto;
	}


	public String getExTipi() {
		return exTipi;
	}


	public void setExTipi(String exTipi) {
		this.exTipi = exTipi;
	}


	public String getCodigoLst() {
		return codigoLst;
	}


	public void setCodigoLst(String codigoLst) {
		this.codigoLst = codigoLst;
	}


	public String getClasseAbc() {
		return classeAbc;
	}


	public void setClasseAbc(String classeAbc) {
		this.classeAbc = classeAbc;
	}


	public String getIat() {
		return iat;
	}


	public void setIat(String iat) {
		this.iat = iat;
	}


	public String getIppt() {
		return ippt;
	}


	public void setIppt(String ippt) {
		this.ippt = ippt;
	}


	public String getTipoItemSped() {
		return tipoItemSped;
	}


	public void setTipoItemSped(String tipoItemSped) {
		this.tipoItemSped = tipoItemSped;
	}


	public BigDecimal getPeso() {
		return peso;
	}


	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}


	public BigDecimal getPorcentoComissao() {
		return porcentoComissao;
	}


	public void setPorcentoComissao(BigDecimal porcentoComissao) {
		this.porcentoComissao = porcentoComissao;
	}


	public BigDecimal getPontoPedido() {
		return pontoPedido;
	}


	public void setPontoPedido(BigDecimal pontoPedido) {
		this.pontoPedido = pontoPedido;
	}


	public BigDecimal getLoteEconomicoCompra() {
		return loteEconomicoCompra;
	}


	public void setLoteEconomicoCompra(BigDecimal loteEconomicoCompra) {
		this.loteEconomicoCompra = loteEconomicoCompra;
	}


	public BigDecimal getAliquotaIcmsPaf() {
		return aliquotaIcmsPaf;
	}


	public void setAliquotaIcmsPaf(BigDecimal aliquotaIcmsPaf) {
		this.aliquotaIcmsPaf = aliquotaIcmsPaf;
	}


	public BigDecimal getAliquotaIssqnPaf() {
		return aliquotaIssqnPaf;
	}


	public void setAliquotaIssqnPaf(BigDecimal aliquotaIssqnPaf) {
		this.aliquotaIssqnPaf = aliquotaIssqnPaf;
	}


	public String getTotalizadorParcial() {
		return totalizadorParcial;
	}


	public void setTotalizadorParcial(String totalizadorParcial) {
		this.totalizadorParcial = totalizadorParcial;
	}


	public Integer getCodigoBalanca() {
		return codigoBalanca;
	}


	public void setCodigoBalanca(Integer codigoBalanca) {
		this.codigoBalanca = codigoBalanca;
	}


	public Date getDataAlteracao() {
		return dataAlteracao;
	}


	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public UnidadeProduto getUnidadeProduto() {
		return unidadeProduto;
	}


	public void setUnidadeProduto(UnidadeProduto unidadeProduto) {
		this.unidadeProduto = unidadeProduto;
	}


	public ProdutoSubGrupo getProdutoSubGrupo() {
		return produtoSubGrupo;
	}


	public void setProdutoSubGrupo(ProdutoSubGrupo produtoSubGrupo) {
		this.produtoSubGrupo = produtoSubGrupo;
	}


	public ProdutoMarca getProdutoMarca() {
		return produtoMarca;
	}


	public void setProdutoMarca(ProdutoMarca produtoMarca) {
		this.produtoMarca = produtoMarca;
	}


	public TributGrupoTributario getTributGrupoTributario() {
		return tributGrupoTributario;
	}


	public void setTributGrupoTributario(TributGrupoTributario tributGrupoTributario) {
		this.tributGrupoTributario = tributGrupoTributario;
	}


	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}


	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}


	public TributIcmsCustomCab getTributIcmsCustomCab() {
		return tributIcmsCustomCab;
	}


	public void setTributIcmsCustomCab(TributIcmsCustomCab tributIcmsCustomCab) {
		this.tributIcmsCustomCab = tributIcmsCustomCab;
	}


	public Long getInquilino_id() {
		return inquilino_id;
	}


	public void setInquilino_id(Long inquilino_id) {
		this.inquilino_id = inquilino_id;
	}
    
    
    
    
}
