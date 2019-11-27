package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class OportunidadeInteresseClienteRegraColecao {
	
	public OportunidadeInteresseClienteRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		OportunidadeInteresseClienteDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		OportunidadeInteresseClienteFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private OportunidadeInteresseClienteFiltro _filtro;

	public OportunidadeInteresseClienteFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new OportunidadeInteresseClienteFiltro();
		return _filtro;
	}

	public void setFiltro(OportunidadeInteresseClienteFiltro dado) {
		_filtro = dado;
	}

	private OportunidadeInteresseClienteFiltro[] _listaEntrada;
	@Deprecated
	protected OportunidadeInteresseClienteFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final OportunidadeInteresseClienteFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<OportunidadeInteresseCliente> _listaItem;
	protected List<OportunidadeInteresseCliente> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<OportunidadeInteresseCliente> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final OportunidadeInteresseClienteDao getDao() {
		return DBB.getInstancia().getOportunidadeInteresseClienteDao();
	}
	protected final OportunidadeInteresseClienteDao getDao(final DaoConexao conexao) {
		OportunidadeInteresseClienteDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final OportunidadeInteresseClienteDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public OportunidadeInteresseCliente PreInsercao(OportunidadeInteresseCliente item) {
		return item;
	}

	public OportunidadeInteresseCliente PreAlteracao(OportunidadeInteresseCliente item) {
		return item;
	}

	public OportunidadeInteresseCliente obtemPorChave(long chave) throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		OportunidadeInteresseCliente saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public OportunidadeInteresseCliente obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao();
		dao.setConexao(conexao);
		OportunidadeInteresseCliente saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public OportunidadeInteresseCliente excluiItem(OportunidadeInteresseCliente item) throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao();
		DaoConexao conexao = null;
		OportunidadeInteresseCliente saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OportunidadeInteresseCliente excluiItem(OportunidadeInteresseCliente item, DaoConexao conexao) throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public OportunidadeInteresseCliente alteraItem(OportunidadeInteresseCliente item) throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao();
		DaoConexao conexao = null;
		OportunidadeInteresseCliente saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OportunidadeInteresseCliente alteraItem(OportunidadeInteresseCliente item, DaoConexao conexao) throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public OportunidadeInteresseCliente insereItemLoad(OportunidadeInteresseCliente item) throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao();
		DaoConexao conexao = null;
		OportunidadeInteresseCliente saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OportunidadeInteresseCliente insereItemLoad(OportunidadeInteresseCliente item, DaoConexao conexao) throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceAProdutoCliente(long id) throws DaoException {
		// Existe no DAO
		OportunidadeInteresseClienteDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorProdutoClientePertenceA(id);
	}
	public boolean excluiPorPertenceAProdutoCliente(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorPertenceAProdutoCliente(long id, DaoConexao conn) throws DaoException {
		OportunidadeInteresseClienteDao dao = getDao(conn);
		return dao.ListaPorProdutoClientePertenceA(id);
	}
	
	
}
