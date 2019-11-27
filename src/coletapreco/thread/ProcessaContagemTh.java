package coletapreco.thread;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.log.ArquivoLog;
import coletapreco.regracolecao.ContagemProdutoRegraColecao;
import coletapreco.regracolecao.FabricaRegra;

public class ProcessaContagemTh extends Thread {

	@Override
	public void run() {
		
		ContagemProdutoRegraColecao srv = FabricaRegra.getInstancia().getContagemProdutoRegraColecao();
		try {
			System.out.println("Antes RegistraQuantidadesDia");
			srv.RegistraQuantidadesDia();
			System.out.println("Antes de CalculaDiferencaErro");
			srv.CalculaDiferencaErro();
			System.out.println("Antes de EnviaParaServidor");
			srv.EnviaParaServidor();
			System.out.println("Finalizacao ProcessaContagemTh.run");
		} catch (DaoException e) {
			e.printStackTrace();
			System.out.println("Erro:" + e.getMessage());
			ArquivoLog.getInstancia().salvaErro(e);
		}
		
	}

	
	
}
