package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class FacebookFanpageObjetoWs   { 
      long _idFacebookFanpage;
	public long getIdFacebookFanpage() {
		return _idFacebookFanpage;
	}
	public void setIdFacebookFanpage( long dado ) {
		_idFacebookFanpage = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
      String _codigoFacebook;
	public String getCodigoFacebook() {
		return _codigoFacebook;
	}
	public void setCodigoFacebook( String dado ) {
		_codigoFacebook = dado;
	}
      String _nomeUrl;
	public String getNomeUrl() {
		return _nomeUrl;
	}
	public void setNomeUrl( String dado ) {
		_nomeUrl = dado;
	}
      long _quantidadeDia;
	public long getQuantidadeDia() {
		return _quantidadeDia;
	}
	public void setQuantidadeDia( long dado ) {
		_quantidadeDia = dado;
	}
      long _idFacebookPerfilPa;
	public long getIdFacebookPerfilPa() {
		return _idFacebookPerfilPa;
	}
	public void setIdFacebookPerfilPa( long dado ) {
		_idFacebookPerfilPa = dado;
	}
      long _idAppProdutoD;
	public long getIdAppProdutoD() {
		return _idAppProdutoD;
	}
	public void setIdAppProdutoD( long dado ) {
		_idAppProdutoD = dado;
	}
  private FacebookPerfilObjetoWs _FacebookPerfilPertenceA;
	public FacebookPerfilObjetoWs getFacebookPerfilPertenceA() {
		return _FacebookPerfilPertenceA;
	}
	public void setFacebookPerfilPertenceA( FacebookPerfilObjetoWs dado ) {
		_FacebookPerfilPertenceA = dado;
	}
  private AppProdutoObjetoWs _AppProdutoDivulga;
	public AppProdutoObjetoWs getAppProdutoDivulga() {
		return _AppProdutoDivulga;
	}
	public void setAppProdutoDivulga( AppProdutoObjetoWs dado ) {
		_AppProdutoDivulga = dado;
	}
}
