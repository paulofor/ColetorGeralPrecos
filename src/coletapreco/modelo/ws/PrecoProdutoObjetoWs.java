package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class PrecoProdutoObjetoWs   { 
      long _idPrecoProduto;
	public long getIdPrecoProduto() {
		return _idPrecoProduto;
	}
	public void setIdPrecoProduto( long dado ) {
		_idPrecoProduto = dado;
	}
      float _media2meses;
	public float getMedia2meses() {
		return _media2meses;
	}
	public void setMedia2meses( float dado ) {
		_media2meses = dado;
	}
      float _percentualAjuste;
	public float getPercentualAjuste() {
		return _percentualAjuste;
	}
	public void setPercentualAjuste( float dado ) {
		_percentualAjuste = dado;
	}
      String _dataUltimaVisita;
	public String getDataUltimaVisita() {
		return _dataUltimaVisita;
	}
	public void setDataUltimaVisita( String dado ) {
		_dataUltimaVisita = dado;
	}
      float _precoRegular;
	public float getPrecoRegular() {
		return _precoRegular;
	}
	public void setPrecoRegular( float dado ) {
		_precoRegular = dado;
	}
      float _precoVenda;
	public float getPrecoVenda() {
		return _precoVenda;
	}
	public void setPrecoVenda( float dado ) {
		_precoVenda = dado;
	}
      float _precoParcela;
	public float getPrecoParcela() {
		return _precoParcela;
	}
	public void setPrecoParcela( float dado ) {
		_precoParcela = dado;
	}
      long _quantidadeParcela;
	public long getQuantidadeParcela() {
		return _quantidadeParcela;
	}
	public void setQuantidadeParcela( long dado ) {
		_quantidadeParcela = dado;
	}
      String _dataVisitaInicial;
	public String getDataVisitaInicial() {
		return _dataVisitaInicial;
	}
	public void setDataVisitaInicial( String dado ) {
		_dataVisitaInicial = dado;
	}
      float _precoBoleto;
	public float getPrecoBoleto() {
		return _precoBoleto;
	}
	public void setPrecoBoleto( float dado ) {
		_precoBoleto = dado;
	}
      float _minimo3meses;
	public float getMinimo3meses() {
		return _minimo3meses;
	}
	public void setMinimo3meses( float dado ) {
		_minimo3meses = dado;
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
