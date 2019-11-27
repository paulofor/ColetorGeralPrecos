package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class LojaNaturezaObjetoWs   { 
      boolean _parseCategoria;
	public boolean getParseCategoria() {
		return _parseCategoria;
	}
	public void setParseCategoria( boolean dado ) {
		_parseCategoria = dado;
	}
      long _idLojaNatureza;
	public long getIdLojaNatureza() {
		return _idLojaNatureza;
	}
	public void setIdLojaNatureza( long dado ) {
		_idLojaNatureza = dado;
	}
      String _urlInicial;
	public String getUrlInicial() {
		return _urlInicial;
	}
	public void setUrlInicial( String dado ) {
		_urlInicial = dado;
	}
      long _idLojaVirtualRa;
	public long getIdLojaVirtualRa() {
		return _idLojaVirtualRa;
	}
	public void setIdLojaVirtualRa( long dado ) {
		_idLojaVirtualRa = dado;
	}
      long _idNaturezaProdutoRa;
	public long getIdNaturezaProdutoRa() {
		return _idNaturezaProdutoRa;
	}
	public void setIdNaturezaProdutoRa( long dado ) {
		_idNaturezaProdutoRa = dado;
	}
  private LojaVirtualObjetoWs _LojaVirtualReferenteA;
	public LojaVirtualObjetoWs getLojaVirtualReferenteA() {
		return _LojaVirtualReferenteA;
	}
	public void setLojaVirtualReferenteA( LojaVirtualObjetoWs dado ) {
		_LojaVirtualReferenteA = dado;
	}
  private NaturezaProdutoObjetoWs _NaturezaProdutoReferenteA;
	public NaturezaProdutoObjetoWs getNaturezaProdutoReferenteA() {
		return _NaturezaProdutoReferenteA;
	}
	public void setNaturezaProdutoReferenteA( NaturezaProdutoObjetoWs dado ) {
		_NaturezaProdutoReferenteA = dado;
	}
}
