package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class PrecoDiarioClienteVo implements PrecoDiarioCliente
{
		
	public long getIdObj()
    {
       return idPrecoDiarioClientte;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdPrecoDiarioClientte\" : \"" + idPrecoDiarioClientte + "\" "
		+ ", \"DataHora\" : \"" + dataHora + "\" "
		+ ", \"PrecoVenda\" : \"" + precoVenda + "\" "
		+ ", \"IdProdutoClientePa\" : \"" + idProdutoClientePa + "\" "
		+ ", \"IdUsuarioS\" : \"" + idUsuarioS + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private PrecoDiarioClienteDerivada derivada = null;
	private PrecoDiarioClienteDerivada getDerivada() {
		if (derivada==null) {
			derivada = new PrecoDiarioClienteDerivada(this);
		}
		return derivada;
	}

	private PrecoDiarioClienteAgregado agregado = null;
	private PrecoDiarioClienteAgregado getAgregado() {
		if (agregado==null) {
			agregado = new PrecoDiarioClienteAgregado(this);
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
	
	
	// Montador Tradicional
	public Usuario getUsuarioSincroniza(boolean lazyLoader)
	{
		return getAgregado().getUsuarioSincroniza(lazyLoader); 
	} 
	public void setUsuarioSincroniza(Usuario value) 
	{
		getAgregado().setUsuarioSincroniza(value); 
	} 
	/*
	public void setUsuarioSincronizaComReversao(Usuario value) 
	{
		getAgregado().setUsuarioSincronizaComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaUsuario_Sincroniza(Usuario value)
	{
		getAgregado().setUsuarioSincroniza(value); 
	} 
	public Usuario getCorrenteUsuario_Sincroniza()
	{
		return getAgregado().getUsuarioSincroniza(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idPrecoDiarioClientte;
	public long getIdPrecoDiarioClientte()
	{
		return idPrecoDiarioClientte;
	}
	public  void setIdPrecoDiarioClientte(long value)
	{
		idPrecoDiarioClientte = value; 
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
	
	
	
	public String getPrecoVendaFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoVenda);
	}
	
	
	
	private float precoVenda;
	public float getPrecoVenda()
	{
		return precoVenda;
	}
	public  void setPrecoVenda(float value)
	{
		precoVenda = value; 
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
	
	
	
	
		
	private long idUsuarioS;
	public long getIdUsuarioS() {
		// relacionamento
		if (idUsuarioS==0 && this.getUsuarioSincroniza(false)!=null) 
			return getUsuarioSincroniza(false).getIdObj();
		else
			return idUsuarioS;
	}
	public void setIdUsuarioS(long _valor) {
		idUsuarioS = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
