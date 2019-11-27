package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class UsuarioObjetoWs   { 
      long _idUsuario;
	public long getIdUsuario() {
		return _idUsuario;
	}
	public void setIdUsuario( long dado ) {
		_idUsuario = dado;
	}
      String _nomeUsuario;
	public String getNomeUsuario() {
		return _nomeUsuario;
	}
	public void setNomeUsuario( String dado ) {
		_nomeUsuario = dado;
	}
}
