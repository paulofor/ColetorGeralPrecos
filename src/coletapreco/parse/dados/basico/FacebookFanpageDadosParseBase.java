package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.FacebookFanpageDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class FacebookFanpageDadosParseBase extends DadosParseDao {

	protected FacebookFanpageDao dao = null;
	protected FacebookFanpage itemDetalhe = null;
	protected List<FacebookFanpage> lista = null;
	
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
	// do Objeto FacebookFanpage
	// Para listas usar itemCorrente.
	public FacebookFanpage getItemDetalhe() {
		return itemDetalhe;
	}
	
	private FacebookFanpage itemCorrente = null;
	
	//Tem 
	private	FacebookPost correnteFacebookPost;
	protected List<FacebookPost> listaFacebookPost = new ArrayList<FacebookPost>();
	
	// Adicionado em 01-08-2016
	public void adicionaFacebookPost(FacebookPost itemLista) {
		itemLista.setIdFacebookFanpageFe(itemDetalhe.getIdFacebookFanpage());
		//ArquivoLog.getInstancia().salvaLog("FacebookFanpage(adicionaCorrenteFacebookPost):" + FacebookPostDadosParseBase.displayLog(correnteFacebookPost));
		listaFacebookPost.add(itemLista);
	}
	
	
	
	@Deprecated
	public FacebookPost getCorrenteFacebookPost() {
		return correnteFacebookPost;
	}
	@Deprecated
	public void adicionaCorrenteFacebookPost() {
		correnteFacebookPost.setIdFacebookFanpageFe(itemDetalhe.getIdFacebookFanpage());
		ArquivoLog.getInstancia().salvaLog("FacebookFanpage(adicionaCorrenteFacebookPost):" + FacebookPostDadosParseBase.displayLog(correnteFacebookPost));
		
		listaFacebookPost.add(correnteFacebookPost);
	}
	@Deprecated
	public void criaCorrenteFacebookPost() {
		correnteFacebookPost = FabricaVo.criaFacebookPost();
	}
 		
	
	public FacebookFanpageDadosParseBase() {
		super();
		lista = new ArrayList<FacebookFanpage>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public FacebookFanpage getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(FacebookFanpage item) {
		ArquivoLog.getInstancia().salvaLog("FacebookFanpage(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(FacebookFanpage item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("FacebookFanpage(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaFacebookFanpage();
	}


	public void setItemDetalhe(FacebookFanpage item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em FacebookFanpageDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em FacebookFanpageDadosParse";
 	}

	
	private FacebookPerfil _facebookPerfil_PertenceA; 
	
	@Deprecated
	public void setFacebookPerfil_PertenceA(FacebookPerfil item) {
		_facebookPerfil_PertenceA = item;
	}
	@Deprecated
	public FacebookPerfil getFacebookPerfil_PertenceA() {
		return _facebookPerfil_PertenceA;
	}
 	
	private AppProduto _appProduto_Divulga; 
	
	@Deprecated
	public void setAppProduto_Divulga(AppProduto item) {
		_appProduto_Divulga = item;
	}
	@Deprecated
	public AppProduto getAppProduto_Divulga() {
		return _appProduto_Divulga;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getFacebookFanpageDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getFacebookFanpageDao();
			dao.setConexao(getConexao());
			List<FacebookFanpage> listaBanco = dao.ListaCorrente();
			List<FacebookFanpage> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<FacebookFanpage> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<FacebookFanpage> it = listaInclusao.iterator();
			while (it.hasNext()) {
				FacebookFanpage item = it.next();
				System.out.println("FacebookFanpage Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<FacebookFanpage> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				FacebookFanpage item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(FacebookFanpage item, FacebookFanpageDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(FacebookFanpage item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(FacebookFanpage item) {
		try {
			dao = DBB.getInstancia().getFacebookFanpageDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<FacebookFanpage> subtraiListaPorNome(List<FacebookFanpage> listaMaior, List<FacebookFanpage> listaMenor) {
		Iterator<FacebookFanpage> itMaior = listaMaior.iterator();
		Iterator<FacebookFanpage> itMenor = null;
		List<FacebookFanpage> listaDiferenca = new ArrayList<FacebookFanpage>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			FacebookFanpage corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				FacebookFanpage comparador = itMenor.next();
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
	protected boolean iguais(FacebookFanpage item1, FacebookFanpage item2) {
		throw new RuntimeException("Fazer override em FacebookFanpageDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(FacebookFanpage item) {
		return "Fazer override em FacebookFanpageDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaFacebookPost.clear();
	
	}
	
	
	public void displayLogLista(List<FacebookFanpage> lista, String codigo) {
		for (FacebookFanpage item : lista) {
			ArquivoLog.getInstancia().salvaLog("FacebookFanpage(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(FacebookFanpage item) {
		StringBuffer display = new StringBuffer();
		display.append("FacebookFanpage {");
		
		display.append("IdFacebookFanpage:" + item.getIdFacebookFanpage() + ";");
		
		display.append("Nome:" + item.getNome() + ";");
		
		display.append("CodigoFacebook:" + item.getCodigoFacebook() + ";");
		
		display.append("NomeUrl:" + item.getNomeUrl() + ";");
		
		display.append("QuantidadeDia:" + item.getQuantidadeDia() + ";");
		
		display.append("IdFacebookPerfilPa:" + item.getIdFacebookPerfilPa() + ";");
		
		display.append("IdAppProdutoD:" + item.getIdAppProdutoD() + ";");
		
		
		
		if (item.getFacebookPerfilPertenceA(false)!=null) {
			display.append("FacebookPerfil{");
			display.append(FacebookPerfilDadosParse.displayLog(item.getFacebookPerfilPertenceA(false)));
			display.append("}");
		}
 		
		if (item.getAppProdutoDivulga(false)!=null) {
			display.append("AppProduto{");
			display.append(AppProdutoDadosParse.displayLog(item.getAppProdutoDivulga(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}