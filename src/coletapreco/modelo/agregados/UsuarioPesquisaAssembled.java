package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class UsuarioPesquisaAssembled   implements UsuarioPesquisaAssembledI { 
  private Usuario _UsuarioSincroniza;
	public Usuario getUsuarioSincroniza() {
		return _UsuarioSincroniza;
	}
	public void setUsuarioSincroniza( Usuario dado ) {
		_UsuarioSincroniza = dado;
	}
  private NaturezaProduto _NaturezaProdutoPesquisa;
	public NaturezaProduto getNaturezaProdutoPesquisa() {
		return _NaturezaProdutoPesquisa;
	}
	public void setNaturezaProdutoPesquisa( NaturezaProduto dado ) {
		_NaturezaProdutoPesquisa = dado;
	}
}
