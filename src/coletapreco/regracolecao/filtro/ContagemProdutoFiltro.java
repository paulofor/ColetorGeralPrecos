
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class ContagemProdutoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idNaturezaProdutoReferenteA = -1;
		public long getCodigoNaturezaProdutoReferenteA() {
			return _codigo_idNaturezaProdutoReferenteA;
		}
		public void setCodigoNaturezaProdutoReferenteA(long dado) {
			_codigo_idNaturezaProdutoReferenteA = dado;
		}
      	
      	private long _codigo_idLojaVirtualReferenteA = -1;
		public long getCodigoLojaVirtualReferenteA() {
			return _codigo_idLojaVirtualReferenteA;
		}
		public void setCodigoLojaVirtualReferenteA(long dado) {
			_codigo_idLojaVirtualReferenteA = dado;
		}
      	




		
}