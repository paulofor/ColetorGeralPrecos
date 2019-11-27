package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.CategoriaLojaProdutoDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class CategoriaLojaProdutoDadosParseBase extends DadosParseDao {

	protected CategoriaLojaProdutoDao dao = null;
	protected CategoriaLojaProduto itemDetalhe = null;
	protected List<CategoriaLojaProduto> lista = null;
	
	private boolean debug;
	
	public void setDebug() {
		debug = true;
	}
	
	private String proximaPagina = null;
	public void setProximaPagina(String url) {
		proximaPagina = url;
	}
	@Override
	public void setJson(JSONObject json) {
		throw new RuntimeException("voce deve implmentar o metodo setJson em " + this.getClass().toString());
	}
	
	// Para ser utilizado quando se esta obtendo o detalhe 
	// do Objeto CategoriaLojaProduto
	// Para listas usar itemCorrente.
	public CategoriaLojaProduto getItemDetalhe() {
		return itemDetalhe;
	}
	
	private CategoriaLojaProduto itemCorrente = null;
	
	
	public CategoriaLojaProdutoDadosParseBase() {
		super();
		lista = new ArrayList<CategoriaLojaProduto>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public CategoriaLojaProduto getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(CategoriaLojaProduto item) {
		ArquivoLog.getInstancia().salvaLog("CategoriaLojaProduto(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(CategoriaLojaProduto item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("CategoriaLojaProduto(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaCategoriaLojaProduto();
	}


	public void setItemDetalhe(CategoriaLojaProduto item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em CategoriaLojaProdutoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em CategoriaLojaProdutoDadosParse";
 	}

	
	private CategoriaLoja _categoriaLoja_ReferenteA; 
	
	@Deprecated
	public void setCategoriaLoja_ReferenteA(CategoriaLoja item) {
		_categoriaLoja_ReferenteA = item;
	}
	@Deprecated
	public CategoriaLoja getCategoriaLoja_ReferenteA() {
		return _categoriaLoja_ReferenteA;
	}
 	
	private Produto _produto_ReferenteA; 
	
	@Deprecated
	public void setProduto_ReferenteA(Produto item) {
		_produto_ReferenteA = item;
	}
	@Deprecated
	public Produto getProduto_ReferenteA() {
		return _produto_ReferenteA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getCategoriaLojaProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getCategoriaLojaProdutoDao();
			dao.setConexao(getConexao());
			List<CategoriaLojaProduto> listaBanco = dao.ListaCorrente();
			List<CategoriaLojaProduto> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<CategoriaLojaProduto> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<CategoriaLojaProduto> it = listaInclusao.iterator();
			while (it.hasNext()) {
				CategoriaLojaProduto item = it.next();
				System.out.println("CategoriaLojaProduto Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<CategoriaLojaProduto> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				CategoriaLojaProduto item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(CategoriaLojaProduto item, CategoriaLojaProdutoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(CategoriaLojaProduto item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(CategoriaLojaProduto item) {
		try {
			dao = DBB.getInstancia().getCategoriaLojaProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<CategoriaLojaProduto> subtraiListaPorNome(List<CategoriaLojaProduto> listaMaior, List<CategoriaLojaProduto> listaMenor) {
		Iterator<CategoriaLojaProduto> itMaior = listaMaior.iterator();
		Iterator<CategoriaLojaProduto> itMenor = null;
		List<CategoriaLojaProduto> listaDiferenca = new ArrayList<CategoriaLojaProduto>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			CategoriaLojaProduto corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				CategoriaLojaProduto comparador = itMenor.next();
				if (iguais(comparador,corrente)) {
					achou = true;
					break;
				}
			}
			if (!achou) {
				listaDiferenca.add(corrente);
			}
		}
		return listaDiferenca;
	}
	protected boolean iguais(CategoriaLojaProduto item1, CategoriaLojaProduto item2) {
		throw new RuntimeException("Fazer override em CategoriaLojaProdutoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(CategoriaLojaProduto item) {
		return "Fazer override em CategoriaLojaProdutoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<CategoriaLojaProduto> lista, String codigo) {
		for (CategoriaLojaProduto item : lista) {
			ArquivoLog.getInstancia().salvaLog("CategoriaLojaProduto(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(CategoriaLojaProduto item) {
		StringBuffer display = new StringBuffer();
		display.append("CategoriaLojaProduto {");
		
		display.append("IdCategoriaLojaProduto:" + item.getIdCategoriaLojaProduto() + ";");
		
		display.append("DataUltimaVisita:" + item.getDataUltimaVisita() + ";");
		
		display.append("IdCategoriaLojaRa:" + item.getIdCategoriaLojaRa() + ";");
		
		display.append("IdProdutoRa:" + item.getIdProdutoRa() + ";");
		
		
		
		if (item.getCategoriaLojaReferenteA(false)!=null) {
			display.append("CategoriaLoja{");
			display.append(CategoriaLojaDadosParse.displayLog(item.getCategoriaLojaReferenteA(false)));
			display.append("}");
		}
 		
		if (item.getProdutoReferenteA(false)!=null) {
			display.append("Produto{");
			display.append(ProdutoDadosParse.displayLog(item.getProdutoReferenteA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}