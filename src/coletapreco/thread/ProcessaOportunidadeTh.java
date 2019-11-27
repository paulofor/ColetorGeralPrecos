package coletapreco.thread;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.log.ArquivoLog;
import coletapreco.regracolecao.ContagemProdutoRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.OportunidadeDiaRegraColecao;

public class ProcessaOportunidadeTh extends Thread {

	@Override
	public void run() {
		OportunidadeDiaRegraColecao srv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
		try {
			System.out.println("Vai calcular oportunidades...");
			srv.CalculaOportunidadesHoje();
			System.out.println("Final de calculando oportunidades...");
			srv.EnviaParaServidor();
			System.out.println("Final de envio para o servidor...");
		} catch (DaoException e) {
			e.printStackTrace();
			ArquivoLog.getInstancia().salvaErro(e);
		}
	}
}
