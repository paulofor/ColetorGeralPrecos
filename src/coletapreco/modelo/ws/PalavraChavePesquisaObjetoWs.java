package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class PalavraChavePesquisaObjetoWs   { 
      long _idPalavraChavePesquisa;
	public long getIdPalavraChavePesquisa() {
		return _idPalavraChavePesquisa;
	}
	public void setIdPalavraChavePesquisa( long dado ) {
		_idPalavraChavePesquisa = dado;
	}
      String _textoBusca;
	public String getTextoBusca() {
		return _textoBusca;
	}
	public void setTextoBusca( String dado ) {
		_textoBusca = dado;
	}
      String _dataVar;
	public String getData() {
		return _dataVar;
	}
	public void setData( String dado ) {
		_dataVar = dado;
	}
      long _idUsuarioS;
	public long getIdUsuarioS() {
		return _idUsuarioS;
	}
	public void setIdUsuarioS( long dado ) {
		_idUsuarioS = dado;
	}
      long _idNaturezaProdutoRa;
	public long getIdNaturezaProdutoRa() {
		return _idNaturezaProdutoRa;
	}
	public void setIdNaturezaProdutoRa( long dado ) {
		_idNaturezaProdutoRa = dado;
	}
  private UsuarioObjetoWs _UsuarioSincroniza;
	public UsuarioObjetoWs getUsuarioSincroniza() {
		return _UsuarioSincroniza;
	}
	public void setUsuarioSincroniza( UsuarioObjetoWs dado ) {
		_UsuarioSincroniza = dado;
	}
  private NaturezaProdutoObjetoWs _NaturezaProdutoReferenteA;
	public NaturezaProdutoObjetoWs getNaturezaProdutoReferenteA() {
		return _NaturezaProdutoReferenteA;
	}
	public void setNaturezaProdutoReferenteA( NaturezaProdutoObjetoWs dado ) {
		_NaturezaProdutoReferenteA = dado;
	}
}
