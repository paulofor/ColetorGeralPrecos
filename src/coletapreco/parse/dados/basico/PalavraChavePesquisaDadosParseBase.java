package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.PalavraChavePesquisaDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class PalavraChavePesquisaDadosParseBase extends DadosParseDao {

	protected PalavraChavePesquisaDao dao = null;
	protected PalavraChavePesquisa itemDetalhe = null;
	protected List<PalavraChavePesquisa> lista = null;
	
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
	// do Objeto PalavraChavePesquisa
	// Para listas usar itemCorrente.
	public PalavraChavePesquisa getItemDetalhe() {
		return itemDetalhe;
	}
	
	private PalavraChavePesquisa itemCorrente = null;
	
	//Gerou 
	private	ProdutoCliente correnteProdutoCliente;
	protected List<ProdutoCliente> listaProdutoCliente = new ArrayList<ProdutoCliente>();
	
	// Adicionado em 01-08-2016
	public void adicionaProdutoCliente(ProdutoCliente itemLista) {
		itemLista.setIdPalavraChavePesquisaRa(itemDetalhe.getIdPalavraChavePesquisa());
		//ArquivoLog.getInstancia().salvaLog("PalavraChavePesquisa(adicionaCorrenteProdutoCliente):" + ProdutoClienteDadosParseBase.displayLog(correnteProdutoCliente));
		listaProdutoCliente.add(itemLista);
	}
	
	
	
	@Deprecated
	public ProdutoCliente getCorrenteProdutoCliente() {
		return correnteProdutoCliente;
	}
	@Deprecated
	public void adicionaCorrenteProdutoCliente() {
		correnteProdutoCliente.setIdPalavraChavePesquisaRa(itemDetalhe.getIdPalavraChavePesquisa());
		ArquivoLog.getInstancia().salvaLog("PalavraChavePesquisa(adicionaCorrenteProdutoCliente):" + ProdutoClienteDadosParseBase.displayLog(correnteProdutoCliente));
		
		listaProdutoCliente.add(correnteProdutoCliente);
	}
	@Deprecated
	public void criaCorrenteProdutoCliente() {
		correnteProdutoCliente = FabricaVo.criaProdutoCliente();
	}
 		
	
	public PalavraChavePesquisaDadosParseBase() {
		super();
		lista = new ArrayList<PalavraChavePesquisa>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public PalavraChavePesquisa getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(PalavraChavePesquisa item) {
		ArquivoLog.getInstancia().salvaLog("PalavraChavePesquisa(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(PalavraChavePesquisa item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("PalavraChavePesquisa(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaPalavraChavePesquisa();
	}


	public void setItemDetalhe(PalavraChavePesquisa item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em PalavraChavePesquisaDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em PalavraChavePesquisaDadosParse";
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
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getPalavraChavePesquisaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getPalavraChavePesquisaDao();
			dao.setConexao(getConexao());
			List<PalavraChavePesquisa> listaBanco = dao.ListaCorrente();
			List<PalavraChavePesquisa> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<PalavraChavePesquisa> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<PalavraChavePesquisa> it = listaInclusao.iterator();
			while (it.hasNext()) {
				PalavraChavePesquisa item = it.next();
				System.out.println("PalavraChavePesquisa Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<PalavraChavePesquisa> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				PalavraChavePesquisa item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(PalavraChavePesquisa item, PalavraChavePesquisaDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(PalavraChavePesquisa item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(PalavraChavePesquisa item) {
		try {
			dao = DBB.getInstancia().getPalavraChavePesquisaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<PalavraChavePesquisa> subtraiListaPorNome(List<PalavraChavePesquisa> listaMaior, List<PalavraChavePesquisa> listaMenor) {
		Iterator<PalavraChavePesquisa> itMaior = listaMaior.iterator();
		Iterator<PalavraChavePesquisa> itMenor = null;
		List<PalavraChavePesquisa> listaDiferenca = new ArrayList<PalavraChavePesquisa>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			PalavraChavePesquisa corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				PalavraChavePesquisa comparador = itMenor.next();
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
	protected boolean iguais(PalavraChavePesquisa item1, PalavraChavePesquisa item2) {
		throw new RuntimeException("Fazer override em PalavraChavePesquisaDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(PalavraChavePesquisa item) {
		return "Fazer override em PalavraChavePesquisaDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaProdutoCliente.clear();
	
	}
	
	
	public void displayLogLista(List<PalavraChavePesquisa> lista, String codigo) {
		for (PalavraChavePesquisa item : lista) {
			ArquivoLog.getInstancia().salvaLog("PalavraChavePesquisa(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(PalavraChavePesquisa item) {
		StringBuffer display = new StringBuffer();
		display.append("PalavraChavePesquisa {");
		
		display.append("IdPalavraChavePesquisa:" + item.getIdPalavraChavePesquisa() + ";");
		
		display.append("TextoBusca:" + item.getTextoBusca() + ";");
		
		display.append("Data:" + item.getData() + ";");
		
		display.append("IdUsuarioS:" + item.getIdUsuarioS() + ";");
		
		display.append("IdNaturezaProdutoRa:" + item.getIdNaturezaProdutoRa() + ";");
		
		
		
		if (item.getNaturezaProdutoReferenteA(false)!=null) {
			display.append("NaturezaProduto{");
			display.append(NaturezaProdutoDadosParse.displayLog(item.getNaturezaProdutoReferenteA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}