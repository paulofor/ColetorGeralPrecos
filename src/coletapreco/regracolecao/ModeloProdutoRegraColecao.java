package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class ModeloProdutoRegraColecao {
	
	public ModeloProdutoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		ModeloProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		ModeloProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		ModeloProdutoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private ModeloProdutoFiltro _filtro;

	public ModeloProdutoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new ModeloProdutoFiltro();
		return _filtro;
	}

	public void setFiltro(ModeloProdutoFiltro dado) {
		_filtro = dado;
	}

	private ModeloProdutoFiltro[] _listaEntrada;
	@Deprecated
	protected ModeloProdutoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final ModeloProdutoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<ModeloProduto> _listaItem;
	protected List<ModeloProduto> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<ModeloProduto> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final ModeloProduto UnificacaoProduto() throws DaoException {
		ModeloProduto saida;
		ModeloProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = UnificacaoProduto(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract ModeloProduto UnificacaoProduto(final DaoConexao conexao)
			throws DaoException;
	public final ModeloProduto CriaModeloNovo() throws DaoException {
		ModeloProduto saida;
		ModeloProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaModeloNovo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract ModeloProduto CriaModeloNovo(final DaoConexao conexao)
			throws DaoException;




	public static final ModeloProdutoDao getDao() {
		return DBB.getInstancia().getModeloProdutoDao();
	}
	protected final ModeloProdutoDao getDao(final DaoConexao conexao) {
		ModeloProdutoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final ModeloProdutoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		ModeloProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		ModeloProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		ModeloProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		ModeloProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public ModeloProduto PreInsercao(ModeloProduto item) {
		return item;
	}

	public ModeloProduto PreAlteracao(ModeloProduto item) {
		return item;
	}

	public ModeloProduto obtemPorChave(long chave) throws DaoException {
		ModeloProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		ModeloProduto saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public ModeloProduto obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		ModeloProdutoDao dao = getDao();
		dao.setConexao(conexao);
		ModeloProduto saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		ModeloProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		ModeloProdutoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		ModeloProdutoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public ModeloProduto excluiItem(ModeloProduto item) throws DaoException {
		ModeloProdutoDao dao = getDao();
		DaoConexao conexao = null;
		ModeloProduto saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ModeloProduto excluiItem(ModeloProduto item, DaoConexao conexao) throws DaoException {
		ModeloProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public ModeloProduto alteraItem(ModeloProduto item) throws DaoException {
		ModeloProdutoDao dao = getDao();
		DaoConexao conexao = null;
		ModeloProduto saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ModeloProduto alteraItem(ModeloProduto item, DaoConexao conexao) throws DaoException {
		ModeloProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public ModeloProduto insereItemLoad(ModeloProduto item) throws DaoException {
		ModeloProdutoDao dao = getDao();
		DaoConexao conexao = null;
		ModeloProduto saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ModeloProduto insereItemLoad(ModeloProduto item, DaoConexao conexao) throws DaoException {
		ModeloProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
