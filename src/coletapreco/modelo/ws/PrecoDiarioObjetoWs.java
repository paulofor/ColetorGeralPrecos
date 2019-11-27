package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class PrecoDiarioObjetoWs   { 
      long _idPrecoDiario;
	public long getIdPrecoDiario() {
		return _idPrecoDiario;
	}
	public void setIdPrecoDiario( long dado ) {
		_idPrecoDiario = dado;
	}
      float _precoBoleto;
	public float getPrecoBoleto() {
		return _precoBoleto;
	}
	public void setPrecoBoleto( float dado ) {
		_precoBoleto = dado;
	}
      String _dataHora;
	public String getDataHora() {
		return _dataHora;
	}
	public void setDataHora( String dado ) {
		_dataHora = dado;
	}
      long _quantidadeParcela;
	public long getQuantidadeParcela() {
		return _quantidadeParcela;
	}
	public void setQuantidadeParcela( long dado ) {
		_quantidadeParcela = dado;
	}
      float _precoParcela;
	public float getPrecoParcela() {
		return _precoParcela;
	}
	public void setPrecoParcela( float dado ) {
		_precoParcela = dado;
	}
      float _precoVenda;
	public float getPrecoVenda() {
		return _precoVenda;
	}
	public void setPrecoVenda( float dado ) {
		_precoVenda = dado;
	}
      float _precoRegular;
	public float getPrecoRegular() {
		return _precoRegular;
	}
	public void setPrecoRegular( float dado ) {
		_precoRegular = dado;
	}
      long _posicaoProduto;
	public long getPosicaoProduto() {
		return _posicaoProduto;
	}
	public void setPosicaoProduto( long dado ) {
		_posicaoProduto = dado;
	}
      long _idProdutoPa;
	public long getIdProdutoPa() {
		return _idProdutoPa;
	}
	public void setIdProdutoPa( long dado ) {
		_idProdutoPa = dado;
	}
  private ProdutoObjetoWs _ProdutoPertenceA;
	public ProdutoObjetoWs getProdutoPertenceA() {
		return _ProdutoPertenceA;
	}
	public void setProdutoPertenceA( ProdutoObjetoWs dado ) {
		_ProdutoPertenceA = dado;
	}
}
