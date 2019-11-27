package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.MarcaDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class MarcaDadosParseBase extends DadosParseDao {

	protected MarcaDao dao = null;
	protected Marca itemDetalhe = null;
	protected List<Marca> lista = null;
	
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
	// do Objeto Marca
	// Para listas usar itemCorrente.
	public Marca getItemDetalhe() {
		return itemDetalhe;
	}
	
	private Marca itemCorrente = null;
	
	//ReferenteA 
	private	Produto correnteProduto;
	protected List<Produto> listaProduto = new ArrayList<Produto>();
	
	// Adicionado em 01-08-2016
	public void adicionaProduto(Produto itemLista) {
		itemLista.setIdMarcaP(itemDetalhe.getIdMarca());
		//ArquivoLog.getInstancia().salvaLog("Marca(adicionaCorrenteProduto):" + ProdutoDadosParseBase.displayLog(correnteProduto));
		listaProduto.add(itemLista);
	}
	
	
	
	@Deprecated
	public Produto getCorrenteProduto() {
		return correnteProduto;
	}
	@Deprecated
	public void adicionaCorrenteProduto() {
		correnteProduto.setIdMarcaP(itemDetalhe.getIdMarca());
		ArquivoLog.getInstancia().salvaLog("Marca(adicionaCorrenteProduto):" + ProdutoDadosParseBase.displayLog(correnteProduto));
		
		listaProduto.add(correnteProduto);
	}
	@Deprecated
	public void criaCorrenteProduto() {
		correnteProduto = FabricaVo.criaProduto();
	}
 		
	
	public MarcaDadosParseBase() {
		super();
		lista = new ArrayList<Marca>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public Marca getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(Marca item) {
		ArquivoLog.getInstancia().salvaLog("Marca(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(Marca item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("Marca(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaMarca();
	}


	public void setItemDetalhe(Marca item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em MarcaDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em MarcaDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getMarcaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getMarcaDao();
			dao.setConexao(getConexao());
			List<Marca> listaBanco = dao.ListaCorrente();
			List<Marca> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<Marca> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<Marca> it = listaInclusao.iterator();
			while (it.hasNext()) {
				Marca item = it.next();
				System.out.println("Marca Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<Marca> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				Marca item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(Marca item, MarcaDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(Marca item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(Marca item) {
		try {
			dao = DBB.getInstancia().getMarcaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<Marca> subtraiListaPorNome(List<Marca> listaMaior, List<Marca> listaMenor) {
		Iterator<Marca> itMaior = listaMaior.iterator();
		Iterator<Marca> itMenor = null;
		List<Marca> listaDiferenca = new ArrayList<Marca>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			Marca corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				Marca comparador = itMenor.next();
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
	protected boolean iguais(Marca item1, Marca item2) {
		throw new RuntimeException("Fazer override em MarcaDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(Marca item) {
		return "Fazer override em MarcaDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaProduto.clear();
	
	}
	
	
	public void displayLogLista(List<Marca> lista, String codigo) {
		for (Marca item : lista) {
			ArquivoLog.getInstancia().salvaLog("Marca(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(Marca item) {
		StringBuffer display = new StringBuffer();
		display.append("Marca {");
		
		display.append("IdMarca:" + item.getIdMarca() + ";");
		
		display.append("NomeMarca:" + item.getNomeMarca() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}