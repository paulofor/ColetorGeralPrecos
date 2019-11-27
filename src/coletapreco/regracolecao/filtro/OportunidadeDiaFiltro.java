
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class OportunidadeDiaFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idProdutoReferenteA = -1;
		public long getCodigoProdutoReferenteA() {
			return _codigo_idProdutoReferenteA;
		}
		public void setCodigoProdutoReferenteA(long dado) {
			_codigo_idProdutoReferenteA = dado;
		}
      	
      	private long _codigo_idNaturezaProdutoPertenceA = -1;
		public long getCodigoNaturezaProdutoPertenceA() {
			return _codigo_idNaturezaProdutoPertenceA;
		}
		public void setCodigoNaturezaProdutoPertenceA(long dado) {
			_codigo_idNaturezaProdutoPertenceA = dado;
		}
      	

		private NaturezaProduto _Natureza;
		public NaturezaProduto getNatureza () {
			return _Natureza ;
		}
		public void setNatureza (NaturezaProduto value) {
			_Natureza  = value;
		}
		
		public NaturezaProduto validaNatureza() {
			
			if (_Natureza == null) {
				throw new RuntimeException("Natureza eh nulo");
			}
			
			return getNatureza ();
		}
		
		private FacebookFanpage _FbPage;
		public FacebookFanpage getFbPage () {
			return _FbPage ;
		}
		public void setFbPage (FacebookFanpage value) {
			_FbPage  = value;
		}
		
		public FacebookFanpage validaFbPage() {
			
			if (_FbPage == null) {
				throw new RuntimeException("FbPage eh nulo");
			}
			
			return getFbPage ();
		}
		



		
}