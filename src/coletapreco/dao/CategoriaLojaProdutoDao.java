package coletapreco.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.basica.*;
import coletapreco.modelo.CategoriaLojaProduto;

public interface CategoriaLojaProdutoDao
 extends CategoriaLojaProdutoDaoBaseI {

	CategoriaLojaProduto ObtemPorRelacionamento(CategoriaLojaProduto item) throws DaoException;

	
}
