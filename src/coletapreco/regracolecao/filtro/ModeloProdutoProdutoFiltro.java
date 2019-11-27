
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class ModeloProdutoProdutoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idModeloProdutoReferenteA = -1;
		public long getCodigoModeloProdutoReferenteA() {
			return _codigo_idModeloProdutoReferenteA;
		}
		public void setCodigoModeloProdutoReferenteA(long dado) {
			_codigo_idModeloProdutoReferenteA = dado;
		}
      	
      	private long _codigo_idProdutoReferenteA = -1;
		public long getCodigoProdutoReferenteA() {
			return _codigo_idProdutoReferenteA;
		}
		public void setCodigoProdutoReferenteA(long dado) {
			_codigo_idProdutoReferenteA = dado;
		}
      	




		
}