package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.ProdutoClienteDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class ProdutoClienteDadosParseBase extends DadosParseDao {

	protected ProdutoClienteDao dao = null;
	protected ProdutoCliente itemDetalhe = null;
	protected List<ProdutoCliente> lista = null;
	
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
	// do Objeto ProdutoCliente
	// Para listas usar itemCorrente.
	public ProdutoCliente getItemDetalhe() {
		return itemDetalhe;
	}
	
	private ProdutoCliente itemCorrente = null;
	
	//Possui 
	private	InteresseProduto correnteInteresseProduto;
	protected List<InteresseProduto> listaInteresseProduto = new ArrayList<InteresseProduto>();
	
	// Adicionado em 01-08-2016
	public void adicionaInteresseProduto(InteresseProduto itemLista) {
		itemLista.setIdProdutoClienteRa(itemDetalhe.getIdProdutoCliente());
		//ArquivoLog.getInstancia().salvaLog("ProdutoCliente(adicionaCorrenteInteresseProduto):" + InteresseProdutoDadosParseBase.displayLog(correnteInteresseProduto));
		listaInteresseProduto.add(itemLista);
	}
	
	
	
	@Deprecated
	public InteresseProduto getCorrenteInteresseProduto() {
		return correnteInteresseProduto;
	}
	@Deprecated
	public void adicionaCorrenteInteresseProduto() {
		correnteInteresseProduto.setIdProdutoClienteRa(itemDetalhe.getIdProdutoCliente());
		ArquivoLog.getInstancia().salvaLog("ProdutoCliente(adicionaCorrenteInteresseProduto):" + InteresseProdutoDadosParseBase.displayLog(correnteInteresseProduto));
		
		listaInteresseProduto.add(correnteInteresseProduto);
	}
	@Deprecated
	public void criaCorrenteInteresseProduto() {
		correnteInteresseProduto = FabricaVo.criaInteresseProduto();
	}
 		
	//Possui 
	private	PrecoDiarioCliente correntePrecoDiarioCliente;
	protected List<PrecoDiarioCliente> listaPrecoDiarioCliente = new ArrayList<PrecoDiarioCliente>();
	
	// Adicionado em 01-08-2016
	public void adicionaPrecoDiarioCliente(PrecoDiarioCliente itemLista) {
		itemLista.setIdProdutoClientePa(itemDetalhe.getIdProdutoCliente());
		//ArquivoLog.getInstancia().salvaLog("ProdutoCliente(adicionaCorrentePrecoDiarioCliente):" + PrecoDiarioClienteDadosParseBase.displayLog(correntePrecoDiarioCliente));
		listaPrecoDiarioCliente.add(itemLista);
	}
	
	
	
	@Deprecated
	public PrecoDiarioCliente getCorrentePrecoDiarioCliente() {
		return correntePrecoDiarioCliente;
	}
	@Deprecated
	public void adicionaCorrentePrecoDiarioCliente() {
		correntePrecoDiarioCliente.setIdProdutoClientePa(itemDetalhe.getIdProdutoCliente());
		ArquivoLog.getInstancia().salvaLog("ProdutoCliente(adicionaCorrentePrecoDiarioCliente):" + PrecoDiarioClienteDadosParseBase.displayLog(correntePrecoDiarioCliente));
		
		listaPrecoDiarioCliente.add(correntePrecoDiarioCliente);
	}
	@Deprecated
	public void criaCorrentePrecoDiarioCliente() {
		correntePrecoDiarioCliente = FabricaVo.criaPrecoDiarioCliente();
	}
 		
	//Possui 
	private	OportunidadeInteresseCliente correnteOportunidadeInteresseCliente;
	protected List<OportunidadeInteresseCliente> listaOportunidadeInteresseCliente = new ArrayList<OportunidadeInteresseCliente>();
	
	// Adicionado em 01-08-2016
	public void adicionaOportunidadeInteresseCliente(OportunidadeInteresseCliente itemLista) {
		itemLista.setIdProdutoClientePa(itemDetalhe.getIdProdutoCliente());
		//ArquivoLog.getInstancia().salvaLog("ProdutoCliente(adicionaCorrenteOportunidadeInteresseCliente):" + OportunidadeInteresseClienteDadosParseBase.displayLog(correnteOportunidadeInteresseCliente));
		listaOportunidadeInteresseCliente.add(itemLista);
	}
	
	
	
	@Deprecated
	public OportunidadeInteresseCliente getCorrenteOportunidadeInteresseCliente() {
		return correnteOportunidadeInteresseCliente;
	}
	@Deprecated
	public void adicionaCorrenteOportunidadeInteresseCliente() {
		correnteOportunidadeInteresseCliente.setIdProdutoClientePa(itemDetalhe.getIdProdutoCliente());
		ArquivoLog.getInstancia().salvaLog("ProdutoCliente(adicionaCorrenteOportunidadeInteresseCliente):" + OportunidadeInteresseClienteDadosParseBase.displayLog(correnteOportunidadeInteresseCliente));
		
		listaOportunidadeInteresseCliente.add(correnteOportunidadeInteresseCliente);
	}
	@Deprecated
	public void criaCorrenteOportunidadeInteresseCliente() {
		correnteOportunidadeInteresseCliente = FabricaVo.criaOportunidadeInteresseCliente();
	}
 		
	
	public ProdutoClienteDadosParseBase() {
		super();
		lista = new ArrayList<ProdutoCliente>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public ProdutoCliente getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(ProdutoCliente item) {
		ArquivoLog.getInstancia().salvaLog("ProdutoCliente(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(ProdutoCliente item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("ProdutoCliente(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaProdutoCliente();
	}


	public void setItemDetalhe(ProdutoCliente item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em ProdutoClienteDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em ProdutoClienteDadosParse";
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
 	
	private PalavraChavePesquisa _palavraChavePesquisa_ReferenteA; 
	
	@Deprecated
	public void setPalavraChavePesquisa_ReferenteA(PalavraChavePesquisa item) {
		_palavraChavePesquisa_ReferenteA = item;
	}
	@Deprecated
	public PalavraChavePesquisa getPalavraChavePesquisa_ReferenteA() {
		return _palavraChavePesquisa_ReferenteA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getProdutoClienteDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getProdutoClienteDao();
			dao.setConexao(getConexao());
			List<ProdutoCliente> listaBanco = dao.ListaCorrente();
			List<ProdutoCliente> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<ProdutoCliente> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<ProdutoCliente> it = listaInclusao.iterator();
			while (it.hasNext()) {
				ProdutoCliente item = it.next();
				System.out.println("ProdutoCliente Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<ProdutoCliente> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				ProdutoCliente item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(ProdutoCliente item, ProdutoClienteDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(ProdutoCliente item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(ProdutoCliente item) {
		try {
			dao = DBB.getInstancia().getProdutoClienteDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<ProdutoCliente> subtraiListaPorNome(List<ProdutoCliente> listaMaior, List<ProdutoCliente> listaMenor) {
		Iterator<ProdutoCliente> itMaior = listaMaior.iterator();
		Iterator<ProdutoCliente> itMenor = null;
		List<ProdutoCliente> listaDiferenca = new ArrayList<ProdutoCliente>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			ProdutoCliente corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				ProdutoCliente comparador = itMenor.next();
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
	protected boolean iguais(ProdutoCliente item1, ProdutoCliente item2) {
		throw new RuntimeException("Fazer override em ProdutoClienteDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(ProdutoCliente item) {
		return "Fazer override em ProdutoClienteDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaInteresseProduto.clear();
		listaPrecoDiarioCliente.clear();
		listaOportunidadeInteresseCliente.clear();
	
	}
	
	
	public void displayLogLista(List<ProdutoCliente> lista, String codigo) {
		for (ProdutoCliente item : lista) {
			ArquivoLog.getInstancia().salvaLog("ProdutoCliente(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(ProdutoCliente item) {
		StringBuffer display = new StringBuffer();
		display.append("ProdutoCliente {");
		
		display.append("IdProdutoCliente:" + item.getIdProdutoCliente() + ";");
		
		display.append("Nome:" + item.getNome() + ";");
		
		display.append("PosicaoProduto:" + item.getPosicaoProduto() + ";");
		
		display.append("Imagem:" + item.getImagem() + ";");
		
		display.append("PrecoAtual:" + item.getPrecoAtual() + ";");
		
		display.append("Marca:" + item.getMarca() + ";");
		
		display.append("Loja:" + item.getLoja() + ";");
		
		display.append("Data:" + item.getData() + ";");
		
		display.append("Url:" + item.getUrl() + ";");
		
		display.append("Detalhe:" + item.getDetalhe() + ";");
		
		display.append("IdNaturezaProdutoRa:" + item.getIdNaturezaProdutoRa() + ";");
		
		display.append("IdUsuarioS:" + item.getIdUsuarioS() + ";");
		
		display.append("IdPalavraChavePesquisaRa:" + item.getIdPalavraChavePesquisaRa() + ";");
		
		
		
		if (item.getNaturezaProdutoReferenteA(false)!=null) {
			display.append("NaturezaProduto{");
			display.append(NaturezaProdutoDadosParse.displayLog(item.getNaturezaProdutoReferenteA(false)));
			display.append("}");
		}
 		
		if (item.getPalavraChavePesquisaReferenteA(false)!=null) {
			display.append("PalavraChavePesquisa{");
			display.append(PalavraChavePesquisaDadosParse.displayLog(item.getPalavraChavePesquisaReferenteA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}