
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class CategoriaLojaFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idCategoriaLojaFilho = -1;
		public long getCodigoCategoriaLojaFilho() {
			return _codigo_idCategoriaLojaFilho;
		}
		public void setCodigoCategoriaLojaFilho(long dado) {
			_codigo_idCategoriaLojaFilho = dado;
		}
      	
      	private long _codigo_idNaturezaProdutoReferenteA = -1;
		public long getCodigoNaturezaProdutoReferenteA() {
			return _codigo_idNaturezaProdutoReferenteA;
		}
		public void setCodigoNaturezaProdutoReferenteA(long dado) {
			_codigo_idNaturezaProdutoReferenteA = dado;
		}
      	
      	private long _codigo_idLojaVirtualPertenceA = -1;
		public long getCodigoLojaVirtualPertenceA() {
			return _codigo_idLojaVirtualPertenceA;
		}
		public void setCodigoLojaVirtualPertenceA(long dado) {
			_codigo_idLojaVirtualPertenceA = dado;
		}
      	

		private CategoriaLoja _Item;
		public CategoriaLoja getItem () {
			return _Item ;
		}
		public void setItem (CategoriaLoja value) {
			_Item  = value;
		}
		
		public CategoriaLoja validaItem() {
			
			if (_Item == null) {
				throw new RuntimeException("Item eh nulo");
			}
			
			return getItem ();
		}
		



		
}