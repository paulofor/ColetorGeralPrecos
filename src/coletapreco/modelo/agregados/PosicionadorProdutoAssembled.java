package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class PosicionadorProdutoAssembled   implements PosicionadorProdutoAssembledI { 
  private Produto _ProdutoPosicao;
	public Produto getProdutoPosicao() {
		return _ProdutoPosicao;
	}
	public void setProdutoPosicao( Produto dado ) {
		_ProdutoPosicao = dado;
	}
}
