package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.NaturezaProdutoDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class NaturezaProdutoDadosParseBase extends DadosParseDao {

	protected NaturezaProdutoDao dao = null;
	protected NaturezaProduto itemDetalhe = null;
	protected List<NaturezaProduto> lista = null;
	
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
	// do Objeto NaturezaProduto
	// Para listas usar itemCorrente.
	public NaturezaProduto getItemDetalhe() {
		return itemDetalhe;
	}
	
	private NaturezaProduto itemCorrente = null;
	
	//Possui 
	private	CategoriaLoja correnteCategoriaLoja;
	protected List<CategoriaLoja> listaCategoriaLoja = new ArrayList<CategoriaLoja>();
	
	// Adicionado em 01-08-2016
	public void adicionaCategoriaLoja(CategoriaLoja itemLista) {
		itemLista.setIdNaturezaProdutoRa(itemDetalhe.getIdNaturezaProduto());
		//ArquivoLog.getInstancia().salvaLog("NaturezaProduto(adicionaCorrenteCategoriaLoja):" + CategoriaLojaDadosParseBase.displayLog(correnteCategoriaLoja));
		listaCategoriaLoja.add(itemLista);
	}
	
	
	
	@Deprecated
	public CategoriaLoja getCorrenteCategoriaLoja() {
		return correnteCategoriaLoja;
	}
	@Deprecated
	public void adicionaCorrenteCategoriaLoja() {
		correnteCategoriaLoja.setIdNaturezaProdutoRa(itemDetalhe.getIdNaturezaProduto());
		ArquivoLog.getInstancia().salvaLog("NaturezaProduto(adicionaCorrenteCategoriaLoja):" + CategoriaLojaDadosParseBase.displayLog(correnteCategoriaLoja));
		
		listaCategoriaLoja.add(correnteCategoriaLoja);
	}
	@Deprecated
	public void criaCorrenteCategoriaLoja() {
		correnteCategoriaLoja = FabricaVo.criaCategoriaLoja();
	}
 		
	//Encontrada 
	private	LojaNatureza correnteLojaNatureza;
	protected List<LojaNatureza> listaLojaNatureza = new ArrayList<LojaNatureza>();
	
	// Adicionado em 01-08-2016
	public void adicionaLojaNatureza(LojaNatureza itemLista) {
		itemLista.setIdNaturezaProdutoRa(itemDetalhe.getIdNaturezaProduto());
		//ArquivoLog.getInstancia().salvaLog("NaturezaProduto(adicionaCorrenteLojaNatureza):" + LojaNaturezaDadosParseBase.displayLog(correnteLojaNatureza));
		listaLojaNatureza.add(itemLista);
	}
	
	
	
	@Deprecated
	public LojaNatureza getCorrenteLojaNatureza() {
		return correnteLojaNatureza;
	}
	@Deprecated
	public void adicionaCorrenteLojaNatureza() {
		correnteLojaNatureza.setIdNaturezaProdutoRa(itemDetalhe.getIdNaturezaProduto());
		ArquivoLog.getInstancia().salvaLog("NaturezaProduto(adicionaCorrenteLojaNatureza):" + LojaNaturezaDadosParseBase.displayLog(correnteLojaNatureza));
		
		listaLojaNatureza.add(correnteLojaNatureza);
	}
	@Deprecated
	public void criaCorrenteLojaNatureza() {
		correnteLojaNatureza = FabricaVo.criaLojaNatureza();
	}
 		
	//Possui 
	private	OportunidadeDia correnteOportunidadeDia;
	protected List<OportunidadeDia> listaOportunidadeDia = new ArrayList<OportunidadeDia>();
	
	// Adicionado em 01-08-2016
	public void adicionaOportunidadeDia(OportunidadeDia itemLista) {
		itemLista.setIdNaturezaProdutoPa(itemDetalhe.getIdNaturezaProduto());
		//ArquivoLog.getInstancia().salvaLog("NaturezaProduto(adicionaCorrenteOportunidadeDia):" + OportunidadeDiaDadosParseBase.displayLog(correnteOportunidadeDia));
		listaOportunidadeDia.add(itemLista);
	}
	
	
	
	@Deprecated
	public OportunidadeDia getCorrenteOportunidadeDia() {
		return correnteOportunidadeDia;
	}
	@Deprecated
	public void adicionaCorrenteOportunidadeDia() {
		correnteOportunidadeDia.setIdNaturezaProdutoPa(itemDetalhe.getIdNaturezaProduto());
		ArquivoLog.getInstancia().salvaLog("NaturezaProduto(adicionaCorrenteOportunidadeDia):" + OportunidadeDiaDadosParseBase.displayLog(correnteOportunidadeDia));
		
		listaOportunidadeDia.add(correnteOportunidadeDia);
	}
	@Deprecated
	public void criaCorrenteOportunidadeDia() {
		correnteOportunidadeDia = FabricaVo.criaOportunidadeDia();
	}
 		
	//PesquisadoPor 
	private	UsuarioPesquisa correnteUsuarioPesquisa;
	protected List<UsuarioPesquisa> listaUsuarioPesquisa = new ArrayList<UsuarioPesquisa>();
	
	// Adicionado em 01-08-2016
	public void adicionaUsuarioPesquisa(UsuarioPesquisa itemLista) {
		itemLista.setIdNaturezaProdutoP(itemDetalhe.getIdNaturezaProduto());
		//ArquivoLog.getInstancia().salvaLog("NaturezaProduto(adicionaCorrenteUsuarioPesquisa):" + UsuarioPesquisaDadosParseBase.displayLog(correnteUsuarioPesquisa));
		listaUsuarioPesquisa.add(itemLista);
	}
	
	
	
	@Deprecated
	public UsuarioPesquisa getCorrenteUsuarioPesquisa() {
		return correnteUsuarioPesquisa;
	}
	@Deprecated
	public void adicionaCorrenteUsuarioPesquisa() {
		correnteUsuarioPesquisa.setIdNaturezaProdutoP(itemDetalhe.getIdNaturezaProduto());
		ArquivoLog.getInstancia().salvaLog("NaturezaProduto(adicionaCorrenteUsuarioPesquisa):" + UsuarioPesquisaDadosParseBase.displayLog(correnteUsuarioPesquisa));
		
		listaUsuarioPesquisa.add(correnteUsuarioPesquisa);
	}
	@Deprecated
	public void criaCorrenteUsuarioPesquisa() {
		correnteUsuarioPesquisa = FabricaVo.criaUsuarioPesquisa();
	}
 		
	//Possui 
	private	ContagemProduto correnteContagemProduto;
	protected List<ContagemProduto> listaContagemProduto = new ArrayList<ContagemProduto>();
	
	// Adicionado em 01-08-2016
	public void adicionaContagemProduto(ContagemProduto itemLista) {
		itemLista.setIdNaturezaProdutoRa(itemDetalhe.getIdNaturezaProduto());
		//ArquivoLog.getInstancia().salvaLog("NaturezaProduto(adicionaCorrenteContagemProduto):" + ContagemProdutoDadosParseBase.displayLog(correnteContagemProduto));
		listaContagemProduto.add(itemLista);
	}
	
	
	
	@Deprecated
	public ContagemProduto getCorrenteContagemProduto() {
		return correnteContagemProduto;
	}
	@Deprecated
	public void adicionaCorrenteContagemProduto() {
		correnteContagemProduto.setIdNaturezaProdutoRa(itemDetalhe.getIdNaturezaProduto());
		ArquivoLog.getInstancia().salvaLog("NaturezaProduto(adicionaCorrenteContagemProduto):" + ContagemProdutoDadosParseBase.displayLog(correnteContagemProduto));
		
		listaContagemProduto.add(correnteContagemProduto);
	}
	@Deprecated
	public void criaCorrenteContagemProduto() {
		correnteContagemProduto = FabricaVo.criaContagemProduto();
	}
 		
	//PodePesquisar 
	private	PalavraChavePesquisa correntePalavraChavePesquisa;
	protected List<PalavraChavePesquisa> listaPalavraChavePesquisa = new ArrayList<PalavraChavePesquisa>();
	
	// Adicionado em 01-08-2016
	public void adicionaPalavraChavePesquisa(PalavraChavePesquisa itemLista) {
		itemLista.setIdNaturezaProdutoRa(itemDetalhe.getIdNaturezaProduto());
		//ArquivoLog.getInstancia().salvaLog("NaturezaProduto(adicionaCorrentePalavraChavePesquisa):" + PalavraChavePesquisaDadosParseBase.displayLog(correntePalavraChavePesquisa));
		listaPalavraChavePesquisa.add(itemLista);
	}
	
	
	
	@Deprecated
	public PalavraChavePesquisa getCorrentePalavraChavePesquisa() {
		return correntePalavraChavePesquisa;
	}
	@Deprecated
	public void adicionaCorrentePalavraChavePesquisa() {
		correntePalavraChavePesquisa.setIdNaturezaProdutoRa(itemDetalhe.getIdNaturezaProduto());
		ArquivoLog.getInstancia().salvaLog("NaturezaProduto(adicionaCorrentePalavraChavePesquisa):" + PalavraChavePesquisaDadosParseBase.displayLog(correntePalavraChavePesquisa));
		
		listaPalavraChavePesquisa.add(correntePalavraChavePesquisa);
	}
	@Deprecated
	public void criaCorrentePalavraChavePesquisa() {
		correntePalavraChavePesquisa = FabricaVo.criaPalavraChavePesquisa();
	}
 		
	//Possui 
	private	ProdutoCliente correnteProdutoCliente;
	protected List<ProdutoCliente> listaProdutoCliente = new ArrayList<ProdutoCliente>();
	
	// Adicionado em 01-08-2016
	public void adicionaProdutoCliente(ProdutoCliente itemLista) {
		itemLista.setIdNaturezaProdutoRa(itemDetalhe.getIdNaturezaProduto());
		//ArquivoLog.getInstancia().salvaLog("NaturezaProduto(adicionaCorrenteProdutoCliente):" + ProdutoClienteDadosParseBase.displayLog(correnteProdutoCliente));
		listaProdutoCliente.add(itemLista);
	}
	
	
	
	@Deprecated
	public ProdutoCliente getCorrenteProdutoCliente() {
		return correnteProdutoCliente;
	}
	@Deprecated
	public void adicionaCorrenteProdutoCliente() {
		correnteProdutoCliente.setIdNaturezaProdutoRa(itemDetalhe.getIdNaturezaProduto());
		ArquivoLog.getInstancia().salvaLog("NaturezaProduto(adicionaCorrenteProdutoCliente):" + ProdutoClienteDadosParseBase.displayLog(correnteProdutoCliente));
		
		listaProdutoCliente.add(correnteProdutoCliente);
	}
	@Deprecated
	public void criaCorrenteProdutoCliente() {
		correnteProdutoCliente = FabricaVo.criaProdutoCliente();
	}
 		
	
	public NaturezaProdutoDadosParseBase() {
		super();
		lista = new ArrayList<NaturezaProduto>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public NaturezaProduto getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(NaturezaProduto item) {
		ArquivoLog.getInstancia().salvaLog("NaturezaProduto(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(NaturezaProduto item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("NaturezaProduto(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaNaturezaProduto();
	}


	public void setItemDetalhe(NaturezaProduto item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em NaturezaProdutoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em NaturezaProdutoDadosParse";
 	}

	
	private AppProduto _appProduto_AtendidoPor; 
	
	@Deprecated
	public void setAppProduto_AtendidoPor(AppProduto item) {
		_appProduto_AtendidoPor = item;
	}
	@Deprecated
	public AppProduto getAppProduto_AtendidoPor() {
		return _appProduto_AtendidoPor;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getNaturezaProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getNaturezaProdutoDao();
			dao.setConexao(getConexao());
			List<NaturezaProduto> listaBanco = dao.ListaCorrente();
			List<NaturezaProduto> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<NaturezaProduto> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<NaturezaProduto> it = listaInclusao.iterator();
			while (it.hasNext()) {
				NaturezaProduto item = it.next();
				System.out.println("NaturezaProduto Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<NaturezaProduto> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				NaturezaProduto item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(NaturezaProduto item, NaturezaProdutoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(NaturezaProduto item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(NaturezaProduto item) {
		try {
			dao = DBB.getInstancia().getNaturezaProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<NaturezaProduto> subtraiListaPorNome(List<NaturezaProduto> listaMaior, List<NaturezaProduto> listaMenor) {
		Iterator<NaturezaProduto> itMaior = listaMaior.iterator();
		Iterator<NaturezaProduto> itMenor = null;
		List<NaturezaProduto> listaDiferenca = new ArrayList<NaturezaProduto>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			NaturezaProduto corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				NaturezaProduto comparador = itMenor.next();
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
	protected boolean iguais(NaturezaProduto item1, NaturezaProduto item2) {
		throw new RuntimeException("Fazer override em NaturezaProdutoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(NaturezaProduto item) {
		return "Fazer override em NaturezaProdutoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaCategoriaLoja.clear();
		listaLojaNatureza.clear();
		listaOportunidadeDia.clear();
		listaUsuarioPesquisa.clear();
		listaContagemProduto.clear();
		listaPalavraChavePesquisa.clear();
		listaProdutoCliente.clear();
	
	}
	
	
	public void displayLogLista(List<NaturezaProduto> lista, String codigo) {
		for (NaturezaProduto item : lista) {
			ArquivoLog.getInstancia().salvaLog("NaturezaProduto(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(NaturezaProduto item) {
		StringBuffer display = new StringBuffer();
		display.append("NaturezaProduto {");
		
		display.append("IdNaturezaProduto:" + item.getIdNaturezaProduto() + ";");
		
		display.append("NomeNaturezaProduto:" + item.getNomeNaturezaProduto() + ";");
		
		display.append("CodigoNaturezaProduto:" + item.getCodigoNaturezaProduto() + ";");
		
		display.append("IdAppProdutoAp:" + item.getIdAppProdutoAp() + ";");
		
		
		
		if (item.getAppProdutoAtendidoPor(false)!=null) {
			display.append("AppProduto{");
			display.append(AppProdutoDadosParse.displayLog(item.getAppProdutoAtendidoPor(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}