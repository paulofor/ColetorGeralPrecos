package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class FacebookPostPerformanceObjetoWs   { 
      long _idFacebookPostPerformance;
	public long getIdFacebookPostPerformance() {
		return _idFacebookPostPerformance;
	}
	public void setIdFacebookPostPerformance( long dado ) {
		_idFacebookPostPerformance = dado;
	}
      String _dataVar;
	public String getData() {
		return _dataVar;
	}
	public void setData( String dado ) {
		_dataVar = dado;
	}
      long _alcance;
	public long getAlcance() {
		return _alcance;
	}
	public void setAlcance( long dado ) {
		_alcance = dado;
	}
      long _idFacebookPostRa;
	public long getIdFacebookPostRa() {
		return _idFacebookPostRa;
	}
	public void setIdFacebookPostRa( long dado ) {
		_idFacebookPostRa = dado;
	}
  private FacebookPostObjetoWs _FacebookPostReferenteA;
	public FacebookPostObjetoWs getFacebookPostReferenteA() {
		return _FacebookPostReferenteA;
	}
	public void setFacebookPostReferenteA( FacebookPostObjetoWs dado ) {
		_FacebookPostReferenteA = dado;
	}
}
