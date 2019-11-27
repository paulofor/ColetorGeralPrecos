package coletapreco.desen;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.DBB;
import coletapreco.dao.ProdutoDao;
import coletapreco.modelo.Produto;
import coletapreco.parse.regracolecaoadaptador.custom.ProdutoAdaptador;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.ProdutoRegraColecao;

public class TestaGetImagemAmericanas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProdutoRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoRegraColecao();
		try {
			Produto produto = produtoSrv.obtemPorChave(1066235);
			
			ProdutoAdaptador adaptadorProduto = new ProdutoAdaptador();
			
			DaoConexao conexao = getDao().criaConexao();
			adaptadorProduto.atualizaDetalhe(produto, conexao);
			
		} catch (DaoException e) {
			
			e.printStackTrace();
		}
	}

	public static final ProdutoDao getDao() {
		return DBB.getInstancia().getProdutoDao();
	}
}
