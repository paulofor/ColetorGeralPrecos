package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class NaturezaProdutoRegraColecao {
	
	public NaturezaProdutoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		NaturezaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		NaturezaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		NaturezaProdutoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private NaturezaProdutoFiltro _filtro;

	public NaturezaProdutoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new NaturezaProdutoFiltro();
		return _filtro;
	}

	public void setFiltro(NaturezaProdutoFiltro dado) {
		_filtro = dado;
	}

	private NaturezaProdutoFiltro[] _listaEntrada;
	@Deprecated
	protected NaturezaProdutoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final NaturezaProdutoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<NaturezaProduto> _listaItem;
	protected List<NaturezaProduto> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<NaturezaProduto> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final NaturezaProduto ObtemPorCodigo() throws DaoException {
		NaturezaProduto saida;
		NaturezaProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorCodigo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract NaturezaProduto ObtemPorCodigo(final DaoConexao conexao)
			throws DaoException;
	public final NaturezaProduto ObtemPorProduto() throws DaoException {
		NaturezaProduto saida;
		NaturezaProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorProduto(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract NaturezaProduto ObtemPorProduto(final DaoConexao conexao)
			throws DaoException;




	public static final NaturezaProdutoDao getDao() {
		return DBB.getInstancia().getNaturezaProdutoDao();
	}
	protected final NaturezaProdutoDao getDao(final DaoConexao conexao) {
		NaturezaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final NaturezaProdutoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		NaturezaProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		NaturezaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		NaturezaProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		NaturezaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public NaturezaProduto PreInsercao(NaturezaProduto item) {
		return item;
	}

	public NaturezaProduto PreAlteracao(NaturezaProduto item) {
		return item;
	}

	public NaturezaProduto obtemPorChave(long chave) throws DaoException {
		NaturezaProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		NaturezaProduto saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public NaturezaProduto obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		NaturezaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		NaturezaProduto saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		NaturezaProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		NaturezaProdutoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		NaturezaProdutoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public NaturezaProduto excluiItem(NaturezaProduto item) throws DaoException {
		NaturezaProdutoDao dao = getDao();
		DaoConexao conexao = null;
		NaturezaProduto saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public NaturezaProduto excluiItem(NaturezaProduto item, DaoConexao conexao) throws DaoException {
		NaturezaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public NaturezaProduto alteraItem(NaturezaProduto item) throws DaoException {
		NaturezaProdutoDao dao = getDao();
		DaoConexao conexao = null;
		NaturezaProduto saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public NaturezaProduto alteraItem(NaturezaProduto item, DaoConexao conexao) throws DaoException {
		NaturezaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public NaturezaProduto insereItemLoad(NaturezaProduto item) throws DaoException {
		NaturezaProdutoDao dao = getDao();
		DaoConexao conexao = null;
		NaturezaProduto saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public NaturezaProduto insereItemLoad(NaturezaProduto item, DaoConexao conexao) throws DaoException {
		NaturezaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorAtendidoPorAppProduto(long id) throws DaoException {
		// Existe no DAO
		NaturezaProdutoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorAppProdutoAtendidoPor(id);
	}
	public boolean excluiPorAtendidoPorAppProduto(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorAtendidoPorAppProduto(long id, DaoConexao conn) throws DaoException {
		NaturezaProdutoDao dao = getDao(conn);
		return dao.ListaPorAppProdutoAtendidoPor(id);
	}
	
	
}
