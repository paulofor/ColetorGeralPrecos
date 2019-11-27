
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class InteresseProdutoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idProdutoClienteReferenteA = -1;
		public long getCodigoProdutoClienteReferenteA() {
			return _codigo_idProdutoClienteReferenteA;
		}
		public void setCodigoProdutoClienteReferenteA(long dado) {
			_codigo_idProdutoClienteReferenteA = dado;
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
		
		private InteresseProduto _Item;
		public InteresseProduto getItem () {
			return _Item ;
		}
		public void setItem (InteresseProduto value) {
			_Item  = value;
		}
		
		public InteresseProduto validaItem() {
			
			if (_Item == null) {
				throw new RuntimeException("Item eh nulo");
			}
			
			return getItem ();
		}
		
		private List _ListaPrecoDiarioOrdenado;
		public List getListaPrecoDiarioOrdenado () {
			return _ListaPrecoDiarioOrdenado ;
		}
		public void setListaPrecoDiarioOrdenado (List value) {
			_ListaPrecoDiarioOrdenado  = value;
		}
		
		public List validaListaPrecoDiarioOrdenado() {
			
			if (_ListaPrecoDiarioOrdenado == null) {
				throw new RuntimeException("ListaPrecoDiarioOrdenado eh nulo");
			}
			
			return getListaPrecoDiarioOrdenado ();
		}
		


		//public List ListaPrecoDiarioOrdenado;

		
}