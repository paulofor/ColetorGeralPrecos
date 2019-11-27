
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class CategoriaLojaProdutoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idCategoriaLojaReferenteA = -1;
		public long getCodigoCategoriaLojaReferenteA() {
			return _codigo_idCategoriaLojaReferenteA;
		}
		public void setCodigoCategoriaLojaReferenteA(long dado) {
			_codigo_idCategoriaLojaReferenteA = dado;
		}
      	
      	private long _codigo_idProdutoReferenteA = -1;
		public long getCodigoProdutoReferenteA() {
			return _codigo_idProdutoReferenteA;
		}
		public void setCodigoProdutoReferenteA(long dado) {
			_codigo_idProdutoReferenteA = dado;
		}
      	

		private CategoriaLojaProduto _Item;
		public CategoriaLojaProduto getItem () {
			return _Item ;
		}
		public void setItem (CategoriaLojaProduto value) {
			_Item  = value;
		}
		
		public CategoriaLojaProduto validaItem() {
			
			if (_Item == null) {
				throw new RuntimeException("Item eh nulo");
			}
			
			return getItem ();
		}
		



		
}