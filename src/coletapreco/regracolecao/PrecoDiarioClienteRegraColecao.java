package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class PrecoDiarioClienteRegraColecao {
	
	public PrecoDiarioClienteRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		PrecoDiarioClienteDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		PrecoDiarioClienteDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		PrecoDiarioClienteFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private PrecoDiarioClienteFiltro _filtro;

	public PrecoDiarioClienteFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new PrecoDiarioClienteFiltro();
		return _filtro;
	}

	public void setFiltro(PrecoDiarioClienteFiltro dado) {
		_filtro = dado;
	}

	private PrecoDiarioClienteFiltro[] _listaEntrada;
	@Deprecated
	protected PrecoDiarioClienteFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final PrecoDiarioClienteFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<PrecoDiarioCliente> _listaItem;
	protected List<PrecoDiarioCliente> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<PrecoDiarioCliente> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final List<PrecoDiarioCliente> ConverteEnviaListaParaCliente() throws DaoException {
		List<PrecoDiarioCliente> saida;
		PrecoDiarioClienteDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ConverteEnviaListaParaCliente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<PrecoDiarioCliente> ConverteEnviaListaParaCliente(final DaoConexao conexao)
			throws DaoException;




	public static final PrecoDiarioClienteDao getDao() {
		return DBB.getInstancia().getPrecoDiarioClienteDao();
	}
	protected final PrecoDiarioClienteDao getDao(final DaoConexao conexao) {
		PrecoDiarioClienteDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final PrecoDiarioClienteDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		PrecoDiarioClienteDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		PrecoDiarioClienteDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		PrecoDiarioClienteDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		PrecoDiarioClienteDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public PrecoDiarioCliente PreInsercao(PrecoDiarioCliente item) {
		return item;
	}

	public PrecoDiarioCliente PreAlteracao(PrecoDiarioCliente item) {
		return item;
	}

	public PrecoDiarioCliente obtemPorChave(long chave) throws DaoException {
		PrecoDiarioClienteDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		PrecoDiarioCliente saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public PrecoDiarioCliente obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		PrecoDiarioClienteDao dao = getDao();
		dao.setConexao(conexao);
		PrecoDiarioCliente saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		PrecoDiarioClienteDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		PrecoDiarioClienteDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		PrecoDiarioClienteDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public PrecoDiarioCliente excluiItem(PrecoDiarioCliente item) throws DaoException {
		PrecoDiarioClienteDao dao = getDao();
		DaoConexao conexao = null;
		PrecoDiarioCliente saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PrecoDiarioCliente excluiItem(PrecoDiarioCliente item, DaoConexao conexao) throws DaoException {
		PrecoDiarioClienteDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public PrecoDiarioCliente alteraItem(PrecoDiarioCliente item) throws DaoException {
		PrecoDiarioClienteDao dao = getDao();
		DaoConexao conexao = null;
		PrecoDiarioCliente saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PrecoDiarioCliente alteraItem(PrecoDiarioCliente item, DaoConexao conexao) throws DaoException {
		PrecoDiarioClienteDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public PrecoDiarioCliente insereItemLoad(PrecoDiarioCliente item) throws DaoException {
		PrecoDiarioClienteDao dao = getDao();
		DaoConexao conexao = null;
		PrecoDiarioCliente saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PrecoDiarioCliente insereItemLoad(PrecoDiarioCliente item, DaoConexao conexao) throws DaoException {
		PrecoDiarioClienteDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceAProdutoCliente(long id) throws DaoException {
		// Existe no DAO
		PrecoDiarioClienteDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorProdutoClientePertenceA(id);
	}
	public boolean excluiPorPertenceAProdutoCliente(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorPertenceAProdutoCliente(long id, DaoConexao conn) throws DaoException {
		PrecoDiarioClienteDao dao = getDao(conn);
		return dao.ListaPorProdutoClientePertenceA(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorSincronizaUsuario(long id) throws DaoException {
		// Existe no DAO
		PrecoDiarioClienteDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorUsuarioSincroniza(id);
	}
	public boolean excluiPorSincronizaUsuario(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorSincronizaUsuario(long id, DaoConexao conn) throws DaoException {
		PrecoDiarioClienteDao dao = getDao(conn);
		return dao.ListaPorUsuarioSincroniza(id);
	}
	
	
}
