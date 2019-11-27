
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class MarcaFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}


		private String _Nome;
		public String getNome () {
			return _Nome ;
		}
		public void setNome (String value) {
			_Nome  = value;
		}
		
		public String validaNome() {
			
			if (_Nome == null) {
				throw new RuntimeException("Nome eh nulo");
			}
			
			return getNome ();
		}
		


		//public String Nome;

		
}