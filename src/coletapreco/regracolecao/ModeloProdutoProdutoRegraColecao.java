package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class ModeloProdutoProdutoRegraColecao {
	
	public ModeloProdutoProdutoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		ModeloProdutoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		ModeloProdutoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		ModeloProdutoProdutoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private ModeloProdutoProdutoFiltro _filtro;

	public ModeloProdutoProdutoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new ModeloProdutoProdutoFiltro();
		return _filtro;
	}

	public void setFiltro(ModeloProdutoProdutoFiltro dado) {
		_filtro = dado;
	}

	private ModeloProdutoProdutoFiltro[] _listaEntrada;
	@Deprecated
	protected ModeloProdutoProdutoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final ModeloProdutoProdutoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<ModeloProdutoProduto> _listaItem;
	protected List<ModeloProdutoProduto> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<ModeloProdutoProduto> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final ModeloProdutoProdutoDao getDao() {
		return DBB.getInstancia().getModeloProdutoProdutoDao();
	}
	protected final ModeloProdutoProdutoDao getDao(final DaoConexao conexao) {
		ModeloProdutoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final ModeloProdutoProdutoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		ModeloProdutoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		ModeloProdutoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		ModeloProdutoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		ModeloProdutoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public ModeloProdutoProduto PreInsercao(ModeloProdutoProduto item) {
		return item;
	}

	public ModeloProdutoProduto PreAlteracao(ModeloProdutoProduto item) {
		return item;
	}

	public ModeloProdutoProduto obtemPorChave(long chave) throws DaoException {
		ModeloProdutoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		ModeloProdutoProduto saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public ModeloProdutoProduto obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		ModeloProdutoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		ModeloProdutoProduto saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		ModeloProdutoProdutoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		ModeloProdutoProdutoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		ModeloProdutoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public ModeloProdutoProduto excluiItem(ModeloProdutoProduto item) throws DaoException {
		ModeloProdutoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		ModeloProdutoProduto saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ModeloProdutoProduto excluiItem(ModeloProdutoProduto item, DaoConexao conexao) throws DaoException {
		ModeloProdutoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public ModeloProdutoProduto alteraItem(ModeloProdutoProduto item) throws DaoException {
		ModeloProdutoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		ModeloProdutoProduto saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ModeloProdutoProduto alteraItem(ModeloProdutoProduto item, DaoConexao conexao) throws DaoException {
		ModeloProdutoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public ModeloProdutoProduto insereItemLoad(ModeloProdutoProduto item) throws DaoException {
		ModeloProdutoProdutoDao dao = getDao();
		DaoConexao conexao = null;
		ModeloProdutoProduto saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ModeloProdutoProduto insereItemLoad(ModeloProdutoProduto item, DaoConexao conexao) throws DaoException {
		ModeloProdutoProdutoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
		
	
	public void criaRelSeNaoExiste(ModeloProdutoProduto item, DaoConexao conexao) throws DaoException {
		ModeloProdutoProdutoDao dao = getDao(conexao);
		ModeloProdutoProduto obj = dao.obtemPorRel(item.getIdModeloProdutoRa(), item.getIdProdutoRa());
		if (obj==null) {
			dao.insereItem(item);
		}
	}
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos associativos
	
	//public List getPorReferenteAModeloProduto(long id) throws DaoException{ // Padrao
	public List ListaPorModeloProdutoReferenteA(long id, DaoConexao conexao) throws DaoException{ // Combinar com Interface
		ModeloProdutoProdutoDao dao = getDao(conexao);
		List saida = null;
		saida = dao.ListaPorModeloProdutoReferenteA(id);
		return saida;
	}
	public boolean excluiPorReferenteAModeloProduto(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	
	//public List getPorReferenteAProduto(long id) throws DaoException{ // Padrao
	public List ListaPorProdutoReferenteA(long id, DaoConexao conexao) throws DaoException{ // Combinar com Interface
		ModeloProdutoProdutoDao dao = getDao(conexao);
		List saida = null;
		saida = dao.ListaPorProdutoReferenteA(id);
		return saida;
	}
	public boolean excluiPorReferenteAProduto(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	
	
	
	
}
