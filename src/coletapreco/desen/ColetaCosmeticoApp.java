package coletapreco.desen;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.regracolecao.ContagemProdutoRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.LojaVirtualRegraColecao;
import coletapreco.thread.ProcessaOportunidadeTh;

public class ColetaCosmeticoApp {

	public static void main(String[] args) {
		System.out.println("Versao: 27-12-2020 (1)");
		
		LojaVirtualRegraColecao srv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		ContagemProdutoRegraColecao contagemSrv = FabricaRegra.getInstancia().getContagemProdutoRegraColecao();
		ProcessaOportunidadeTh oportunidade = new ProcessaOportunidadeTh();

		try {
			
			srv.AtualizaCosmetico();
			contagemSrv.RegistraQuantidadesDia();
			oportunidade.setIdNatureza(26);
			oportunidade.run();
			contagemSrv.EnviaParaServidor();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
