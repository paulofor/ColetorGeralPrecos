package coletapreco.desen;

import coletapreco.regracolecao.ContagemProdutoRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.LojaVirtualRegraColecao;
import coletapreco.thread.ProcessaOportunidadeTh;

public class ColetaComputadorApp {

	public static void main(String[] args) {
		System.out.println("ColetaComputadorApp-Versao: 06-12-2020 (1)");
		
		LojaVirtualRegraColecao srv = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
		ContagemProdutoRegraColecao contagemSrv = FabricaRegra.getInstancia().getContagemProdutoRegraColecao();
		ProcessaOportunidadeTh oportunidade = new ProcessaOportunidadeTh();

		try {
			
			srv.AtualizaNotebook();
			//contagemSrv.RegistraQuantidadesDia();
			//oportunidade.setIdNatureza(10);
			//oportunidade.run();
			//contagemSrv.EnviaParaServidor();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
