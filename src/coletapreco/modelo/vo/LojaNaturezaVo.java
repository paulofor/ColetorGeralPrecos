package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class LojaNaturezaVo implements LojaNatureza
{
		
	public long getIdObj()
    {
       return idLojaNatureza;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdLojaNatureza\" : \"" + idLojaNatureza + "\" "
		+ ", \"UrlInicial\" : \"" + urlInicial + "\" "
		+ ", \"ParseCategoria\" : \"" + parseCategoria + "\" "
		+ ", \"IdLojaVirtualRa\" : \"" + idLojaVirtualRa + "\" "
		+ ", \"IdNaturezaProdutoRa\" : \"" + idNaturezaProdutoRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private LojaNaturezaDerivada derivada = null;
	private LojaNaturezaDerivada getDerivada() {
		if (derivada==null) {
			derivada = new LojaNaturezaDerivada(this);
		}
		return derivada;
	}

	private LojaNaturezaAgregado agregado = null;
	private LojaNaturezaAgregado getAgregado() {
		if (agregado==null) {
			agregado = new LojaNaturezaAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public LojaVirtual getLojaVirtualReferenteA(boolean lazyLoader)
	{
		return getAgregado().getLojaVirtualReferenteA(lazyLoader); 
	} 
	public void setLojaVirtualReferenteA(LojaVirtual value) 
	{
		getAgregado().setLojaVirtualReferenteA(value); 
	} 
	/*
	public void setLojaVirtualReferenteAComReversao(LojaVirtual value) 
	{
		getAgregado().setLojaVirtualReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaLojaVirtual_ReferenteA(LojaVirtual value)
	{
		getAgregado().setLojaVirtualReferenteA(value); 
	} 
	public LojaVirtual getCorrenteLojaVirtual_ReferenteA()
	{
		return getAgregado().getLojaVirtualReferenteA(false); 
	} 
	
	
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
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idLojaNatureza;
	public long getIdLojaNatureza()
	{
		return idLojaNatureza;
	}
	public  void setIdLojaNatureza(long value)
	{
		idLojaNatureza = value; 
	}
	
	
	
	
	
	private String urlInicial;
	public String getUrlInicial()
	{
		return urlInicial;
	}
	public  void setUrlInicial(String value)
	{
		urlInicial = value; 
	}
	
	
	
	
	
	private boolean parseCategoria;
	public boolean getParseCategoria()
	{
		return parseCategoria;
	}
	public  void setParseCategoria(boolean value)
	{
		parseCategoria = value; 
	}
	
	
	
	
		
	private long idLojaVirtualRa;
	public long getIdLojaVirtualRa() {
		// relacionamento
		if (idLojaVirtualRa==0 && this.getLojaVirtualReferenteA(false)!=null) 
			return getLojaVirtualReferenteA(false).getIdObj();
		else
			return idLojaVirtualRa;
	}
	public void setIdLojaVirtualRa(long _valor) {
		idLojaVirtualRa = _valor;
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
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
