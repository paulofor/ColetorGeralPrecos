package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class FacebookFanpageRegraColecao {
	
	public FacebookFanpageRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		FacebookFanpageDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		FacebookFanpageDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		FacebookFanpageFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private FacebookFanpageFiltro _filtro;

	public FacebookFanpageFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new FacebookFanpageFiltro();
		return _filtro;
	}

	public void setFiltro(FacebookFanpageFiltro dado) {
		_filtro = dado;
	}

	private FacebookFanpageFiltro[] _listaEntrada;
	@Deprecated
	protected FacebookFanpageFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final FacebookFanpageFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<FacebookFanpage> _listaItem;
	protected List<FacebookFanpage> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<FacebookFanpage> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final List<FacebookFanpage> ListaParaDivulgarOportunidade() throws DaoException {
		List<FacebookFanpage> saida;
		FacebookFanpageDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaParaDivulgarOportunidade(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<FacebookFanpage> ListaParaDivulgarOportunidade(final DaoConexao conexao)
			throws DaoException;
	public final FacebookFanpage EnviaOportunidade() throws DaoException {
		FacebookFanpage saida;
		FacebookFanpageDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = EnviaOportunidade(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract FacebookFanpage EnviaOportunidade(final DaoConexao conexao)
			throws DaoException;




	public static final FacebookFanpageDao getDao() {
		return DBB.getInstancia().getFacebookFanpageDao();
	}
	protected final FacebookFanpageDao getDao(final DaoConexao conexao) {
		FacebookFanpageDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final FacebookFanpageDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		FacebookFanpageDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		FacebookFanpageDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		FacebookFanpageDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		FacebookFanpageDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public FacebookFanpage PreInsercao(FacebookFanpage item) {
		return item;
	}

	public FacebookFanpage PreAlteracao(FacebookFanpage item) {
		return item;
	}

	public FacebookFanpage obtemPorChave(long chave) throws DaoException {
		FacebookFanpageDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		FacebookFanpage saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public FacebookFanpage obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		FacebookFanpageDao dao = getDao();
		dao.setConexao(conexao);
		FacebookFanpage saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		FacebookFanpageDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		FacebookFanpageDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		FacebookFanpageDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public FacebookFanpage excluiItem(FacebookFanpage item) throws DaoException {
		FacebookFanpageDao dao = getDao();
		DaoConexao conexao = null;
		FacebookFanpage saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public FacebookFanpage excluiItem(FacebookFanpage item, DaoConexao conexao) throws DaoException {
		FacebookFanpageDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public FacebookFanpage alteraItem(FacebookFanpage item) throws DaoException {
		FacebookFanpageDao dao = getDao();
		DaoConexao conexao = null;
		FacebookFanpage saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public FacebookFanpage alteraItem(FacebookFanpage item, DaoConexao conexao) throws DaoException {
		FacebookFanpageDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public FacebookFanpage insereItemLoad(FacebookFanpage item) throws DaoException {
		FacebookFanpageDao dao = getDao();
		DaoConexao conexao = null;
		FacebookFanpage saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public FacebookFanpage insereItemLoad(FacebookFanpage item, DaoConexao conexao) throws DaoException {
		FacebookFanpageDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceAFacebookPerfil(long id) throws DaoException {
		// Existe no DAO
		FacebookFanpageDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorFacebookPerfilPertenceA(id);
	}
	public boolean excluiPorPertenceAFacebookPerfil(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorPertenceAFacebookPerfil(long id, DaoConexao conn) throws DaoException {
		FacebookFanpageDao dao = getDao(conn);
		return dao.ListaPorFacebookPerfilPertenceA(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorDivulgaAppProduto(long id) throws DaoException {
		// Existe no DAO
		FacebookFanpageDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorAppProdutoDivulga(id);
	}
	public boolean excluiPorDivulgaAppProduto(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorDivulgaAppProduto(long id, DaoConexao conn) throws DaoException {
		FacebookFanpageDao dao = getDao(conn);
		return dao.ListaPorAppProdutoDivulga(id);
	}
	
	
}
