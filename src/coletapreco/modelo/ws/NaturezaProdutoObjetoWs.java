package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class NaturezaProdutoObjetoWs   { 
      long _idNaturezaProduto;
	public long getIdNaturezaProduto() {
		return _idNaturezaProduto;
	}
	public void setIdNaturezaProduto( long dado ) {
		_idNaturezaProduto = dado;
	}
      String _nomeNaturezaProduto;
	public String getNomeNaturezaProduto() {
		return _nomeNaturezaProduto;
	}
	public void setNomeNaturezaProduto( String dado ) {
		_nomeNaturezaProduto = dado;
	}
      String _codigoNaturezaProduto;
	public String getCodigoNaturezaProduto() {
		return _codigoNaturezaProduto;
	}
	public void setCodigoNaturezaProduto( String dado ) {
		_codigoNaturezaProduto = dado;
	}
      long _idAppProdutoAp;
	public long getIdAppProdutoAp() {
		return _idAppProdutoAp;
	}
	public void setIdAppProdutoAp( long dado ) {
		_idAppProdutoAp = dado;
	}
  private AppProdutoObjetoWs _AppProdutoAtendidoPor;
	public AppProdutoObjetoWs getAppProdutoAtendidoPor() {
		return _AppProdutoAtendidoPor;
	}
	public void setAppProdutoAtendidoPor( AppProdutoObjetoWs dado ) {
		_AppProdutoAtendidoPor = dado;
	}
}
