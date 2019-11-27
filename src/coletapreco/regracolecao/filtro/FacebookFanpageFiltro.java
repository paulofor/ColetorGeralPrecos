
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class FacebookFanpageFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idFacebookPerfilPertenceA = -1;
		public long getCodigoFacebookPerfilPertenceA() {
			return _codigo_idFacebookPerfilPertenceA;
		}
		public void setCodigoFacebookPerfilPertenceA(long dado) {
			_codigo_idFacebookPerfilPertenceA = dado;
		}
      	
      	private long _codigo_idAppProdutoDivulga = -1;
		public long getCodigoAppProdutoDivulga() {
			return _codigo_idAppProdutoDivulga;
		}
		public void setCodigoAppProdutoDivulga(long dado) {
			_codigo_idAppProdutoDivulga = dado;
		}
      	

		private FacebookPerfil _FbEnviadorPerfil;
		public FacebookPerfil getFbEnviadorPerfil () {
			return _FbEnviadorPerfil ;
		}
		public void setFbEnviadorPerfil (FacebookPerfil value) {
			_FbEnviadorPerfil  = value;
		}
		
		public FacebookPerfil validaFbEnviadorPerfil() {
			
			if (_FbEnviadorPerfil == null) {
				throw new RuntimeException("FbEnviadorPerfil eh nulo");
			}
			
			return getFbEnviadorPerfil ();
		}
		
		private OportunidadeDia _FbEnviadorOportunidade;
		public OportunidadeDia getFbEnviadorOportunidade () {
			return _FbEnviadorOportunidade ;
		}
		public void setFbEnviadorOportunidade (OportunidadeDia value) {
			_FbEnviadorOportunidade  = value;
		}
		
		public OportunidadeDia validaFbEnviadorOportunidade() {
			
			if (_FbEnviadorOportunidade == null) {
				throw new RuntimeException("FbEnviadorOportunidade eh nulo");
			}
			
			return getFbEnviadorOportunidade ();
		}
		
		private FacebookFanpage _FbEnviadorFanpage;
		public FacebookFanpage getFbEnviadorFanpage () {
			return _FbEnviadorFanpage ;
		}
		public void setFbEnviadorFanpage (FacebookFanpage value) {
			_FbEnviadorFanpage  = value;
		}
		
		public FacebookFanpage validaFbEnviadorFanpage() {
			
			if (_FbEnviadorFanpage == null) {
				throw new RuntimeException("FbEnviadorFanpage eh nulo");
			}
			
			return getFbEnviadorFanpage ();
		}
		



		
}