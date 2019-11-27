package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class AppProdutoObjetoWs   { 
      long _idAppProduto;
	public long getIdAppProduto() {
		return _idAppProduto;
	}
	public void setIdAppProduto( long dado ) {
		_idAppProduto = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
      String _urlInstalacao;
	public String getUrlInstalacao() {
		return _urlInstalacao;
	}
	public void setUrlInstalacao( String dado ) {
		_urlInstalacao = dado;
	}
      boolean _possuiVitrine;
	public boolean getPossuiVitrine() {
		return _possuiVitrine;
	}
	public void setPossuiVitrine( boolean dado ) {
		_possuiVitrine = dado;
	}
      boolean _ativo;
	public boolean getAtivo() {
		return _ativo;
	}
	public void setAtivo( boolean dado ) {
		_ativo = dado;
	}
      String _status;
	public String getStatus() {
		return _status;
	}
	public void setStatus( String dado ) {
		_status = dado;
	}
      long _limitePosicionador;
	public long getLimitePosicionador() {
		return _limitePosicionador;
	}
	public void setLimitePosicionador( long dado ) {
		_limitePosicionador = dado;
	}
      boolean _possuiPalavraChave;
	public boolean getPossuiPalavraChave() {
		return _possuiPalavraChave;
	}
	public void setPossuiPalavraChave( boolean dado ) {
		_possuiPalavraChave = dado;
	}
      String _codigoHash;
	public String getCodigoHash() {
		return _codigoHash;
	}
	public void setCodigoHash( String dado ) {
		_codigoHash = dado;
	}
}
