package coletapreco.app;

import br.com.digicom.modelo.NotificacaoApp;

public class NotificadorCosmeticCenterApp {

	public static void main(String[] args) {
		NotificadorCosmeticCenterObj obj = new NotificadorCosmeticCenterObj();
		obj.executa(getNotificacao());
	}
	
	public static NotificacaoApp getNotificacao() {
		NotificacaoApp notificacao = new NotificacaoApp();
		notificacao.setTitulo("Cosmetic Center");
		notificacao.setCorpo("Chegaram novos produtos");
		return notificacao;
	}

}
