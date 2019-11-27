package coletapreco.desen;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.regracolecao.ContagemProdutoRegraColecao;
import coletapreco.regracolecao.FabricaRegra;

public class TesteCalculaContagemProdutoDia {

	public static void main(String[] args) {
		ContagemProdutoRegraColecao contagemSrv = FabricaRegra.getInstancia().getContagemProdutoRegraColecao();
		try {
			contagemSrv.RegistraQuantidadesDia();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
}
