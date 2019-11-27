package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class UsuarioPesquisaObjetoWs   { 
      long _idUsuarioPesquisa;
	public long getIdUsuarioPesquisa() {
		return _idUsuarioPesquisa;
	}
	public void setIdUsuarioPesquisa( long dado ) {
		_idUsuarioPesquisa = dado;
	}
      long _idUsuarioS;
	public long getIdUsuarioS() {
		return _idUsuarioS;
	}
	public void setIdUsuarioS( long dado ) {
		_idUsuarioS = dado;
	}
      long _idNaturezaProdutoP;
	public long getIdNaturezaProdutoP() {
		return _idNaturezaProdutoP;
	}
	public void setIdNaturezaProdutoP( long dado ) {
		_idNaturezaProdutoP = dado;
	}
  private UsuarioObjetoWs _UsuarioSincroniza;
	public UsuarioObjetoWs getUsuarioSincroniza() {
		return _UsuarioSincroniza;
	}
	public void setUsuarioSincroniza( UsuarioObjetoWs dado ) {
		_UsuarioSincroniza = dado;
	}
  private NaturezaProdutoObjetoWs _NaturezaProdutoPesquisa;
	public NaturezaProdutoObjetoWs getNaturezaProdutoPesquisa() {
		return _NaturezaProdutoPesquisa;
	}
	public void setNaturezaProdutoPesquisa( NaturezaProdutoObjetoWs dado ) {
		_NaturezaProdutoPesquisa = dado;
	}
}
