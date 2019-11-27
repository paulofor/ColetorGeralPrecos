package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class FacebookFanpageVo implements FacebookFanpage
{
		
	public long getIdObj()
    {
       return idFacebookFanpage;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdFacebookFanpage\" : \"" + idFacebookFanpage + "\" "
		+ ", \"Nome\" : \"" + nome + "\" "
		+ ", \"CodigoFacebook\" : \"" + codigoFacebook + "\" "
		+ ", \"NomeUrl\" : \"" + nomeUrl + "\" "
		+ ", \"QuantidadeDia\" : \"" + quantidadeDia + "\" "
		+ ", \"IdFacebookPerfilPa\" : \"" + idFacebookPerfilPa + "\" "
		+ ", \"IdAppProdutoD\" : \"" + idAppProdutoD + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private FacebookFanpageDerivada derivada = null;
	private FacebookFanpageDerivada getDerivada() {
		if (derivada==null) {
			derivada = new FacebookFanpageDerivada(this);
		}
		return derivada;
	}

	private FacebookFanpageAgregado agregado = null;
	private FacebookFanpageAgregado getAgregado() {
		if (agregado==null) {
			agregado = new FacebookFanpageAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public FacebookPerfil getFacebookPerfilPertenceA(boolean lazyLoader)
	{
		return getAgregado().getFacebookPerfilPertenceA(lazyLoader); 
	} 
	public void setFacebookPerfilPertenceA(FacebookPerfil value) 
	{
		getAgregado().setFacebookPerfilPertenceA(value); 
	} 
	/*
	public void setFacebookPerfilPertenceAComReversao(FacebookPerfil value) 
	{
		getAgregado().setFacebookPerfilPertenceAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaFacebookPerfil_PertenceA(FacebookPerfil value)
	{
		getAgregado().setFacebookPerfilPertenceA(value); 
	} 
	public FacebookPerfil getCorrenteFacebookPerfil_PertenceA()
	{
		return getAgregado().getFacebookPerfilPertenceA(false); 
	} 
	
	
	// Montador Tradicional
	public AppProduto getAppProdutoDivulga(boolean lazyLoader)
	{
		return getAgregado().getAppProdutoDivulga(lazyLoader); 
	} 
	public void setAppProdutoDivulga(AppProduto value) 
	{
		getAgregado().setAppProdutoDivulga(value); 
	} 
	/*
	public void setAppProdutoDivulgaComReversao(AppProduto value) 
	{
		getAgregado().setAppProdutoDivulgaComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaAppProduto_Divulga(AppProduto value)
	{
		getAgregado().setAppProdutoDivulga(value); 
	} 
	public AppProduto getCorrenteAppProduto_Divulga()
	{
		return getAgregado().getAppProdutoDivulga(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaFacebookPost_Tem() {
		return getAgregado().existeListaFacebookPost_Tem();
	}
	public void criaVaziaListaFacebookPost_Tem() {
		getAgregado().criaVaziaListaFacebookPost_Tem();
	}
	public List<FacebookPost> getListaFacebookPost_Tem() 
	{
		return getAgregado().getListaFacebookPost_Tem(); 
	} 
	public void setListaFacebookPost_Tem(List<FacebookPost> value) 
	{
		getAgregado().setListaFacebookPost_Tem(value); 
	} 
	public void addListaFacebookPost_Tem(FacebookPost value) 
	{
		getAgregado().addListaFacebookPost_Tem(value); 
	} 
	public FacebookPost getCorrenteFacebookPost_Tem()
	{
		return getAgregado().getCorrenteFacebookPost_Tem(); 
	} 
	

	
	
	
	
	
	private long idFacebookFanpage;
	public long getIdFacebookFanpage()
	{
		return idFacebookFanpage;
	}
	public  void setIdFacebookFanpage(long value)
	{
		idFacebookFanpage = value; 
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
	
	
	
	
	
	private String codigoFacebook;
	public String getCodigoFacebook()
	{
		return codigoFacebook;
	}
	public  void setCodigoFacebook(String value)
	{
		codigoFacebook = value; 
	}
	
	
	
	
	
	private String nomeUrl;
	public String getNomeUrl()
	{
		return nomeUrl;
	}
	public  void setNomeUrl(String value)
	{
		nomeUrl = value; 
	}
	
	
	
	
	
	private long quantidadeDia;
	public long getQuantidadeDia()
	{
		return quantidadeDia;
	}
	public  void setQuantidadeDia(long value)
	{
		quantidadeDia = value; 
	}
	
	
	
	
		
	private long idFacebookPerfilPa;
	public long getIdFacebookPerfilPa() {
		// relacionamento
		if (idFacebookPerfilPa==0 && this.getFacebookPerfilPertenceA(false)!=null) 
			return getFacebookPerfilPertenceA(false).getIdObj();
		else
			return idFacebookPerfilPa;
	}
	public void setIdFacebookPerfilPa(long _valor) {
		idFacebookPerfilPa = _valor;
	}
	
	
	
	
		
	private long idAppProdutoD;
	public long getIdAppProdutoD() {
		// relacionamento
		if (idAppProdutoD==0 && this.getAppProdutoDivulga(false)!=null) 
			return getAppProdutoDivulga(false).getIdObj();
		else
			return idAppProdutoD;
	}
	public void setIdAppProdutoD(long _valor) {
		idAppProdutoD = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
