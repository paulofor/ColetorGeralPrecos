package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class AppProdutoRegraColecao {
	
	public AppProdutoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		AppProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		AppProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		AppProdutoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private AppProdutoFiltro _filtro;

	public AppProdutoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new AppProdutoFiltro();
		return _filtro;
	}

	public void setFiltro(AppProdutoFiltro dado) {
		_filtro = dado;
	}

	private AppProdutoFiltro[] _listaEntrada;
	@Deprecated
	protected AppProdutoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final AppProdutoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<AppProduto> _listaItem;
	protected List<AppProduto> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<AppProduto> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final List<AppProduto> ListaAtivoComVitrine() throws DaoException {
		List<AppProduto> saida;
		AppProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaAtivoComVitrine(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<AppProduto> ListaAtivoComVitrine(final DaoConexao conexao)
			throws DaoException;
	public final AppProduto ChamaDispostivos() throws DaoException {
		AppProduto saida;
		AppProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ChamaDispostivos(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract AppProduto ChamaDispostivos(final DaoConexao conexao)
			throws DaoException;




	public static final AppProdutoDao getDao() {
		return DBB.getInstancia().getAppProdutoDao();
	}
	protected final AppProdutoDao getDao(final DaoConexao conexao) {
		AppProdutoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final AppProdutoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		AppProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		AppProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		AppProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		AppProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public AppProduto PreInsercao(AppProduto item) {
		return item;
	}

	public AppProduto PreAlteracao(AppProduto item) {
		return item;
	}

	public AppProduto obtemPorChave(long chave) throws DaoException {
		AppProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		AppProduto saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public AppProduto obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		AppProdutoDao dao = getDao();
		dao.setConexao(conexao);
		AppProduto saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		AppProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		AppProdutoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		AppProdutoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public AppProduto excluiItem(AppProduto item) throws DaoException {
		AppProdutoDao dao = getDao();
		DaoConexao conexao = null;
		AppProduto saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public AppProduto excluiItem(AppProduto item, DaoConexao conexao) throws DaoException {
		AppProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public AppProduto alteraItem(AppProduto item) throws DaoException {
		AppProdutoDao dao = getDao();
		DaoConexao conexao = null;
		AppProduto saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public AppProduto alteraItem(AppProduto item, DaoConexao conexao) throws DaoException {
		AppProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public AppProduto insereItemLoad(AppProduto item) throws DaoException {
		AppProdutoDao dao = getDao();
		DaoConexao conexao = null;
		AppProduto saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public AppProduto insereItemLoad(AppProduto item, DaoConexao conexao) throws DaoException {
		AppProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
