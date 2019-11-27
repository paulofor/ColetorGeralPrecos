package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class LojaVirtualVo implements LojaVirtual
{
		
	public long getIdObj()
    {
       return idLojaVirtual;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdLojaVirtual\" : \"" + idLojaVirtual + "\" "
		+ ", \"NomeLojaVirtual\" : \"" + nomeLojaVirtual + "\" "
		+ ", \"UrlInicialBrinquedo\" : \"" + urlInicialBrinquedo + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private LojaVirtualDerivada derivada = null;
	private LojaVirtualDerivada getDerivada() {
		if (derivada==null) {
			derivada = new LojaVirtualDerivada(this);
		}
		return derivada;
	}

	private LojaVirtualAgregado agregado = null;
	private LojaVirtualAgregado getAgregado() {
		if (agregado==null) {
			agregado = new LojaVirtualAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaProduto_Possui() {
		return getAgregado().existeListaProduto_Possui();
	}
	public void criaVaziaListaProduto_Possui() {
		getAgregado().criaVaziaListaProduto_Possui();
	}
	public List<Produto> getListaProduto_Possui() 
	{
		return getAgregado().getListaProduto_Possui(); 
	} 
	public void setListaProduto_Possui(List<Produto> value) 
	{
		getAgregado().setListaProduto_Possui(value); 
	} 
	public void addListaProduto_Possui(Produto value) 
	{
		getAgregado().addListaProduto_Possui(value); 
	} 
	public Produto getCorrenteProduto_Possui()
	{
		return getAgregado().getCorrenteProduto_Possui(); 
	} 
	
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
	public boolean existeListaLojaNatureza_Oferece() {
		return getAgregado().existeListaLojaNatureza_Oferece();
	}
	public void criaVaziaListaLojaNatureza_Oferece() {
		getAgregado().criaVaziaListaLojaNatureza_Oferece();
	}
	public List<LojaNatureza> getListaLojaNatureza_Oferece() 
	{
		return getAgregado().getListaLojaNatureza_Oferece(); 
	} 
	public void setListaLojaNatureza_Oferece(List<LojaNatureza> value) 
	{
		getAgregado().setListaLojaNatureza_Oferece(value); 
	} 
	public void addListaLojaNatureza_Oferece(LojaNatureza value) 
	{
		getAgregado().addListaLojaNatureza_Oferece(value); 
	} 
	public LojaNatureza getCorrenteLojaNatureza_Oferece()
	{
		return getAgregado().getCorrenteLojaNatureza_Oferece(); 
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
	

	
	
	
	
	
	private long idLojaVirtual;
	public long getIdLojaVirtual()
	{
		return idLojaVirtual;
	}
	public  void setIdLojaVirtual(long value)
	{
		idLojaVirtual = value; 
	}
	
	
	
	
	
	private String nomeLojaVirtual;
	public String getNomeLojaVirtual()
	{
		return nomeLojaVirtual;
	}
	public  void setNomeLojaVirtual(String value)
	{
		nomeLojaVirtual = value; 
	}
	
	
	
	
	
	private String urlInicialBrinquedo;
	public String getUrlInicialBrinquedo()
	{
		return urlInicialBrinquedo;
	}
	public  void setUrlInicialBrinquedo(String value)
	{
		urlInicialBrinquedo = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
