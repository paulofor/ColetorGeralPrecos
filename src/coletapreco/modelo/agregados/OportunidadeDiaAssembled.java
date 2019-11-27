package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class OportunidadeDiaAssembled   implements OportunidadeDiaAssembledI { 
  private Produto _ProdutoReferenteA;
	public Produto getProdutoReferenteA() {
		return _ProdutoReferenteA;
	}
	public void setProdutoReferenteA( Produto dado ) {
		_ProdutoReferenteA = dado;
	}
  private NaturezaProduto _NaturezaProdutoPertenceA;
	public NaturezaProduto getNaturezaProdutoPertenceA() {
		return _NaturezaProdutoPertenceA;
	}
	public void setNaturezaProdutoPertenceA( NaturezaProduto dado ) {
		_NaturezaProdutoPertenceA = dado;
	}
}
