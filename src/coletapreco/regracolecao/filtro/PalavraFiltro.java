
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class PalavraFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
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
		
		private String _DescricaoPalavra;
		public String getDescricaoPalavra () {
			return _DescricaoPalavra ;
		}
		public void setDescricaoPalavra (String value) {
			_DescricaoPalavra  = value;
		}
		
		public String validaDescricaoPalavra() {
			
			if (_DescricaoPalavra == null) {
				throw new RuntimeException("DescricaoPalavra eh nulo");
			}
			
			return getDescricaoPalavra ();
		}
		


		//public String DescricaoPalavra;

		
}