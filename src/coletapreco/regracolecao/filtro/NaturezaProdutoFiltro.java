
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class NaturezaProdutoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idAppProdutoAtendidoPor = -1;
		public long getCodigoAppProdutoAtendidoPor() {
			return _codigo_idAppProdutoAtendidoPor;
		}
		public void setCodigoAppProdutoAtendidoPor(long dado) {
			_codigo_idAppProdutoAtendidoPor = dado;
		}
      	

		private String _CodigoPesquisa;
		public String getCodigoPesquisa () {
			return _CodigoPesquisa ;
		}
		public void setCodigoPesquisa (String value) {
			_CodigoPesquisa  = value;
		}
		
		public String validaCodigoPesquisa() {
			
			if (_CodigoPesquisa == null) {
				throw new RuntimeException("CodigoPesquisa eh nulo");
			}
			
			return getCodigoPesquisa ();
		}
		
		private Produto _Produto;
		public Produto getProduto () {
			return _Produto ;
		}
		public void setProduto (Produto value) {
			_Produto  = value;
		}
		
		public Produto validaProduto() {
			
			if (_Produto == null) {
				throw new RuntimeException("Produto eh nulo");
			}
			
			return getProduto ();
		}
		


		//public String CodigoPesquisa;

		
}