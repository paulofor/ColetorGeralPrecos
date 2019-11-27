package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class ContagemProdutoDerivada   implements ContagemProdutoDerivadaI { 
  private ContagemProduto principal;
      public ContagemProdutoDerivada( ContagemProduto itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
