package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class CategoriaLojaProdutoVo implements CategoriaLojaProduto
{
		
	public long getIdObj()
    {
       return idCategoriaLojaProduto;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdCategoriaLojaProduto\" : \"" + idCategoriaLojaProduto + "\" "
		+ ", \"DataUltimaVisita\" : \"" + dataUltimaVisita + "\" "
		+ ", \"IdCategoriaLojaRa\" : \"" + idCategoriaLojaRa + "\" "
		+ ", \"IdProdutoRa\" : \"" + idProdutoRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private CategoriaLojaProdutoDerivada derivada = null;
	private CategoriaLojaProdutoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new CategoriaLojaProdutoDerivada(this);
		}
		return derivada;
	}

	private CategoriaLojaProdutoAgregado agregado = null;
	private CategoriaLojaProdutoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new CategoriaLojaProdutoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public CategoriaLoja getCategoriaLojaReferenteA(boolean lazyLoader)
	{
		return getAgregado().getCategoriaLojaReferenteA(lazyLoader); 
	} 
	public void setCategoriaLojaReferenteA(CategoriaLoja value) 
	{
		getAgregado().setCategoriaLojaReferenteA(value); 
	} 
	/*
	public void setCategoriaLojaReferenteAComReversao(CategoriaLoja value) 
	{
		getAgregado().setCategoriaLojaReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaCategoriaLoja_ReferenteA(CategoriaLoja value)
	{
		getAgregado().setCategoriaLojaReferenteA(value); 
	} 
	public CategoriaLoja getCorrenteCategoriaLoja_ReferenteA()
	{
		return getAgregado().getCategoriaLojaReferenteA(false); 
	} 
	
	
	// Montador Tradicional
	public Produto getProdutoReferenteA(boolean lazyLoader)
	{
		return getAgregado().getProdutoReferenteA(lazyLoader); 
	} 
	public void setProdutoReferenteA(Produto value) 
	{
		getAgregado().setProdutoReferenteA(value); 
	} 
	/*
	public void setProdutoReferenteAComReversao(Produto value) 
	{
		getAgregado().setProdutoReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaProduto_ReferenteA(Produto value)
	{
		getAgregado().setProdutoReferenteA(value); 
	} 
	public Produto getCorrenteProduto_ReferenteA()
	{
		return getAgregado().getProdutoReferenteA(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idCategoriaLojaProduto;
	public long getIdCategoriaLojaProduto()
	{
		return idCategoriaLojaProduto;
	}
	public  void setIdCategoriaLojaProduto(long value)
	{
		idCategoriaLojaProduto = value; 
	}
	
	
	
	
	
	private String dataUltimaVisita;
	public String getDataUltimaVisita()
	{
		return dataUltimaVisita;
	}
	public  void setDataUltimaVisita(String value)
	{
		dataUltimaVisita = value; 
	}
	
	
	
	
		
	private long idCategoriaLojaRa;
	public long getIdCategoriaLojaRa() {
		// relacionamento
		if (idCategoriaLojaRa==0 && this.getCategoriaLojaReferenteA(false)!=null) 
			return getCategoriaLojaReferenteA(false).getIdObj();
		else
			return idCategoriaLojaRa;
	}
	public void setIdCategoriaLojaRa(long _valor) {
		idCategoriaLojaRa = _valor;
	}
	
	
	
	
		
	private long idProdutoRa;
	public long getIdProdutoRa() {
		// relacionamento
		if (idProdutoRa==0 && this.getProdutoReferenteA(false)!=null) 
			return getProdutoReferenteA(false).getIdObj();
		else
			return idProdutoRa;
	}
	public void setIdProdutoRa(long _valor) {
		idProdutoRa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
