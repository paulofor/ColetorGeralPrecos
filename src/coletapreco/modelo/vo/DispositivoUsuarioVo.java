package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class DispositivoUsuarioVo implements DispositivoUsuario
{
		
	public long getIdObj()
    {
       return idDispositivoUsuario;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdDispositivoUsuario\" : \"" + idDispositivoUsuario + "\" "
		+ ", \"NumeroCelular\" : \"" + numeroCelular + "\" "
		+ ", \"CodigoDispositivo\" : \"" + codigoDispositivo + "\" "
		+ ", \"TipoAcesso\" : \"" + tipoAcesso + "\" "
		+ ", \"MelhorPath\" : \"" + melhorPath + "\" "
		+ ", \"TokenGcm\" : \"" + tokenGcm + "\" "
		+ ", \"TokenGcmMonitor\" : \"" + tokenGcmMonitor + "\" "
		+ ", \"MicroSd\" : \"" + microSd + "\" "
		+ ", \"DataChamada\" : \"" + dataChamada + "\" "
		+ ", \"DataUltimoAcesso\" : \"" + dataUltimoAcesso + "\" "
		+ ", \"DataCriacao\" : \"" + dataCriacao + "\" "
		+ ", \"TemMudanca\" : \"" + temMudanca + "\" "
		+ ", \"Ativo\" : \"" + ativo + "\" "
		+ ", \"IdUsuarioRa\" : \"" + idUsuarioRa + "\" "
		+ ", \"IdAppProdutoU\" : \"" + idAppProdutoU + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private DispositivoUsuarioDerivada derivada = null;
	private DispositivoUsuarioDerivada getDerivada() {
		if (derivada==null) {
			derivada = new DispositivoUsuarioDerivada(this);
		}
		return derivada;
	}

	private DispositivoUsuarioAgregado agregado = null;
	private DispositivoUsuarioAgregado getAgregado() {
		if (agregado==null) {
			agregado = new DispositivoUsuarioAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public Usuario getUsuarioReferenteA(boolean lazyLoader)
	{
		return getAgregado().getUsuarioReferenteA(lazyLoader); 
	} 
	public void setUsuarioReferenteA(Usuario value) 
	{
		getAgregado().setUsuarioReferenteA(value); 
	} 
	/*
	public void setUsuarioReferenteAComReversao(Usuario value) 
	{
		getAgregado().setUsuarioReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaUsuario_ReferenteA(Usuario value)
	{
		getAgregado().setUsuarioReferenteA(value); 
	} 
	public Usuario getCorrenteUsuario_ReferenteA()
	{
		return getAgregado().getUsuarioReferenteA(false); 
	} 
	
	
	// Montador Tradicional
	public AppProduto getAppProdutoUsa(boolean lazyLoader)
	{
		return getAgregado().getAppProdutoUsa(lazyLoader); 
	} 
	public void setAppProdutoUsa(AppProduto value) 
	{
		getAgregado().setAppProdutoUsa(value); 
	} 
	/*
	public void setAppProdutoUsaComReversao(AppProduto value) 
	{
		getAgregado().setAppProdutoUsaComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaAppProduto_Usa(AppProduto value)
	{
		getAgregado().setAppProdutoUsa(value); 
	} 
	public AppProduto getCorrenteAppProduto_Usa()
	{
		return getAgregado().getAppProdutoUsa(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idDispositivoUsuario;
	public long getIdDispositivoUsuario()
	{
		return idDispositivoUsuario;
	}
	public  void setIdDispositivoUsuario(long value)
	{
		idDispositivoUsuario = value; 
	}
	
	
	
	
	
	private String numeroCelular;
	public String getNumeroCelular()
	{
		return numeroCelular;
	}
	public  void setNumeroCelular(String value)
	{
		numeroCelular = value; 
	}
	
	
	
	
	
	private String codigoDispositivo;
	public String getCodigoDispositivo()
	{
		return codigoDispositivo;
	}
	public  void setCodigoDispositivo(String value)
	{
		codigoDispositivo = value; 
	}
	
	
	
	
	
	private String tipoAcesso;
	public String getTipoAcesso()
	{
		return tipoAcesso;
	}
	public  void setTipoAcesso(String value)
	{
		tipoAcesso = value; 
	}
	
	
	
	
	
	private String melhorPath;
	public String getMelhorPath()
	{
		return melhorPath;
	}
	public  void setMelhorPath(String value)
	{
		melhorPath = value; 
	}
	
	
	
	
	
	private String tokenGcm;
	public String getTokenGcm()
	{
		return tokenGcm;
	}
	public  void setTokenGcm(String value)
	{
		tokenGcm = value; 
	}
	
	
	
	
	
	private String tokenGcmMonitor;
	public String getTokenGcmMonitor()
	{
		return tokenGcmMonitor;
	}
	public  void setTokenGcmMonitor(String value)
	{
		tokenGcmMonitor = value; 
	}
	
	
	
	
	
	private long microSd;
	public long getMicroSd()
	{
		return microSd;
	}
	public  void setMicroSd(long value)
	{
		microSd = value; 
	}
	
	
	
	
	
	private String dataChamada;
	public String getDataChamada()
	{
		return dataChamada;
	}
	public  void setDataChamada(String value)
	{
		dataChamada = value; 
	}
	
	
	
	
	
	private String dataUltimoAcesso;
	public String getDataUltimoAcesso()
	{
		return dataUltimoAcesso;
	}
	public  void setDataUltimoAcesso(String value)
	{
		dataUltimoAcesso = value; 
	}
	
	
	
	
	
	private String dataCriacao;
	public String getDataCriacao()
	{
		return dataCriacao;
	}
	public  void setDataCriacao(String value)
	{
		dataCriacao = value; 
	}
	
	
	
	
	
	private boolean temMudanca;
	public boolean getTemMudanca()
	{
		return temMudanca;
	}
	public  void setTemMudanca(boolean value)
	{
		temMudanca = value; 
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
	
	
	
	
		
	private long idUsuarioRa;
	public long getIdUsuarioRa() {
		// relacionamento
		if (idUsuarioRa==0 && this.getUsuarioReferenteA(false)!=null) 
			return getUsuarioReferenteA(false).getIdObj();
		else
			return idUsuarioRa;
	}
	public void setIdUsuarioRa(long _valor) {
		idUsuarioRa = _valor;
	}
	
	
	
	
		
	private long idAppProdutoU;
	public long getIdAppProdutoU() {
		// relacionamento
		if (idAppProdutoU==0 && this.getAppProdutoUsa(false)!=null) 
			return getAppProdutoUsa(false).getIdObj();
		else
			return idAppProdutoU;
	}
	public void setIdAppProdutoU(long _valor) {
		idAppProdutoU = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
