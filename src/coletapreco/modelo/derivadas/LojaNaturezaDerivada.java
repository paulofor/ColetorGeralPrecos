package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class LojaNaturezaDerivada   implements LojaNaturezaDerivadaI { 
  private LojaNatureza principal;
      public LojaNaturezaDerivada( LojaNatureza itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
