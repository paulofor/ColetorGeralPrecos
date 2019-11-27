package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class FacebookPostPerformanceRegraColecao {
	
	public FacebookPostPerformanceRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		FacebookPostPerformanceDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		FacebookPostPerformanceDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		FacebookPostPerformanceFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private FacebookPostPerformanceFiltro _filtro;

	public FacebookPostPerformanceFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new FacebookPostPerformanceFiltro();
		return _filtro;
	}

	public void setFiltro(FacebookPostPerformanceFiltro dado) {
		_filtro = dado;
	}

	private FacebookPostPerformanceFiltro[] _listaEntrada;
	@Deprecated
	protected FacebookPostPerformanceFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final FacebookPostPerformanceFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<FacebookPostPerformance> _listaItem;
	protected List<FacebookPostPerformance> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<FacebookPostPerformance> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final FacebookPostPerformanceDao getDao() {
		return DBB.getInstancia().getFacebookPostPerformanceDao();
	}
	protected final FacebookPostPerformanceDao getDao(final DaoConexao conexao) {
		FacebookPostPerformanceDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final FacebookPostPerformanceDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		FacebookPostPerformanceDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		FacebookPostPerformanceDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		FacebookPostPerformanceDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		FacebookPostPerformanceDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public FacebookPostPerformance PreInsercao(FacebookPostPerformance item) {
		return item;
	}

	public FacebookPostPerformance PreAlteracao(FacebookPostPerformance item) {
		return item;
	}

	public FacebookPostPerformance obtemPorChave(long chave) throws DaoException {
		FacebookPostPerformanceDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		FacebookPostPerformance saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public FacebookPostPerformance obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		FacebookPostPerformanceDao dao = getDao();
		dao.setConexao(conexao);
		FacebookPostPerformance saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		FacebookPostPerformanceDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		FacebookPostPerformanceDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		FacebookPostPerformanceDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public FacebookPostPerformance excluiItem(FacebookPostPerformance item) throws DaoException {
		FacebookPostPerformanceDao dao = getDao();
		DaoConexao conexao = null;
		FacebookPostPerformance saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public FacebookPostPerformance excluiItem(FacebookPostPerformance item, DaoConexao conexao) throws DaoException {
		FacebookPostPerformanceDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public FacebookPostPerformance alteraItem(FacebookPostPerformance item) throws DaoException {
		FacebookPostPerformanceDao dao = getDao();
		DaoConexao conexao = null;
		FacebookPostPerformance saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public FacebookPostPerformance alteraItem(FacebookPostPerformance item, DaoConexao conexao) throws DaoException {
		FacebookPostPerformanceDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public FacebookPostPerformance insereItemLoad(FacebookPostPerformance item) throws DaoException {
		FacebookPostPerformanceDao dao = getDao();
		DaoConexao conexao = null;
		FacebookPostPerformance saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public FacebookPostPerformance insereItemLoad(FacebookPostPerformance item, DaoConexao conexao) throws DaoException {
		FacebookPostPerformanceDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAFacebookPost(long id) throws DaoException {
		// Existe no DAO
		FacebookPostPerformanceDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorFacebookPostReferenteA(id);
	}
	public boolean excluiPorReferenteAFacebookPost(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteAFacebookPost(long id, DaoConexao conn) throws DaoException {
		FacebookPostPerformanceDao dao = getDao(conn);
		return dao.ListaPorFacebookPostReferenteA(id);
	}
	
	
}
