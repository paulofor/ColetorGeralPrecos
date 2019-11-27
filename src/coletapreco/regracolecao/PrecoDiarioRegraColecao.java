package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class PrecoDiarioRegraColecao {
	
	public PrecoDiarioRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		PrecoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		PrecoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		PrecoDiarioFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private PrecoDiarioFiltro _filtro;

	public PrecoDiarioFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new PrecoDiarioFiltro();
		return _filtro;
	}

	public void setFiltro(PrecoDiarioFiltro dado) {
		_filtro = dado;
	}

	private PrecoDiarioFiltro[] _listaEntrada;
	@Deprecated
	protected PrecoDiarioFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final PrecoDiarioFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<PrecoDiario> _listaItem;
	protected List<PrecoDiario> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<PrecoDiario> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final PrecoDiario RegistraPreco() throws DaoException {
		PrecoDiario saida;
		PrecoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = RegistraPreco(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract PrecoDiario RegistraPreco(final DaoConexao conexao)
			throws DaoException;
	public final PrecoDiario ObtemPorDataIdProduto() throws DaoException {
		PrecoDiario saida;
		PrecoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorDataIdProduto(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract PrecoDiario ObtemPorDataIdProduto(final DaoConexao conexao)
			throws DaoException;
	public final PrecoDiario ObtemMaisRecentePorIdProduto() throws DaoException {
		PrecoDiario saida;
		PrecoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemMaisRecentePorIdProduto(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract PrecoDiario ObtemMaisRecentePorIdProduto(final DaoConexao conexao)
			throws DaoException;
	public final PrecoDiario AtualizaPrecoDia() throws DaoException {
		PrecoDiario saida;
		PrecoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaPrecoDia(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract PrecoDiario AtualizaPrecoDia(final DaoConexao conexao)
			throws DaoException;
	public final PrecoDiario EnviaListaServidorComoCliente() throws DaoException {
		PrecoDiario saida;
		PrecoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = EnviaListaServidorComoCliente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract PrecoDiario EnviaListaServidorComoCliente(final DaoConexao conexao)
			throws DaoException;
	public final List<PrecoDiario> ListaPorIdProduto2Mes() throws DaoException {
		List<PrecoDiario> saida;
		PrecoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorIdProduto2Mes(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<PrecoDiario> ListaPorIdProduto2Mes(final DaoConexao conexao)
			throws DaoException;
	public final List<PrecoDiario> ListaPorIdProduto1mes() throws DaoException {
		List<PrecoDiario> saida;
		PrecoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorIdProduto1mes(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<PrecoDiario> ListaPorIdProduto1mes(final DaoConexao conexao)
			throws DaoException;




	public static final PrecoDiarioDao getDao() {
		return DBB.getInstancia().getPrecoDiarioDao();
	}
	protected final PrecoDiarioDao getDao(final DaoConexao conexao) {
		PrecoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final PrecoDiarioDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		PrecoDiarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		PrecoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		PrecoDiarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		PrecoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public PrecoDiario PreInsercao(PrecoDiario item) {
		return item;
	}

	public PrecoDiario PreAlteracao(PrecoDiario item) {
		return item;
	}

	public PrecoDiario obtemPorChave(long chave) throws DaoException {
		PrecoDiarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		PrecoDiario saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public PrecoDiario obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		PrecoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		PrecoDiario saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		PrecoDiarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		PrecoDiarioDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		PrecoDiarioDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public PrecoDiario excluiItem(PrecoDiario item) throws DaoException {
		PrecoDiarioDao dao = getDao();
		DaoConexao conexao = null;
		PrecoDiario saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PrecoDiario excluiItem(PrecoDiario item, DaoConexao conexao) throws DaoException {
		PrecoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public PrecoDiario alteraItem(PrecoDiario item) throws DaoException {
		PrecoDiarioDao dao = getDao();
		DaoConexao conexao = null;
		PrecoDiario saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PrecoDiario alteraItem(PrecoDiario item, DaoConexao conexao) throws DaoException {
		PrecoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public PrecoDiario insereItemLoad(PrecoDiario item) throws DaoException {
		PrecoDiarioDao dao = getDao();
		DaoConexao conexao = null;
		PrecoDiario saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PrecoDiario insereItemLoad(PrecoDiario item, DaoConexao conexao) throws DaoException {
		PrecoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceAProduto(long id) throws DaoException {
		// Existe no DAO
		PrecoDiarioDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorProdutoPertenceA(id);
	}
	public boolean excluiPorPertenceAProduto(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorPertenceAProduto(long id, DaoConexao conn) throws DaoException {
		PrecoDiarioDao dao = getDao(conn);
		return dao.ListaPorProdutoPertenceA(id);
	}
	
	
}
