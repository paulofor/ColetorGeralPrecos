package coletapreco.app;

import br.com.digicom.lib.dao.DaoException;

public class MontadorVitrineApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MontadorVitrineObj obj = new MontadorVitrineObj();
		try {
			obj.executa();
		} catch (DaoException e) {
			System.out.println("Erro:" + e.getMessage());
			e.printStackTrace();
		}
	}

}
