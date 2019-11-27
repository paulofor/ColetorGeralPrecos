package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class AppProdutoDerivada   implements AppProdutoDerivadaI { 
  private AppProduto principal;
      public AppProdutoDerivada( AppProduto itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
