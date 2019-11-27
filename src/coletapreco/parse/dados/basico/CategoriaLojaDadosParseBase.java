package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.CategoriaLojaDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class CategoriaLojaDadosParseBase extends DadosParseDao {

	protected CategoriaLojaDao dao = null;
	protected CategoriaLoja itemDetalhe = null;
	protected List<CategoriaLoja> lista = null;
	
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
	// do Objeto CategoriaLoja
	// Para listas usar itemCorrente.
	public CategoriaLoja getItemDetalhe() {
		return itemDetalhe;
	}
	
	private CategoriaLoja itemCorrente = null;
	
	//Possui 
	private	CategoriaLojaProduto correnteCategoriaLojaProduto;
	protected List<CategoriaLojaProduto> listaCategoriaLojaProduto = new ArrayList<CategoriaLojaProduto>();
	
	// Adicionado em 01-08-2016
	public void adicionaCategoriaLojaProduto(CategoriaLojaProduto itemLista) {
		itemLista.setIdCategoriaLojaRa(itemDetalhe.getIdCategoriaLoja());
		//ArquivoLog.getInstancia().salvaLog("CategoriaLoja(adicionaCorrenteCategoriaLojaProduto):" + CategoriaLojaProdutoDadosParseBase.displayLog(correnteCategoriaLojaProduto));
		listaCategoriaLojaProduto.add(itemLista);
	}
	
	
	
	@Deprecated
	public CategoriaLojaProduto getCorrenteCategoriaLojaProduto() {
		return correnteCategoriaLojaProduto;
	}
	@Deprecated
	public void adicionaCorrenteCategoriaLojaProduto() {
		correnteCategoriaLojaProduto.setIdCategoriaLojaRa(itemDetalhe.getIdCategoriaLoja());
		ArquivoLog.getInstancia().salvaLog("CategoriaLoja(adicionaCorrenteCategoriaLojaProduto):" + CategoriaLojaProdutoDadosParseBase.displayLog(correnteCategoriaLojaProduto));
		
		listaCategoriaLojaProduto.add(correnteCategoriaLojaProduto);
	}
	@Deprecated
	public void criaCorrenteCategoriaLojaProduto() {
		correnteCategoriaLojaProduto = FabricaVo.criaCategoriaLojaProduto();
	}
 		
	//Filho 
	private	CategoriaLoja correnteCategoriaLoja;
	protected List<CategoriaLoja> listaCategoriaLoja = new ArrayList<CategoriaLoja>();
	
	// Adicionado em 01-08-2016
	public void adicionaCategoriaLoja(CategoriaLoja itemLista) {
		itemLista.setIdCategoriaLojaF(itemDetalhe.getIdCategoriaLoja());
		//ArquivoLog.getInstancia().salvaLog("CategoriaLoja(adicionaCorrenteCategoriaLoja):" + CategoriaLojaDadosParseBase.displayLog(correnteCategoriaLoja));
		listaCategoriaLoja.add(itemLista);
	}
	
	
	
	@Deprecated
	public CategoriaLoja getCorrenteCategoriaLoja() {
		return correnteCategoriaLoja;
	}
	@Deprecated
	public void adicionaCorrenteCategoriaLoja() {
		correnteCategoriaLoja.setIdCategoriaLojaF(itemDetalhe.getIdCategoriaLoja());
		ArquivoLog.getInstancia().salvaLog("CategoriaLoja(adicionaCorrenteCategoriaLoja):" + CategoriaLojaDadosParseBase.displayLog(correnteCategoriaLoja));
		
		listaCategoriaLoja.add(correnteCategoriaLoja);
	}
	@Deprecated
	public void criaCorrenteCategoriaLoja() {
		correnteCategoriaLoja = FabricaVo.criaCategoriaLoja();
	}
 		
	
	public CategoriaLojaDadosParseBase() {
		super();
		lista = new ArrayList<CategoriaLoja>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public CategoriaLoja getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(CategoriaLoja item) {
		ArquivoLog.getInstancia().salvaLog("CategoriaLoja(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(CategoriaLoja item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("CategoriaLoja(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaCategoriaLoja();
	}


	public void setItemDetalhe(CategoriaLoja item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em CategoriaLojaDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em CategoriaLojaDadosParse";
 	}

	
	private CategoriaLoja _categoriaLoja_Filho; 
	
	@Deprecated
	public void setCategoriaLoja_Filho(CategoriaLoja item) {
		_categoriaLoja_Filho = item;
	}
	@Deprecated
	public CategoriaLoja getCategoriaLoja_Filho() {
		return _categoriaLoja_Filho;
	}
 	
	private NaturezaProduto _naturezaProduto_ReferenteA; 
	
	@Deprecated
	public void setNaturezaProduto_ReferenteA(NaturezaProduto item) {
		_naturezaProduto_ReferenteA = item;
	}
	@Deprecated
	public NaturezaProduto getNaturezaProduto_ReferenteA() {
		return _naturezaProduto_ReferenteA;
	}
 	
	private LojaVirtual _lojaVirtual_PertenceA; 
	
	@Deprecated
	public void setLojaVirtual_PertenceA(LojaVirtual item) {
		_lojaVirtual_PertenceA = item;
	}
	@Deprecated
	public LojaVirtual getLojaVirtual_PertenceA() {
		return _lojaVirtual_PertenceA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getCategoriaLojaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getCategoriaLojaDao();
			dao.setConexao(getConexao());
			List<CategoriaLoja> listaBanco = dao.ListaCorrente();
			List<CategoriaLoja> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<CategoriaLoja> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<CategoriaLoja> it = listaInclusao.iterator();
			while (it.hasNext()) {
				CategoriaLoja item = it.next();
				System.out.println("CategoriaLoja Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<CategoriaLoja> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				CategoriaLoja item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(CategoriaLoja item, CategoriaLojaDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(CategoriaLoja item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(CategoriaLoja item) {
		try {
			dao = DBB.getInstancia().getCategoriaLojaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<CategoriaLoja> subtraiListaPorNome(List<CategoriaLoja> listaMaior, List<CategoriaLoja> listaMenor) {
		Iterator<CategoriaLoja> itMaior = listaMaior.iterator();
		Iterator<CategoriaLoja> itMenor = null;
		List<CategoriaLoja> listaDiferenca = new ArrayList<CategoriaLoja>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			CategoriaLoja corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				CategoriaLoja comparador = itMenor.next();
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
	protected boolean iguais(CategoriaLoja item1, CategoriaLoja item2) {
		throw new RuntimeException("Fazer override em CategoriaLojaDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(CategoriaLoja item) {
		return "Fazer override em CategoriaLojaDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaCategoriaLojaProduto.clear();
		listaCategoriaLoja.clear();
	
	}
	
	
	public void displayLogLista(List<CategoriaLoja> lista, String codigo) {
		for (CategoriaLoja item : lista) {
			ArquivoLog.getInstancia().salvaLog("CategoriaLoja(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(CategoriaLoja item) {
		StringBuffer display = new StringBuffer();
		display.append("CategoriaLoja {");
		
		display.append("IdCategoriaLoja:" + item.getIdCategoriaLoja() + ";");
		
		display.append("Nome:" + item.getNome() + ";");
		
		display.append("Url:" + item.getUrl() + ";");
		
		display.append("DataInclusao:" + item.getDataInclusao() + ";");
		
		display.append("IdCategoriaLojaF:" + item.getIdCategoriaLojaF() + ";");
		
		display.append("IdNaturezaProdutoRa:" + item.getIdNaturezaProdutoRa() + ";");
		
		display.append("IdLojaVirtualPa:" + item.getIdLojaVirtualPa() + ";");
		
		
		
		if (item.getCategoriaLojaFilho(false)!=null) {
			display.append("CategoriaLoja{");
			display.append(CategoriaLojaDadosParse.displayLog(item.getCategoriaLojaFilho(false)));
			display.append("}");
		}
 		
		if (item.getNaturezaProdutoReferenteA(false)!=null) {
			display.append("NaturezaProduto{");
			display.append(NaturezaProdutoDadosParse.displayLog(item.getNaturezaProdutoReferenteA(false)));
			display.append("}");
		}
 		
		if (item.getLojaVirtualPertenceA(false)!=null) {
			display.append("LojaVirtual{");
			display.append(LojaVirtualDadosParse.displayLog(item.getLojaVirtualPertenceA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}