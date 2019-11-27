package coletapreco.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.*;
import coletapreco.dao.basica.*;
import coletapreco.modelo.CategoriaLojaProduto;


public  class CategoriaLojaProdutoDaoExtendida  extends CategoriaLojaProdutoDaoBase implements CategoriaLojaProdutoDao {

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public CategoriaLojaProduto ObtemPorRelacionamento(CategoriaLojaProduto item) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where id_categoria_loja_ra = " + item.getIdCategoriaLojaRa() + " and " +
				" id_produto_ra = " + item.getIdProdutoRa();
		return (CategoriaLojaProduto) this.getObjeto(sql);
	}

	

	
}
