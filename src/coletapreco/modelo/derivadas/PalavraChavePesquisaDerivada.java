package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class PalavraChavePesquisaDerivada   implements PalavraChavePesquisaDerivadaI { 
  private PalavraChavePesquisa principal;
      public PalavraChavePesquisaDerivada( PalavraChavePesquisa itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
