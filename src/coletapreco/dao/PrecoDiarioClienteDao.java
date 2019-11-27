package coletapreco.dao;

import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.basica.PrecoDiarioClienteDaoBaseI;

public interface PrecoDiarioClienteDao extends PrecoDiarioClienteDaoBaseI{

	void excluiTodosUsuario(long idUsuario) throws DaoException;

	List ListaPorUsuarioSincroniza(long id) throws DaoException;

}
