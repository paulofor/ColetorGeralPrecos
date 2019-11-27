package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class FacebookFanpageAssembled   implements FacebookFanpageAssembledI { 
  private FacebookPerfil _FacebookPerfilPertenceA;
	public FacebookPerfil getFacebookPerfilPertenceA() {
		return _FacebookPerfilPertenceA;
	}
	public void setFacebookPerfilPertenceA( FacebookPerfil dado ) {
		_FacebookPerfilPertenceA = dado;
	}
  private AppProduto _AppProdutoDivulga;
	public AppProduto getAppProdutoDivulga() {
		return _AppProdutoDivulga;
	}
	public void setAppProdutoDivulga( AppProduto dado ) {
		_AppProdutoDivulga = dado;
	}
}
