
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class CompartilhamentoProdutoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idUsuarioPertenceA = -1;
		public long getCodigoUsuarioPertenceA() {
			return _codigo_idUsuarioPertenceA;
		}
		public void setCodigoUsuarioPertenceA(long dado) {
			_codigo_idUsuarioPertenceA = dado;
		}
      	
      	private long _codigo_idProdutoReferenteA = -1;
		public long getCodigoProdutoReferenteA() {
			return _codigo_idProdutoReferenteA;
		}
		public void setCodigoProdutoReferenteA(long dado) {
			_codigo_idProdutoReferenteA = dado;
		}
      	




		
}