package coletapreco.dao;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.basica.*;
import coletapreco.modelo.Marca;

public interface MarcaDao
 extends MarcaDaoBaseI {

	Marca ObtemPorNome(String nome) throws DaoException; 
}
