package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.AppProdutoDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class AppProdutoDadosParseBase extends DadosParseDao {

	protected AppProdutoDao dao = null;
	protected AppProduto itemDetalhe = null;
	protected List<AppProduto> lista = null;
	
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
	// do Objeto AppProduto
	// Para listas usar itemCorrente.
	public AppProduto getItemDetalhe() {
		return itemDetalhe;
	}
	
	private AppProduto itemCorrente = null;
	
	//DivulgadoPor 
	private	FacebookFanpage correnteFacebookFanpage;
	protected List<FacebookFanpage> listaFacebookFanpage = new ArrayList<FacebookFanpage>();
	
	// Adicionado em 01-08-2016
	public void adicionaFacebookFanpage(FacebookFanpage itemLista) {
		itemLista.setIdAppProdutoD(itemDetalhe.getIdAppProduto());
		//ArquivoLog.getInstancia().salvaLog("AppProduto(adicionaCorrenteFacebookFanpage):" + FacebookFanpageDadosParseBase.displayLog(correnteFacebookFanpage));
		listaFacebookFanpage.add(itemLista);
	}
	
	
	
	@Deprecated
	public FacebookFanpage getCorrenteFacebookFanpage() {
		return correnteFacebookFanpage;
	}
	@Deprecated
	public void adicionaCorrenteFacebookFanpage() {
		correnteFacebookFanpage.setIdAppProdutoD(itemDetalhe.getIdAppProduto());
		ArquivoLog.getInstancia().salvaLog("AppProduto(adicionaCorrenteFacebookFanpage):" + FacebookFanpageDadosParseBase.displayLog(correnteFacebookFanpage));
		
		listaFacebookFanpage.add(correnteFacebookFanpage);
	}
	@Deprecated
	public void criaCorrenteFacebookFanpage() {
		correnteFacebookFanpage = FabricaVo.criaFacebookFanpage();
	}
 		
	//Atende 
	private	NaturezaProduto correnteNaturezaProduto;
	protected List<NaturezaProduto> listaNaturezaProduto = new ArrayList<NaturezaProduto>();
	
	// Adicionado em 01-08-2016
	public void adicionaNaturezaProduto(NaturezaProduto itemLista) {
		itemLista.setIdAppProdutoAp(itemDetalhe.getIdAppProduto());
		//ArquivoLog.getInstancia().salvaLog("AppProduto(adicionaCorrenteNaturezaProduto):" + NaturezaProdutoDadosParseBase.displayLog(correnteNaturezaProduto));
		listaNaturezaProduto.add(itemLista);
	}
	
	
	
	@Deprecated
	public NaturezaProduto getCorrenteNaturezaProduto() {
		return correnteNaturezaProduto;
	}
	@Deprecated
	public void adicionaCorrenteNaturezaProduto() {
		correnteNaturezaProduto.setIdAppProdutoAp(itemDetalhe.getIdAppProduto());
		ArquivoLog.getInstancia().salvaLog("AppProduto(adicionaCorrenteNaturezaProduto):" + NaturezaProdutoDadosParseBase.displayLog(correnteNaturezaProduto));
		
		listaNaturezaProduto.add(correnteNaturezaProduto);
	}
	@Deprecated
	public void criaCorrenteNaturezaProduto() {
		correnteNaturezaProduto = FabricaVo.criaNaturezaProduto();
	}
 		
	//UsadoPor 
	private	DispositivoUsuario correnteDispositivoUsuario;
	protected List<DispositivoUsuario> listaDispositivoUsuario = new ArrayList<DispositivoUsuario>();
	
	// Adicionado em 01-08-2016
	public void adicionaDispositivoUsuario(DispositivoUsuario itemLista) {
		itemLista.setIdAppProdutoU(itemDetalhe.getIdAppProduto());
		//ArquivoLog.getInstancia().salvaLog("AppProduto(adicionaCorrenteDispositivoUsuario):" + DispositivoUsuarioDadosParseBase.displayLog(correnteDispositivoUsuario));
		listaDispositivoUsuario.add(itemLista);
	}
	
	
	
	@Deprecated
	public DispositivoUsuario getCorrenteDispositivoUsuario() {
		return correnteDispositivoUsuario;
	}
	@Deprecated
	public void adicionaCorrenteDispositivoUsuario() {
		correnteDispositivoUsuario.setIdAppProdutoU(itemDetalhe.getIdAppProduto());
		ArquivoLog.getInstancia().salvaLog("AppProduto(adicionaCorrenteDispositivoUsuario):" + DispositivoUsuarioDadosParseBase.displayLog(correnteDispositivoUsuario));
		
		listaDispositivoUsuario.add(correnteDispositivoUsuario);
	}
	@Deprecated
	public void criaCorrenteDispositivoUsuario() {
		correnteDispositivoUsuario = FabricaVo.criaDispositivoUsuario();
	}
 		
	
	public AppProdutoDadosParseBase() {
		super();
		lista = new ArrayList<AppProduto>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public AppProduto getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(AppProduto item) {
		ArquivoLog.getInstancia().salvaLog("AppProduto(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(AppProduto item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("AppProduto(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaAppProduto();
	}


	public void setItemDetalhe(AppProduto item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em AppProdutoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em AppProdutoDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getAppProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getAppProdutoDao();
			dao.setConexao(getConexao());
			List<AppProduto> listaBanco = dao.ListaCorrente();
			List<AppProduto> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<AppProduto> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<AppProduto> it = listaInclusao.iterator();
			while (it.hasNext()) {
				AppProduto item = it.next();
				System.out.println("AppProduto Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<AppProduto> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				AppProduto item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(AppProduto item, AppProdutoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(AppProduto item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(AppProduto item) {
		try {
			dao = DBB.getInstancia().getAppProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<AppProduto> subtraiListaPorNome(List<AppProduto> listaMaior, List<AppProduto> listaMenor) {
		Iterator<AppProduto> itMaior = listaMaior.iterator();
		Iterator<AppProduto> itMenor = null;
		List<AppProduto> listaDiferenca = new ArrayList<AppProduto>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			AppProduto corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				AppProduto comparador = itMenor.next();
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
	protected boolean iguais(AppProduto item1, AppProduto item2) {
		throw new RuntimeException("Fazer override em AppProdutoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(AppProduto item) {
		return "Fazer override em AppProdutoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaFacebookFanpage.clear();
		listaNaturezaProduto.clear();
		listaDispositivoUsuario.clear();
	
	}
	
	
	public void displayLogLista(List<AppProduto> lista, String codigo) {
		for (AppProduto item : lista) {
			ArquivoLog.getInstancia().salvaLog("AppProduto(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(AppProduto item) {
		StringBuffer display = new StringBuffer();
		display.append("AppProduto {");
		
		display.append("IdAppProduto:" + item.getIdAppProduto() + ";");
		
		display.append("Nome:" + item.getNome() + ";");
		
		display.append("UrlInstalacao:" + item.getUrlInstalacao() + ";");
		
		display.append("PossuiVitrine:" + item.getPossuiVitrine() + ";");
		
		display.append("Ativo:" + item.getAtivo() + ";");
		
		display.append("Status:" + item.getStatus() + ";");
		
		display.append("LimitePosicionador:" + item.getLimitePosicionador() + ";");
		
		display.append("PossuiPalavraChave:" + item.getPossuiPalavraChave() + ";");
		
		display.append("CodigoHash:" + item.getCodigoHash() + ";");
		
		display.append("ApiKey:" + item.getApiKey() + ";");
		
		display.append("DiasPrecoVitrine:" + item.getDiasPrecoVitrine() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}