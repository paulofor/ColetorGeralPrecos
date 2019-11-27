package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class ProdutoClienteObjetoWs   { 
      long _idProdutoCliente;
	public long getIdProdutoCliente() {
		return _idProdutoCliente;
	}
	public void setIdProdutoCliente( long dado ) {
		_idProdutoCliente = dado;
	}
      String _nome;
	public String getNome() {
		return _nome;
	}
	public void setNome( String dado ) {
		_nome = dado;
	}
      long _posicaoProduto;
	public long getPosicaoProduto() {
		return _posicaoProduto;
	}
	public void setPosicaoProduto( long dado ) {
		_posicaoProduto = dado;
	}
      String _imagem;
	public String getImagem() {
		return _imagem;
	}
	public void setImagem( String dado ) {
		_imagem = dado;
	}
      float _precoAtual;
	public float getPrecoAtual() {
		return _precoAtual;
	}
	public void setPrecoAtual( float dado ) {
		_precoAtual = dado;
	}
      String _marca;
	public String getMarca() {
		return _marca;
	}
	public void setMarca( String dado ) {
		_marca = dado;
	}
      String _loja;
	public String getLoja() {
		return _loja;
	}
	public void setLoja( String dado ) {
		_loja = dado;
	}
      String _dataVar;
	public String getData() {
		return _dataVar;
	}
	public void setData( String dado ) {
		_dataVar = dado;
	}
      long _idNaturezaProdutoRa;
	public long getIdNaturezaProdutoRa() {
		return _idNaturezaProdutoRa;
	}
	public void setIdNaturezaProdutoRa( long dado ) {
		_idNaturezaProdutoRa = dado;
	}
  private NaturezaProdutoObjetoWs _NaturezaProdutoReferenteA;
	public NaturezaProdutoObjetoWs getNaturezaProdutoReferenteA() {
		return _NaturezaProdutoReferenteA;
	}
	public void setNaturezaProdutoReferenteA( NaturezaProdutoObjetoWs dado ) {
		_NaturezaProdutoReferenteA = dado;
	}
}
