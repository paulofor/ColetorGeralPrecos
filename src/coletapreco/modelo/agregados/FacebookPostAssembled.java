package coletapreco.modelo.agregados;


import coletapreco.modelo.agregados.*;
import coletapreco.modelo.*;


public  class FacebookPostAssembled   implements FacebookPostAssembledI { 
  private FacebookFanpage _FacebookFanpageFeitoEm;
	public FacebookFanpage getFacebookFanpageFeitoEm() {
		return _FacebookFanpageFeitoEm;
	}
	public void setFacebookFanpageFeitoEm( FacebookFanpage dado ) {
		_FacebookFanpageFeitoEm = dado;
	}
  private Produto _ProdutoDivulgando;
	public Produto getProdutoDivulgando() {
		return _ProdutoDivulgando;
	}
	public void setProdutoDivulgando( Produto dado ) {
		_ProdutoDivulgando = dado;
	}
}
