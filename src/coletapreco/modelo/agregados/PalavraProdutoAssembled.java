package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class PalavraProdutoAssembled   implements PalavraProdutoAssembledI { 
  private Palavra _PalavraRelaciondoA;
	public Palavra getPalavraRelaciondoA() {
		return _PalavraRelaciondoA;
	}
	public void setPalavraRelaciondoA( Palavra dado ) {
		_PalavraRelaciondoA = dado;
	}
  private Produto _ProdutoRelaciondoA;
	public Produto getProdutoRelaciondoA() {
		return _ProdutoRelaciondoA;
	}
	public void setProdutoRelaciondoA( Produto dado ) {
		_ProdutoRelaciondoA = dado;
	}
}
