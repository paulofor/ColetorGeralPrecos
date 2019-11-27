package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class PalavraProdutoDerivada   implements PalavraProdutoDerivadaI { 
  private PalavraProduto principal;
      public PalavraProdutoDerivada( PalavraProduto itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
