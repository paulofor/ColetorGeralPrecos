
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class LojaVirtualFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}


		private long _IdNaturezaProduto;
		public long getIdNaturezaProduto () {
			return _IdNaturezaProduto ;
		}
		public void setIdNaturezaProduto (long value) {
			_IdNaturezaProduto  = value;
		}
		
		public long validaIdNaturezaProduto() {
			
			if (_IdNaturezaProduto == 0) {
				throw new RuntimeException("IdNaturezaProduto eh zero");
			}
			
			return getIdNaturezaProduto ();
		}
		
		private Produto _ProdutoPesquisa;
		public Produto getProdutoPesquisa () {
			return _ProdutoPesquisa ;
		}
		public void setProdutoPesquisa (Produto value) {
			_ProdutoPesquisa  = value;
		}
		
		public Produto validaProdutoPesquisa() {
			
			if (_ProdutoPesquisa == null) {
				throw new RuntimeException("ProdutoPesquisa eh nulo");
			}
			
			return getProdutoPesquisa ();
		}
		
		private LojaNatureza _LojaNaturezaExecucao;
		public LojaNatureza getLojaNaturezaExecucao () {
			return _LojaNaturezaExecucao ;
		}
		public void setLojaNaturezaExecucao (LojaNatureza value) {
			_LojaNaturezaExecucao  = value;
		}
		
		public LojaNatureza validaLojaNaturezaExecucao() {
			
			if (_LojaNaturezaExecucao == null) {
				throw new RuntimeException("LojaNaturezaExecucao eh nulo");
			}
			
			return getLojaNaturezaExecucao ();
		}
		


		//public long IdNaturezaProduto;

		
}