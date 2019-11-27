package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.FacebookPostPerformanceDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class FacebookPostPerformanceDadosParseBase extends DadosParseDao {

	protected FacebookPostPerformanceDao dao = null;
	protected FacebookPostPerformance itemDetalhe = null;
	protected List<FacebookPostPerformance> lista = null;
	
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
	// do Objeto FacebookPostPerformance
	// Para listas usar itemCorrente.
	public FacebookPostPerformance getItemDetalhe() {
		return itemDetalhe;
	}
	
	private FacebookPostPerformance itemCorrente = null;
	
	
	public FacebookPostPerformanceDadosParseBase() {
		super();
		lista = new ArrayList<FacebookPostPerformance>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public FacebookPostPerformance getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(FacebookPostPerformance item) {
		ArquivoLog.getInstancia().salvaLog("FacebookPostPerformance(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(FacebookPostPerformance item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("FacebookPostPerformance(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaFacebookPostPerformance();
	}


	public void setItemDetalhe(FacebookPostPerformance item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em FacebookPostPerformanceDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em FacebookPostPerformanceDadosParse";
 	}

	
	private FacebookPost _facebookPost_ReferenteA; 
	
	@Deprecated
	public void setFacebookPost_ReferenteA(FacebookPost item) {
		_facebookPost_ReferenteA = item;
	}
	@Deprecated
	public FacebookPost getFacebookPost_ReferenteA() {
		return _facebookPost_ReferenteA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getFacebookPostPerformanceDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getFacebookPostPerformanceDao();
			dao.setConexao(getConexao());
			List<FacebookPostPerformance> listaBanco = dao.ListaCorrente();
			List<FacebookPostPerformance> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<FacebookPostPerformance> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<FacebookPostPerformance> it = listaInclusao.iterator();
			while (it.hasNext()) {
				FacebookPostPerformance item = it.next();
				System.out.println("FacebookPostPerformance Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<FacebookPostPerformance> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				FacebookPostPerformance item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(FacebookPostPerformance item, FacebookPostPerformanceDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(FacebookPostPerformance item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(FacebookPostPerformance item) {
		try {
			dao = DBB.getInstancia().getFacebookPostPerformanceDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<FacebookPostPerformance> subtraiListaPorNome(List<FacebookPostPerformance> listaMaior, List<FacebookPostPerformance> listaMenor) {
		Iterator<FacebookPostPerformance> itMaior = listaMaior.iterator();
		Iterator<FacebookPostPerformance> itMenor = null;
		List<FacebookPostPerformance> listaDiferenca = new ArrayList<FacebookPostPerformance>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			FacebookPostPerformance corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				FacebookPostPerformance comparador = itMenor.next();
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
	protected boolean iguais(FacebookPostPerformance item1, FacebookPostPerformance item2) {
		throw new RuntimeException("Fazer override em FacebookPostPerformanceDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(FacebookPostPerformance item) {
		return "Fazer override em FacebookPostPerformanceDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<FacebookPostPerformance> lista, String codigo) {
		for (FacebookPostPerformance item : lista) {
			ArquivoLog.getInstancia().salvaLog("FacebookPostPerformance(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(FacebookPostPerformance item) {
		StringBuffer display = new StringBuffer();
		display.append("FacebookPostPerformance {");
		
		display.append("IdFacebookPostPerformance:" + item.getIdFacebookPostPerformance() + ";");
		
		display.append("Data:" + item.getData() + ";");
		
		display.append("Alcance:" + item.getAlcance() + ";");
		
		display.append("IdFacebookPostRa:" + item.getIdFacebookPostRa() + ";");
		
		
		
		if (item.getFacebookPostReferenteA(false)!=null) {
			display.append("FacebookPost{");
			display.append(FacebookPostDadosParse.displayLog(item.getFacebookPostReferenteA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}