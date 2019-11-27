package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class PalavraProdutoObjetoWs   { 
      long _idPalavraProduto;
	public long getIdPalavraProduto() {
		return _idPalavraProduto;
	}
	public void setIdPalavraProduto( long dado ) {
		_idPalavraProduto = dado;
	}
      long _idPalavraRa;
	public long getIdPalavraRa() {
		return _idPalavraRa;
	}
	public void setIdPalavraRa( long dado ) {
		_idPalavraRa = dado;
	}
      long _idProdutoRa;
	public long getIdProdutoRa() {
		return _idProdutoRa;
	}
	public void setIdProdutoRa( long dado ) {
		_idProdutoRa = dado;
	}
  private PalavraObjetoWs _PalavraRelaciondoA;
	public PalavraObjetoWs getPalavraRelaciondoA() {
		return _PalavraRelaciondoA;
	}
	public void setPalavraRelaciondoA( PalavraObjetoWs dado ) {
		_PalavraRelaciondoA = dado;
	}
  private ProdutoObjetoWs _ProdutoRelaciondoA;
	public ProdutoObjetoWs getProdutoRelaciondoA() {
		return _ProdutoRelaciondoA;
	}
	public void setProdutoRelaciondoA( ProdutoObjetoWs dado ) {
		_ProdutoRelaciondoA = dado;
	}
}
