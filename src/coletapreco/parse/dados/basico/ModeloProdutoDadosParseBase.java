package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.ModeloProdutoDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class ModeloProdutoDadosParseBase extends DadosParseDao {

	protected ModeloProdutoDao dao = null;
	protected ModeloProduto itemDetalhe = null;
	protected List<ModeloProduto> lista = null;
	
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
	// do Objeto ModeloProduto
	// Para listas usar itemCorrente.
	public ModeloProduto getItemDetalhe() {
		return itemDetalhe;
	}
	
	private ModeloProduto itemCorrente = null;
	
	//ReferenteA 
	private	ModeloProdutoProduto correnteModeloProdutoProduto;
	protected List<ModeloProdutoProduto> listaModeloProdutoProduto = new ArrayList<ModeloProdutoProduto>();
	
	// Adicionado em 01-08-2016
	public void adicionaModeloProdutoProduto(ModeloProdutoProduto itemLista) {
		itemLista.setIdModeloProdutoRa(itemDetalhe.getIdModeloProduto());
		//ArquivoLog.getInstancia().salvaLog("ModeloProduto(adicionaCorrenteModeloProdutoProduto):" + ModeloProdutoProdutoDadosParseBase.displayLog(correnteModeloProdutoProduto));
		listaModeloProdutoProduto.add(itemLista);
	}
	
	
	
	@Deprecated
	public ModeloProdutoProduto getCorrenteModeloProdutoProduto() {
		return correnteModeloProdutoProduto;
	}
	@Deprecated
	public void adicionaCorrenteModeloProdutoProduto() {
		correnteModeloProdutoProduto.setIdModeloProdutoRa(itemDetalhe.getIdModeloProduto());
		ArquivoLog.getInstancia().salvaLog("ModeloProduto(adicionaCorrenteModeloProdutoProduto):" + ModeloProdutoProdutoDadosParseBase.displayLog(correnteModeloProdutoProduto));
		
		listaModeloProdutoProduto.add(correnteModeloProdutoProduto);
	}
	@Deprecated
	public void criaCorrenteModeloProdutoProduto() {
		correnteModeloProdutoProduto = FabricaVo.criaModeloProdutoProduto();
	}
 		
	
	public ModeloProdutoDadosParseBase() {
		super();
		lista = new ArrayList<ModeloProduto>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public ModeloProduto getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(ModeloProduto item) {
		ArquivoLog.getInstancia().salvaLog("ModeloProduto(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(ModeloProduto item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("ModeloProduto(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaModeloProduto();
	}


	public void setItemDetalhe(ModeloProduto item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em ModeloProdutoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em ModeloProdutoDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getModeloProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getModeloProdutoDao();
			dao.setConexao(getConexao());
			List<ModeloProduto> listaBanco = dao.ListaCorrente();
			List<ModeloProduto> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<ModeloProduto> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<ModeloProduto> it = listaInclusao.iterator();
			while (it.hasNext()) {
				ModeloProduto item = it.next();
				System.out.println("ModeloProduto Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<ModeloProduto> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				ModeloProduto item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(ModeloProduto item, ModeloProdutoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(ModeloProduto item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(ModeloProduto item) {
		try {
			dao = DBB.getInstancia().getModeloProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<ModeloProduto> subtraiListaPorNome(List<ModeloProduto> listaMaior, List<ModeloProduto> listaMenor) {
		Iterator<ModeloProduto> itMaior = listaMaior.iterator();
		Iterator<ModeloProduto> itMenor = null;
		List<ModeloProduto> listaDiferenca = new ArrayList<ModeloProduto>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			ModeloProduto corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				ModeloProduto comparador = itMenor.next();
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
	protected boolean iguais(ModeloProduto item1, ModeloProduto item2) {
		throw new RuntimeException("Fazer override em ModeloProdutoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(ModeloProduto item) {
		return "Fazer override em ModeloProdutoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaModeloProdutoProduto.clear();
	
	}
	
	
	public void displayLogLista(List<ModeloProduto> lista, String codigo) {
		for (ModeloProduto item : lista) {
			ArquivoLog.getInstancia().salvaLog("ModeloProduto(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(ModeloProduto item) {
		StringBuffer display = new StringBuffer();
		display.append("ModeloProduto {");
		
		display.append("IdModeloProduto:" + item.getIdModeloProduto() + ";");
		
		display.append("NomeModeloProduto:" + item.getNomeModeloProduto() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}