
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class PrecoProdutoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idProdutoPertenceA = -1;
		public long getCodigoProdutoPertenceA() {
			return _codigo_idProdutoPertenceA;
		}
		public void setCodigoProdutoPertenceA(long dado) {
			_codigo_idProdutoPertenceA = dado;
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
		
		private PrecoProduto _Item;
		public PrecoProduto getItem () {
			return _Item ;
		}
		public void setItem (PrecoProduto value) {
			_Item  = value;
		}
		
		public PrecoProduto validaItem() {
			
			if (_Item == null) {
				throw new RuntimeException("Item eh nulo");
			}
			
			return getItem ();
		}
		
		private PrecoDiario _PrecoAtual;
		public PrecoDiario getPrecoAtual () {
			return _PrecoAtual ;
		}
		public void setPrecoAtual (PrecoDiario value) {
			_PrecoAtual  = value;
		}
		
		public PrecoDiario validaPrecoAtual() {
			
			if (_PrecoAtual == null) {
				throw new RuntimeException("PrecoAtual eh nulo");
			}
			
			return getPrecoAtual ();
		}
		
		private List _ListaIneresse;
		public List getListaIneresse () {
			return _ListaIneresse ;
		}
		public void setListaIneresse (List value) {
			_ListaIneresse  = value;
		}
		
		public List validaListaIneresse() {
			
			if (_ListaIneresse == null) {
				throw new RuntimeException("ListaIneresse eh nulo");
			}
			
			return getListaIneresse ();
		}
		
		


		//public List ListaIneresse;
		
		// Colocados na mão -- 2019
		int idLoja;
		int qtdePosicao;
		public int getIdLoja() {
			return idLoja;
		}
		public void setIdLoja(int idLoja) {
			this.idLoja = idLoja;
		}
		public int getQtdePosicao() {
			return qtdePosicao;
		}
		public void setQtdePosicao(int qtdePosicao) {
			this.qtdePosicao = qtdePosicao;
		}
		

		
}