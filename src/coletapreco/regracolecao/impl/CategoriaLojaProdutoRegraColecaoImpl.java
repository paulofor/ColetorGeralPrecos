package coletapreco.regracolecao.impl;


import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.log.DatasUtils;
import coletapreco.dao.CategoriaLojaProdutoDao;
import coletapreco.modelo.CategoriaLojaProduto;
import coletapreco.regracolecao.CategoriaLojaProdutoRegraColecao;


public  class CategoriaLojaProdutoRegraColecaoImpl  extends CategoriaLojaProdutoRegraColecao {

	@Override
	public CategoriaLojaProduto AtualizaRelacionamento(DaoConexao conexao) throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		CategoriaLojaProduto item = this.getFiltro().getItem();
		CategoriaLojaProduto pesquisa = dao.ObtemPorRelacionamento(item);
		if (pesquisa!=null) {
			pesquisa.setDataUltimaVisita(DatasUtils.getDataDD_MM_AAAA());
			dao.alteraItem(pesquisa);
			return pesquisa;
		} else {
			item.setDataUltimaVisita(DatasUtils.getDataDD_MM_AAAA());
			dao.insereItem(item);
			return item;
		}
	}

	@Override
	public List<CategoriaLojaProduto> PersisteParseLista(DaoConexao conexao)
			throws DaoException {
		// TODO Auto-generated method stub
		return null;
	} 
}
