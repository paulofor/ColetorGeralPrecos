
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class DispositivoUsuarioFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idUsuarioReferenteA = -1;
		public long getCodigoUsuarioReferenteA() {
			return _codigo_idUsuarioReferenteA;
		}
		public void setCodigoUsuarioReferenteA(long dado) {
			_codigo_idUsuarioReferenteA = dado;
		}
      	
      	private long _codigo_idAppProdutoUsa = -1;
		public long getCodigoAppProdutoUsa() {
			return _codigo_idAppProdutoUsa;
		}
		public void setCodigoAppProdutoUsa(long dado) {
			_codigo_idAppProdutoUsa = dado;
		}
      	

		private DispositivoUsuario _ItemComApp;
		public DispositivoUsuario getItemComApp () {
			return _ItemComApp ;
		}
		public void setItemComApp (DispositivoUsuario value) {
			_ItemComApp  = value;
		}
		
		public DispositivoUsuario validaItemComApp() {
			
			if (_ItemComApp == null) {
				throw new RuntimeException("ItemComApp eh nulo");
			}
			
			return getItemComApp ();
		}
		
		private DispositivoUsuario _ItemDispositivoOld;
		public DispositivoUsuario getItemDispositivoOld () {
			return _ItemDispositivoOld ;
		}
		public void setItemDispositivoOld (DispositivoUsuario value) {
			_ItemDispositivoOld  = value;
		}
		
		public DispositivoUsuario validaItemDispositivoOld() {
			
			if (_ItemDispositivoOld == null) {
				throw new RuntimeException("ItemDispositivoOld eh nulo");
			}
			
			return getItemDispositivoOld ();
		}
		
		private AppProduto _AppMonitorameneto;
		public AppProduto getAppMonitorameneto () {
			return _AppMonitorameneto ;
		}
		public void setAppMonitorameneto (AppProduto value) {
			_AppMonitorameneto  = value;
		}
		
		public AppProduto validaAppMonitorameneto() {
			
			if (_AppMonitorameneto == null) {
				throw new RuntimeException("AppMonitorameneto eh nulo");
			}
			
			return getAppMonitorameneto ();
		}
		



		
}