
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class FacebookPostFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idFacebookFanpageFeitoEm = -1;
		public long getCodigoFacebookFanpageFeitoEm() {
			return _codigo_idFacebookFanpageFeitoEm;
		}
		public void setCodigoFacebookFanpageFeitoEm(long dado) {
			_codigo_idFacebookFanpageFeitoEm = dado;
		}
      	
      	private long _codigo_idProdutoDivulgando = -1;
		public long getCodigoProdutoDivulgando() {
			return _codigo_idProdutoDivulgando;
		}
		public void setCodigoProdutoDivulgando(long dado) {
			_codigo_idProdutoDivulgando = dado;
		}
      	




		
}