package coletapreco.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.basica.AppProdutoDaoBase;
import coletapreco.modelo.AppProduto;


public  class AppProdutoDaoExtendida  extends AppProdutoDaoBase implements AppProdutoDao {

	@Override
	public List ListaNaoRelacionadaEmFacebookFanpageListaDivulgadoPor(long idFacebookFanpage) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaNaoRelacionadaEmNaturezaProdutoListaAtende(long idNaturezaProduto) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<AppProduto> ListaAtivoComVitrine() throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where ativo = 'S' and possui_vitrine = 'S' ";
		return this.getListaSql(sql);
	}

	@Override
	public List ListaNaoRelacionadaEmDispositivoUsuarioListaUsadoPor(long idDispositivoUsuario) throws DaoException {
		throw new UnsupportedOperationException();
	}

	
}
