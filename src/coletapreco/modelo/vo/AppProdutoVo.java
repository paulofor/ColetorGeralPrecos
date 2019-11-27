package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class AppProdutoVo implements AppProduto
{
		
	public long getIdObj()
    {
       return idAppProduto;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdAppProduto\" : \"" + idAppProduto + "\" "
		+ ", \"Nome\" : \"" + nome + "\" "
		+ ", \"UrlInstalacao\" : \"" + urlInstalacao + "\" "
		+ ", \"PossuiVitrine\" : \"" + possuiVitrine + "\" "
		+ ", \"Ativo\" : \"" + ativo + "\" "
		+ ", \"Status\" : \"" + status + "\" "
		+ ", \"LimitePosicionador\" : \"" + limitePosicionador + "\" "
		+ ", \"PossuiPalavraChave\" : \"" + possuiPalavraChave + "\" "
		+ ", \"CodigoHash\" : \"" + codigoHash + "\" "
		+ ", \"ApiKey\" : \"" + apiKey + "\" "
		+ ", \"DiasPrecoVitrine\" : \"" + diasPrecoVitrine + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private AppProdutoDerivada derivada = null;
	private AppProdutoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new AppProdutoDerivada(this);
		}
		return derivada;
	}

	private AppProdutoAgregado agregado = null;
	private AppProdutoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new AppProdutoAgregado(this);
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
	public boolean existeListaFacebookFanpage_DivulgadoPor() {
		return getAgregado().existeListaFacebookFanpage_DivulgadoPor();
	}
	public void criaVaziaListaFacebookFanpage_DivulgadoPor() {
		getAgregado().criaVaziaListaFacebookFanpage_DivulgadoPor();
	}
	public List<FacebookFanpage> getListaFacebookFanpage_DivulgadoPor() 
	{
		return getAgregado().getListaFacebookFanpage_DivulgadoPor(); 
	} 
	public void setListaFacebookFanpage_DivulgadoPor(List<FacebookFanpage> value) 
	{
		getAgregado().setListaFacebookFanpage_DivulgadoPor(value); 
	} 
	public void addListaFacebookFanpage_DivulgadoPor(FacebookFanpage value) 
	{
		getAgregado().addListaFacebookFanpage_DivulgadoPor(value); 
	} 
	public FacebookFanpage getCorrenteFacebookFanpage_DivulgadoPor()
	{
		return getAgregado().getCorrenteFacebookFanpage_DivulgadoPor(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaNaturezaProduto_Atende() {
		return getAgregado().existeListaNaturezaProduto_Atende();
	}
	public void criaVaziaListaNaturezaProduto_Atende() {
		getAgregado().criaVaziaListaNaturezaProduto_Atende();
	}
	public List<NaturezaProduto> getListaNaturezaProduto_Atende() 
	{
		return getAgregado().getListaNaturezaProduto_Atende(); 
	} 
	public void setListaNaturezaProduto_Atende(List<NaturezaProduto> value) 
	{
		getAgregado().setListaNaturezaProduto_Atende(value); 
	} 
	public void addListaNaturezaProduto_Atende(NaturezaProduto value) 
	{
		getAgregado().addListaNaturezaProduto_Atende(value); 
	} 
	public NaturezaProduto getCorrenteNaturezaProduto_Atende()
	{
		return getAgregado().getCorrenteNaturezaProduto_Atende(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaDispositivoUsuario_UsadoPor() {
		return getAgregado().existeListaDispositivoUsuario_UsadoPor();
	}
	public void criaVaziaListaDispositivoUsuario_UsadoPor() {
		getAgregado().criaVaziaListaDispositivoUsuario_UsadoPor();
	}
	public List<DispositivoUsuario> getListaDispositivoUsuario_UsadoPor() 
	{
		return getAgregado().getListaDispositivoUsuario_UsadoPor(); 
	} 
	public void setListaDispositivoUsuario_UsadoPor(List<DispositivoUsuario> value) 
	{
		getAgregado().setListaDispositivoUsuario_UsadoPor(value); 
	} 
	public void addListaDispositivoUsuario_UsadoPor(DispositivoUsuario value) 
	{
		getAgregado().addListaDispositivoUsuario_UsadoPor(value); 
	} 
	public DispositivoUsuario getCorrenteDispositivoUsuario_UsadoPor()
	{
		return getAgregado().getCorrenteDispositivoUsuario_UsadoPor(); 
	} 
	

	
	
	
	
	
	private long idAppProduto;
	public long getIdAppProduto()
	{
		return idAppProduto;
	}
	public  void setIdAppProduto(long value)
	{
		idAppProduto = value; 
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
	
	
	
	
	
	private String urlInstalacao;
	public String getUrlInstalacao()
	{
		return urlInstalacao;
	}
	public  void setUrlInstalacao(String value)
	{
		urlInstalacao = value; 
	}
	
	
	
	
	
	private boolean possuiVitrine;
	public boolean getPossuiVitrine()
	{
		return possuiVitrine;
	}
	public  void setPossuiVitrine(boolean value)
	{
		possuiVitrine = value; 
	}
	
	
	
	
	
	private boolean ativo;
	public boolean getAtivo()
	{
		return ativo;
	}
	public  void setAtivo(boolean value)
	{
		ativo = value; 
	}
	
	
	
	
	
	private String status;
	public String getStatus()
	{
		return status;
	}
	public  void setStatus(String value)
	{
		status = value; 
	}
	
	
	
	
	
	private long limitePosicionador;
	public long getLimitePosicionador()
	{
		return limitePosicionador;
	}
	public  void setLimitePosicionador(long value)
	{
		limitePosicionador = value; 
	}
	
	
	
	
	
	private boolean possuiPalavraChave;
	public boolean getPossuiPalavraChave()
	{
		return possuiPalavraChave;
	}
	public  void setPossuiPalavraChave(boolean value)
	{
		possuiPalavraChave = value; 
	}
	
	
	
	
	
	private String codigoHash;
	public String getCodigoHash()
	{
		return codigoHash;
	}
	public  void setCodigoHash(String value)
	{
		codigoHash = value; 
	}
	
	
	
	
	
	private String apiKey;
	public String getApiKey()
	{
		return apiKey;
	}
	public  void setApiKey(String value)
	{
		apiKey = value; 
	}
	
	
	
	
	
	private long diasPrecoVitrine;
	public long getDiasPrecoVitrine()
	{
		return diasPrecoVitrine;
	}
	public  void setDiasPrecoVitrine(long value)
	{
		diasPrecoVitrine = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
