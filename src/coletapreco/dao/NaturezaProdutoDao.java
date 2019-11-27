package coletapreco.dao;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.basica.*;
import coletapreco.modelo.NaturezaProduto;

public interface NaturezaProdutoDao
 extends NaturezaProdutoDaoBaseI {

	NaturezaProduto obtemPorCodigo(String codigoPesquisa) throws DaoException;

	NaturezaProduto obtemPorCodigoProduto(long idObj) throws DaoException;
}
