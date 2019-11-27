package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class ModeloProdutoProdutoVo implements ModeloProdutoProduto
{
		
	public long getIdObj()
    {
       return idModeloProdutoProduto;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdModeloProdutoProduto\" : \"" + idModeloProdutoProduto + "\" "
		+ ", \"IdModeloProdutoRa\" : \"" + idModeloProdutoRa + "\" "
		+ ", \"IdProdutoRa\" : \"" + idProdutoRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private ModeloProdutoProdutoDerivada derivada = null;
	private ModeloProdutoProdutoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new ModeloProdutoProdutoDerivada(this);
		}
		return derivada;
	}

	private ModeloProdutoProdutoAgregado agregado = null;
	private ModeloProdutoProdutoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new ModeloProdutoProdutoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public ModeloProduto getModeloProdutoReferenteA(boolean lazyLoader)
	{
		return getAgregado().getModeloProdutoReferenteA(lazyLoader); 
	} 
	public void setModeloProdutoReferenteA(ModeloProduto value) 
	{
		getAgregado().setModeloProdutoReferenteA(value); 
	} 
	/*
	public void setModeloProdutoReferenteAComReversao(ModeloProduto value) 
	{
		getAgregado().setModeloProdutoReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaModeloProduto_ReferenteA(ModeloProduto value)
	{
		getAgregado().setModeloProdutoReferenteA(value); 
	} 
	public ModeloProduto getCorrenteModeloProduto_ReferenteA()
	{
		return getAgregado().getModeloProdutoReferenteA(false); 
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
	

	
	
	
	
	
	private long idModeloProdutoProduto;
	public long getIdModeloProdutoProduto()
	{
		return idModeloProdutoProduto;
	}
	public  void setIdModeloProdutoProduto(long value)
	{
		idModeloProdutoProduto = value; 
	}
	
	
	
	
		
	private long idModeloProdutoRa;
	public long getIdModeloProdutoRa() {
		// relacionamento
		if (idModeloProdutoRa==0 && this.getModeloProdutoReferenteA(false)!=null) 
			return getModeloProdutoReferenteA(false).getIdObj();
		else
			return idModeloProdutoRa;
	}
	public void setIdModeloProdutoRa(long _valor) {
		idModeloProdutoRa = _valor;
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
