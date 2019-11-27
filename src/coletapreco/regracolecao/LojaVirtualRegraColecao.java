package coletapreco.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;


public abstract class LojaVirtualRegraColecao {
	
	public LojaVirtualRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		LojaVirtualDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		LojaVirtualDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		LojaVirtualFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private LojaVirtualFiltro _filtro;

	public LojaVirtualFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new LojaVirtualFiltro();
		return _filtro;
	}

	public void setFiltro(LojaVirtualFiltro dado) {
		_filtro = dado;
	}

	private LojaVirtualFiltro[] _listaEntrada;
	@Deprecated
	protected LojaVirtualFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final LojaVirtualFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<LojaVirtual> _listaItem;
	protected List<LojaVirtual> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<LojaVirtual> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final LojaVirtual AtualizaBrinquedo() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaBrinquedo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaBrinquedo(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaCelular() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaCelular(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaCelular(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaGeladeira() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaGeladeira(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaGeladeira(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaFogao() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaFogao(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaFogao(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaLavaRoupa() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaLavaRoupa(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaLavaRoupa(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaMicroOnda() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaMicroOnda(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaMicroOnda(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaArCondicionado() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaArCondicionado(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaArCondicionado(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaVentilador() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaVentilador(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaVentilador(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaNotebook() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaNotebook(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaNotebook(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaCosmetico() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaCosmetico(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaCosmetico(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaTV() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaTV(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaTV(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaTablet() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaTablet(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaTablet(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaMoveisQuarto() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaMoveisQuarto(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaMoveisQuarto(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaMoveisSalaEstar() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaMoveisSalaEstar(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaMoveisSalaEstar(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaMoveisSalaJantar() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaMoveisSalaJantar(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaMoveisSalaJantar(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaFilmadora() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaFilmadora(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaFilmadora(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaCamera() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaCamera(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaCamera(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual CorrigeTabelas() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CorrigeTabelas(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual CorrigeTabelas(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaSapatoFeminino() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaSapatoFeminino(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaSapatoFeminino(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaGamePS4() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaGamePS4(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaGamePS4(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaGamePS3() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaGamePS3(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaGamePS3(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaGameXbox360() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaGameXbox360(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaGameXbox360(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaGameXboxOne() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaGameXboxOne(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaGameXboxOne(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaGameNintendoWiiU() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaGameNintendoWiiU(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaGameNintendoWiiU(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual ObtemPorProduto() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorProduto(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual ObtemPorProduto(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual AtualizaComputador() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaComputador(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual AtualizaComputador(final DaoConexao conexao)
			throws DaoException;
	public final LojaVirtual ExecutaNaturezaLoja() throws DaoException {
		LojaVirtual saida;
		LojaVirtualDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ExecutaNaturezaLoja(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract LojaVirtual ExecutaNaturezaLoja(final DaoConexao conexao)
			throws DaoException;




	public static final LojaVirtualDao getDao() {
		return DBB.getInstancia().getLojaVirtualDao();
	}
	protected final LojaVirtualDao getDao(final DaoConexao conexao) {
		LojaVirtualDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final LojaVirtualDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		LojaVirtualDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		LojaVirtualDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		LojaVirtualDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		LojaVirtualDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public LojaVirtual PreInsercao(LojaVirtual item) {
		return item;
	}

	public LojaVirtual PreAlteracao(LojaVirtual item) {
		return item;
	}

	public LojaVirtual obtemPorChave(long chave) throws DaoException {
		LojaVirtualDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		LojaVirtual saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public LojaVirtual obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		LojaVirtualDao dao = getDao();
		dao.setConexao(conexao);
		LojaVirtual saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		LojaVirtualDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		LojaVirtualDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		LojaVirtualDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public LojaVirtual excluiItem(LojaVirtual item) throws DaoException {
		LojaVirtualDao dao = getDao();
		DaoConexao conexao = null;
		LojaVirtual saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public LojaVirtual excluiItem(LojaVirtual item, DaoConexao conexao) throws DaoException {
		LojaVirtualDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public LojaVirtual alteraItem(LojaVirtual item) throws DaoException {
		LojaVirtualDao dao = getDao();
		DaoConexao conexao = null;
		LojaVirtual saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public LojaVirtual alteraItem(LojaVirtual item, DaoConexao conexao) throws DaoException {
		LojaVirtualDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public LojaVirtual insereItemLoad(LojaVirtual item) throws DaoException {
		LojaVirtualDao dao = getDao();
		DaoConexao conexao = null;
		LojaVirtual saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public LojaVirtual insereItemLoad(LojaVirtual item, DaoConexao conexao) throws DaoException {
		LojaVirtualDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
