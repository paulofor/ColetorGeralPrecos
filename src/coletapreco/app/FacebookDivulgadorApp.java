package coletapreco.app;

import br.com.digicom.lib.dao.DaoException;
import digicom.facebook.obj.FbEnviadorObj;

public class FacebookDivulgadorApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FbEnviadorObj obj2 = new FbEnviadorObj();
		
		FacebookDivulgadorObj obj = new FacebookDivulgadorObj();
		try {
			obj2.criaListaFoto();
			//obj.executa();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
