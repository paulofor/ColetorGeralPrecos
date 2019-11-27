package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class InteresseProdutoRegraColecao {
	
	public InteresseProdutoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		InteresseProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		InteresseProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		InteresseProdutoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private InteresseProdutoFiltro _filtro;

	public InteresseProdutoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new InteresseProdutoFiltro();
		return _filtro;
	}

	public void setFiltro(InteresseProdutoFiltro dado) {
		_filtro = dado;
	}

	private InteresseProdutoFiltro[] _listaEntrada;
	@Deprecated
	protected InteresseProdutoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final InteresseProdutoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<InteresseProduto> _listaItem;
	protected List<InteresseProduto> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<InteresseProduto> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final InteresseProduto CalculaNota() throws DaoException {
		InteresseProduto saida;
		InteresseProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CalculaNota(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract InteresseProduto CalculaNota(final DaoConexao conexao)
			throws DaoException;
	public final InteresseProduto AtualizaComListaPrecoDiario() throws DaoException {
		InteresseProduto saida;
		InteresseProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaComListaPrecoDiario(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract InteresseProduto AtualizaComListaPrecoDiario(final DaoConexao conexao)
			throws DaoException;




	public static final InteresseProdutoDao getDao() {
		return DBB.getInstancia().getInteresseProdutoDao();
	}
	protected final InteresseProdutoDao getDao(final DaoConexao conexao) {
		InteresseProdutoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final InteresseProdutoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		InteresseProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		InteresseProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		InteresseProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		InteresseProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public InteresseProduto PreInsercao(InteresseProduto item) {
		return item;
	}

	public InteresseProduto PreAlteracao(InteresseProduto item) {
		return item;
	}

	public InteresseProduto obtemPorChave(long chave) throws DaoException {
		InteresseProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		InteresseProduto saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public InteresseProduto obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		InteresseProdutoDao dao = getDao();
		dao.setConexao(conexao);
		InteresseProduto saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		InteresseProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		InteresseProdutoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		InteresseProdutoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public InteresseProduto excluiItem(InteresseProduto item) throws DaoException {
		InteresseProdutoDao dao = getDao();
		DaoConexao conexao = null;
		InteresseProduto saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public InteresseProduto excluiItem(InteresseProduto item, DaoConexao conexao) throws DaoException {
		InteresseProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public InteresseProduto alteraItem(InteresseProduto item) throws DaoException {
		InteresseProdutoDao dao = getDao();
		DaoConexao conexao = null;
		InteresseProduto saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public InteresseProduto alteraItem(InteresseProduto item, DaoConexao conexao) throws DaoException {
		InteresseProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public InteresseProduto insereItemLoad(InteresseProduto item) throws DaoException {
		InteresseProdutoDao dao = getDao();
		DaoConexao conexao = null;
		InteresseProduto saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public InteresseProduto insereItemLoad(InteresseProduto item, DaoConexao conexao) throws DaoException {
		InteresseProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAProdutoCliente(long id) throws DaoException {
		// Existe no DAO
		InteresseProdutoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorProdutoClienteReferenteA(id);
	}
	public boolean excluiPorReferenteAProdutoCliente(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteAProdutoCliente(long id, DaoConexao conn) throws DaoException {
		InteresseProdutoDao dao = getDao(conn);
		return dao.ListaPorProdutoClienteReferenteA(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorSincronizaUsuario(long id) throws DaoException {
		// Existe no DAO
		InteresseProdutoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorUsuarioSincroniza(id);
	}
	public boolean excluiPorSincronizaUsuario(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorSincronizaUsuario(long id, DaoConexao conn) throws DaoException {
		InteresseProdutoDao dao = getDao(conn);
		return dao.ListaPorUsuarioSincroniza(id);
	}
	
	
}
