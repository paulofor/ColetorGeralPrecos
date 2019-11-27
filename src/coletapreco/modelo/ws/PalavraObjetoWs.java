package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class PalavraObjetoWs   { 
      long _idPalavra;
	public long getIdPalavra() {
		return _idPalavra;
	}
	public void setIdPalavra( long dado ) {
		_idPalavra = dado;
	}
      String _descricao;
	public String getDescricao() {
		return _descricao;
	}
	public void setDescricao( String dado ) {
		_descricao = dado;
	}
      boolean _comum;
	public boolean getComum() {
		return _comum;
	}
	public void setComum( boolean dado ) {
		_comum = dado;
	}
}
