package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class ProdutoClienteAssembled   implements ProdutoClienteAssembledI { 
  private NaturezaProduto _NaturezaProdutoReferenteA;
	public NaturezaProduto getNaturezaProdutoReferenteA() {
		return _NaturezaProdutoReferenteA;
	}
	public void setNaturezaProdutoReferenteA( NaturezaProduto dado ) {
		_NaturezaProdutoReferenteA = dado;
	}
}
