package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class PalavraProdutoVo implements PalavraProduto
{
		
	public long getIdObj()
    {
       return idPalavraProduto;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdPalavraProduto\" : \"" + idPalavraProduto + "\" "
		+ ", \"IdPalavraRa\" : \"" + idPalavraRa + "\" "
		+ ", \"IdProdutoRa\" : \"" + idProdutoRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private PalavraProdutoDerivada derivada = null;
	private PalavraProdutoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new PalavraProdutoDerivada(this);
		}
		return derivada;
	}

	private PalavraProdutoAgregado agregado = null;
	private PalavraProdutoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new PalavraProdutoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public Palavra getPalavraRelaciondoA(boolean lazyLoader)
	{
		return getAgregado().getPalavraRelaciondoA(lazyLoader); 
	} 
	public void setPalavraRelaciondoA(Palavra value) 
	{
		getAgregado().setPalavraRelaciondoA(value); 
	} 
	/*
	public void setPalavraRelaciondoAComReversao(Palavra value) 
	{
		getAgregado().setPalavraRelaciondoAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaPalavra_RelaciondoA(Palavra value)
	{
		getAgregado().setPalavraRelaciondoA(value); 
	} 
	public Palavra getCorrentePalavra_RelaciondoA()
	{
		return getAgregado().getPalavraRelaciondoA(false); 
	} 
	
	
	// Montador Tradicional
	public Produto getProdutoRelaciondoA(boolean lazyLoader)
	{
		return getAgregado().getProdutoRelaciondoA(lazyLoader); 
	} 
	public void setProdutoRelaciondoA(Produto value) 
	{
		getAgregado().setProdutoRelaciondoA(value); 
	} 
	/*
	public void setProdutoRelaciondoAComReversao(Produto value) 
	{
		getAgregado().setProdutoRelaciondoAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaProduto_RelaciondoA(Produto value)
	{
		getAgregado().setProdutoRelaciondoA(value); 
	} 
	public Produto getCorrenteProduto_RelaciondoA()
	{
		return getAgregado().getProdutoRelaciondoA(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idPalavraProduto;
	public long getIdPalavraProduto()
	{
		return idPalavraProduto;
	}
	public  void setIdPalavraProduto(long value)
	{
		idPalavraProduto = value; 
	}
	
	
	
	
		
	private long idPalavraRa;
	public long getIdPalavraRa() {
		// relacionamento
		if (idPalavraRa==0 && this.getPalavraRelaciondoA(false)!=null) 
			return getPalavraRelaciondoA(false).getIdObj();
		else
			return idPalavraRa;
	}
	public void setIdPalavraRa(long _valor) {
		idPalavraRa = _valor;
	}
	
	
	
	
		
	private long idProdutoRa;
	public long getIdProdutoRa() {
		// relacionamento
		if (idProdutoRa==0 && this.getProdutoRelaciondoA(false)!=null) 
			return getProdutoRelaciondoA(false).getIdObj();
		else
			return idProdutoRa;
	}
	public void setIdProdutoRa(long _valor) {
		idProdutoRa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
