
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class ProdutoClienteFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idNaturezaProdutoReferenteA = -1;
		public long getCodigoNaturezaProdutoReferenteA() {
			return _codigo_idNaturezaProdutoReferenteA;
		}
		public void setCodigoNaturezaProdutoReferenteA(long dado) {
			_codigo_idNaturezaProdutoReferenteA = dado;
		}
      	
      	private long _codigo_idPalavraChavePesquisaReferenteA = -1;
		public long getCodigoPalavraChavePesquisaReferenteA() {
			return _codigo_idPalavraChavePesquisaReferenteA;
		}
		public void setCodigoPalavraChavePesquisaReferenteA(long dado) {
			_codigo_idPalavraChavePesquisaReferenteA = dado;
		}
      	

		private long _CodigoNatureza;
		public long getCodigoNatureza () {
			return _CodigoNatureza ;
		}
		public void setCodigoNatureza (long value) {
			_CodigoNatureza  = value;
		}
		
		public long validaCodigoNatureza() {
			
			if (_CodigoNatureza == 0) {
				throw new RuntimeException("CodigoNatureza eh zero");
			}
			
			return getCodigoNatureza ();
		}
		
		private long _LimitePosicionador;
		public long getLimitePosicionador () {
			return _LimitePosicionador ;
		}
		public void setLimitePosicionador (long value) {
			_LimitePosicionador  = value;
		}
		
		public long validaLimitePosicionador() {
			
			if (_LimitePosicionador == 0) {
				throw new RuntimeException("LimitePosicionador eh zero");
			}
			
			return getLimitePosicionador ();
		}
		
		private Produto _Origem;
		public Produto getOrigem () {
			return _Origem ;
		}
		public void setOrigem (Produto value) {
			_Origem  = value;
		}
		
		public Produto validaOrigem() {
			
			if (_Origem == null) {
				throw new RuntimeException("Origem eh nulo");
			}
			
			return getOrigem ();
		}
		


		//public long CodigoNatureza;
		//public long LimitePosicionador;

		
}