package coletapreco.desen;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.log.ArquivoLog;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.OportunidadeDiaRegraColecao;

public class TesteCriaOportunidade {

	public static void main(String[] args) {
		OportunidadeDiaRegraColecao srv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
		try {
			System.out.println("Vai calcular oportunidades...");
			srv.CalculaOportunidadesPosicaoHoje();
			System.out.println("Final de calculando oportunidades...");
			srv.EnviaParaServidor();
			System.out.println("Final de envio para o servidor...");
		} catch (DaoException e) {
			e.printStackTrace();
			ArquivoLog.getInstancia().salvaErro(e);
		}

	}

}
