package coletapreco.regracolecao.impl;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.ModeloProdutoDao;
import coletapreco.modelo.ModeloProduto;
import coletapreco.modelo.ModeloProdutoProduto;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.ModeloProdutoProdutoRegraColecao;
import coletapreco.regracolecao.ModeloProdutoRegraColecao;


public  class ModeloProdutoRegraColecaoImpl  extends ModeloProdutoRegraColecao {

	@Override
	public ModeloProduto UnificacaoProduto(DaoConexao conexao) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModeloProduto CriaModeloNovo(DaoConexao conexao) throws DaoException {
		// Criando o modelo com as relaçòes
		ModeloProdutoDao dao = getDao(conexao);
		ModeloProduto novo = getFiltro().validaModeloNovo();
		dao.insereItemLoad(novo);
		ModeloProdutoProdutoRegraColecao srv = FabricaRegra.getInstancia().getModeloProdutoProdutoRegraColecao();
		for (ModeloProdutoProduto rel : novo.getListaModeloProdutoProduto_ReferenteA()) {
			rel.setModeloProdutoReferenteA(novo);
			srv.insereItemLoad(rel, conexao);
		}
		return novo;
	} 
}
