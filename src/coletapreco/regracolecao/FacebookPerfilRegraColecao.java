package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class FacebookPerfilRegraColecao {
	
	public FacebookPerfilRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		FacebookPerfilDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		FacebookPerfilDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		FacebookPerfilFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private FacebookPerfilFiltro _filtro;

	public FacebookPerfilFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new FacebookPerfilFiltro();
		return _filtro;
	}

	public void setFiltro(FacebookPerfilFiltro dado) {
		_filtro = dado;
	}

	private FacebookPerfilFiltro[] _listaEntrada;
	@Deprecated
	protected FacebookPerfilFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final FacebookPerfilFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<FacebookPerfil> _listaItem;
	protected List<FacebookPerfil> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<FacebookPerfil> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final FacebookPerfilDao getDao() {
		return DBB.getInstancia().getFacebookPerfilDao();
	}
	protected final FacebookPerfilDao getDao(final DaoConexao conexao) {
		FacebookPerfilDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final FacebookPerfilDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		FacebookPerfilDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		FacebookPerfilDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		FacebookPerfilDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		FacebookPerfilDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public FacebookPerfil PreInsercao(FacebookPerfil item) {
		return item;
	}

	public FacebookPerfil PreAlteracao(FacebookPerfil item) {
		return item;
	}

	public FacebookPerfil obtemPorChave(long chave) throws DaoException {
		FacebookPerfilDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		FacebookPerfil saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public FacebookPerfil obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		FacebookPerfilDao dao = getDao();
		dao.setConexao(conexao);
		FacebookPerfil saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		FacebookPerfilDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		FacebookPerfilDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		FacebookPerfilDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public FacebookPerfil excluiItem(FacebookPerfil item) throws DaoException {
		FacebookPerfilDao dao = getDao();
		DaoConexao conexao = null;
		FacebookPerfil saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public FacebookPerfil excluiItem(FacebookPerfil item, DaoConexao conexao) throws DaoException {
		FacebookPerfilDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public FacebookPerfil alteraItem(FacebookPerfil item) throws DaoException {
		FacebookPerfilDao dao = getDao();
		DaoConexao conexao = null;
		FacebookPerfil saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public FacebookPerfil alteraItem(FacebookPerfil item, DaoConexao conexao) throws DaoException {
		FacebookPerfilDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public FacebookPerfil insereItemLoad(FacebookPerfil item) throws DaoException {
		FacebookPerfilDao dao = getDao();
		DaoConexao conexao = null;
		FacebookPerfil saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public FacebookPerfil insereItemLoad(FacebookPerfil item, DaoConexao conexao) throws DaoException {
		FacebookPerfilDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
