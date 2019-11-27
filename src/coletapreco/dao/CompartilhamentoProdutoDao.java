package coletapreco.dao;

import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.basica.CompartilhamentoProdutoDaoBaseI;

public interface CompartilhamentoProdutoDao extends CompartilhamentoProdutoDaoBaseI{

	List ListaPorProdutoReferenteA(long id) throws DaoException;

}
