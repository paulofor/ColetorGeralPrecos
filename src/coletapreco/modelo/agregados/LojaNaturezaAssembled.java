package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class LojaNaturezaAssembled   implements LojaNaturezaAssembledI { 
  private LojaVirtual _LojaVirtualReferenteA;
	public LojaVirtual getLojaVirtualReferenteA() {
		return _LojaVirtualReferenteA;
	}
	public void setLojaVirtualReferenteA( LojaVirtual dado ) {
		_LojaVirtualReferenteA = dado;
	}
  private NaturezaProduto _NaturezaProdutoReferenteA;
	public NaturezaProduto getNaturezaProdutoReferenteA() {
		return _NaturezaProdutoReferenteA;
	}
	public void setNaturezaProdutoReferenteA( NaturezaProduto dado ) {
		_NaturezaProdutoReferenteA = dado;
	}
}
