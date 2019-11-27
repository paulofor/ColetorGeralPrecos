package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class PrecoProdutoRegraColecao {
	
	public PrecoProdutoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		PrecoProdutoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private PrecoProdutoFiltro _filtro;

	public PrecoProdutoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new PrecoProdutoFiltro();
		return _filtro;
	}

	public void setFiltro(PrecoProdutoFiltro dado) {
		_filtro = dado;
	}

	private PrecoProdutoFiltro[] _listaEntrada;
	@Deprecated
	protected PrecoProdutoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final PrecoProdutoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<PrecoProduto> _listaItem;
	protected List<PrecoProduto> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<PrecoProduto> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final PrecoProduto AtualizaPreco() throws DaoException {
		PrecoProduto saida;
		PrecoProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaPreco(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract PrecoProduto AtualizaPreco(final DaoConexao conexao)
			throws DaoException;
	public final PrecoProduto MaisRecentePorProduto() throws DaoException {
		PrecoProduto saida;
		PrecoProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = MaisRecentePorProduto(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract PrecoProduto MaisRecentePorProduto(final DaoConexao conexao)
			throws DaoException;
	public final PrecoProduto MinimoPorProduto() throws DaoException {
		PrecoProduto saida;
		PrecoProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = MinimoPorProduto(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract PrecoProduto MinimoPorProduto(final DaoConexao conexao)
			throws DaoException;
	public final PrecoProduto CalculaMinimo() throws DaoException {
		PrecoProduto saida;
		PrecoProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CalculaMinimo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract PrecoProduto CalculaMinimo(final DaoConexao conexao)
			throws DaoException;
	public final PrecoProduto CalculaPrecoMedio() throws DaoException {
		PrecoProduto saida;
		PrecoProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CalculaPrecoMedio(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract PrecoProduto CalculaPrecoMedio(final DaoConexao conexao)
			throws DaoException;
	public final PrecoProduto CalculaMedioMinimoAjustePositivo() throws DaoException {
		PrecoProduto saida;
		PrecoProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CalculaMedioMinimoAjustePositivo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract PrecoProduto CalculaMedioMinimoAjustePositivo(final DaoConexao conexao)
			throws DaoException;
	public final PrecoProduto AtualizaPorPrecoAtual() throws DaoException {
		PrecoProduto saida;
		PrecoProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaPorPrecoAtual(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract PrecoProduto AtualizaPorPrecoAtual(final DaoConexao conexao)
			throws DaoException;
	public final PrecoProduto AtualizaMediaMinimoPorListaInteresse() throws DaoException {
		PrecoProduto saida;
		PrecoProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaMediaMinimoPorListaInteresse(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract PrecoProduto AtualizaMediaMinimoPorListaInteresse(final DaoConexao conexao)
			throws DaoException;




	public static final PrecoProdutoDao getDao() {
		return DBB.getInstancia().getPrecoProdutoDao();
	}
	protected final PrecoProdutoDao getDao(final DaoConexao conexao) {
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final PrecoProdutoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		PrecoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		PrecoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public PrecoProduto PreInsercao(PrecoProduto item) {
		return item;
	}

	public PrecoProduto PreAlteracao(PrecoProduto item) {
		return item;
	}

	public PrecoProduto obtemPorChave(long chave) throws DaoException {
		PrecoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		PrecoProduto saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public PrecoProduto obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		PrecoProduto saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		PrecoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		PrecoProdutoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		PrecoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public PrecoProduto excluiItem(PrecoProduto item) throws DaoException {
		PrecoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		PrecoProduto saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PrecoProduto excluiItem(PrecoProduto item, DaoConexao conexao) throws DaoException {
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public PrecoProduto alteraItem(PrecoProduto item) throws DaoException {
		PrecoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		PrecoProduto saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PrecoProduto alteraItem(PrecoProduto item, DaoConexao conexao) throws DaoException {
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public PrecoProduto insereItemLoad(PrecoProduto item) throws DaoException {
		PrecoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		PrecoProduto saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PrecoProduto insereItemLoad(PrecoProduto item, DaoConexao conexao) throws DaoException {
		PrecoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceAProduto(long id) throws DaoException {
		// Existe no DAO
		PrecoProdutoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorProdutoPertenceA(id);
	}
	public boolean excluiPorPertenceAProduto(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorPertenceAProduto(long id, DaoConexao conn) throws DaoException {
		PrecoProdutoDao dao = getDao(conn);
		return dao.ListaPorProdutoPertenceA(id);
	}

	
	// Criadas na mao -- 2019
	public final PrecoProduto CalculaDiferencaPosicao() throws DaoException {
		PrecoProduto saida;
		PrecoProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CalculaDiferencaPosicao(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract PrecoProduto CalculaDiferencaPosicao(final DaoConexao conexao)
			throws DaoException;

	
	public final List<PrecoProduto> ObtemMelhorPosicaoDia() throws DaoException {
		List<PrecoProduto> saida;
		PrecoProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemMelhorPosicaoDia(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<PrecoProduto> ObtemMelhorPosicaoDia(final DaoConexao conexao)
			throws DaoException;
}
