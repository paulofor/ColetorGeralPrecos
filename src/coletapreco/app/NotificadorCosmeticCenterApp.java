package coletapreco.app;

import br.com.digicom.modelo.NotificacaoApp;

public class NotificadorCosmeticCenterApp {

	public static void main(String[] args) {
		NotificadorCosmeticCenterObj obj = new NotificadorCosmeticCenterObj();
		obj.executa(getNotificacao());
		
		try {
			Thread.sleep(7 * 60 * 1000);
			System.exit(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static NotificacaoApp getNotificacao() {
		NotificacaoApp notificacao = new NotificacaoApp();
		notificacao.setTitulo("Cosmetic Center");
		notificacao.setCorpo("Chegaram novos produtos");
		return notificacao;
	}

}
