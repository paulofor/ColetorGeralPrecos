package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class CategoriaLojaRegraColecao {
	
	public CategoriaLojaRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		CategoriaLojaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		CategoriaLojaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		CategoriaLojaFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private CategoriaLojaFiltro _filtro;

	public CategoriaLojaFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new CategoriaLojaFiltro();
		return _filtro;
	}

	public void setFiltro(CategoriaLojaFiltro dado) {
		_filtro = dado;
	}

	private CategoriaLojaFiltro[] _listaEntrada;
	@Deprecated
	protected CategoriaLojaFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final CategoriaLojaFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<CategoriaLoja> _listaItem;
	protected List<CategoriaLoja> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<CategoriaLoja> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final CategoriaLoja CriaSeNecessario() throws DaoException {
		CategoriaLoja saida;
		CategoriaLojaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaSeNecessario(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CategoriaLoja CriaSeNecessario(final DaoConexao conexao)
			throws DaoException;
	public final List<CategoriaLoja> ListaPorLojaNaturezaNivel0() throws DaoException {
		List<CategoriaLoja> saida;
		CategoriaLojaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorLojaNaturezaNivel0(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<CategoriaLoja> ListaPorLojaNaturezaNivel0(final DaoConexao conexao)
			throws DaoException;




	public static final CategoriaLojaDao getDao() {
		return DBB.getInstancia().getCategoriaLojaDao();
	}
	protected final CategoriaLojaDao getDao(final DaoConexao conexao) {
		CategoriaLojaDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final CategoriaLojaDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		CategoriaLojaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		CategoriaLojaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		CategoriaLojaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		CategoriaLojaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public CategoriaLoja PreInsercao(CategoriaLoja item) {
		return item;
	}

	public CategoriaLoja PreAlteracao(CategoriaLoja item) {
		return item;
	}

	public CategoriaLoja obtemPorChave(long chave) throws DaoException {
		CategoriaLojaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		CategoriaLoja saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public CategoriaLoja obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		CategoriaLojaDao dao = getDao();
		dao.setConexao(conexao);
		CategoriaLoja saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		CategoriaLojaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		CategoriaLojaDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		CategoriaLojaDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public CategoriaLoja excluiItem(CategoriaLoja item) throws DaoException {
		CategoriaLojaDao dao = getDao();
		DaoConexao conexao = null;
		CategoriaLoja saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CategoriaLoja excluiItem(CategoriaLoja item, DaoConexao conexao) throws DaoException {
		CategoriaLojaDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public CategoriaLoja alteraItem(CategoriaLoja item) throws DaoException {
		CategoriaLojaDao dao = getDao();
		DaoConexao conexao = null;
		CategoriaLoja saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CategoriaLoja alteraItem(CategoriaLoja item, DaoConexao conexao) throws DaoException {
		CategoriaLojaDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public CategoriaLoja insereItemLoad(CategoriaLoja item) throws DaoException {
		CategoriaLojaDao dao = getDao();
		DaoConexao conexao = null;
		CategoriaLoja saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CategoriaLoja insereItemLoad(CategoriaLoja item, DaoConexao conexao) throws DaoException {
		CategoriaLojaDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorFilhoCategoriaLoja(long id) throws DaoException {
		// Existe no DAO
		CategoriaLojaDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorCategoriaLojaFilho(id);
	}
	public boolean excluiPorFilhoCategoriaLoja(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorFilhoCategoriaLoja(long id, DaoConexao conn) throws DaoException {
		CategoriaLojaDao dao = getDao(conn);
		return dao.ListaPorCategoriaLojaFilho(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteANaturezaProduto(long id) throws DaoException {
		// Existe no DAO
		CategoriaLojaDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorNaturezaProdutoReferenteA(id);
	}
	public boolean excluiPorReferenteANaturezaProduto(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteANaturezaProduto(long id, DaoConexao conn) throws DaoException {
		CategoriaLojaDao dao = getDao(conn);
		return dao.ListaPorNaturezaProdutoReferenteA(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceALojaVirtual(long id) throws DaoException {
		// Existe no DAO
		CategoriaLojaDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorLojaVirtualPertenceA(id);
	}
	public boolean excluiPorPertenceALojaVirtual(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorPertenceALojaVirtual(long id, DaoConexao conn) throws DaoException {
		CategoriaLojaDao dao = getDao(conn);
		return dao.ListaPorLojaVirtualPertenceA(id);
	}
	
	
}
