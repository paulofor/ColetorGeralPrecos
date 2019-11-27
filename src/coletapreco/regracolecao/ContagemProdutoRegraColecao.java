package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class ContagemProdutoRegraColecao {
	
	public ContagemProdutoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		ContagemProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		ContagemProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		ContagemProdutoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private ContagemProdutoFiltro _filtro;

	public ContagemProdutoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new ContagemProdutoFiltro();
		return _filtro;
	}

	public void setFiltro(ContagemProdutoFiltro dado) {
		_filtro = dado;
	}

	private ContagemProdutoFiltro[] _listaEntrada;
	@Deprecated
	protected ContagemProdutoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final ContagemProdutoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<ContagemProduto> _listaItem;
	protected List<ContagemProduto> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<ContagemProduto> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final ContagemProduto RegistraQuantidadesDia() throws DaoException {
		ContagemProduto saida;
		ContagemProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = RegistraQuantidadesDia(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract ContagemProduto RegistraQuantidadesDia(final DaoConexao conexao)
			throws DaoException;
	public final ContagemProduto EnviaParaServidor() throws DaoException {
		ContagemProduto saida;
		ContagemProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = EnviaParaServidor(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract ContagemProduto EnviaParaServidor(final DaoConexao conexao)
			throws DaoException;
	public final ContagemProduto CalculaDiferencaErro() throws DaoException {
		ContagemProduto saida;
		ContagemProdutoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CalculaDiferencaErro(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract ContagemProduto CalculaDiferencaErro(final DaoConexao conexao)
			throws DaoException;




	public static final ContagemProdutoDao getDao() {
		return DBB.getInstancia().getContagemProdutoDao();
	}
	protected final ContagemProdutoDao getDao(final DaoConexao conexao) {
		ContagemProdutoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final ContagemProdutoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		ContagemProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		ContagemProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		ContagemProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		ContagemProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public ContagemProduto PreInsercao(ContagemProduto item) {
		return item;
	}

	public ContagemProduto PreAlteracao(ContagemProduto item) {
		return item;
	}

	public ContagemProduto obtemPorChave(long chave) throws DaoException {
		ContagemProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		ContagemProduto saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public ContagemProduto obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		ContagemProdutoDao dao = getDao();
		dao.setConexao(conexao);
		ContagemProduto saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		ContagemProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		ContagemProdutoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		ContagemProdutoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public ContagemProduto excluiItem(ContagemProduto item) throws DaoException {
		ContagemProdutoDao dao = getDao();
		DaoConexao conexao = null;
		ContagemProduto saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ContagemProduto excluiItem(ContagemProduto item, DaoConexao conexao) throws DaoException {
		ContagemProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public ContagemProduto alteraItem(ContagemProduto item) throws DaoException {
		ContagemProdutoDao dao = getDao();
		DaoConexao conexao = null;
		ContagemProduto saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ContagemProduto alteraItem(ContagemProduto item, DaoConexao conexao) throws DaoException {
		ContagemProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public ContagemProduto insereItemLoad(ContagemProduto item) throws DaoException {
		ContagemProdutoDao dao = getDao();
		DaoConexao conexao = null;
		ContagemProduto saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ContagemProduto insereItemLoad(ContagemProduto item, DaoConexao conexao) throws DaoException {
		ContagemProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteANaturezaProduto(long id) throws DaoException {
		// Existe no DAO
		ContagemProdutoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorNaturezaProdutoReferenteA(id);
	}
	public boolean excluiPorReferenteANaturezaProduto(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteANaturezaProduto(long id, DaoConexao conn) throws DaoException {
		ContagemProdutoDao dao = getDao(conn);
		return dao.ListaPorNaturezaProdutoReferenteA(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteALojaVirtual(long id) throws DaoException {
		// Existe no DAO
		ContagemProdutoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorLojaVirtualReferenteA(id);
	}
	public boolean excluiPorReferenteALojaVirtual(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteALojaVirtual(long id, DaoConexao conn) throws DaoException {
		ContagemProdutoDao dao = getDao(conn);
		return dao.ListaPorLojaVirtualReferenteA(id);
	}
	
	
}
