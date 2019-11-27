package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class ModeloProdutoObjetoWs   { 
      long _idModeloProduto;
	public long getIdModeloProduto() {
		return _idModeloProduto;
	}
	public void setIdModeloProduto( long dado ) {
		_idModeloProduto = dado;
	}
      String _nomeModeloProduto;
	public String getNomeModeloProduto() {
		return _nomeModeloProduto;
	}
	public void setNomeModeloProduto( String dado ) {
		_nomeModeloProduto = dado;
	}
}
