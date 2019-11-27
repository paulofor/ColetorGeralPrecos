package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class UsuarioPesquisaDerivada   implements UsuarioPesquisaDerivadaI { 
  private UsuarioPesquisa principal;
      public UsuarioPesquisaDerivada( UsuarioPesquisa itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
