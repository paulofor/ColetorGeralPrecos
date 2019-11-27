package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class ProdutoClienteRegraColecao {
	
	public ProdutoClienteRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		ProdutoClienteDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		ProdutoClienteDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		ProdutoClienteFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private ProdutoClienteFiltro _filtro;

	public ProdutoClienteFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new ProdutoClienteFiltro();
		return _filtro;
	}

	public void setFiltro(ProdutoClienteFiltro dado) {
		_filtro = dado;
	}

	private ProdutoClienteFiltro[] _listaEntrada;
	@Deprecated
	protected ProdutoClienteFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final ProdutoClienteFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<ProdutoCliente> _listaItem;
	protected List<ProdutoCliente> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<ProdutoCliente> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final ProdutoCliente CriaDeOrigem() throws DaoException {
		ProdutoCliente saida;
		ProdutoClienteDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaDeOrigem(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract ProdutoCliente CriaDeOrigem(final DaoConexao conexao)
			throws DaoException;
	public final ProdutoCliente ReinicializaNaturezaLista() throws DaoException {
		ProdutoCliente saida;
		ProdutoClienteDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ReinicializaNaturezaLista(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract ProdutoCliente ReinicializaNaturezaLista(final DaoConexao conexao)
			throws DaoException;
	public final List<ProdutoCliente> RetiraDuplicata() throws DaoException {
		List<ProdutoCliente> saida;
		ProdutoClienteDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = RetiraDuplicata(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<ProdutoCliente> RetiraDuplicata(final DaoConexao conexao)
			throws DaoException;




	public static final ProdutoClienteDao getDao() {
		return DBB.getInstancia().getProdutoClienteDao();
	}
	protected final ProdutoClienteDao getDao(final DaoConexao conexao) {
		ProdutoClienteDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final ProdutoClienteDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		ProdutoClienteDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		ProdutoClienteDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		ProdutoClienteDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		ProdutoClienteDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public ProdutoCliente PreInsercao(ProdutoCliente item) {
		return item;
	}

	public ProdutoCliente PreAlteracao(ProdutoCliente item) {
		return item;
	}

	public ProdutoCliente obtemPorChave(long chave) throws DaoException {
		ProdutoClienteDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		ProdutoCliente saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public ProdutoCliente obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		ProdutoClienteDao dao = getDao();
		dao.setConexao(conexao);
		ProdutoCliente saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		ProdutoClienteDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		ProdutoClienteDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		ProdutoClienteDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public ProdutoCliente excluiItem(ProdutoCliente item) throws DaoException {
		ProdutoClienteDao dao = getDao();
		DaoConexao conexao = null;
		ProdutoCliente saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ProdutoCliente excluiItem(ProdutoCliente item, DaoConexao conexao) throws DaoException {
		ProdutoClienteDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public ProdutoCliente alteraItem(ProdutoCliente item) throws DaoException {
		ProdutoClienteDao dao = getDao();
		DaoConexao conexao = null;
		ProdutoCliente saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ProdutoCliente alteraItem(ProdutoCliente item, DaoConexao conexao) throws DaoException {
		ProdutoClienteDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public ProdutoCliente insereItemLoad(ProdutoCliente item) throws DaoException {
		ProdutoClienteDao dao = getDao();
		DaoConexao conexao = null;
		ProdutoCliente saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ProdutoCliente insereItemLoad(ProdutoCliente item, DaoConexao conexao) throws DaoException {
		ProdutoClienteDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteANaturezaProduto(long id) throws DaoException {
		// Existe no DAO
		ProdutoClienteDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorNaturezaProdutoReferenteA(id);
	}
	public boolean excluiPorReferenteANaturezaProduto(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteANaturezaProduto(long id, DaoConexao conn) throws DaoException {
		ProdutoClienteDao dao = getDao(conn);
		return dao.ListaPorNaturezaProdutoReferenteA(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorSincronizaUsuario(long id) throws DaoException {
		// Existe no DAO
		ProdutoClienteDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorUsuarioSincroniza(id);
	}
	public boolean excluiPorSincronizaUsuario(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorSincronizaUsuario(long id, DaoConexao conn) throws DaoException {
		ProdutoClienteDao dao = getDao(conn);
		return dao.ListaPorUsuarioSincroniza(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAPalavraChavePesquisa(long id) throws DaoException {
		// Existe no DAO
		ProdutoClienteDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorPalavraChavePesquisaReferenteA(id);
	}
	public boolean excluiPorReferenteAPalavraChavePesquisa(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteAPalavraChavePesquisa(long id, DaoConexao conn) throws DaoException {
		ProdutoClienteDao dao = getDao(conn);
		return dao.ListaPorPalavraChavePesquisaReferenteA(id);
	}
	
	
}
