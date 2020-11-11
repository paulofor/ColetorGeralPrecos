package coletapreco.regracolecao;

import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;

import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.regracolecao.filtro.*;

public abstract class OportunidadeDiaRegraColecao {

	public OportunidadeDiaRegraColecao() {
		_filtro = null;
	}
	


	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		 * OportunidadeDiaDao dao = getDao(); dao.setConexao(conexao); List
		 * saida = null; OportunidadeDiaFiltro filtroWork = getFiltro(); if
		 * (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) { saida =
		 * dao.ListaPorLinhaProdutoEstaEm(filtroWork
		 * .getCodigoLinhaProdutoEstaEm()); return saida; } saida =
		 * dao.ListaCorrenteAgrupada(); return saida;
		 */
	}

	private OportunidadeDiaFiltro _filtro;

	public OportunidadeDiaFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new OportunidadeDiaFiltro();
		return _filtro;
	}

	public void setFiltro(OportunidadeDiaFiltro dado) {
		_filtro = dado;
	}

	private OportunidadeDiaFiltro[] _listaEntrada;

	@Deprecated
	protected OportunidadeDiaFiltro[] getListaEntrada() {
		return _listaEntrada;
	}

	@Deprecated
	public void setListaEntrada(final OportunidadeDiaFiltro[] dado) {
		_listaEntrada = dado;
	}

	private List<OportunidadeDia> _listaItem;

	protected List<OportunidadeDia> getListaEntradaItem() {
		return _listaItem;
	}

	public void setListaEntradaItem(final List<OportunidadeDia> dado) {
		_listaItem = dado;
	}

	private List _listaGenerica;

	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}

	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}

	public final OportunidadeDia EnviaParaServidor() throws DaoException {
		OportunidadeDia saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = EnviaParaServidor(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public abstract OportunidadeDia EnviaParaServidor(final DaoConexao conexao) throws DaoException;
	
	public final OportunidadeDia EnviaParaServidor(final long idNatureza) throws DaoException {
		OportunidadeDia saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = EnviaParaServidor(idNatureza, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public abstract OportunidadeDia EnviaParaServidor(final long idNatureza, final DaoConexao conexao) throws DaoException;

	

	public final OportunidadeDia CalculaOportunidadesHoje() throws DaoException {
		OportunidadeDia saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CalculaOportunidadesHoje(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public abstract OportunidadeDia CalculaOportunidadesHoje(final DaoConexao conexao) throws DaoException;
	
	public final OportunidadeDia CalculaOportunidadesHoje(final long idNatureza) throws DaoException {
		OportunidadeDia saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CalculaOportunidadesHoje(idNatureza, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public abstract OportunidadeDia CalculaOportunidadesHoje(final long idNatureza, final DaoConexao conexao) throws DaoException;


	public final List<OportunidadeDia> ListaPorNatureza() throws DaoException {
		List<OportunidadeDia> saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorNatureza(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public abstract List<OportunidadeDia> ListaPorNatureza(final DaoConexao conexao) throws DaoException;

	public final OportunidadeDia ChamaMobile() throws DaoException {
		OportunidadeDia saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ChamaMobile(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public abstract OportunidadeDia ChamaMobile(final DaoConexao conexao) throws DaoException;

	public final OportunidadeDia ChamaMobileCliente() throws DaoException {
		OportunidadeDia saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ChamaMobileCliente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public abstract OportunidadeDia ChamaMobileCliente(final DaoConexao conexao) throws DaoException;

	public final OportunidadeDia ConfirmaOportunidadeDia() throws DaoException {
		OportunidadeDia saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ConfirmaOportunidadeDia(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public abstract OportunidadeDia ConfirmaOportunidadeDia(final DaoConexao conexao) throws DaoException;

	public final List<OportunidadeDia> ListaPorFanpage() throws DaoException {
		List<OportunidadeDia> saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorFanpage(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public abstract List<OportunidadeDia> ListaPorFanpage(final DaoConexao conexao) throws DaoException;

	public static final OportunidadeDiaDao getDao() {
		return DBB.getInstancia().getOportunidadeDiaDao();
	}

	protected final OportunidadeDiaDao getDao(final DaoConexao conexao) {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final OportunidadeDiaDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		OportunidadeDiaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		OportunidadeDiaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public OportunidadeDia PreInsercao(OportunidadeDia item) {
		return item;
	}

	public OportunidadeDia PreAlteracao(OportunidadeDia item) {
		return item;
	}

	public OportunidadeDia obtemPorChave(long chave) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		OportunidadeDia saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public OportunidadeDia obtemPorChave(long chave, DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		OportunidadeDia saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		OportunidadeDiaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		OportunidadeDiaDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public OportunidadeDia excluiItem(OportunidadeDia item) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		DaoConexao conexao = null;
		OportunidadeDia saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public OportunidadeDia excluiItem(OportunidadeDia item, DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}

	public OportunidadeDia alteraItem(OportunidadeDia item) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		DaoConexao conexao = null;
		OportunidadeDia saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public OportunidadeDia alteraItem(OportunidadeDia item, DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}

	public OportunidadeDia insereItemLoad(OportunidadeDia item) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		DaoConexao conexao = null;
		OportunidadeDia saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public OportunidadeDia insereItemLoad(OportunidadeDia item, DaoConexao conexao) throws DaoException {
		OportunidadeDiaDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}

	// Tratamento de objetos que possuem FK nesse objeto para objetos nao
	// associativos
	public List getPorReferenteAProduto(long id) throws DaoException {
		// Existe no DAO
		OportunidadeDiaDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorProdutoReferenteA(id);
	}

	public boolean excluiPorReferenteAProduto(long id) throws DaoException {
		// Existe no DAO
		return true;
	}

	public List getPorReferenteAProduto(long id, DaoConexao conn) throws DaoException {
		OportunidadeDiaDao dao = getDao(conn);
		return dao.ListaPorProdutoReferenteA(id);
	}

	// Tratamento de objetos que possuem FK nesse objeto para objetos nao
	// associativos
	public List getPorPertenceANaturezaProduto(long id) throws DaoException {
		// Existe no DAO
		OportunidadeDiaDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorNaturezaProdutoPertenceA(id);
	}

	public boolean excluiPorPertenceANaturezaProduto(long id) throws DaoException {
		// Existe no DAO
		return true;
	}

	public List getPorPertenceANaturezaProduto(long id, DaoConexao conn) throws DaoException {
		OportunidadeDiaDao dao = getDao(conn);
		return dao.ListaPorNaturezaProdutoPertenceA(id);
	}

	public final OportunidadeDia CalculaOportunidadesPosicaoHoje() throws DaoException {
		OportunidadeDia saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CalculaOportunidadesPosicaoHoje(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OportunidadeDia CalculaOportunidadesPosicaoHoje(final DaoConexao conexao) throws DaoException;
	
	
	/*
	public final OportunidadeDia CalculaSugestaoPreco() throws DaoException {
		OportunidadeDia saida;
		OportunidadeDiaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CalculaSugestaoPreco(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public abstract OportunidadeDia CalculaSugestaoPreco(final DaoConexao conexao) throws DaoException;
	*/

}
