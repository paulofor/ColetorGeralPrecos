package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class ModeloProdutoProdutoAssembled   implements ModeloProdutoProdutoAssembledI { 
  private ModeloProduto _ModeloProdutoReferenteA;
	public ModeloProduto getModeloProdutoReferenteA() {
		return _ModeloProdutoReferenteA;
	}
	public void setModeloProdutoReferenteA( ModeloProduto dado ) {
		_ModeloProdutoReferenteA = dado;
	}
  private Produto _ProdutoReferenteA;
	public Produto getProdutoReferenteA() {
		return _ProdutoReferenteA;
	}
	public void setProdutoReferenteA( Produto dado ) {
		_ProdutoReferenteA = dado;
	}
}
