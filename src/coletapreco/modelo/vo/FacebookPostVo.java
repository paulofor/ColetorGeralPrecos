package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class FacebookPostVo implements FacebookPost
{
		
	public long getIdObj()
    {
       return idFacebookPost;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdFacebookPost\" : \"" + idFacebookPost + "\" "
		+ ", \"DataHora\" : \"" + dataHora + "\" "
		+ ", \"CodigoFacebook\" : \"" + codigoFacebook + "\" "
		+ ", \"HorarioProgramacao\" : \"" + horarioProgramacao + "\" "
		+ ", \"IdFacebookFanpageFe\" : \"" + idFacebookFanpageFe + "\" "
		+ ", \"IdProdutoD\" : \"" + idProdutoD + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private FacebookPostDerivada derivada = null;
	private FacebookPostDerivada getDerivada() {
		if (derivada==null) {
			derivada = new FacebookPostDerivada(this);
		}
		return derivada;
	}

	private FacebookPostAgregado agregado = null;
	private FacebookPostAgregado getAgregado() {
		if (agregado==null) {
			agregado = new FacebookPostAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public FacebookFanpage getFacebookFanpageFeitoEm(boolean lazyLoader)
	{
		return getAgregado().getFacebookFanpageFeitoEm(lazyLoader); 
	} 
	public void setFacebookFanpageFeitoEm(FacebookFanpage value) 
	{
		getAgregado().setFacebookFanpageFeitoEm(value); 
	} 
	/*
	public void setFacebookFanpageFeitoEmComReversao(FacebookFanpage value) 
	{
		getAgregado().setFacebookFanpageFeitoEmComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaFacebookFanpage_FeitoEm(FacebookFanpage value)
	{
		getAgregado().setFacebookFanpageFeitoEm(value); 
	} 
	public FacebookFanpage getCorrenteFacebookFanpage_FeitoEm()
	{
		return getAgregado().getFacebookFanpageFeitoEm(false); 
	} 
	
	
	// Montador Tradicional
	public Produto getProdutoDivulgando(boolean lazyLoader)
	{
		return getAgregado().getProdutoDivulgando(lazyLoader); 
	} 
	public void setProdutoDivulgando(Produto value) 
	{
		getAgregado().setProdutoDivulgando(value); 
	} 
	/*
	public void setProdutoDivulgandoComReversao(Produto value) 
	{
		getAgregado().setProdutoDivulgandoComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaProduto_Divulgando(Produto value)
	{
		getAgregado().setProdutoDivulgando(value); 
	} 
	public Produto getCorrenteProduto_Divulgando()
	{
		return getAgregado().getProdutoDivulgando(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaFacebookPostPerformance_Gera() {
		return getAgregado().existeListaFacebookPostPerformance_Gera();
	}
	public void criaVaziaListaFacebookPostPerformance_Gera() {
		getAgregado().criaVaziaListaFacebookPostPerformance_Gera();
	}
	public List<FacebookPostPerformance> getListaFacebookPostPerformance_Gera() 
	{
		return getAgregado().getListaFacebookPostPerformance_Gera(); 
	} 
	public void setListaFacebookPostPerformance_Gera(List<FacebookPostPerformance> value) 
	{
		getAgregado().setListaFacebookPostPerformance_Gera(value); 
	} 
	public void addListaFacebookPostPerformance_Gera(FacebookPostPerformance value) 
	{
		getAgregado().addListaFacebookPostPerformance_Gera(value); 
	} 
	public FacebookPostPerformance getCorrenteFacebookPostPerformance_Gera()
	{
		return getAgregado().getCorrenteFacebookPostPerformance_Gera(); 
	} 
	

	
	
	
	
	
	private long idFacebookPost;
	public long getIdFacebookPost()
	{
		return idFacebookPost;
	}
	public  void setIdFacebookPost(long value)
	{
		idFacebookPost = value; 
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
	
	
	
	
	
	private String codigoFacebook;
	public String getCodigoFacebook()
	{
		return codigoFacebook;
	}
	public  void setCodigoFacebook(String value)
	{
		codigoFacebook = value; 
	}
	
	
	
	
	
	private String horarioProgramacao;
	public String getHorarioProgramacao()
	{
		return horarioProgramacao;
	}
	public  void setHorarioProgramacao(String value)
	{
		horarioProgramacao = value; 
	}
	
	
	
	
		
	private long idFacebookFanpageFe;
	public long getIdFacebookFanpageFe() {
		// relacionamento
		if (idFacebookFanpageFe==0 && this.getFacebookFanpageFeitoEm(false)!=null) 
			return getFacebookFanpageFeitoEm(false).getIdObj();
		else
			return idFacebookFanpageFe;
	}
	public void setIdFacebookFanpageFe(long _valor) {
		idFacebookFanpageFe = _valor;
	}
	
	
	
	
		
	private long idProdutoD;
	public long getIdProdutoD() {
		// relacionamento
		if (idProdutoD==0 && this.getProdutoDivulgando(false)!=null) 
			return getProdutoDivulgando(false).getIdObj();
		else
			return idProdutoD;
	}
	public void setIdProdutoD(long _valor) {
		idProdutoD = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
