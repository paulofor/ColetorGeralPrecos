package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class CategoriaLojaProdutoRegraColecao {
	
	public CategoriaLojaProdutoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		CategoriaLojaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		CategoriaLojaProdutoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private CategoriaLojaProdutoFiltro _filtro;

	public CategoriaLojaProdutoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new CategoriaLojaProdutoFiltro();
		return _filtro;
	}

	public void setFiltro(CategoriaLojaProdutoFiltro dado) {
		_filtro = dado;
	}

	private CategoriaLojaProdutoFiltro[] _listaEntrada;
	@Deprecated
	protected CategoriaLojaProdutoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final CategoriaLojaProdutoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<CategoriaLojaProduto> _listaItem;
	protected List<CategoriaLojaProduto> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<CategoriaLojaProduto> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final CategoriaLojaProduto AtualizaRelacionamento() throws DaoException {
		CategoriaLojaProduto saida;
		CategoriaLojaProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaRelacionamento(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CategoriaLojaProduto AtualizaRelacionamento(final DaoConexao conexao)
			throws DaoException;
	public final List<CategoriaLojaProduto> PersisteParseLista() throws DaoException {
		List<CategoriaLojaProduto> saida;
		CategoriaLojaProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = PersisteParseLista(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<CategoriaLojaProduto> PersisteParseLista(final DaoConexao conexao)
			throws DaoException;




	public static final CategoriaLojaProdutoDao getDao() {
		return DBB.getInstancia().getCategoriaLojaProdutoDao();
	}
	protected final CategoriaLojaProdutoDao getDao(final DaoConexao conexao) {
		CategoriaLojaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final CategoriaLojaProdutoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public CategoriaLojaProduto PreInsercao(CategoriaLojaProduto item) {
		return item;
	}

	public CategoriaLojaProduto PreAlteracao(CategoriaLojaProduto item) {
		return item;
	}

	public CategoriaLojaProduto obtemPorChave(long chave) throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		CategoriaLojaProduto saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public CategoriaLojaProduto obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		CategoriaLojaProduto saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public CategoriaLojaProduto excluiItem(CategoriaLojaProduto item) throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		DaoConexao conexao = null;
		CategoriaLojaProduto saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CategoriaLojaProduto excluiItem(CategoriaLojaProduto item, DaoConexao conexao) throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public CategoriaLojaProduto alteraItem(CategoriaLojaProduto item) throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		DaoConexao conexao = null;
		CategoriaLojaProduto saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CategoriaLojaProduto alteraItem(CategoriaLojaProduto item, DaoConexao conexao) throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public CategoriaLojaProduto insereItemLoad(CategoriaLojaProduto item) throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		DaoConexao conexao = null;
		CategoriaLojaProduto saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CategoriaLojaProduto insereItemLoad(CategoriaLojaProduto item, DaoConexao conexao) throws DaoException {
		CategoriaLojaProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
		
	
	public void criaRelSeNaoExiste(CategoriaLojaProduto item, DaoConexao conexao) throws DaoException {
		CategoriaLojaProdutoDao dao = getDao(conexao);
		CategoriaLojaProduto obj = dao.obtemPorRel(item.getIdCategoriaLojaRa(), item.getIdProdutoRa());
		if (obj==null) {
			dao.insereItem(item);
		}
	}
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos associativos
	
	//public List getPorReferenteACategoriaLoja(long id) throws DaoException{ // Padrao
	public List ListaPorCategoriaLojaReferenteA(long id, DaoConexao conexao) throws DaoException{ // Combinar com Interface
		CategoriaLojaProdutoDao dao = getDao(conexao);
		List saida = null;
		saida = dao.ListaPorCategoriaLojaReferenteA(id);
		return saida;
	}
	public boolean excluiPorReferenteACategoriaLoja(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	
	//public List getPorReferenteAProduto(long id) throws DaoException{ // Padrao
	public List ListaPorProdutoReferenteA(long id, DaoConexao conexao) throws DaoException{ // Combinar com Interface
		CategoriaLojaProdutoDao dao = getDao(conexao);
		List saida = null;
		saida = dao.ListaPorProdutoReferenteA(id);
		return saida;
	}
	public boolean excluiPorReferenteAProduto(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	
	
	
	
}
