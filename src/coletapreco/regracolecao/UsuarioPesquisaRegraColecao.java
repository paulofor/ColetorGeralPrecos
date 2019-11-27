package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class UsuarioPesquisaRegraColecao {
	
	public UsuarioPesquisaRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		UsuarioPesquisaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		UsuarioPesquisaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		UsuarioPesquisaFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private UsuarioPesquisaFiltro _filtro;

	public UsuarioPesquisaFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new UsuarioPesquisaFiltro();
		return _filtro;
	}

	public void setFiltro(UsuarioPesquisaFiltro dado) {
		_filtro = dado;
	}

	private UsuarioPesquisaFiltro[] _listaEntrada;
	@Deprecated
	protected UsuarioPesquisaFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final UsuarioPesquisaFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<UsuarioPesquisa> _listaItem;
	protected List<UsuarioPesquisa> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<UsuarioPesquisa> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final UsuarioPesquisaDao getDao() {
		return DBB.getInstancia().getUsuarioPesquisaDao();
	}
	protected final UsuarioPesquisaDao getDao(final DaoConexao conexao) {
		UsuarioPesquisaDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final UsuarioPesquisaDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		UsuarioPesquisaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		UsuarioPesquisaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		UsuarioPesquisaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		UsuarioPesquisaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public UsuarioPesquisa PreInsercao(UsuarioPesquisa item) {
		return item;
	}

	public UsuarioPesquisa PreAlteracao(UsuarioPesquisa item) {
		return item;
	}

	public UsuarioPesquisa obtemPorChave(long chave) throws DaoException {
		UsuarioPesquisaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		UsuarioPesquisa saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public UsuarioPesquisa obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		UsuarioPesquisaDao dao = getDao();
		dao.setConexao(conexao);
		UsuarioPesquisa saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		UsuarioPesquisaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		UsuarioPesquisaDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		UsuarioPesquisaDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public UsuarioPesquisa excluiItem(UsuarioPesquisa item) throws DaoException {
		UsuarioPesquisaDao dao = getDao();
		DaoConexao conexao = null;
		UsuarioPesquisa saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public UsuarioPesquisa excluiItem(UsuarioPesquisa item, DaoConexao conexao) throws DaoException {
		UsuarioPesquisaDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public UsuarioPesquisa alteraItem(UsuarioPesquisa item) throws DaoException {
		UsuarioPesquisaDao dao = getDao();
		DaoConexao conexao = null;
		UsuarioPesquisa saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public UsuarioPesquisa alteraItem(UsuarioPesquisa item, DaoConexao conexao) throws DaoException {
		UsuarioPesquisaDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public UsuarioPesquisa insereItemLoad(UsuarioPesquisa item) throws DaoException {
		UsuarioPesquisaDao dao = getDao();
		DaoConexao conexao = null;
		UsuarioPesquisa saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public UsuarioPesquisa insereItemLoad(UsuarioPesquisa item, DaoConexao conexao) throws DaoException {
		UsuarioPesquisaDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorSincronizaUsuario(long id) throws DaoException {
		// Existe no DAO
		UsuarioPesquisaDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorUsuarioSincroniza(id);
	}
	public boolean excluiPorSincronizaUsuario(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorSincronizaUsuario(long id, DaoConexao conn) throws DaoException {
		UsuarioPesquisaDao dao = getDao(conn);
		return dao.ListaPorUsuarioSincroniza(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPesquisaNaturezaProduto(long id) throws DaoException {
		// Existe no DAO
		UsuarioPesquisaDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorNaturezaProdutoPesquisa(id);
	}
	public boolean excluiPorPesquisaNaturezaProduto(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorPesquisaNaturezaProduto(long id, DaoConexao conn) throws DaoException {
		UsuarioPesquisaDao dao = getDao(conn);
		return dao.ListaPorNaturezaProdutoPesquisa(id);
	}
	
	
}
