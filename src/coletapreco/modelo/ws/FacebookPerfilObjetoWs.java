package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class FacebookPerfilObjetoWs   { 
      long _idFacebookPerfil;
	public long getIdFacebookPerfil() {
		return _idFacebookPerfil;
	}
	public void setIdFacebookPerfil( long dado ) {
		_idFacebookPerfil = dado;
	}
      String _tokenAcesso;
	public String getTokenAcesso() {
		return _tokenAcesso;
	}
	public void setTokenAcesso( String dado ) {
		_tokenAcesso = dado;
	}
      String _emailUtilizado;
	public String getEmailUtilizado() {
		return _emailUtilizado;
	}
	public void setEmailUtilizado( String dado ) {
		_emailUtilizado = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
      String _sobrenome;
	public String getSobrenome() {
		return _sobrenome;
	}
	public void setSobrenome( String dado ) {
		_sobrenome = dado;
	}
}
