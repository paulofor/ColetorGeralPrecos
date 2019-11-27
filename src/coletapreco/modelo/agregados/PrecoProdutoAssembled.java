package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class PrecoProdutoAssembled   implements PrecoProdutoAssembledI { 
  private Produto _ProdutoPertenceA;
	public Produto getProdutoPertenceA() {
		return _ProdutoPertenceA;
	}
	public void setProdutoPertenceA( Produto dado ) {
		_ProdutoPertenceA = dado;
	}
}
