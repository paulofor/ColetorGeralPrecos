package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class InteresseProdutoDerivada   implements InteresseProdutoDerivadaI { 
  private InteresseProduto principal;
      public InteresseProdutoDerivada( InteresseProduto itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
