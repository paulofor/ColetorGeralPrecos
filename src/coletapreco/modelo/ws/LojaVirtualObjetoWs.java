package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class LojaVirtualObjetoWs   { 
      long _idLojaVirtual;
	public long getIdLojaVirtual() {
		return _idLojaVirtual;
	}
	public void setIdLojaVirtual( long dado ) {
		_idLojaVirtual = dado;
	}
      String _nomeLojaVirtual;
	public String getNomeLojaVirtual() {
		return _nomeLojaVirtual;
	}
	public void setNomeLojaVirtual( String dado ) {
		_nomeLojaVirtual = dado;
	}
      String _urlInicialBrinquedo;
	public String getUrlInicialBrinquedo() {
		return _urlInicialBrinquedo;
	}
	public void setUrlInicialBrinquedo( String dado ) {
		_urlInicialBrinquedo = dado;
	}
}
