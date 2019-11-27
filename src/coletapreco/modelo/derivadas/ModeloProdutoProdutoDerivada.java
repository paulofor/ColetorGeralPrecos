package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class ModeloProdutoProdutoDerivada   implements ModeloProdutoProdutoDerivadaI { 
  private ModeloProdutoProduto principal;
      public ModeloProdutoProdutoDerivada( ModeloProdutoProduto itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
