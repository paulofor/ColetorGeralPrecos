package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class ContagemProdutoAssembled   implements ContagemProdutoAssembledI { 
  private NaturezaProduto _NaturezaProdutoReferenteA;
	public NaturezaProduto getNaturezaProdutoReferenteA() {
		return _NaturezaProdutoReferenteA;
	}
	public void setNaturezaProdutoReferenteA( NaturezaProduto dado ) {
		_NaturezaProdutoReferenteA = dado;
	}
  private LojaVirtual _LojaVirtualReferenteA;
	public LojaVirtual getLojaVirtualReferenteA() {
		return _LojaVirtualReferenteA;
	}
	public void setLojaVirtualReferenteA( LojaVirtual dado ) {
		_LojaVirtualReferenteA = dado;
	}
}
