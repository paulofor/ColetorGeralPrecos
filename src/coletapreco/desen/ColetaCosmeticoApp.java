package coletapreco.desen;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.regracolecao.ContagemProdutoRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.LojaVirtualRegraColecao;
import coletapreco.thread.ProcessaOportunidadeTh;

public class ColetaCosmeticoApp {

	public static void main(String[] args) {
		System.out.println("Versao: 09-01-2020 (2)");
		
		LojaVirtualRegraColecao srv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		ContagemProdutoRegraColecao contagemSrv = FabricaRegra.getInstancia().getContagemProdutoRegraColecao();
		ProcessaOportunidadeTh oportunidade = new ProcessaOportunidadeTh();

		try {
			
			srv.AtualizaCosmetico();
			contagemSrv.RegistraQuantidadesDia();
			oportunidade.run();
			contagemSrv.EnviaParaServidor();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
