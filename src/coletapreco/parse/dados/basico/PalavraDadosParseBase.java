package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.PalavraDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class PalavraDadosParseBase extends DadosParseDao {

	protected PalavraDao dao = null;
	protected Palavra itemDetalhe = null;
	protected List<Palavra> lista = null;
	
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
	// do Objeto Palavra
	// Para listas usar itemCorrente.
	public Palavra getItemDetalhe() {
		return itemDetalhe;
	}
	
	private Palavra itemCorrente = null;
	
	//Possui 
	private	PalavraProduto correntePalavraProduto;
	protected List<PalavraProduto> listaPalavraProduto = new ArrayList<PalavraProduto>();
	
	// Adicionado em 01-08-2016
	public void adicionaPalavraProduto(PalavraProduto itemLista) {
		itemLista.setIdPalavraRa(itemDetalhe.getIdPalavra());
		//ArquivoLog.getInstancia().salvaLog("Palavra(adicionaCorrentePalavraProduto):" + PalavraProdutoDadosParseBase.displayLog(correntePalavraProduto));
		listaPalavraProduto.add(itemLista);
	}
	
	
	
	@Deprecated
	public PalavraProduto getCorrentePalavraProduto() {
		return correntePalavraProduto;
	}
	@Deprecated
	public void adicionaCorrentePalavraProduto() {
		correntePalavraProduto.setIdPalavraRa(itemDetalhe.getIdPalavra());
		ArquivoLog.getInstancia().salvaLog("Palavra(adicionaCorrentePalavraProduto):" + PalavraProdutoDadosParseBase.displayLog(correntePalavraProduto));
		
		listaPalavraProduto.add(correntePalavraProduto);
	}
	@Deprecated
	public void criaCorrentePalavraProduto() {
		correntePalavraProduto = FabricaVo.criaPalavraProduto();
	}
 		
	
	public PalavraDadosParseBase() {
		super();
		lista = new ArrayList<Palavra>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public Palavra getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(Palavra item) {
		ArquivoLog.getInstancia().salvaLog("Palavra(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(Palavra item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("Palavra(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaPalavra();
	}


	public void setItemDetalhe(Palavra item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em PalavraDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em PalavraDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getPalavraDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getPalavraDao();
			dao.setConexao(getConexao());
			List<Palavra> listaBanco = dao.ListaCorrente();
			List<Palavra> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<Palavra> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<Palavra> it = listaInclusao.iterator();
			while (it.hasNext()) {
				Palavra item = it.next();
				System.out.println("Palavra Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<Palavra> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				Palavra item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(Palavra item, PalavraDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(Palavra item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(Palavra item) {
		try {
			dao = DBB.getInstancia().getPalavraDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<Palavra> subtraiListaPorNome(List<Palavra> listaMaior, List<Palavra> listaMenor) {
		Iterator<Palavra> itMaior = listaMaior.iterator();
		Iterator<Palavra> itMenor = null;
		List<Palavra> listaDiferenca = new ArrayList<Palavra>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			Palavra corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				Palavra comparador = itMenor.next();
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
	protected boolean iguais(Palavra item1, Palavra item2) {
		throw new RuntimeException("Fazer override em PalavraDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(Palavra item) {
		return "Fazer override em PalavraDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaPalavraProduto.clear();
	
	}
	
	
	public void displayLogLista(List<Palavra> lista, String codigo) {
		for (Palavra item : lista) {
			ArquivoLog.getInstancia().salvaLog("Palavra(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(Palavra item) {
		StringBuffer display = new StringBuffer();
		display.append("Palavra {");
		
		display.append("IdPalavra:" + item.getIdPalavra() + ";");
		
		display.append("Descricao:" + item.getDescricao() + ";");
		
		display.append("Comum:" + item.getComum() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}