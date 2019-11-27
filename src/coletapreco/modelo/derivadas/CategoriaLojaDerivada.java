package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class CategoriaLojaDerivada   implements CategoriaLojaDerivadaI { 
  private CategoriaLoja principal;
      public CategoriaLojaDerivada( CategoriaLoja itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
