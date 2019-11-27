
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class ModeloProdutoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}


		private ModeloProduto _ModeloNovo;
		public ModeloProduto getModeloNovo () {
			return _ModeloNovo ;
		}
		public void setModeloNovo (ModeloProduto value) {
			_ModeloNovo  = value;
		}
		
		public ModeloProduto validaModeloNovo() {
			
			if (_ModeloNovo == null) {
				throw new RuntimeException("ModeloNovo eh nulo");
			}
			
			return getModeloNovo ();
		}
		



		
}