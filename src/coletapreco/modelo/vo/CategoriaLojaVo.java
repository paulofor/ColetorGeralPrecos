package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class CategoriaLojaVo implements CategoriaLoja
{
		
	public long getIdObj()
    {
       return idCategoriaLoja;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdCategoriaLoja\" : \"" + idCategoriaLoja + "\" "
		+ ", \"Nome\" : \"" + nome + "\" "
		+ ", \"Url\" : \"" + url + "\" "
		+ ", \"DataInclusao\" : \"" + dataInclusao + "\" "
		+ ", \"IdCategoriaLojaF\" : \"" + idCategoriaLojaP + "\" "
		+ ", \"IdNaturezaProdutoRa\" : \"" + idNaturezaProdutoRa + "\" "
		+ ", \"IdLojaVirtualPa\" : \"" + idLojaVirtualPa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private CategoriaLojaDerivada derivada = null;
	private CategoriaLojaDerivada getDerivada() {
		if (derivada==null) {
			derivada = new CategoriaLojaDerivada(this);
		}
		return derivada;
	}

	private CategoriaLojaAgregado agregado = null;
	private CategoriaLojaAgregado getAgregado() {
		if (agregado==null) {
			agregado = new CategoriaLojaAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public CategoriaLoja getCategoriaLojaFilho(boolean lazyLoader)
	{
		return getAgregado().getCategoriaLojaFilho(lazyLoader); 
	} 
	public void setCategoriaLojaFilho(CategoriaLoja value) 
	{
		getAgregado().setCategoriaLojaFilho(value); 
	} 
	/*
	public void setCategoriaLojaFilhoComReversao(CategoriaLoja value) 
	{
		getAgregado().setCategoriaLojaFilhoComReversao(value); 
	} 
	*/
	
	/*  AutoRelacionamento
	
	// Montador Alternativo e Tradicional
	public void addListaCategoriaLoja_Filho(CategoriaLoja value)
	{
		getAgregado().setCategoriaLojaFilho(value); 
	} 
	public CategoriaLoja getCorrenteCategoriaLoja_Filho()
	{
		return getAgregado().getCategoriaLojaFilho(false); 
	} 
	
	*/
	
	
	// Montador Tradicional
	public NaturezaProduto getNaturezaProdutoReferenteA(boolean lazyLoader)
	{
		return getAgregado().getNaturezaProdutoReferenteA(lazyLoader); 
	} 
	public void setNaturezaProdutoReferenteA(NaturezaProduto value) 
	{
		getAgregado().setNaturezaProdutoReferenteA(value); 
	} 
	/*
	public void setNaturezaProdutoReferenteAComReversao(NaturezaProduto value) 
	{
		getAgregado().setNaturezaProdutoReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaNaturezaProduto_ReferenteA(NaturezaProduto value)
	{
		getAgregado().setNaturezaProdutoReferenteA(value); 
	} 
	public NaturezaProduto getCorrenteNaturezaProduto_ReferenteA()
	{
		return getAgregado().getNaturezaProdutoReferenteA(false); 
	} 
	
	
	// Montador Tradicional
	public LojaVirtual getLojaVirtualPertenceA(boolean lazyLoader)
	{
		return getAgregado().getLojaVirtualPertenceA(lazyLoader); 
	} 
	public void setLojaVirtualPertenceA(LojaVirtual value) 
	{
		getAgregado().setLojaVirtualPertenceA(value); 
	} 
	/*
	public void setLojaVirtualPertenceAComReversao(LojaVirtual value) 
	{
		getAgregado().setLojaVirtualPertenceAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaLojaVirtual_PertenceA(LojaVirtual value)
	{
		getAgregado().setLojaVirtualPertenceA(value); 
	} 
	public LojaVirtual getCorrenteLojaVirtual_PertenceA()
	{
		return getAgregado().getLojaVirtualPertenceA(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
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
	public boolean existeListaCategoriaLoja_Filho() {
		return getAgregado().existeListaCategoriaLoja_Filho();
	}
	public void criaVaziaListaCategoriaLoja_Filho() {
		getAgregado().criaVaziaListaCategoriaLoja_Filho();
	}
	public List<CategoriaLoja> getListaCategoriaLoja_Filho() 
	{
		return getAgregado().getListaCategoriaLoja_Filho(); 
	} 
	public void setListaCategoriaLoja_Filho(List<CategoriaLoja> value) 
	{
		getAgregado().setListaCategoriaLoja_Filho(value); 
	} 
	public void addListaCategoriaLoja_Filho(CategoriaLoja value) 
	{
		getAgregado().addListaCategoriaLoja_Filho(value); 
	} 
	public CategoriaLoja getCorrenteCategoriaLoja_Filho()
	{
		return getAgregado().getCorrenteCategoriaLoja_Filho(); 
	} 
	

	
	
	
	
	
	private long idCategoriaLoja;
	public long getIdCategoriaLoja()
	{
		return idCategoriaLoja;
	}
	public  void setIdCategoriaLoja(long value)
	{
		idCategoriaLoja = value; 
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
	
	
	
	
	
	private String url;
	public String getUrl()
	{
		return url;
	}
	public  void setUrl(String value)
	{
		url = value; 
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
	
	
	
	
		
	private long idCategoriaLojaP;
	public long getIdCategoriaLojaF() {
		// relacionamento
		if (idCategoriaLojaP==0 && this.getCategoriaLojaFilho(false)!=null) 
			return getCategoriaLojaFilho(false).getIdObj();
		else
			return idCategoriaLojaP;
	}
	public void setIdCategoriaLojaF(long _valor) {
		idCategoriaLojaP = _valor;
	}
	
	
	
	
		
	private long idNaturezaProdutoRa;
	public long getIdNaturezaProdutoRa() {
		// relacionamento
		if (idNaturezaProdutoRa==0 && this.getNaturezaProdutoReferenteA(false)!=null) 
			return getNaturezaProdutoReferenteA(false).getIdObj();
		else
			return idNaturezaProdutoRa;
	}
	public void setIdNaturezaProdutoRa(long _valor) {
		idNaturezaProdutoRa = _valor;
	}
	
	
	
	
		
	private long idLojaVirtualPa;
	public long getIdLojaVirtualPa() {
		// relacionamento
		if (idLojaVirtualPa==0 && this.getLojaVirtualPertenceA(false)!=null) 
			return getLojaVirtualPertenceA(false).getIdObj();
		else
			return idLojaVirtualPa;
	}
	public void setIdLojaVirtualPa(long _valor) {
		idLojaVirtualPa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
