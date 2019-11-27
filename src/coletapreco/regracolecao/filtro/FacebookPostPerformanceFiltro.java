
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class FacebookPostPerformanceFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idFacebookPostReferenteA = -1;
		public long getCodigoFacebookPostReferenteA() {
			return _codigo_idFacebookPostReferenteA;
		}
		public void setCodigoFacebookPostReferenteA(long dado) {
			_codigo_idFacebookPostReferenteA = dado;
		}
      	




		
}