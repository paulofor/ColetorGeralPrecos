package coletapreco.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.basica.CategoriaLojaDaoBase;
import coletapreco.dao.basica.DataSourceNuvem;
import coletapreco.dao.basica.NaturezaProdutoDaoBase;
import coletapreco.modelo.NaturezaProduto;


public  class NaturezaProdutoDaoExtendida  extends NaturezaProdutoDaoBase implements NaturezaProdutoDao {

	
	//public NaturezaProdutoDaoExtendida() {
	//	super(new DataSourceNuvem());
	//}
	
	@Override
	public List ListaNaoRelacionadaEmCategoriaLojaListaPossui(long idCategoriaLoja) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public NaturezaProduto obtemPorCodigo(String codigoPesquisa) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where codigo_natureza_produto = '" + codigoPesquisa + "' ";
		return (NaturezaProduto) this.getObjeto(sql);
	}

	@Override
	public List ListaNaoRelacionadaEmLojaNaturezaListaEncontrada(long idLojaVirtual) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public NaturezaProduto obtemPorCodigoProduto(long idObj) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				this.innerJoinCategoriaLoja_Possui() +
				CategoriaLojaDaoBase.innerJoinCategoriaLojaProduto_Possui() +
				" where id_produto_ra = " + idObj;
		return (NaturezaProduto) this.getObjeto(sql);
				
	}

	@Override
	public List ListaNaoRelacionadaEmOportunidadeDiaListaPossui(long idOportunidadeDia) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaNaoRelacionadaEmUsuarioPesquisaListaPesquisadoPor(long idUsuario) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaNaoRelacionadaEmContagemProdutoListaPossui(long idContagemProduto) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new UnsupportedOperationException();
	}

	

	@Override
	public List ListaNaoRelacionadaEmPalavraChavePesquisaListaPodePesquisar(long idPalavraChavePesquisa) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaNaoRelacionadaEmProdutoClienteListaPossui(long idProdutoCliente) throws DaoException {
		throw new UnsupportedOperationException();
	}

	
}
