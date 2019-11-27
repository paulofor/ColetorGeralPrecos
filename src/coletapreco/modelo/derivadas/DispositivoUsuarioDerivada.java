package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class DispositivoUsuarioDerivada   implements DispositivoUsuarioDerivadaI { 
  private DispositivoUsuario principal;
      public DispositivoUsuarioDerivada( DispositivoUsuario itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
