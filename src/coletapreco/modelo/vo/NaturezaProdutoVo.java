package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class NaturezaProdutoVo implements NaturezaProduto
{
		
	public long getIdObj()
    {
       return idNaturezaProduto;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdNaturezaProduto\" : \"" + idNaturezaProduto + "\" "
		+ ", \"NomeNaturezaProduto\" : \"" + nomeNaturezaProduto + "\" "
		+ ", \"CodigoNaturezaProduto\" : \"" + codigoNaturezaProduto + "\" "
		+ ", \"IdAppProdutoAp\" : \"" + idAppProdutoAp + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private NaturezaProdutoDerivada derivada = null;
	private NaturezaProdutoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new NaturezaProdutoDerivada(this);
		}
		return derivada;
	}

	private NaturezaProdutoAgregado agregado = null;
	private NaturezaProdutoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new NaturezaProdutoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public AppProduto getAppProdutoAtendidoPor(boolean lazyLoader)
	{
		return getAgregado().getAppProdutoAtendidoPor(lazyLoader); 
	} 
	public void setAppProdutoAtendidoPor(AppProduto value) 
	{
		getAgregado().setAppProdutoAtendidoPor(value); 
	} 
	/*
	public void setAppProdutoAtendidoPorComReversao(AppProduto value) 
	{
		getAgregado().setAppProdutoAtendidoPorComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaAppProduto_AtendidoPor(AppProduto value)
	{
		getAgregado().setAppProdutoAtendidoPor(value); 
	} 
	public AppProduto getCorrenteAppProduto_AtendidoPor()
	{
		return getAgregado().getAppProdutoAtendidoPor(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaCategoriaLoja_Possui() {
		return getAgregado().existeListaCategoriaLoja_Possui();
	}
	public void criaVaziaListaCategoriaLoja_Possui() {
		getAgregado().criaVaziaListaCategoriaLoja_Possui();
	}
	public List<CategoriaLoja> getListaCategoriaLoja_Possui() 
	{
		return getAgregado().getListaCategoriaLoja_Possui(); 
	} 
	public void setListaCategoriaLoja_Possui(List<CategoriaLoja> value) 
	{
		getAgregado().setListaCategoriaLoja_Possui(value); 
	} 
	public void addListaCategoriaLoja_Possui(CategoriaLoja value) 
	{
		getAgregado().addListaCategoriaLoja_Possui(value); 
	} 
	public CategoriaLoja getCorrenteCategoriaLoja_Possui()
	{
		return getAgregado().getCorrenteCategoriaLoja_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaLojaNatureza_Encontrada() {
		return getAgregado().existeListaLojaNatureza_Encontrada();
	}
	public void criaVaziaListaLojaNatureza_Encontrada() {
		getAgregado().criaVaziaListaLojaNatureza_Encontrada();
	}
	public List<LojaNatureza> getListaLojaNatureza_Encontrada() 
	{
		return getAgregado().getListaLojaNatureza_Encontrada(); 
	} 
	public void setListaLojaNatureza_Encontrada(List<LojaNatureza> value) 
	{
		getAgregado().setListaLojaNatureza_Encontrada(value); 
	} 
	public void addListaLojaNatureza_Encontrada(LojaNatureza value) 
	{
		getAgregado().addListaLojaNatureza_Encontrada(value); 
	} 
	public LojaNatureza getCorrenteLojaNatureza_Encontrada()
	{
		return getAgregado().getCorrenteLojaNatureza_Encontrada(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaOportunidadeDia_Possui() {
		return getAgregado().existeListaOportunidadeDia_Possui();
	}
	public void criaVaziaListaOportunidadeDia_Possui() {
		getAgregado().criaVaziaListaOportunidadeDia_Possui();
	}
	public List<OportunidadeDia> getListaOportunidadeDia_Possui() 
	{
		return getAgregado().getListaOportunidadeDia_Possui(); 
	} 
	public void setListaOportunidadeDia_Possui(List<OportunidadeDia> value) 
	{
		getAgregado().setListaOportunidadeDia_Possui(value); 
	} 
	public void addListaOportunidadeDia_Possui(OportunidadeDia value) 
	{
		getAgregado().addListaOportunidadeDia_Possui(value); 
	} 
	public OportunidadeDia getCorrenteOportunidadeDia_Possui()
	{
		return getAgregado().getCorrenteOportunidadeDia_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaUsuarioPesquisa_PesquisadoPor() {
		return getAgregado().existeListaUsuarioPesquisa_PesquisadoPor();
	}
	public void criaVaziaListaUsuarioPesquisa_PesquisadoPor() {
		getAgregado().criaVaziaListaUsuarioPesquisa_PesquisadoPor();
	}
	public List<UsuarioPesquisa> getListaUsuarioPesquisa_PesquisadoPor() 
	{
		return getAgregado().getListaUsuarioPesquisa_PesquisadoPor(); 
	} 
	public void setListaUsuarioPesquisa_PesquisadoPor(List<UsuarioPesquisa> value) 
	{
		getAgregado().setListaUsuarioPesquisa_PesquisadoPor(value); 
	} 
	public void addListaUsuarioPesquisa_PesquisadoPor(UsuarioPesquisa value) 
	{
		getAgregado().addListaUsuarioPesquisa_PesquisadoPor(value); 
	} 
	public UsuarioPesquisa getCorrenteUsuarioPesquisa_PesquisadoPor()
	{
		return getAgregado().getCorrenteUsuarioPesquisa_PesquisadoPor(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaContagemProduto_Possui() {
		return getAgregado().existeListaContagemProduto_Possui();
	}
	public void criaVaziaListaContagemProduto_Possui() {
		getAgregado().criaVaziaListaContagemProduto_Possui();
	}
	public List<ContagemProduto> getListaContagemProduto_Possui() 
	{
		return getAgregado().getListaContagemProduto_Possui(); 
	} 
	public void setListaContagemProduto_Possui(List<ContagemProduto> value) 
	{
		getAgregado().setListaContagemProduto_Possui(value); 
	} 
	public void addListaContagemProduto_Possui(ContagemProduto value) 
	{
		getAgregado().addListaContagemProduto_Possui(value); 
	} 
	public ContagemProduto getCorrenteContagemProduto_Possui()
	{
		return getAgregado().getCorrenteContagemProduto_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaPalavraChavePesquisa_PodePesquisar() {
		return getAgregado().existeListaPalavraChavePesquisa_PodePesquisar();
	}
	public void criaVaziaListaPalavraChavePesquisa_PodePesquisar() {
		getAgregado().criaVaziaListaPalavraChavePesquisa_PodePesquisar();
	}
	public List<PalavraChavePesquisa> getListaPalavraChavePesquisa_PodePesquisar() 
	{
		return getAgregado().getListaPalavraChavePesquisa_PodePesquisar(); 
	} 
	public void setListaPalavraChavePesquisa_PodePesquisar(List<PalavraChavePesquisa> value) 
	{
		getAgregado().setListaPalavraChavePesquisa_PodePesquisar(value); 
	} 
	public void addListaPalavraChavePesquisa_PodePesquisar(PalavraChavePesquisa value) 
	{
		getAgregado().addListaPalavraChavePesquisa_PodePesquisar(value); 
	} 
	public PalavraChavePesquisa getCorrentePalavraChavePesquisa_PodePesquisar()
	{
		return getAgregado().getCorrentePalavraChavePesquisa_PodePesquisar(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaProdutoCliente_Possui() {
		return getAgregado().existeListaProdutoCliente_Possui();
	}
	public void criaVaziaListaProdutoCliente_Possui() {
		getAgregado().criaVaziaListaProdutoCliente_Possui();
	}
	public List<ProdutoCliente> getListaProdutoCliente_Possui() 
	{
		return getAgregado().getListaProdutoCliente_Possui(); 
	} 
	public void setListaProdutoCliente_Possui(List<ProdutoCliente> value) 
	{
		getAgregado().setListaProdutoCliente_Possui(value); 
	} 
	public void addListaProdutoCliente_Possui(ProdutoCliente value) 
	{
		getAgregado().addListaProdutoCliente_Possui(value); 
	} 
	public ProdutoCliente getCorrenteProdutoCliente_Possui()
	{
		return getAgregado().getCorrenteProdutoCliente_Possui(); 
	} 
	

	
	
	
	
	
	private long idNaturezaProduto;
	public long getIdNaturezaProduto()
	{
		return idNaturezaProduto;
	}
	public  void setIdNaturezaProduto(long value)
	{
		idNaturezaProduto = value; 
	}
	
	
	
	
	
	private String nomeNaturezaProduto;
	public String getNomeNaturezaProduto()
	{
		return nomeNaturezaProduto;
	}
	public  void setNomeNaturezaProduto(String value)
	{
		nomeNaturezaProduto = value; 
	}
	
	
	
	
	
	private String codigoNaturezaProduto;
	public String getCodigoNaturezaProduto()
	{
		return codigoNaturezaProduto;
	}
	public  void setCodigoNaturezaProduto(String value)
	{
		codigoNaturezaProduto = value; 
	}
	
	
	
	
		
	private long idAppProdutoAp;
	public long getIdAppProdutoAp() {
		// relacionamento
		if (idAppProdutoAp==0 && this.getAppProdutoAtendidoPor(false)!=null) 
			return getAppProdutoAtendidoPor(false).getIdObj();
		else
			return idAppProdutoAp;
	}
	public void setIdAppProdutoAp(long _valor) {
		idAppProdutoAp = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
