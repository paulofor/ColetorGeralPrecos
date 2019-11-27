package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class ProdutoRegraColecao {
	
	public ProdutoRegraColecao() {
		_filtro = null;
	}

	
	
	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		ProdutoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private ProdutoFiltro _filtro;

	public ProdutoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new ProdutoFiltro();
		return _filtro;
	}

	public void setFiltro(ProdutoFiltro dado) {
		_filtro = dado;
	}

	private ProdutoFiltro[] _listaEntrada;
	@Deprecated
	protected ProdutoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final ProdutoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<Produto> _listaItem;
	protected List<Produto> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<Produto> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final Produto ObtemPorNomeLoja() throws DaoException {
		Produto saida;
		ProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorNomeLoja(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Produto ObtemPorNomeLoja(final DaoConexao conexao)
			throws DaoException;
	public final Produto ObtemPorUrlProduto() throws DaoException {
		Produto saida;
		ProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorUrlProduto(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Produto ObtemPorUrlProduto(final DaoConexao conexao)
			throws DaoException;
	public final List<Produto> OportunidadeDia() throws DaoException {
		List<Produto> saida;
		ProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = OportunidadeDia(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<Produto> OportunidadeDia(final DaoConexao conexao)
			throws DaoException;
	public final Produto CriaListaPalavra() throws DaoException {
		Produto saida;
		ProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaListaPalavra(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Produto CriaListaPalavra(final DaoConexao conexao)
			throws DaoException;
	public final Produto CriaListaModelo() throws DaoException {
		Produto saida;
		ProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaListaModelo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Produto CriaListaModelo(final DaoConexao conexao)
			throws DaoException;
	public final List<Produto> ListaMesmaPalavra() throws DaoException {
		List<Produto> saida;
		ProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaMesmaPalavra(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<Produto> ListaMesmaPalavra(final DaoConexao conexao)
			throws DaoException;
	public final List<Produto> ListaMelhoresPorNaturezaLimite() throws DaoException {
		List<Produto> saida;
		ProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaMelhoresPorNaturezaLimite(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<Produto> ListaMelhoresPorNaturezaLimite(final DaoConexao conexao)
			throws DaoException;
	public final Produto SalvaImagemLocal() throws DaoException {
		Produto saida;
		ProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = SalvaImagemLocal(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Produto SalvaImagemLocal(final DaoConexao conexao)
			throws DaoException;
	public final Produto AcessaInformacaoProdutoPorId() throws DaoException {
		Produto saida;
		ProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AcessaInformacaoProdutoPorId(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Produto AcessaInformacaoProdutoPorId(final DaoConexao conexao)
			throws DaoException;
	public final Produto AjustaNomeLista() throws DaoException {
		Produto saida;
		ProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AjustaNomeLista(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Produto AjustaNomeLista(final DaoConexao conexao)
			throws DaoException;
	public final Produto AtualizaProdutoExistente() throws DaoException {
		Produto saida;
		ProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaProdutoExistente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Produto AtualizaProdutoExistente(final DaoConexao conexao)
			throws DaoException;




	public static final ProdutoDao getDao() {
		return DBB.getInstancia().getProdutoDao();
	}
	protected final ProdutoDao getDao(final DaoConexao conexao) {
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final ProdutoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		ProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		ProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public Produto PreInsercao(Produto item) {
		return item;
	}

	public Produto PreAlteracao(Produto item) {
		return item;
	}

	public Produto obtemPorChave(long chave) throws DaoException {
		ProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		Produto saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public Produto obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		Produto saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		ProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		ProdutoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public Produto excluiItem(Produto item) throws DaoException {
		ProdutoDao dao = getDao();
		DaoConexao conexao = null;
		Produto saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Produto excluiItem(Produto item, DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public Produto alteraItem(Produto item) throws DaoException {
		ProdutoDao dao = getDao();
		DaoConexao conexao = null;
		Produto saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Produto alteraItem(Produto item, DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public Produto insereItemLoad(Produto item) throws DaoException {
		ProdutoDao dao = getDao();
		DaoConexao conexao = null;
		Produto saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Produto insereItemLoad(Produto item, DaoConexao conexao) throws DaoException {
		ProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorLidoEmLojaVirtual(long id) throws DaoException {
		// Existe no DAO
		ProdutoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorLojaVirtualLidoEm(id);
	}
	public boolean excluiPorLidoEmLojaVirtual(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorLidoEmLojaVirtual(long id, DaoConexao conn) throws DaoException {
		ProdutoDao dao = getDao(conn);
		return dao.ListaPorLojaVirtualLidoEm(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPossuiMarca(long id) throws DaoException {
		// Existe no DAO
		ProdutoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorMarcaPossui(id);
	}
	public boolean excluiPorPossuiMarca(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorPossuiMarca(long id, DaoConexao conn) throws DaoException {
		ProdutoDao dao = getDao(conn);
		return dao.ListaPorMarcaPossui(id);
	}
	
	
	// Manual
	public final Produto CorrigeImagemLista() throws DaoException {
		Produto saida;
		ProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CorrigeImagemLista(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Produto CorrigeImagemLista(final DaoConexao conexao)
			throws DaoException;
}
