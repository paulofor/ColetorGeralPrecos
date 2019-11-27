package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class PosicionadorProdutoObjetoWs   { 
      long _idPosicionadorProduto;
	public long getIdPosicionadorProduto() {
		return _idPosicionadorProduto;
	}
	public void setIdPosicionadorProduto( long dado ) {
		_idPosicionadorProduto = dado;
	}
      long _posicao;
	public long getPosicao() {
		return _posicao;
	}
	public void setPosicao( long dado ) {
		_posicao = dado;
	}
      long _idProdutoP;
	public long getIdProdutoP() {
		return _idProdutoP;
	}
	public void setIdProdutoP( long dado ) {
		_idProdutoP = dado;
	}
  private ProdutoObjetoWs _ProdutoPosicao;
	public ProdutoObjetoWs getProdutoPosicao() {
		return _ProdutoPosicao;
	}
	public void setProdutoPosicao( ProdutoObjetoWs dado ) {
		_ProdutoPosicao = dado;
	}
}
