package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class NaturezaProdutoDerivada   implements NaturezaProdutoDerivadaI { 
  private NaturezaProduto principal;
      public NaturezaProdutoDerivada( NaturezaProduto itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
