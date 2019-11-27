package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class ProdutoClienteDerivada   implements ProdutoClienteDerivadaI { 
  private ProdutoCliente principal;
      public ProdutoClienteDerivada( ProdutoCliente itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
