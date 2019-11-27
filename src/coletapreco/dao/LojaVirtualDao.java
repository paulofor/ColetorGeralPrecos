package coletapreco.dao;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.basica.*;
import coletapreco.modelo.LojaVirtual;

public interface LojaVirtualDao
 extends LojaVirtualDaoBaseI {

	void corrigeTabelas() throws DaoException;

	LojaVirtual ObtemPorProduto(long idProduto) throws DaoException;
}
