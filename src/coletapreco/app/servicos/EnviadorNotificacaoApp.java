package coletapreco.app.servicos;

import br.com.digicom.lib.dao.DaoException;

public class EnviadorNotificacaoApp {

	
	
	public static void main(String[] args) {
		EnviadorNotificacaoObj obj = new EnviadorNotificacaoObj();
		try {
			obj.executa();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
