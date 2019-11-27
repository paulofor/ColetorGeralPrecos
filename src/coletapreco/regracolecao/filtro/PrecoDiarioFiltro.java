
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class PrecoDiarioFiltro {

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
		
		private long _IdProduto;
		public long getIdProduto () {
			return _IdProduto ;
		}
		public void setIdProduto (long value) {
			_IdProduto  = value;
		}
		
		public long validaIdProduto() {
			
			if (_IdProduto == 0) {
				throw new RuntimeException("IdProduto eh zero");
			}
			
			return getIdProduto ();
		}
		
		private String _DataPesquisa;
		public String getDataPesquisa () {
			return _DataPesquisa ;
		}
		public void setDataPesquisa (String value) {
			_DataPesquisa  = value;
		}
		
		public String validaDataPesquisa() {
			
			if (_DataPesquisa == null) {
				throw new RuntimeException("DataPesquisa eh nulo");
			}
			
			return getDataPesquisa ();
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
		


		//public long IdProduto;
		//public String DataPesquisa;

		
}