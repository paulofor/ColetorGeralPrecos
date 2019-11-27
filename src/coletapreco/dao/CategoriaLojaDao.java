package coletapreco.dao;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.basica.*;
import coletapreco.modelo.CategoriaLoja;

public interface CategoriaLojaDao
 extends CategoriaLojaDaoBaseI {

	CategoriaLoja obtemPorNomeLojaVirtual(CategoriaLoja pesquisa) throws DaoException; 
}
