package coletapreco.regracolecao.impl;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.MarcaDao;
import coletapreco.modelo.Marca;
import coletapreco.regracolecao.MarcaRegraColecao;


public  class MarcaRegraColecaoImpl  extends MarcaRegraColecao {

	@Override
	public Marca ObtemPorNome(DaoConexao conexao) throws DaoException {
		MarcaDao dao = getDao();
		dao.setConexao(conexao);
		Marca marca = dao.ObtemPorNome(getFiltro().getNome());
		return marca;
		
	} 
}
