package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class PalavraChavePesquisaRegraColecao {
	
	public PalavraChavePesquisaRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		PalavraChavePesquisaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		PalavraChavePesquisaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		PalavraChavePesquisaFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private PalavraChavePesquisaFiltro _filtro;

	public PalavraChavePesquisaFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new PalavraChavePesquisaFiltro();
		return _filtro;
	}

	public void setFiltro(PalavraChavePesquisaFiltro dado) {
		_filtro = dado;
	}

	private PalavraChavePesquisaFiltro[] _listaEntrada;
	@Deprecated
	protected PalavraChavePesquisaFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final PalavraChavePesquisaFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<PalavraChavePesquisa> _listaItem;
	protected List<PalavraChavePesquisa> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<PalavraChavePesquisa> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final PalavraChavePesquisaDao getDao() {
		return DBB.getInstancia().getPalavraChavePesquisaDao();
	}
	protected final PalavraChavePesquisaDao getDao(final DaoConexao conexao) {
		PalavraChavePesquisaDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final PalavraChavePesquisaDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		PalavraChavePesquisaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		PalavraChavePesquisaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		PalavraChavePesquisaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		PalavraChavePesquisaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public PalavraChavePesquisa PreInsercao(PalavraChavePesquisa item) {
		return item;
	}

	public PalavraChavePesquisa PreAlteracao(PalavraChavePesquisa item) {
		return item;
	}

	public PalavraChavePesquisa obtemPorChave(long chave) throws DaoException {
		PalavraChavePesquisaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		PalavraChavePesquisa saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public PalavraChavePesquisa obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		PalavraChavePesquisaDao dao = getDao();
		dao.setConexao(conexao);
		PalavraChavePesquisa saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		PalavraChavePesquisaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		PalavraChavePesquisaDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		PalavraChavePesquisaDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public PalavraChavePesquisa excluiItem(PalavraChavePesquisa item) throws DaoException {
		PalavraChavePesquisaDao dao = getDao();
		DaoConexao conexao = null;
		PalavraChavePesquisa saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PalavraChavePesquisa excluiItem(PalavraChavePesquisa item, DaoConexao conexao) throws DaoException {
		PalavraChavePesquisaDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public PalavraChavePesquisa alteraItem(PalavraChavePesquisa item) throws DaoException {
		PalavraChavePesquisaDao dao = getDao();
		DaoConexao conexao = null;
		PalavraChavePesquisa saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PalavraChavePesquisa alteraItem(PalavraChavePesquisa item, DaoConexao conexao) throws DaoException {
		PalavraChavePesquisaDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public PalavraChavePesquisa insereItemLoad(PalavraChavePesquisa item) throws DaoException {
		PalavraChavePesquisaDao dao = getDao();
		DaoConexao conexao = null;
		PalavraChavePesquisa saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PalavraChavePesquisa insereItemLoad(PalavraChavePesquisa item, DaoConexao conexao) throws DaoException {
		PalavraChavePesquisaDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorSincronizaUsuario(long id) throws DaoException {
		// Existe no DAO
		PalavraChavePesquisaDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorUsuarioSincroniza(id);
	}
	public boolean excluiPorSincronizaUsuario(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorSincronizaUsuario(long id, DaoConexao conn) throws DaoException {
		PalavraChavePesquisaDao dao = getDao(conn);
		return dao.ListaPorUsuarioSincroniza(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteANaturezaProduto(long id) throws DaoException {
		// Existe no DAO
		PalavraChavePesquisaDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorNaturezaProdutoReferenteA(id);
	}
	public boolean excluiPorReferenteANaturezaProduto(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteANaturezaProduto(long id, DaoConexao conn) throws DaoException {
		PalavraChavePesquisaDao dao = getDao(conn);
		return dao.ListaPorNaturezaProdutoReferenteA(id);
	}
	
	
}
