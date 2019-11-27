package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class OportunidadeInteresseClienteVo implements OportunidadeInteresseCliente
{
		
	public long getIdObj()
    {
       return idOportunidadeInteresseCliente;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdOportunidadeInteresseCliente\" : \"" + idOportunidadeInteresseCliente + "\" "
		+ ", \"IdProdutoClientePa\" : \"" + idProdutoClientePa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private OportunidadeInteresseClienteDerivada derivada = null;
	private OportunidadeInteresseClienteDerivada getDerivada() {
		if (derivada==null) {
			derivada = new OportunidadeInteresseClienteDerivada(this);
		}
		return derivada;
	}

	private OportunidadeInteresseClienteAgregado agregado = null;
	private OportunidadeInteresseClienteAgregado getAgregado() {
		if (agregado==null) {
			agregado = new OportunidadeInteresseClienteAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public ProdutoCliente getProdutoClientePertenceA(boolean lazyLoader)
	{
		return getAgregado().getProdutoClientePertenceA(lazyLoader); 
	} 
	public void setProdutoClientePertenceA(ProdutoCliente value) 
	{
		getAgregado().setProdutoClientePertenceA(value); 
	} 
	/*
	public void setProdutoClientePertenceAComReversao(ProdutoCliente value) 
	{
		getAgregado().setProdutoClientePertenceAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaProdutoCliente_PertenceA(ProdutoCliente value)
	{
		getAgregado().setProdutoClientePertenceA(value); 
	} 
	public ProdutoCliente getCorrenteProdutoCliente_PertenceA()
	{
		return getAgregado().getProdutoClientePertenceA(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idOportunidadeInteresseCliente;
	public long getIdOportunidadeInteresseCliente()
	{
		return idOportunidadeInteresseCliente;
	}
	public  void setIdOportunidadeInteresseCliente(long value)
	{
		idOportunidadeInteresseCliente = value; 
	}
	
	
	
	
		
	private long idProdutoClientePa;
	public long getIdProdutoClientePa() {
		// relacionamento
		if (idProdutoClientePa==0 && this.getProdutoClientePertenceA(false)!=null) 
			return getProdutoClientePertenceA(false).getIdObj();
		else
			return idProdutoClientePa;
	}
	public void setIdProdutoClientePa(long _valor) {
		idProdutoClientePa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
