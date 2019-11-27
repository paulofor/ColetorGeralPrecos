package coletapreco.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.basica.*;

public interface ProdutoClienteDao
 extends ProdutoClienteDaoBaseI {

	void DeleteAll() throws DaoException;

	List ListaPorNaturezaProdutoReferenteA(long id)  throws DaoException;

	List ListaPorUsuarioSincroniza(long id) throws DaoException;

	void DeletePorNatureza(long codigoNatureza) throws DaoException;

	List ListaPorPalavraChavePesquisaReferenteA(long id) throws DaoException;
}
