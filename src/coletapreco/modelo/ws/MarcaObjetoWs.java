package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class MarcaObjetoWs   { 
      long _idMarca;
	public long getIdMarca() {
		return _idMarca;
	}
	public void setIdMarca( long dado ) {
		_idMarca = dado;
	}
      String _nomeMarca;
	public String getNomeMarca() {
		return _nomeMarca;
	}
	public void setNomeMarca( String dado ) {
		_nomeMarca = dado;
	}
}
