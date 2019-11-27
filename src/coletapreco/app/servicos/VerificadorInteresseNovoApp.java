package coletapreco.app.servicos;

import br.com.digicom.lib.dao.DaoException;

public class VerificadorInteresseNovoApp {

	public static void main(String[] args) {
		VerificadorInteresseNovoObj obj = new VerificadorInteresseNovoObj();
		try {
			obj.executa();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
