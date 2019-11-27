package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class FacebookPostRegraColecao {
	
	public FacebookPostRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		FacebookPostDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		FacebookPostDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		FacebookPostFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private FacebookPostFiltro _filtro;

	public FacebookPostFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new FacebookPostFiltro();
		return _filtro;
	}

	public void setFiltro(FacebookPostFiltro dado) {
		_filtro = dado;
	}

	private FacebookPostFiltro[] _listaEntrada;
	@Deprecated
	protected FacebookPostFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final FacebookPostFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<FacebookPost> _listaItem;
	protected List<FacebookPost> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<FacebookPost> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final FacebookPost CriaPostsDia() throws DaoException {
		FacebookPost saida;
		FacebookPostDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaPostsDia(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract FacebookPost CriaPostsDia(final DaoConexao conexao)
			throws DaoException;




	public static final FacebookPostDao getDao() {
		return DBB.getInstancia().getFacebookPostDao();
	}
	protected final FacebookPostDao getDao(final DaoConexao conexao) {
		FacebookPostDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final FacebookPostDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		FacebookPostDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		FacebookPostDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		FacebookPostDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		FacebookPostDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public FacebookPost PreInsercao(FacebookPost item) {
		return item;
	}

	public FacebookPost PreAlteracao(FacebookPost item) {
		return item;
	}

	public FacebookPost obtemPorChave(long chave) throws DaoException {
		FacebookPostDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		FacebookPost saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public FacebookPost obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		FacebookPostDao dao = getDao();
		dao.setConexao(conexao);
		FacebookPost saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		FacebookPostDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		FacebookPostDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		FacebookPostDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public FacebookPost excluiItem(FacebookPost item) throws DaoException {
		FacebookPostDao dao = getDao();
		DaoConexao conexao = null;
		FacebookPost saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public FacebookPost excluiItem(FacebookPost item, DaoConexao conexao) throws DaoException {
		FacebookPostDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public FacebookPost alteraItem(FacebookPost item) throws DaoException {
		FacebookPostDao dao = getDao();
		DaoConexao conexao = null;
		FacebookPost saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public FacebookPost alteraItem(FacebookPost item, DaoConexao conexao) throws DaoException {
		FacebookPostDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public FacebookPost insereItemLoad(FacebookPost item) throws DaoException {
		FacebookPostDao dao = getDao();
		DaoConexao conexao = null;
		FacebookPost saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public FacebookPost insereItemLoad(FacebookPost item, DaoConexao conexao) throws DaoException {
		FacebookPostDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorFeitoEmFacebookFanpage(long id) throws DaoException {
		// Existe no DAO
		FacebookPostDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorFacebookFanpageFeitoEm(id);
	}
	public boolean excluiPorFeitoEmFacebookFanpage(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorFeitoEmFacebookFanpage(long id, DaoConexao conn) throws DaoException {
		FacebookPostDao dao = getDao(conn);
		return dao.ListaPorFacebookFanpageFeitoEm(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorDivulgandoProduto(long id) throws DaoException {
		// Existe no DAO
		FacebookPostDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorProdutoDivulgando(id);
	}
	public boolean excluiPorDivulgandoProduto(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorDivulgandoProduto(long id, DaoConexao conn) throws DaoException {
		FacebookPostDao dao = getDao(conn);
		return dao.ListaPorProdutoDivulgando(id);
	}
	
	
}
