package coletapreco.app;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.ProdutoRegraColecao;

public class TestaCallbackDetalheProduto {

	
	private static long CODIGO_PRODUTO = 800957; // Dafiti
	//private static long CODIGO_PRODUTO = 557548; // Ponto Frio
	
	public static void main(String[] args) {
		ProdutoRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoRegraColecao();
		
		produtoSrv.getFiltro().setIdProduto(CODIGO_PRODUTO);
		try {
			produtoSrv.AcessaInformacaoProdutoPorId();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
}
