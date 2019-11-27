package coletapreco.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.*;
import coletapreco.dao.basica.*;


public  class ModeloProdutoDaoExtendida  extends ModeloProdutoDaoBase implements ModeloProdutoDao {

	@Override
	public List ListaNaoRelacionadaEmModeloProdutoProdutoListaReferenteA(
			long idProduto) throws DaoException {
		throw new UnsupportedOperationException();
	} 
}
