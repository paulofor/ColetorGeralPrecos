package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.ModeloProdutoProdutoDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class ModeloProdutoProdutoDadosParseBase extends DadosParseDao {

	protected ModeloProdutoProdutoDao dao = null;
	protected ModeloProdutoProduto itemDetalhe = null;
	protected List<ModeloProdutoProduto> lista = null;
	
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
	// do Objeto ModeloProdutoProduto
	// Para listas usar itemCorrente.
	public ModeloProdutoProduto getItemDetalhe() {
		return itemDetalhe;
	}
	
	private ModeloProdutoProduto itemCorrente = null;
	
	
	public ModeloProdutoProdutoDadosParseBase() {
		super();
		lista = new ArrayList<ModeloProdutoProduto>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public ModeloProdutoProduto getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(ModeloProdutoProduto item) {
		ArquivoLog.getInstancia().salvaLog("ModeloProdutoProduto(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(ModeloProdutoProduto item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("ModeloProdutoProduto(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaModeloProdutoProduto();
	}


	public void setItemDetalhe(ModeloProdutoProduto item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em ModeloProdutoProdutoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em ModeloProdutoProdutoDadosParse";
 	}

	
	private ModeloProduto _modeloProduto_ReferenteA; 
	
	@Deprecated
	public void setModeloProduto_ReferenteA(ModeloProduto item) {
		_modeloProduto_ReferenteA = item;
	}
	@Deprecated
	public ModeloProduto getModeloProduto_ReferenteA() {
		return _modeloProduto_ReferenteA;
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
			dao = DBB.getInstancia().getModeloProdutoProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getModeloProdutoProdutoDao();
			dao.setConexao(getConexao());
			List<ModeloProdutoProduto> listaBanco = dao.ListaCorrente();
			List<ModeloProdutoProduto> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<ModeloProdutoProduto> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<ModeloProdutoProduto> it = listaInclusao.iterator();
			while (it.hasNext()) {
				ModeloProdutoProduto item = it.next();
				System.out.println("ModeloProdutoProduto Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<ModeloProdutoProduto> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				ModeloProdutoProduto item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(ModeloProdutoProduto item, ModeloProdutoProdutoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(ModeloProdutoProduto item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(ModeloProdutoProduto item) {
		try {
			dao = DBB.getInstancia().getModeloProdutoProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<ModeloProdutoProduto> subtraiListaPorNome(List<ModeloProdutoProduto> listaMaior, List<ModeloProdutoProduto> listaMenor) {
		Iterator<ModeloProdutoProduto> itMaior = listaMaior.iterator();
		Iterator<ModeloProdutoProduto> itMenor = null;
		List<ModeloProdutoProduto> listaDiferenca = new ArrayList<ModeloProdutoProduto>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			ModeloProdutoProduto corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				ModeloProdutoProduto comparador = itMenor.next();
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
	protected boolean iguais(ModeloProdutoProduto item1, ModeloProdutoProduto item2) {
		throw new RuntimeException("Fazer override em ModeloProdutoProdutoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(ModeloProdutoProduto item) {
		return "Fazer override em ModeloProdutoProdutoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<ModeloProdutoProduto> lista, String codigo) {
		for (ModeloProdutoProduto item : lista) {
			ArquivoLog.getInstancia().salvaLog("ModeloProdutoProduto(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(ModeloProdutoProduto item) {
		StringBuffer display = new StringBuffer();
		display.append("ModeloProdutoProduto {");
		
		display.append("IdModeloProdutoProduto:" + item.getIdModeloProdutoProduto() + ";");
		
		display.append("IdModeloProdutoRa:" + item.getIdModeloProdutoRa() + ";");
		
		display.append("IdProdutoRa:" + item.getIdProdutoRa() + ";");
		
		
		
		if (item.getModeloProdutoReferenteA(false)!=null) {
			display.append("ModeloProduto{");
			display.append(ModeloProdutoDadosParse.displayLog(item.getModeloProdutoReferenteA(false)));
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