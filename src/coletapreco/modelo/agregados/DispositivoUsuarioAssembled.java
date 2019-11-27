package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class DispositivoUsuarioAssembled   implements DispositivoUsuarioAssembledI { 
  private Usuario _UsuarioReferenteA;
	public Usuario getUsuarioReferenteA() {
		return _UsuarioReferenteA;
	}
	public void setUsuarioReferenteA( Usuario dado ) {
		_UsuarioReferenteA = dado;
	}
  private AppProduto _AppProdutoUsa;
	public AppProduto getAppProdutoUsa() {
		return _AppProdutoUsa;
	}
	public void setAppProdutoUsa( AppProduto dado ) {
		_AppProdutoUsa = dado;
	}
}
