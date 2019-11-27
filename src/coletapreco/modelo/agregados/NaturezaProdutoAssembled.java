package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class NaturezaProdutoAssembled   implements NaturezaProdutoAssembledI { 
  private AppProduto _AppProdutoAtendidoPor;
	public AppProduto getAppProdutoAtendidoPor() {
		return _AppProdutoAtendidoPor;
	}
	public void setAppProdutoAtendidoPor( AppProduto dado ) {
		_AppProdutoAtendidoPor = dado;
	}
}
