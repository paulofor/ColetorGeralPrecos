package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class FacebookPerfilVo implements FacebookPerfil
{
		
	public long getIdObj()
    {
       return idFacebookPerfil;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdFacebookPerfil\" : \"" + idFacebookPerfil + "\" "
		+ ", \"TokenAcesso\" : \"" + tokenAcesso + "\" "
		+ ", \"EmailUtilizado\" : \"" + emailUtilizado + "\" "
		+ ", \"Nome\" : \"" + nome + "\" "
		+ ", \"Sobrenome\" : \"" + sobrenome + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private FacebookPerfilDerivada derivada = null;
	private FacebookPerfilDerivada getDerivada() {
		if (derivada==null) {
			derivada = new FacebookPerfilDerivada(this);
		}
		return derivada;
	}

	private FacebookPerfilAgregado agregado = null;
	private FacebookPerfilAgregado getAgregado() {
		if (agregado==null) {
			agregado = new FacebookPerfilAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaFacebookFanpage_Possui() {
		return getAgregado().existeListaFacebookFanpage_Possui();
	}
	public void criaVaziaListaFacebookFanpage_Possui() {
		getAgregado().criaVaziaListaFacebookFanpage_Possui();
	}
	public List<FacebookFanpage> getListaFacebookFanpage_Possui() 
	{
		return getAgregado().getListaFacebookFanpage_Possui(); 
	} 
	public void setListaFacebookFanpage_Possui(List<FacebookFanpage> value) 
	{
		getAgregado().setListaFacebookFanpage_Possui(value); 
	} 
	public void addListaFacebookFanpage_Possui(FacebookFanpage value) 
	{
		getAgregado().addListaFacebookFanpage_Possui(value); 
	} 
	public FacebookFanpage getCorrenteFacebookFanpage_Possui()
	{
		return getAgregado().getCorrenteFacebookFanpage_Possui(); 
	} 
	

	
	
	
	
	
	private long idFacebookPerfil;
	public long getIdFacebookPerfil()
	{
		return idFacebookPerfil;
	}
	public  void setIdFacebookPerfil(long value)
	{
		idFacebookPerfil = value; 
	}
	
	
	
	
	
	private String tokenAcesso;
	public String getTokenAcesso()
	{
		return tokenAcesso;
	}
	public  void setTokenAcesso(String value)
	{
		tokenAcesso = value; 
	}
	
	
	
	
	
	private String emailUtilizado;
	public String getEmailUtilizado()
	{
		return emailUtilizado;
	}
	public  void setEmailUtilizado(String value)
	{
		emailUtilizado = value; 
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
	
	
	
	
	
	private String sobrenome;
	public String getSobrenome()
	{
		return sobrenome;
	}
	public  void setSobrenome(String value)
	{
		sobrenome = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
