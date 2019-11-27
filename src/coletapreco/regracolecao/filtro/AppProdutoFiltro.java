
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class AppProdutoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}


		private long _IdApp;
		public long getIdApp () {
			return _IdApp ;
		}
		public void setIdApp (long value) {
			_IdApp  = value;
		}
		
		public long validaIdApp() {
			
			if (_IdApp == 0) {
				throw new RuntimeException("IdApp eh zero");
			}
			
			return getIdApp ();
		}
		


		//public long IdApp;

		
}