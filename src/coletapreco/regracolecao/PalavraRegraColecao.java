package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class PalavraRegraColecao {
	
	public PalavraRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		PalavraDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		PalavraDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		PalavraFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private PalavraFiltro _filtro;

	public PalavraFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new PalavraFiltro();
		return _filtro;
	}

	public void setFiltro(PalavraFiltro dado) {
		_filtro = dado;
	}

	private PalavraFiltro[] _listaEntrada;
	@Deprecated
	protected PalavraFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final PalavraFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<Palavra> _listaItem;
	protected List<Palavra> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<Palavra> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final List<Palavra> ListaPorNomeProduto() throws DaoException {
		List<Palavra> saida;
		PalavraDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorNomeProduto(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<Palavra> ListaPorNomeProduto(final DaoConexao conexao)
			throws DaoException;
	public final Palavra ObtemPorDescricaoPalavra() throws DaoException {
		Palavra saida;
		PalavraDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorDescricaoPalavra(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Palavra ObtemPorDescricaoPalavra(final DaoConexao conexao)
			throws DaoException;
	public final Palavra IdentificaPalavraComum() throws DaoException {
		Palavra saida;
		PalavraDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = IdentificaPalavraComum(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Palavra IdentificaPalavraComum(final DaoConexao conexao)
			throws DaoException;




	public static final PalavraDao getDao() {
		return DBB.getInstancia().getPalavraDao();
	}
	protected final PalavraDao getDao(final DaoConexao conexao) {
		PalavraDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final PalavraDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		PalavraDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		PalavraDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		PalavraDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		PalavraDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public Palavra PreInsercao(Palavra item) {
		return item;
	}

	public Palavra PreAlteracao(Palavra item) {
		return item;
	}

	public Palavra obtemPorChave(long chave) throws DaoException {
		PalavraDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		Palavra saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public Palavra obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		PalavraDao dao = getDao();
		dao.setConexao(conexao);
		Palavra saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		PalavraDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		PalavraDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		PalavraDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public Palavra excluiItem(Palavra item) throws DaoException {
		PalavraDao dao = getDao();
		DaoConexao conexao = null;
		Palavra saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Palavra excluiItem(Palavra item, DaoConexao conexao) throws DaoException {
		PalavraDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public Palavra alteraItem(Palavra item) throws DaoException {
		PalavraDao dao = getDao();
		DaoConexao conexao = null;
		Palavra saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Palavra alteraItem(Palavra item, DaoConexao conexao) throws DaoException {
		PalavraDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public Palavra insereItemLoad(Palavra item) throws DaoException {
		PalavraDao dao = getDao();
		DaoConexao conexao = null;
		Palavra saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Palavra insereItemLoad(Palavra item, DaoConexao conexao) throws DaoException {
		PalavraDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
