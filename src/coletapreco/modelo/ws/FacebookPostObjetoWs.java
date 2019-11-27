package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class FacebookPostObjetoWs   { 
      long _idFacebookPost;
	public long getIdFacebookPost() {
		return _idFacebookPost;
	}
	public void setIdFacebookPost( long dado ) {
		_idFacebookPost = dado;
	}
      String _dataHora;
	public String getDataHora() {
		return _dataHora;
	}
	public void setDataHora( String dado ) {
		_dataHora = dado;
	}
      String _codigoFacebook;
	public String getCodigoFacebook() {
		return _codigoFacebook;
	}
	public void setCodigoFacebook( String dado ) {
		_codigoFacebook = dado;
	}
      String _horarioProgramacao;
	public String getHorarioProgramacao() {
		return _horarioProgramacao;
	}
	public void setHorarioProgramacao( String dado ) {
		_horarioProgramacao = dado;
	}
      long _idFacebookFanpageFe;
	public long getIdFacebookFanpageFe() {
		return _idFacebookFanpageFe;
	}
	public void setIdFacebookFanpageFe( long dado ) {
		_idFacebookFanpageFe = dado;
	}
      long _idProdutoD;
	public long getIdProdutoD() {
		return _idProdutoD;
	}
	public void setIdProdutoD( long dado ) {
		_idProdutoD = dado;
	}
  private FacebookFanpageObjetoWs _FacebookFanpageFeitoEm;
	public FacebookFanpageObjetoWs getFacebookFanpageFeitoEm() {
		return _FacebookFanpageFeitoEm;
	}
	public void setFacebookFanpageFeitoEm( FacebookFanpageObjetoWs dado ) {
		_FacebookFanpageFeitoEm = dado;
	}
  private ProdutoObjetoWs _ProdutoDivulgando;
	public ProdutoObjetoWs getProdutoDivulgando() {
		return _ProdutoDivulgando;
	}
	public void setProdutoDivulgando( ProdutoObjetoWs dado ) {
		_ProdutoDivulgando = dado;
	}
}
