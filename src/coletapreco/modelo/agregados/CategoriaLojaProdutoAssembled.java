package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class CategoriaLojaProdutoAssembled   implements CategoriaLojaProdutoAssembledI { 
  private CategoriaLoja _CategoriaLojaReferenteA;
	public CategoriaLoja getCategoriaLojaReferenteA() {
		return _CategoriaLojaReferenteA;
	}
	public void setCategoriaLojaReferenteA( CategoriaLoja dado ) {
		_CategoriaLojaReferenteA = dado;
	}
  private Produto _ProdutoReferenteA;
	public Produto getProdutoReferenteA() {
		return _ProdutoReferenteA;
	}
	public void setProdutoReferenteA( Produto dado ) {
		_ProdutoReferenteA = dado;
	}
}
