package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class LojaNaturezaRegraColecao {
	
	public LojaNaturezaRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		LojaNaturezaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		LojaNaturezaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		LojaNaturezaFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private LojaNaturezaFiltro _filtro;

	public LojaNaturezaFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new LojaNaturezaFiltro();
		return _filtro;
	}

	public void setFiltro(LojaNaturezaFiltro dado) {
		_filtro = dado;
	}

	private LojaNaturezaFiltro[] _listaEntrada;
	@Deprecated
	protected LojaNaturezaFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final LojaNaturezaFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<LojaNatureza> _listaItem;
	protected List<LojaNatureza> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<LojaNatureza> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final LojaNaturezaDao getDao() {
		return DBB.getInstancia().getLojaNaturezaDao();
	}
	protected final LojaNaturezaDao getDao(final DaoConexao conexao) {
		LojaNaturezaDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final LojaNaturezaDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		LojaNaturezaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		LojaNaturezaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		LojaNaturezaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		LojaNaturezaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public LojaNatureza PreInsercao(LojaNatureza item) {
		return item;
	}

	public LojaNatureza PreAlteracao(LojaNatureza item) {
		return item;
	}

	public LojaNatureza obtemPorChave(long chave) throws DaoException {
		LojaNaturezaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		LojaNatureza saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public LojaNatureza obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		LojaNaturezaDao dao = getDao();
		dao.setConexao(conexao);
		LojaNatureza saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		LojaNaturezaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		LojaNaturezaDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		LojaNaturezaDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public LojaNatureza excluiItem(LojaNatureza item) throws DaoException {
		LojaNaturezaDao dao = getDao();
		DaoConexao conexao = null;
		LojaNatureza saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public LojaNatureza excluiItem(LojaNatureza item, DaoConexao conexao) throws DaoException {
		LojaNaturezaDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public LojaNatureza alteraItem(LojaNatureza item) throws DaoException {
		LojaNaturezaDao dao = getDao();
		DaoConexao conexao = null;
		LojaNatureza saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public LojaNatureza alteraItem(LojaNatureza item, DaoConexao conexao) throws DaoException {
		LojaNaturezaDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public LojaNatureza insereItemLoad(LojaNatureza item) throws DaoException {
		LojaNaturezaDao dao = getDao();
		DaoConexao conexao = null;
		LojaNatureza saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public LojaNatureza insereItemLoad(LojaNatureza item, DaoConexao conexao) throws DaoException {
		LojaNaturezaDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
		
	
	public void criaRelSeNaoExiste(LojaNatureza item, DaoConexao conexao) throws DaoException {
		LojaNaturezaDao dao = getDao(conexao);
		LojaNatureza obj = dao.obtemPorRel(item.getIdLojaVirtualRa(), item.getIdNaturezaProdutoRa());
		if (obj==null) {
			dao.insereItem(item);
		}
	}
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos associativos
	
	//public List getPorReferenteALojaVirtual(long id) throws DaoException{ // Padrao
	public List ListaPorLojaVirtualReferenteA(long id, DaoConexao conexao) throws DaoException{ // Combinar com Interface
		LojaNaturezaDao dao = getDao(conexao);
		List saida = null;
		saida = dao.ListaPorLojaVirtualReferenteA(id);
		return saida;
	}
	public boolean excluiPorReferenteALojaVirtual(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	
	//public List getPorReferenteANaturezaProduto(long id) throws DaoException{ // Padrao
	public List ListaPorNaturezaProdutoReferenteA(long id, DaoConexao conexao) throws DaoException{ // Combinar com Interface
		LojaNaturezaDao dao = getDao(conexao);
		List saida = null;
		saida = dao.ListaPorNaturezaProdutoReferenteA(id);
		return saida;
	}
	public boolean excluiPorReferenteANaturezaProduto(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	
	
	
	
}
