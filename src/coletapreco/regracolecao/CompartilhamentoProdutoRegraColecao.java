package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class CompartilhamentoProdutoRegraColecao {
	
	public CompartilhamentoProdutoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		CompartilhamentoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		CompartilhamentoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		CompartilhamentoProdutoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private CompartilhamentoProdutoFiltro _filtro;

	public CompartilhamentoProdutoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new CompartilhamentoProdutoFiltro();
		return _filtro;
	}

	public void setFiltro(CompartilhamentoProdutoFiltro dado) {
		_filtro = dado;
	}

	private CompartilhamentoProdutoFiltro[] _listaEntrada;
	@Deprecated
	protected CompartilhamentoProdutoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final CompartilhamentoProdutoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<CompartilhamentoProduto> _listaItem;
	protected List<CompartilhamentoProduto> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<CompartilhamentoProduto> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final CompartilhamentoProdutoDao getDao() {
		return DBB.getInstancia().getCompartilhamentoProdutoDao();
	}
	protected final CompartilhamentoProdutoDao getDao(final DaoConexao conexao) {
		CompartilhamentoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final CompartilhamentoProdutoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		CompartilhamentoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		CompartilhamentoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		CompartilhamentoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		CompartilhamentoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public CompartilhamentoProduto PreInsercao(CompartilhamentoProduto item) {
		return item;
	}

	public CompartilhamentoProduto PreAlteracao(CompartilhamentoProduto item) {
		return item;
	}

	public CompartilhamentoProduto obtemPorChave(long chave) throws DaoException {
		CompartilhamentoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		CompartilhamentoProduto saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public CompartilhamentoProduto obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		CompartilhamentoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		CompartilhamentoProduto saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		CompartilhamentoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		CompartilhamentoProdutoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		CompartilhamentoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public CompartilhamentoProduto excluiItem(CompartilhamentoProduto item) throws DaoException {
		CompartilhamentoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		CompartilhamentoProduto saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CompartilhamentoProduto excluiItem(CompartilhamentoProduto item, DaoConexao conexao) throws DaoException {
		CompartilhamentoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public CompartilhamentoProduto alteraItem(CompartilhamentoProduto item) throws DaoException {
		CompartilhamentoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		CompartilhamentoProduto saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CompartilhamentoProduto alteraItem(CompartilhamentoProduto item, DaoConexao conexao) throws DaoException {
		CompartilhamentoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public CompartilhamentoProduto insereItemLoad(CompartilhamentoProduto item) throws DaoException {
		CompartilhamentoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		CompartilhamentoProduto saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CompartilhamentoProduto insereItemLoad(CompartilhamentoProduto item, DaoConexao conexao) throws DaoException {
		CompartilhamentoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceAUsuario(long id) throws DaoException {
		// Existe no DAO
		CompartilhamentoProdutoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorUsuarioPertenceA(id);
	}
	public boolean excluiPorPertenceAUsuario(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorPertenceAUsuario(long id, DaoConexao conn) throws DaoException {
		CompartilhamentoProdutoDao dao = getDao(conn);
		return dao.ListaPorUsuarioPertenceA(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAProduto(long id) throws DaoException {
		// Existe no DAO
		CompartilhamentoProdutoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorProdutoReferenteA(id);
	}
	public boolean excluiPorReferenteAProduto(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteAProduto(long id, DaoConexao conn) throws DaoException {
		CompartilhamentoProdutoDao dao = getDao(conn);
		return dao.ListaPorProdutoReferenteA(id);
	}
	
	
}
