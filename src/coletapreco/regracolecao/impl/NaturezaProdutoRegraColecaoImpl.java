package coletapreco.regracolecao.impl;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.NaturezaProdutoDao;
import coletapreco.modelo.NaturezaProduto;
import coletapreco.modelo.Produto;
import coletapreco.regracolecao.NaturezaProdutoRegraColecao;


public  class NaturezaProdutoRegraColecaoImpl  extends NaturezaProdutoRegraColecao {

	@Override
	public NaturezaProduto ObtemPorCodigo(DaoConexao conexao) throws DaoException {
		NaturezaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		return dao.obtemPorCodigo(this.getFiltro().getCodigoPesquisa());
	}

	@Override
	public NaturezaProduto ObtemPorProduto(DaoConexao conexao) throws DaoException {
		Produto produto = getFiltro().getProduto();
		NaturezaProdutoDao dao = getDao(conexao);
		return dao.obtemPorCodigoProduto(produto.getIdProduto());
	}	
}
