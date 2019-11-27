package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class CategoriaLojaAssembled   implements CategoriaLojaAssembledI { 
  private CategoriaLoja _CategoriaLojaFilho;
	public CategoriaLoja getCategoriaLojaFilho() {
		return _CategoriaLojaFilho;
	}
	public void setCategoriaLojaFilho( CategoriaLoja dado ) {
		_CategoriaLojaFilho = dado;
	}
  private NaturezaProduto _NaturezaProdutoReferenteA;
	public NaturezaProduto getNaturezaProdutoReferenteA() {
		return _NaturezaProdutoReferenteA;
	}
	public void setNaturezaProdutoReferenteA( NaturezaProduto dado ) {
		_NaturezaProdutoReferenteA = dado;
	}
  private LojaVirtual _LojaVirtualPertenceA;
	public LojaVirtual getLojaVirtualPertenceA() {
		return _LojaVirtualPertenceA;
	}
	public void setLojaVirtualPertenceA( LojaVirtual dado ) {
		_LojaVirtualPertenceA = dado;
	}
}
