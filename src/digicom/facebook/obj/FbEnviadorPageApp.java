package digicom.facebook.obj;

import br.com.digicom.lib.dao.DaoException;

public class FbEnviadorPageApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FbEnviadorPageObj enviador = new FbEnviadorPageObj();
		try {
			enviador.executa();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
