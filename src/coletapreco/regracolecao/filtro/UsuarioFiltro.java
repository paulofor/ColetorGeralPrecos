
package coletapreco.regracolecao.filtro;

import java.util.List;
import coletapreco.modelo.*;
import javax.swing.JTextArea;



public class UsuarioFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}


		private Usuario _ClienteMonitoramento;
		public Usuario getClienteMonitoramento () {
			return _ClienteMonitoramento ;
		}
		public void setClienteMonitoramento (Usuario value) {
			_ClienteMonitoramento  = value;
		}
		
		public Usuario validaClienteMonitoramento() {
			
			if (_ClienteMonitoramento == null) {
				throw new RuntimeException("ClienteMonitoramento eh nulo");
			}
			
			return getClienteMonitoramento ();
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
		
		private long _QuantidadeNotificacao;
		public long getQuantidadeNotificacao () {
			return _QuantidadeNotificacao ;
		}
		public void setQuantidadeNotificacao (long value) {
			_QuantidadeNotificacao  = value;
		}
		
		public long validaQuantidadeNotificacao() {
			
			if (_QuantidadeNotificacao == 0) {
				throw new RuntimeException("QuantidadeNotificacao eh zero");
			}
			
			return getQuantidadeNotificacao ();
		}
		
		private long _MinutoEsperaSemUsuario;
		public long getMinutoEsperaSemUsuario () {
			return _MinutoEsperaSemUsuario ;
		}
		public void setMinutoEsperaSemUsuario (long value) {
			_MinutoEsperaSemUsuario  = value;
		}
		
		public long validaMinutoEsperaSemUsuario() {
			
			if (_MinutoEsperaSemUsuario == 0) {
				throw new RuntimeException("MinutoEsperaSemUsuario eh zero");
			}
			
			return getMinutoEsperaSemUsuario ();
		}
		
		private long _IntervaloMinimoProcessamento;
		public long getIntervaloMinimoProcessamento () {
			return _IntervaloMinimoProcessamento ;
		}
		public void setIntervaloMinimoProcessamento (long value) {
			_IntervaloMinimoProcessamento  = value;
		}
		
		public long validaIntervaloMinimoProcessamento() {
			
			if (_IntervaloMinimoProcessamento == 0) {
				throw new RuntimeException("IntervaloMinimoProcessamento eh zero");
			}
			
			return getIntervaloMinimoProcessamento ();
		}
		


		//public long QuantidadeNotificacao;
		//public long MinutoEsperaSemUsuario;
		//public long IntervaloMinimoProcessamento;

		
}