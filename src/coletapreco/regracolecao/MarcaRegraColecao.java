package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class MarcaRegraColecao {
	
	public MarcaRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		MarcaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		MarcaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		MarcaFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private MarcaFiltro _filtro;

	public MarcaFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new MarcaFiltro();
		return _filtro;
	}

	public void setFiltro(MarcaFiltro dado) {
		_filtro = dado;
	}

	private MarcaFiltro[] _listaEntrada;
	@Deprecated
	protected MarcaFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final MarcaFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<Marca> _listaItem;
	protected List<Marca> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<Marca> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final Marca ObtemPorNome() throws DaoException {
		Marca saida;
		MarcaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorNome(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Marca ObtemPorNome(final DaoConexao conexao)
			throws DaoException;




	public static final MarcaDao getDao() {
		return DBB.getInstancia().getMarcaDao();
	}
	protected final MarcaDao getDao(final DaoConexao conexao) {
		MarcaDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final MarcaDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		MarcaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		MarcaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		MarcaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		MarcaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public Marca PreInsercao(Marca item) {
		return item;
	}

	public Marca PreAlteracao(Marca item) {
		return item;
	}

	public Marca obtemPorChave(long chave) throws DaoException {
		MarcaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		Marca saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public Marca obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		MarcaDao dao = getDao();
		dao.setConexao(conexao);
		Marca saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		MarcaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		MarcaDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		MarcaDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public Marca excluiItem(Marca item) throws DaoException {
		MarcaDao dao = getDao();
		DaoConexao conexao = null;
		Marca saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Marca excluiItem(Marca item, DaoConexao conexao) throws DaoException {
		MarcaDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public Marca alteraItem(Marca item) throws DaoException {
		MarcaDao dao = getDao();
		DaoConexao conexao = null;
		Marca saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Marca alteraItem(Marca item, DaoConexao conexao) throws DaoException {
		MarcaDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public Marca insereItemLoad(Marca item) throws DaoException {
		MarcaDao dao = getDao();
		DaoConexao conexao = null;
		Marca saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Marca insereItemLoad(Marca item, DaoConexao conexao) throws DaoException {
		MarcaDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
