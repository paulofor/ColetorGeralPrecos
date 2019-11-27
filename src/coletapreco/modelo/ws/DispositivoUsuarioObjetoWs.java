package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class DispositivoUsuarioObjetoWs   { 
      long _idDispositivoUsuario;
	public long getIdDispositivoUsuario() {
		return _idDispositivoUsuario;
	}
	public void setIdDispositivoUsuario( long dado ) {
		_idDispositivoUsuario = dado;
	}
      String _numeroCelular;
	public String getNumeroCelular() {
		return _numeroCelular;
	}
	public void setNumeroCelular( String dado ) {
		_numeroCelular = dado;
	}
      String _codigoDispositivo;
	public String getCodigoDispositivo() {
		return _codigoDispositivo;
	}
	public void setCodigoDispositivo( String dado ) {
		_codigoDispositivo = dado;
	}
      String _tipoAcesso;
	public String getTipoAcesso() {
		return _tipoAcesso;
	}
	public void setTipoAcesso( String dado ) {
		_tipoAcesso = dado;
	}
      String _melhorPath;
	public String getMelhorPath() {
		return _melhorPath;
	}
	public void setMelhorPath( String dado ) {
		_melhorPath = dado;
	}
      String _tokenGcm;
	public String getTokenGcm() {
		return _tokenGcm;
	}
	public void setTokenGcm( String dado ) {
		_tokenGcm = dado;
	}
      String _tokenGcmMonitor;
	public String getTokenGcmMonitor() {
		return _tokenGcmMonitor;
	}
	public void setTokenGcmMonitor( String dado ) {
		_tokenGcmMonitor = dado;
	}
      long _microSd;
	public long getMicroSd() {
		return _microSd;
	}
	public void setMicroSd( long dado ) {
		_microSd = dado;
	}
      long _idUsuarioRa;
	public long getIdUsuarioRa() {
		return _idUsuarioRa;
	}
	public void setIdUsuarioRa( long dado ) {
		_idUsuarioRa = dado;
	}
      long _idAppProdutoU;
	public long getIdAppProdutoU() {
		return _idAppProdutoU;
	}
	public void setIdAppProdutoU( long dado ) {
		_idAppProdutoU = dado;
	}
  private UsuarioObjetoWs _UsuarioReferenteA;
	public UsuarioObjetoWs getUsuarioReferenteA() {
		return _UsuarioReferenteA;
	}
	public void setUsuarioReferenteA( UsuarioObjetoWs dado ) {
		_UsuarioReferenteA = dado;
	}
  private AppProdutoObjetoWs _AppProdutoUsa;
	public AppProdutoObjetoWs getAppProdutoUsa() {
		return _AppProdutoUsa;
	}
	public void setAppProdutoUsa( AppProdutoObjetoWs dado ) {
		_AppProdutoUsa = dado;
	}
}
