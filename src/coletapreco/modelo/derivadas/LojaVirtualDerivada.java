package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class LojaVirtualDerivada   implements LojaVirtualDerivadaI { 
  private LojaVirtual principal;
      public LojaVirtualDerivada( LojaVirtual itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
