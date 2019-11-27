package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class PalavraProdutoRegraColecao {
	
	public PalavraProdutoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		PalavraProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		PalavraProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		PalavraProdutoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private PalavraProdutoFiltro _filtro;

	public PalavraProdutoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new PalavraProdutoFiltro();
		return _filtro;
	}

	public void setFiltro(PalavraProdutoFiltro dado) {
		_filtro = dado;
	}

	private PalavraProdutoFiltro[] _listaEntrada;
	@Deprecated
	protected PalavraProdutoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final PalavraProdutoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<PalavraProduto> _listaItem;
	protected List<PalavraProduto> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<PalavraProduto> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final PalavraProduto PosicionaPalavra() throws DaoException {
		PalavraProduto saida;
		PalavraProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = PosicionaPalavra(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract PalavraProduto PosicionaPalavra(final DaoConexao conexao)
			throws DaoException;




	public static final PalavraProdutoDao getDao() {
		return DBB.getInstancia().getPalavraProdutoDao();
	}
	protected final PalavraProdutoDao getDao(final DaoConexao conexao) {
		PalavraProdutoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final PalavraProdutoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		PalavraProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		PalavraProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		PalavraProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		PalavraProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public PalavraProduto PreInsercao(PalavraProduto item) {
		return item;
	}

	public PalavraProduto PreAlteracao(PalavraProduto item) {
		return item;
	}

	public PalavraProduto obtemPorChave(long chave) throws DaoException {
		PalavraProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		PalavraProduto saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public PalavraProduto obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		PalavraProdutoDao dao = getDao();
		dao.setConexao(conexao);
		PalavraProduto saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		PalavraProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		PalavraProdutoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		PalavraProdutoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public PalavraProduto excluiItem(PalavraProduto item) throws DaoException {
		PalavraProdutoDao dao = getDao();
		DaoConexao conexao = null;
		PalavraProduto saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PalavraProduto excluiItem(PalavraProduto item, DaoConexao conexao) throws DaoException {
		PalavraProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public PalavraProduto alteraItem(PalavraProduto item) throws DaoException {
		PalavraProdutoDao dao = getDao();
		DaoConexao conexao = null;
		PalavraProduto saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PalavraProduto alteraItem(PalavraProduto item, DaoConexao conexao) throws DaoException {
		PalavraProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public PalavraProduto insereItemLoad(PalavraProduto item) throws DaoException {
		PalavraProdutoDao dao = getDao();
		DaoConexao conexao = null;
		PalavraProduto saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PalavraProduto insereItemLoad(PalavraProduto item, DaoConexao conexao) throws DaoException {
		PalavraProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
		
	
	public void criaRelSeNaoExiste(PalavraProduto item, DaoConexao conexao) throws DaoException {
		PalavraProdutoDao dao = getDao(conexao);
		PalavraProduto obj = dao.obtemPorRel(item.getIdPalavraRa(), item.getIdProdutoRa());
		if (obj==null) {
			dao.insereItem(item);
		}
	}
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos associativos
	
	//public List getPorRelaciondoAPalavra(long id) throws DaoException{ // Padrao
	public List ListaPorPalavraRelaciondoA(long id, DaoConexao conexao) throws DaoException{ // Combinar com Interface
		PalavraProdutoDao dao = getDao(conexao);
		List saida = null;
		saida = dao.ListaPorPalavraRelaciondoA(id);
		return saida;
	}
	public boolean excluiPorRelaciondoAPalavra(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	
	//public List getPorRelaciondoAProduto(long id) throws DaoException{ // Padrao
	public List ListaPorProdutoRelaciondoA(long id, DaoConexao conexao) throws DaoException{ // Combinar com Interface
		PalavraProdutoDao dao = getDao(conexao);
		List saida = null;
		saida = dao.ListaPorProdutoRelaciondoA(id);
		return saida;
	}
	public boolean excluiPorRelaciondoAProduto(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	
	
	
	
}
