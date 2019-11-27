package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class FacebookPostPerformanceVo implements FacebookPostPerformance
{
		
	public long getIdObj()
    {
       return idFacebookPostPerformance;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdFacebookPostPerformance\" : \"" + idFacebookPostPerformance + "\" "
		+ ", \"Data\" : \"" + data + "\" "
		+ ", \"Alcance\" : \"" + alcance + "\" "
		+ ", \"IdFacebookPostRa\" : \"" + idFacebookPostRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private FacebookPostPerformanceDerivada derivada = null;
	private FacebookPostPerformanceDerivada getDerivada() {
		if (derivada==null) {
			derivada = new FacebookPostPerformanceDerivada(this);
		}
		return derivada;
	}

	private FacebookPostPerformanceAgregado agregado = null;
	private FacebookPostPerformanceAgregado getAgregado() {
		if (agregado==null) {
			agregado = new FacebookPostPerformanceAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public FacebookPost getFacebookPostReferenteA(boolean lazyLoader)
	{
		return getAgregado().getFacebookPostReferenteA(lazyLoader); 
	} 
	public void setFacebookPostReferenteA(FacebookPost value) 
	{
		getAgregado().setFacebookPostReferenteA(value); 
	} 
	/*
	public void setFacebookPostReferenteAComReversao(FacebookPost value) 
	{
		getAgregado().setFacebookPostReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaFacebookPost_ReferenteA(FacebookPost value)
	{
		getAgregado().setFacebookPostReferenteA(value); 
	} 
	public FacebookPost getCorrenteFacebookPost_ReferenteA()
	{
		return getAgregado().getFacebookPostReferenteA(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idFacebookPostPerformance;
	public long getIdFacebookPostPerformance()
	{
		return idFacebookPostPerformance;
	}
	public  void setIdFacebookPostPerformance(long value)
	{
		idFacebookPostPerformance = value; 
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
	
	
	
	
	
	private long alcance;
	public long getAlcance()
	{
		return alcance;
	}
	public  void setAlcance(long value)
	{
		alcance = value; 
	}
	
	
	
	
		
	private long idFacebookPostRa;
	public long getIdFacebookPostRa() {
		// relacionamento
		if (idFacebookPostRa==0 && this.getFacebookPostReferenteA(false)!=null) 
			return getFacebookPostReferenteA(false).getIdObj();
		else
			return idFacebookPostRa;
	}
	public void setIdFacebookPostRa(long _valor) {
		idFacebookPostRa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
