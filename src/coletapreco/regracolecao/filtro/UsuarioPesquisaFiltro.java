
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class UsuarioPesquisaFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idNaturezaProdutoPesquisa = -1;
		public long getCodigoNaturezaProdutoPesquisa() {
			return _codigo_idNaturezaProdutoPesquisa;
		}
		public void setCodigoNaturezaProdutoPesquisa(long dado) {
			_codigo_idNaturezaProdutoPesquisa = dado;
		}
      	




		
}