
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class PrecoDiarioClienteFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idProdutoClientePertenceA = -1;
		public long getCodigoProdutoClientePertenceA() {
			return _codigo_idProdutoClientePertenceA;
		}
		public void setCodigoProdutoClientePertenceA(long dado) {
			_codigo_idProdutoClientePertenceA = dado;
		}
      	

		private Usuario _Usuario;
		public Usuario getUsuario () {
			return _Usuario ;
		}
		public void setUsuario (Usuario value) {
			_Usuario  = value;
		}
		
		public Usuario validaUsuario() {
			
			if (_Usuario == null) {
				throw new RuntimeException("Usuario eh nulo");
			}
			
			return getUsuario ();
		}
		



		
}