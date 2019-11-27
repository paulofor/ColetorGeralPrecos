package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class CategoriaLojaProdutoDerivada   implements CategoriaLojaProdutoDerivadaI { 
  private CategoriaLojaProduto principal;
      public CategoriaLojaProdutoDerivada( CategoriaLojaProduto itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
