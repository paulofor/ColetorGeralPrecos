package coletapreco.dao;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.basica.*;

public interface InteresseProdutoDao
 extends InteresseProdutoDaoBaseI {

	List ListaPorUsuarioSincroniza(long id) throws DaoException;

	void AtualizaPrecoGeralMonitorado() throws DaoException;
	
	void AtualizaPrecoMonitoradoPorUsuario(long id) throws DaoException;
}
