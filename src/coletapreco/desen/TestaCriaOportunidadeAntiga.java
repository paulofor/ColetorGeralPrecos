package coletapreco.desen;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.app.ColetaPrecoBrinquedoObj;

public class TestaCriaOportunidadeAntiga {

	public static void main(String[] args) {

		ColetaPrecoBrinquedoObj obj = new ColetaPrecoBrinquedoObj();
		try {
			obj.processaOportunidades();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
