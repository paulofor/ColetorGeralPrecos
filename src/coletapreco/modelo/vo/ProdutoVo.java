package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class ProdutoVo implements Produto
{
		
	public long getIdObj()
    {
       return idProduto;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdProduto\" : \"" + idProduto + "\" "
		+ ", \"UrlOrigem\" : \"" + urlOrigem + "\" "
		+ ", \"ImagemLocal\" : \"" + imagemLocal + "\" "
		+ ", \"DataInclusao\" : \"" + dataInclusao + "\" "
		+ ", \"Url\" : \"" + url + "\" "
		+ ", \"Nome\" : \"" + nome + "\" "
		+ ", \"PosicaoProduto\" : \"" + posicaoProduto + "\" "
		+ ", \"Imagem\" : \"" + imagem + "\" "
		+ ", \"VerificacaoNomeOk\" : \"" + verificacaoNomeOk + "\" "
		+ ", \"IdLojaVirtualLe\" : \"" + idLojaVirtualLe + "\" "
		+ ", \"IdMarcaP\" : \"" + idMarcaP + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private ProdutoDerivada derivada = null;
	private ProdutoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new ProdutoDerivada(this);
		}
		return derivada;
	}

	private ProdutoAgregado agregado = null;
	private ProdutoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new ProdutoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public LojaVirtual getLojaVirtualLidoEm(boolean lazyLoader)
	{
		return getAgregado().getLojaVirtualLidoEm(lazyLoader); 
	} 
	public void setLojaVirtualLidoEm(LojaVirtual value) 
	{
		getAgregado().setLojaVirtualLidoEm(value); 
	} 
	/*
	public void setLojaVirtualLidoEmComReversao(LojaVirtual value) 
	{
		getAgregado().setLojaVirtualLidoEmComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaLojaVirtual_LidoEm(LojaVirtual value)
	{
		getAgregado().setLojaVirtualLidoEm(value); 
	} 
	public LojaVirtual getCorrenteLojaVirtual_LidoEm()
	{
		return getAgregado().getLojaVirtualLidoEm(false); 
	} 
	
	
	// Montador Tradicional
	public Marca getMarcaPossui(boolean lazyLoader)
	{
		return getAgregado().getMarcaPossui(lazyLoader); 
	} 
	public void setMarcaPossui(Marca value) 
	{
		getAgregado().setMarcaPossui(value); 
	} 
	/*
	public void setMarcaPossuiComReversao(Marca value) 
	{
		getAgregado().setMarcaPossuiComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaMarca_Possui(Marca value)
	{
		getAgregado().setMarcaPossui(value); 
	} 
	public Marca getCorrenteMarca_Possui()
	{
		return getAgregado().getMarcaPossui(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	public long getPosicao()
	{
		return getDerivada().getPosicao(); 
	} 
	public void setPosicao(long value)
	{
		getDerivada().setPosicao(value); 
	} 
	
	public String getCodigoImagemLocal()
	{
		return getDerivada().getCodigoImagemLocal(); 
	} 
	public void setCodigoImagemLocal(String value)
	{
		getDerivada().setCodigoImagemLocal(value); 
	} 
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaPrecoDiario_Possui() {
		return getAgregado().existeListaPrecoDiario_Possui();
	}
	public void criaVaziaListaPrecoDiario_Possui() {
		getAgregado().criaVaziaListaPrecoDiario_Possui();
	}
	public List<PrecoDiario> getListaPrecoDiario_Possui() 
	{
		return getAgregado().getListaPrecoDiario_Possui(); 
	} 
	public void setListaPrecoDiario_Possui(List<PrecoDiario> value) 
	{
		getAgregado().setListaPrecoDiario_Possui(value); 
	} 
	public void addListaPrecoDiario_Possui(PrecoDiario value) 
	{
		getAgregado().addListaPrecoDiario_Possui(value); 
	} 
	public PrecoDiario getCorrentePrecoDiario_Possui()
	{
		return getAgregado().getCorrentePrecoDiario_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaModeloProdutoProduto_ReferenteA() {
		return getAgregado().existeListaModeloProdutoProduto_ReferenteA();
	}
	public void criaVaziaListaModeloProdutoProduto_ReferenteA() {
		getAgregado().criaVaziaListaModeloProdutoProduto_ReferenteA();
	}
	public List<ModeloProdutoProduto> getListaModeloProdutoProduto_ReferenteA() 
	{
		return getAgregado().getListaModeloProdutoProduto_ReferenteA(); 
	} 
	public void setListaModeloProdutoProduto_ReferenteA(List<ModeloProdutoProduto> value) 
	{
		getAgregado().setListaModeloProdutoProduto_ReferenteA(value); 
	} 
	public void addListaModeloProdutoProduto_ReferenteA(ModeloProdutoProduto value) 
	{
		getAgregado().addListaModeloProdutoProduto_ReferenteA(value); 
	} 
	public ModeloProdutoProduto getCorrenteModeloProdutoProduto_ReferenteA()
	{
		return getAgregado().getCorrenteModeloProdutoProduto_ReferenteA(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaPrecoProduto_Possui() {
		return getAgregado().existeListaPrecoProduto_Possui();
	}
	public void criaVaziaListaPrecoProduto_Possui() {
		getAgregado().criaVaziaListaPrecoProduto_Possui();
	}
	public List<PrecoProduto> getListaPrecoProduto_Possui() 
	{
		return getAgregado().getListaPrecoProduto_Possui(); 
	} 
	public void setListaPrecoProduto_Possui(List<PrecoProduto> value) 
	{
		getAgregado().setListaPrecoProduto_Possui(value); 
	} 
	public void addListaPrecoProduto_Possui(PrecoProduto value) 
	{
		getAgregado().addListaPrecoProduto_Possui(value); 
	} 
	public PrecoProduto getCorrentePrecoProduto_Possui()
	{
		return getAgregado().getCorrentePrecoProduto_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaCategoriaLojaProduto_Possui() {
		return getAgregado().existeListaCategoriaLojaProduto_Possui();
	}
	public void criaVaziaListaCategoriaLojaProduto_Possui() {
		getAgregado().criaVaziaListaCategoriaLojaProduto_Possui();
	}
	public List<CategoriaLojaProduto> getListaCategoriaLojaProduto_Possui() 
	{
		return getAgregado().getListaCategoriaLojaProduto_Possui(); 
	} 
	public void setListaCategoriaLojaProduto_Possui(List<CategoriaLojaProduto> value) 
	{
		getAgregado().setListaCategoriaLojaProduto_Possui(value); 
	} 
	public void addListaCategoriaLojaProduto_Possui(CategoriaLojaProduto value) 
	{
		getAgregado().addListaCategoriaLojaProduto_Possui(value); 
	} 
	public CategoriaLojaProduto getCorrenteCategoriaLojaProduto_Possui()
	{
		return getAgregado().getCorrenteCategoriaLojaProduto_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaOportunidadeDia_PodePossuir() {
		return getAgregado().existeListaOportunidadeDia_PodePossuir();
	}
	public void criaVaziaListaOportunidadeDia_PodePossuir() {
		getAgregado().criaVaziaListaOportunidadeDia_PodePossuir();
	}
	public List<OportunidadeDia> getListaOportunidadeDia_PodePossuir() 
	{
		return getAgregado().getListaOportunidadeDia_PodePossuir(); 
	} 
	public void setListaOportunidadeDia_PodePossuir(List<OportunidadeDia> value) 
	{
		getAgregado().setListaOportunidadeDia_PodePossuir(value); 
	} 
	public void addListaOportunidadeDia_PodePossuir(OportunidadeDia value) 
	{
		getAgregado().addListaOportunidadeDia_PodePossuir(value); 
	} 
	public OportunidadeDia getCorrenteOportunidadeDia_PodePossuir()
	{
		return getAgregado().getCorrenteOportunidadeDia_PodePossuir(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaPalavraProduto_Possui() {
		return getAgregado().existeListaPalavraProduto_Possui();
	}
	public void criaVaziaListaPalavraProduto_Possui() {
		getAgregado().criaVaziaListaPalavraProduto_Possui();
	}
	public List<PalavraProduto> getListaPalavraProduto_Possui() 
	{
		return getAgregado().getListaPalavraProduto_Possui(); 
	} 
	public void setListaPalavraProduto_Possui(List<PalavraProduto> value) 
	{
		getAgregado().setListaPalavraProduto_Possui(value); 
	} 
	public void addListaPalavraProduto_Possui(PalavraProduto value) 
	{
		getAgregado().addListaPalavraProduto_Possui(value); 
	} 
	public PalavraProduto getCorrentePalavraProduto_Possui()
	{
		return getAgregado().getCorrentePalavraProduto_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaFacebookPost_DivulgadoPor() {
		return getAgregado().existeListaFacebookPost_DivulgadoPor();
	}
	public void criaVaziaListaFacebookPost_DivulgadoPor() {
		getAgregado().criaVaziaListaFacebookPost_DivulgadoPor();
	}
	public List<FacebookPost> getListaFacebookPost_DivulgadoPor() 
	{
		return getAgregado().getListaFacebookPost_DivulgadoPor(); 
	} 
	public void setListaFacebookPost_DivulgadoPor(List<FacebookPost> value) 
	{
		getAgregado().setListaFacebookPost_DivulgadoPor(value); 
	} 
	public void addListaFacebookPost_DivulgadoPor(FacebookPost value) 
	{
		getAgregado().addListaFacebookPost_DivulgadoPor(value); 
	} 
	public FacebookPost getCorrenteFacebookPost_DivulgadoPor()
	{
		return getAgregado().getCorrenteFacebookPost_DivulgadoPor(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaCompartilhamentoProduto_Gerou() {
		return getAgregado().existeListaCompartilhamentoProduto_Gerou();
	}
	public void criaVaziaListaCompartilhamentoProduto_Gerou() {
		getAgregado().criaVaziaListaCompartilhamentoProduto_Gerou();
	}
	public List<CompartilhamentoProduto> getListaCompartilhamentoProduto_Gerou() 
	{
		return getAgregado().getListaCompartilhamentoProduto_Gerou(); 
	} 
	public void setListaCompartilhamentoProduto_Gerou(List<CompartilhamentoProduto> value) 
	{
		getAgregado().setListaCompartilhamentoProduto_Gerou(value); 
	} 
	public void addListaCompartilhamentoProduto_Gerou(CompartilhamentoProduto value) 
	{
		getAgregado().addListaCompartilhamentoProduto_Gerou(value); 
	} 
	public CompartilhamentoProduto getCorrenteCompartilhamentoProduto_Gerou()
	{
		return getAgregado().getCorrenteCompartilhamentoProduto_Gerou(); 
	} 
	

	
	
	
	
	
	private long idProduto;
	public long getIdProduto()
	{
		return idProduto;
	}
	public  void setIdProduto(long value)
	{
		idProduto = value; 
	}
	
	
	
	
	
	private String urlOrigem;
	public String getUrlOrigem()
	{
		return urlOrigem;
	}
	public  void setUrlOrigem(String value)
	{
		urlOrigem = value; 
	}
	
	
	
	
	
	private String imagemLocal;
	public String getImagemLocal()
	{
		return imagemLocal;
	}
	public  void setImagemLocal(String value)
	{
		imagemLocal = value; 
	}
	
	
	
	
	
	private String dataInclusao;
	public String getDataInclusao()
	{
		return dataInclusao;
	}
	public  void setDataInclusao(String value)
	{
		dataInclusao = value; 
	}
	
	
	
	
	
	private String url;
	public String getUrl()
	{
		return url;
	}
	public  void setUrl(String value)
	{
		url = value; 
	}
	
	
	
	
	
	private String nome;
	public String getNome()
	{
		return nome;
	}
	public  void setNome(String value)
	{
		nome = value; 
	}
	
	
	
	
	
	private long posicaoProduto;
	public long getPosicaoProduto()
	{
		return posicaoProduto;
	}
	public  void setPosicaoProduto(long value)
	{
		posicaoProduto = value; 
	}
	
	
	
	
	
	private String imagem;
	public String getImagem()
	{
		return imagem;
	}
	public  void setImagem(String value)
	{
		imagem = value; 
	}
	
	
	
	
	
	private boolean verificacaoNomeOk;
	public boolean getVerificacaoNomeOk()
	{
		return verificacaoNomeOk;
	}
	public  void setVerificacaoNomeOk(boolean value)
	{
		verificacaoNomeOk = value; 
	}
	
	
	
	
		
	private long idLojaVirtualLe;
	public long getIdLojaVirtualLe() {
		// relacionamento
		if (idLojaVirtualLe==0 && this.getLojaVirtualLidoEm(false)!=null) 
			return getLojaVirtualLidoEm(false).getIdObj();
		else
			return idLojaVirtualLe;
	}
	public void setIdLojaVirtualLe(long _valor) {
		idLojaVirtualLe = _valor;
	}
	
	
	
	
		
	private long idMarcaP;
	public long getIdMarcaP() {
		// relacionamento
		if (idMarcaP==0 && this.getMarcaPossui(false)!=null) 
			return getMarcaPossui(false).getIdObj();
		else
			return idMarcaP;
	}
	public void setIdMarcaP(long _valor) {
		idMarcaP = _valor;
	}

	

	
	// DESNORMALIZACAO -- BIGDATA
	
	@Override
	public void setIdLojaVirtual(long id) {
		this.getDerivada().setIdLojaVirtual(id);
	}
	@Override
	public long getIdLojaVirtual() {
		return this.getDerivada().getIdLojaVirtual();
	}
	
	
	@Override
	public long getIdNaturezaProduto() {
		return getDerivada().getIdNaturezaProduto();
	}

	@Override
	public void setIdNaturezaProduto(long id) {
		this.getDerivada().setIdNaturezaProduto(id);
	}

	@Override
	public long getIdCategoraLoja() {
		return this.getDerivada().getIdCategoraLoja();
	}

	@Override
	public void setIdCategoriaLoja(long id) {
		this.getDerivada().setIdCategoriaLoja(id);
	}
	
	
	public String toString() {
		return "" + this.idProduto;
	}
	
	
	
	//-------------------------------------------------------
	
	
}
