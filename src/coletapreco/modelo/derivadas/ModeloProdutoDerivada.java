package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class ModeloProdutoDerivada   implements ModeloProdutoDerivadaI { 
  private ModeloProduto principal;
      public ModeloProdutoDerivada( ModeloProduto itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
