package coletapreco.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.*;
import coletapreco.dao.basica.*;
import coletapreco.modelo.Marca;


public  class MarcaDaoExtendida  extends MarcaDaoBase implements MarcaDao {

	@Override
	public Marca ObtemPorNome(String nome) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where nome_marca = '" + nome + "'";
		return (Marca) this.getObjeto(sql);
	}

	@Override
	public List ListaNaoRelacionadaEmProdutoListaReferenteA(long idProduto)
			throws DaoException {
		throw new UnsupportedOperationException();
	} 
	
	
}
