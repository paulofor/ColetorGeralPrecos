package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class UsuarioRegraColecao {
	
	public UsuarioRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		UsuarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		UsuarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		UsuarioFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private UsuarioFiltro _filtro;

	public UsuarioFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new UsuarioFiltro();
		return _filtro;
	}

	public void setFiltro(UsuarioFiltro dado) {
		_filtro = dado;
	}

	private UsuarioFiltro[] _listaEntrada;
	@Deprecated
	protected UsuarioFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final UsuarioFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<Usuario> _listaItem;
	protected List<Usuario> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<Usuario> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final Usuario ObtemProximoParaColetaComDispositivo() throws DaoException {
		Usuario saida;
		UsuarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemProximoParaColetaComDispositivo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Usuario ObtemProximoParaColetaComDispositivo(final DaoConexao conexao)
			throws DaoException;
	public final Usuario TrataMonitoramento() throws DaoException {
		Usuario saida;
		UsuarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = TrataMonitoramento(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Usuario TrataMonitoramento(final DaoConexao conexao)
			throws DaoException;
	public final Usuario EnviaDadosCliente() throws DaoException {
		Usuario saida;
		UsuarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = EnviaDadosCliente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Usuario EnviaDadosCliente(final DaoConexao conexao)
			throws DaoException;
	public final Usuario TrataLoopClientes() throws DaoException {
		Usuario saida;
		UsuarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = TrataLoopClientes(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Usuario TrataLoopClientes(final DaoConexao conexao)
			throws DaoException;
	public final Usuario TrataClienteDadosNuvem() throws DaoException {
		Usuario saida;
		UsuarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = TrataClienteDadosNuvem(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Usuario TrataClienteDadosNuvem(final DaoConexao conexao)
			throws DaoException;
	public final List<Usuario> ListaAtivoChamadaDistanteComDispositivo() throws DaoException {
		List<Usuario> saida;
		UsuarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaAtivoChamadaDistanteComDispositivo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<Usuario> ListaAtivoChamadaDistanteComDispositivo(final DaoConexao conexao)
			throws DaoException;
	public final List<Usuario> ListaInteresseNovo() throws DaoException {
		List<Usuario> saida;
		UsuarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaInteresseNovo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<Usuario> ListaInteresseNovo(final DaoConexao conexao)
			throws DaoException;




	public static final UsuarioDao getDao() {
		return DBB.getInstancia().getUsuarioDao();
	}
	protected final UsuarioDao getDao(final DaoConexao conexao) {
		UsuarioDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final UsuarioDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		UsuarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		UsuarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		UsuarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		UsuarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public Usuario PreInsercao(Usuario item) {
		return item;
	}

	public Usuario PreAlteracao(Usuario item) {
		return item;
	}

	public Usuario obtemPorChave(long chave) throws DaoException {
		UsuarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		Usuario saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public Usuario obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		UsuarioDao dao = getDao();
		dao.setConexao(conexao);
		Usuario saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		UsuarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		UsuarioDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		UsuarioDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public Usuario excluiItem(Usuario item) throws DaoException {
		UsuarioDao dao = getDao();
		DaoConexao conexao = null;
		Usuario saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Usuario excluiItem(Usuario item, DaoConexao conexao) throws DaoException {
		UsuarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public Usuario alteraItem(Usuario item) throws DaoException {
		UsuarioDao dao = getDao();
		DaoConexao conexao = null;
		Usuario saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Usuario alteraItem(Usuario item, DaoConexao conexao) throws DaoException {
		UsuarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public Usuario insereItemLoad(Usuario item) throws DaoException {
		UsuarioDao dao = getDao();
		DaoConexao conexao = null;
		Usuario saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Usuario insereItemLoad(Usuario item, DaoConexao conexao) throws DaoException {
		UsuarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
