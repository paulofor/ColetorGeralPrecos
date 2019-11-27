package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.FacebookPostDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class FacebookPostDadosParseBase extends DadosParseDao {

	protected FacebookPostDao dao = null;
	protected FacebookPost itemDetalhe = null;
	protected List<FacebookPost> lista = null;
	
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
	// do Objeto FacebookPost
	// Para listas usar itemCorrente.
	public FacebookPost getItemDetalhe() {
		return itemDetalhe;
	}
	
	private FacebookPost itemCorrente = null;
	
	//Gera 
	private	FacebookPostPerformance correnteFacebookPostPerformance;
	protected List<FacebookPostPerformance> listaFacebookPostPerformance = new ArrayList<FacebookPostPerformance>();
	
	// Adicionado em 01-08-2016
	public void adicionaFacebookPostPerformance(FacebookPostPerformance itemLista) {
		itemLista.setIdFacebookPostRa(itemDetalhe.getIdFacebookPost());
		//ArquivoLog.getInstancia().salvaLog("FacebookPost(adicionaCorrenteFacebookPostPerformance):" + FacebookPostPerformanceDadosParseBase.displayLog(correnteFacebookPostPerformance));
		listaFacebookPostPerformance.add(itemLista);
	}
	
	
	
	@Deprecated
	public FacebookPostPerformance getCorrenteFacebookPostPerformance() {
		return correnteFacebookPostPerformance;
	}
	@Deprecated
	public void adicionaCorrenteFacebookPostPerformance() {
		correnteFacebookPostPerformance.setIdFacebookPostRa(itemDetalhe.getIdFacebookPost());
		ArquivoLog.getInstancia().salvaLog("FacebookPost(adicionaCorrenteFacebookPostPerformance):" + FacebookPostPerformanceDadosParseBase.displayLog(correnteFacebookPostPerformance));
		
		listaFacebookPostPerformance.add(correnteFacebookPostPerformance);
	}
	@Deprecated
	public void criaCorrenteFacebookPostPerformance() {
		correnteFacebookPostPerformance = FabricaVo.criaFacebookPostPerformance();
	}
 		
	
	public FacebookPostDadosParseBase() {
		super();
		lista = new ArrayList<FacebookPost>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public FacebookPost getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(FacebookPost item) {
		ArquivoLog.getInstancia().salvaLog("FacebookPost(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(FacebookPost item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("FacebookPost(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaFacebookPost();
	}


	public void setItemDetalhe(FacebookPost item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em FacebookPostDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em FacebookPostDadosParse";
 	}

	
	private FacebookFanpage _facebookFanpage_FeitoEm; 
	
	@Deprecated
	public void setFacebookFanpage_FeitoEm(FacebookFanpage item) {
		_facebookFanpage_FeitoEm = item;
	}
	@Deprecated
	public FacebookFanpage getFacebookFanpage_FeitoEm() {
		return _facebookFanpage_FeitoEm;
	}
 	
	private Produto _produto_Divulgando; 
	
	@Deprecated
	public void setProduto_Divulgando(Produto item) {
		_produto_Divulgando = item;
	}
	@Deprecated
	public Produto getProduto_Divulgando() {
		return _produto_Divulgando;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getFacebookPostDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getFacebookPostDao();
			dao.setConexao(getConexao());
			List<FacebookPost> listaBanco = dao.ListaCorrente();
			List<FacebookPost> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<FacebookPost> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<FacebookPost> it = listaInclusao.iterator();
			while (it.hasNext()) {
				FacebookPost item = it.next();
				System.out.println("FacebookPost Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<FacebookPost> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				FacebookPost item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(FacebookPost item, FacebookPostDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(FacebookPost item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(FacebookPost item) {
		try {
			dao = DBB.getInstancia().getFacebookPostDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<FacebookPost> subtraiListaPorNome(List<FacebookPost> listaMaior, List<FacebookPost> listaMenor) {
		Iterator<FacebookPost> itMaior = listaMaior.iterator();
		Iterator<FacebookPost> itMenor = null;
		List<FacebookPost> listaDiferenca = new ArrayList<FacebookPost>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			FacebookPost corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				FacebookPost comparador = itMenor.next();
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
	protected boolean iguais(FacebookPost item1, FacebookPost item2) {
		throw new RuntimeException("Fazer override em FacebookPostDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(FacebookPost item) {
		return "Fazer override em FacebookPostDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaFacebookPostPerformance.clear();
	
	}
	
	
	public void displayLogLista(List<FacebookPost> lista, String codigo) {
		for (FacebookPost item : lista) {
			ArquivoLog.getInstancia().salvaLog("FacebookPost(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(FacebookPost item) {
		StringBuffer display = new StringBuffer();
		display.append("FacebookPost {");
		
		display.append("IdFacebookPost:" + item.getIdFacebookPost() + ";");
		
		display.append("DataHora:" + item.getDataHora() + ";");
		
		display.append("CodigoFacebook:" + item.getCodigoFacebook() + ";");
		
		display.append("HorarioProgramacao:" + item.getHorarioProgramacao() + ";");
		
		display.append("IdFacebookFanpageFe:" + item.getIdFacebookFanpageFe() + ";");
		
		display.append("IdProdutoD:" + item.getIdProdutoD() + ";");
		
		
		
		if (item.getFacebookFanpageFeitoEm(false)!=null) {
			display.append("FacebookFanpage{");
			display.append(FacebookFanpageDadosParse.displayLog(item.getFacebookFanpageFeitoEm(false)));
			display.append("}");
		}
 		
		if (item.getProdutoDivulgando(false)!=null) {
			display.append("Produto{");
			display.append(ProdutoDadosParse.displayLog(item.getProdutoDivulgando(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}