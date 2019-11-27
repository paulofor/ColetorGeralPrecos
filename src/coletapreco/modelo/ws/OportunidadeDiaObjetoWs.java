package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class OportunidadeDiaObjetoWs   { 
      long _idOportunidadeDia;
	public long getIdOportunidadeDia() {
		return _idOportunidadeDia;
	}
	public void setIdOportunidadeDia( long dado ) {
		_idOportunidadeDia = dado;
	}
      float _precoBoletoAtual;
	public float getPrecoBoletoAtual() {
		return _precoBoletoAtual;
	}
	public void setPrecoBoletoAtual( float dado ) {
		_precoBoletoAtual = dado;
	}
      float _precoParcelaAnterior;
	public float getPrecoParcelaAnterior() {
		return _precoParcelaAnterior;
	}
	public void setPrecoParcelaAnterior( float dado ) {
		_precoParcelaAnterior = dado;
	}
      float _precoParcelaAtual;
	public float getPrecoParcelaAtual() {
		return _precoParcelaAtual;
	}
	public void setPrecoParcelaAtual( float dado ) {
		_precoParcelaAtual = dado;
	}
      long _quantidadeParcelaAnterior;
	public long getQuantidadeParcelaAnterior() {
		return _quantidadeParcelaAnterior;
	}
	public void setQuantidadeParcelaAnterior( long dado ) {
		_quantidadeParcelaAnterior = dado;
	}
      long _quantidadeParcelaAtual;
	public long getQuantidadeParcelaAtual() {
		return _quantidadeParcelaAtual;
	}
	public void setQuantidadeParcelaAtual( long dado ) {
		_quantidadeParcelaAtual = dado;
	}
      float _percentualAjusteVenda;
	public float getPercentualAjusteVenda() {
		return _percentualAjusteVenda;
	}
	public void setPercentualAjusteVenda( float dado ) {
		_percentualAjusteVenda = dado;
	}
      float _percentualAjusteBoleto;
	public float getPercentualAjusteBoleto() {
		return _percentualAjusteBoleto;
	}
	public void setPercentualAjusteBoleto( float dado ) {
		_percentualAjusteBoleto = dado;
	}
      String _nomeLojaVirtual;
	public String getNomeLojaVirtual() {
		return _nomeLojaVirtual;
	}
	public void setNomeLojaVirtual( String dado ) {
		_nomeLojaVirtual = dado;
	}
      float _precoMinimo;
	public float getPrecoMinimo() {
		return _precoMinimo;
	}
	public void setPrecoMinimo( float dado ) {
		_precoMinimo = dado;
	}
      float _precoBoletoAnterior;
	public float getPrecoBoletoAnterior() {
		return _precoBoletoAnterior;
	}
	public void setPrecoBoletoAnterior( float dado ) {
		_precoBoletoAnterior = dado;
	}
      float _precoVendaAtual;
	public float getPrecoVendaAtual() {
		return _precoVendaAtual;
	}
	public void setPrecoVendaAtual( float dado ) {
		_precoVendaAtual = dado;
	}
      float _precoVendaAnterior;
	public float getPrecoVendaAnterior() {
		return _precoVendaAnterior;
	}
	public void setPrecoVendaAnterior( float dado ) {
		_precoVendaAnterior = dado;
	}
      String _urlProduto;
	public String getUrlProduto() {
		return _urlProduto;
	}
	public void setUrlProduto( String dado ) {
		_urlProduto = dado;
	}
      String _nomeProduto;
	public String getNomeProduto() {
		return _nomeProduto;
	}
	public void setNomeProduto( String dado ) {
		_nomeProduto = dado;
	}
      String _dataInicioPrecoAtual;
	public String getDataInicioPrecoAtual() {
		return _dataInicioPrecoAtual;
	}
	public void setDataInicioPrecoAtual( String dado ) {
		_dataInicioPrecoAtual = dado;
	}
      String _nomeMarca;
	public String getNomeMarca() {
		return _nomeMarca;
	}
	public void setNomeMarca( String dado ) {
		_nomeMarca = dado;
	}
      String _urlAfiliado;
	public String getUrlAfiliado() {
		return _urlAfiliado;
	}
	public void setUrlAfiliado( String dado ) {
		_urlAfiliado = dado;
	}
      String _dataUltimaPrecoAnterior;
	public String getDataUltimaPrecoAnterior() {
		return _dataUltimaPrecoAnterior;
	}
	public void setDataUltimaPrecoAnterior( String dado ) {
		_dataUltimaPrecoAnterior = dado;
	}
      String _imagemLocal;
	public String getImagemLocal() {
		return _imagemLocal;
	}
	public void setImagemLocal( String dado ) {
		_imagemLocal = dado;
	}
      String _urlImagem;
	public String getUrlImagem() {
		return _urlImagem;
	}
	public void setUrlImagem( String dado ) {
		_urlImagem = dado;
	}
      long _posicaoProduto;
	public long getPosicaoProduto() {
		return _posicaoProduto;
	}
	public void setPosicaoProduto( long dado ) {
		_posicaoProduto = dado;
	}
      float _precoMedio;
	public float getPrecoMedio() {
		return _precoMedio;
	}
	public void setPrecoMedio( float dado ) {
		_precoMedio = dado;
	}
      long _idProdutoRa;
	public long getIdProdutoRa() {
		return _idProdutoRa;
	}
	public void setIdProdutoRa( long dado ) {
		_idProdutoRa = dado;
	}
      long _idNaturezaProdutoPa;
	public long getIdNaturezaProdutoPa() {
		return _idNaturezaProdutoPa;
	}
	public void setIdNaturezaProdutoPa( long dado ) {
		_idNaturezaProdutoPa = dado;
	}
  private ProdutoObjetoWs _ProdutoReferenteA;
	public ProdutoObjetoWs getProdutoReferenteA() {
		return _ProdutoReferenteA;
	}
	public void setProdutoReferenteA( ProdutoObjetoWs dado ) {
		_ProdutoReferenteA = dado;
	}
  private NaturezaProdutoObjetoWs _NaturezaProdutoPertenceA;
	public NaturezaProdutoObjetoWs getNaturezaProdutoPertenceA() {
		return _NaturezaProdutoPertenceA;
	}
	public void setNaturezaProdutoPertenceA( NaturezaProdutoObjetoWs dado ) {
		_NaturezaProdutoPertenceA = dado;
	}
      String _codigoImagemLocal;
	public String getCodigoImagemLocal() {
		return _codigoImagemLocal;
	}
	public void setCodigoImagemLocal( String dado ) {
		_codigoImagemLocal = dado;
	}
      String _mensagemFacebook;
	public String getMensagemFacebook() {
		return _mensagemFacebook;
	}
	public void setMensagemFacebook( String dado ) {
		_mensagemFacebook = dado;
	}
      String _linkAplicativo;
	public String getLinkAplicativo() {
		return _linkAplicativo;
	}
	public void setLinkAplicativo( String dado ) {
		_linkAplicativo = dado;
	}
}
