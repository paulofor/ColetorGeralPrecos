package coletapreco.desen;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.thread.ProcessaOportunidadeTh;

public class TesteEnvioPrecoDiarioServidor {

	public static void main(String[] args) {
		//OportunidadeDiaRegraColecao srv = new OportunidadeDiaRegraColecaoImpl();
		ProcessaOportunidadeTh srv = new ProcessaOportunidadeTh();
		try {
			//srv.EnviaParaServidor(10);
			srv.setIdNatureza(26);
			srv.enviaParaServidor();
		} catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
