package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class UsuarioPesquisaVo implements UsuarioPesquisa
{
		
	public long getIdObj()
    {
       return idUsuarioPesquisa;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdUsuarioPesquisa\" : \"" + idUsuarioPesquisa + "\" "
		+ ", \"IdUsuarioS\" : \"" + idUsuarioS + "\" "
		+ ", \"IdNaturezaProdutoP\" : \"" + idNaturezaProdutoP + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private UsuarioPesquisaDerivada derivada = null;
	private UsuarioPesquisaDerivada getDerivada() {
		if (derivada==null) {
			derivada = new UsuarioPesquisaDerivada(this);
		}
		return derivada;
	}

	private UsuarioPesquisaAgregado agregado = null;
	private UsuarioPesquisaAgregado getAgregado() {
		if (agregado==null) {
			agregado = new UsuarioPesquisaAgregado(this);
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
	public NaturezaProduto getNaturezaProdutoPesquisa(boolean lazyLoader)
	{
		return getAgregado().getNaturezaProdutoPesquisa(lazyLoader); 
	} 
	public void setNaturezaProdutoPesquisa(NaturezaProduto value) 
	{
		getAgregado().setNaturezaProdutoPesquisa(value); 
	} 
	/*
	public void setNaturezaProdutoPesquisaComReversao(NaturezaProduto value) 
	{
		getAgregado().setNaturezaProdutoPesquisaComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaNaturezaProduto_Pesquisa(NaturezaProduto value)
	{
		getAgregado().setNaturezaProdutoPesquisa(value); 
	} 
	public NaturezaProduto getCorrenteNaturezaProduto_Pesquisa()
	{
		return getAgregado().getNaturezaProdutoPesquisa(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idUsuarioPesquisa;
	public long getIdUsuarioPesquisa()
	{
		return idUsuarioPesquisa;
	}
	public  void setIdUsuarioPesquisa(long value)
	{
		idUsuarioPesquisa = value; 
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
	
	
	
	
		
	private long idNaturezaProdutoP;
	public long getIdNaturezaProdutoP() {
		// relacionamento
		if (idNaturezaProdutoP==0 && this.getNaturezaProdutoPesquisa(false)!=null) 
			return getNaturezaProdutoPesquisa(false).getIdObj();
		else
			return idNaturezaProdutoP;
	}
	public void setIdNaturezaProdutoP(long _valor) {
		idNaturezaProdutoP = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
