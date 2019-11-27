
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class PosicionadorProdutoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idProdutoPosicao = -1;
		public long getCodigoProdutoPosicao() {
			return _codigo_idProdutoPosicao;
		}
		public void setCodigoProdutoPosicao(long dado) {
			_codigo_idProdutoPosicao = dado;
		}
      	




		
}