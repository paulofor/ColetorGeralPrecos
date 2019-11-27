package coletapreco.modelo.ws;


import coletapreco.modelo.vo.*;
import coletapreco.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class ModeloProdutoProdutoObjetoWs   { 
      long _idModeloProdutoProduto;
	public long getIdModeloProdutoProduto() {
		return _idModeloProdutoProduto;
	}
	public void setIdModeloProdutoProduto( long dado ) {
		_idModeloProdutoProduto = dado;
	}
      long _idModeloProdutoRa;
	public long getIdModeloProdutoRa() {
		return _idModeloProdutoRa;
	}
	public void setIdModeloProdutoRa( long dado ) {
		_idModeloProdutoRa = dado;
	}
      long _idProdutoRa;
	public long getIdProdutoRa() {
		return _idProdutoRa;
	}
	public void setIdProdutoRa( long dado ) {
		_idProdutoRa = dado;
	}
  private ModeloProdutoObjetoWs _ModeloProdutoReferenteA;
	public ModeloProdutoObjetoWs getModeloProdutoReferenteA() {
		return _ModeloProdutoReferenteA;
	}
	public void setModeloProdutoReferenteA( ModeloProdutoObjetoWs dado ) {
		_ModeloProdutoReferenteA = dado;
	}
  private ProdutoObjetoWs _ProdutoReferenteA;
	public ProdutoObjetoWs getProdutoReferenteA() {
		return _ProdutoReferenteA;
	}
	public void setProdutoReferenteA( ProdutoObjetoWs dado ) {
		_ProdutoReferenteA = dado;
	}
}
