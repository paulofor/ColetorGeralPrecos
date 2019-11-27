package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class MarcaDerivada   implements MarcaDerivadaI { 
  private Marca principal;
      public MarcaDerivada( Marca itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
