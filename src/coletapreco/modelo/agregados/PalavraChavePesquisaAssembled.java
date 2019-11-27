package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class PalavraChavePesquisaAssembled   implements PalavraChavePesquisaAssembledI { 
  private Usuario _UsuarioSincroniza;
	public Usuario getUsuarioSincroniza() {
		return _UsuarioSincroniza;
	}
	public void setUsuarioSincroniza( Usuario dado ) {
		_UsuarioSincroniza = dado;
	}
  private NaturezaProduto _NaturezaProdutoReferenteA;
	public NaturezaProduto getNaturezaProdutoReferenteA() {
		return _NaturezaProdutoReferenteA;
	}
	public void setNaturezaProdutoReferenteA( NaturezaProduto dado ) {
		_NaturezaProdutoReferenteA = dado;
	}
}
