package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class PalavraChavePesquisaVo implements PalavraChavePesquisa
{
		
	public long getIdObj()
    {
       return idPalavraChavePesquisa;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdPalavraChavePesquisa\" : \"" + idPalavraChavePesquisa + "\" "
		+ ", \"TextoBusca\" : \"" + textoBusca + "\" "
		+ ", \"Data\" : \"" + data + "\" "
		+ ", \"IdUsuarioS\" : \"" + idUsuarioS + "\" "
		+ ", \"IdNaturezaProdutoRa\" : \"" + idNaturezaProdutoRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private PalavraChavePesquisaDerivada derivada = null;
	private PalavraChavePesquisaDerivada getDerivada() {
		if (derivada==null) {
			derivada = new PalavraChavePesquisaDerivada(this);
		}
		return derivada;
	}

	private PalavraChavePesquisaAgregado agregado = null;
	private PalavraChavePesquisaAgregado getAgregado() {
		if (agregado==null) {
			agregado = new PalavraChavePesquisaAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
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
	
	// Montador Alternativo
	public boolean existeListaProdutoCliente_Gerou() {
		return getAgregado().existeListaProdutoCliente_Gerou();
	}
	public void criaVaziaListaProdutoCliente_Gerou() {
		getAgregado().criaVaziaListaProdutoCliente_Gerou();
	}
	public List<ProdutoCliente> getListaProdutoCliente_Gerou() 
	{
		return getAgregado().getListaProdutoCliente_Gerou(); 
	} 
	public void setListaProdutoCliente_Gerou(List<ProdutoCliente> value) 
	{
		getAgregado().setListaProdutoCliente_Gerou(value); 
	} 
	public void addListaProdutoCliente_Gerou(ProdutoCliente value) 
	{
		getAgregado().addListaProdutoCliente_Gerou(value); 
	} 
	public ProdutoCliente getCorrenteProdutoCliente_Gerou()
	{
		return getAgregado().getCorrenteProdutoCliente_Gerou(); 
	} 
	

	
	
	
	
	
	private long idPalavraChavePesquisa;
	public long getIdPalavraChavePesquisa()
	{
		return idPalavraChavePesquisa;
	}
	public  void setIdPalavraChavePesquisa(long value)
	{
		idPalavraChavePesquisa = value; 
	}
	
	
	
	
	
	private String textoBusca;
	public String getTextoBusca()
	{
		return textoBusca;
	}
	public  void setTextoBusca(String value)
	{
		textoBusca = value; 
	}
	
	
	
	
	
	private String data;
	public String getData()
	{
		return data;
	}
	public  void setData(String value)
	{
		data = value; 
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
