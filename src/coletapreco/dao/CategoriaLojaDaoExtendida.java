package coletapreco.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.*;
import coletapreco.dao.basica.*;
import coletapreco.modelo.CategoriaLoja;


public  class CategoriaLojaDaoExtendida  extends CategoriaLojaDaoBase implements CategoriaLojaDao {

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new UnsupportedOperationException();
	}

	

	@Override
	public List ListaNaoRelacionadaEmCategoriaLojaProdutoListaPossui(
			long idProduto) throws DaoException {
		throw new UnsupportedOperationException();
	}

	

	@Override
	public CategoriaLoja obtemPorNomeLojaVirtual(CategoriaLoja pesquisa) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where id_loja_virtual_pa = " + pesquisa.getIdLojaVirtualPa() + 
				" and nome = '" + pesquisa.getNome().trim() + "'";
		return (CategoriaLoja) this.getObjeto(sql);
	} 
}
