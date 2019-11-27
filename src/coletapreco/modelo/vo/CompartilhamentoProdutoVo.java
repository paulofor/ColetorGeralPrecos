package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class CompartilhamentoProdutoVo implements CompartilhamentoProduto
{
		
	public long getIdObj()
    {
       return idCompartilhamentoProduto;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdCompartilhamentoProduto\" : \"" + idCompartilhamentoProduto + "\" "
		+ ", \"DataHora\" : \"" + dataHora + "\" "
		+ ", \"IdUsuarioPa\" : \"" + idUsuarioPa + "\" "
		+ ", \"IdProdutoRa\" : \"" + idProdutoRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private CompartilhamentoProdutoDerivada derivada = null;
	private CompartilhamentoProdutoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new CompartilhamentoProdutoDerivada(this);
		}
		return derivada;
	}

	private CompartilhamentoProdutoAgregado agregado = null;
	private CompartilhamentoProdutoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new CompartilhamentoProdutoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public Usuario getUsuarioPertenceA(boolean lazyLoader)
	{
		return getAgregado().getUsuarioPertenceA(lazyLoader); 
	} 
	public void setUsuarioPertenceA(Usuario value) 
	{
		getAgregado().setUsuarioPertenceA(value); 
	} 
	/*
	public void setUsuarioPertenceAComReversao(Usuario value) 
	{
		getAgregado().setUsuarioPertenceAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaUsuario_PertenceA(Usuario value)
	{
		getAgregado().setUsuarioPertenceA(value); 
	} 
	public Usuario getCorrenteUsuario_PertenceA()
	{
		return getAgregado().getUsuarioPertenceA(false); 
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
	

	
	
	
	
	
	private long idCompartilhamentoProduto;
	public long getIdCompartilhamentoProduto()
	{
		return idCompartilhamentoProduto;
	}
	public  void setIdCompartilhamentoProduto(long value)
	{
		idCompartilhamentoProduto = value; 
	}
	
	
	
	
	
	private String dataHora;
	public String getDataHora()
	{
		return dataHora;
	}
	public  void setDataHora(String value)
	{
		dataHora = value; 
	}
	
	
	
	
		
	private long idUsuarioPa;
	public long getIdUsuarioPa() {
		// relacionamento
		if (idUsuarioPa==0 && this.getUsuarioPertenceA(false)!=null) 
			return getUsuarioPertenceA(false).getIdObj();
		else
			return idUsuarioPa;
	}
	public void setIdUsuarioPa(long _valor) {
		idUsuarioPa = _valor;
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
