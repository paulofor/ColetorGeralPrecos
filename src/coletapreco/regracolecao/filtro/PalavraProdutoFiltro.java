
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class PalavraProdutoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idPalavraRelaciondoA = -1;
		public long getCodigoPalavraRelaciondoA() {
			return _codigo_idPalavraRelaciondoA;
		}
		public void setCodigoPalavraRelaciondoA(long dado) {
			_codigo_idPalavraRelaciondoA = dado;
		}
      	
      	private long _codigo_idProdutoRelaciondoA = -1;
		public long getCodigoProdutoRelaciondoA() {
			return _codigo_idProdutoRelaciondoA;
		}
		public void setCodigoProdutoRelaciondoA(long dado) {
			_codigo_idProdutoRelaciondoA = dado;
		}
      	

		private PalavraProduto _Item;
		public PalavraProduto getItem () {
			return _Item ;
		}
		public void setItem (PalavraProduto value) {
			_Item  = value;
		}
		
		public PalavraProduto validaItem() {
			
			if (_Item == null) {
				throw new RuntimeException("Item eh nulo");
			}
			
			return getItem ();
		}
		



		
}