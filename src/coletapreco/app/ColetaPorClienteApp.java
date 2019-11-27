package coletapreco.app;

import br.com.digicom.lib.dao.DaoException;

public class ColetaPorClienteApp {

	
	public static void main(String[] args) {
		ColetaPorClienteObj obj = new ColetaPorClienteObj();
		try {
			obj.executa();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			System.out.println("error:" + e.getMessage());
			e.printStackTrace();
		}
	}
}
