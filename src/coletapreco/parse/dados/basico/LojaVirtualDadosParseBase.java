package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.LojaVirtualDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class LojaVirtualDadosParseBase extends DadosParseDao {

	protected LojaVirtualDao dao = null;
	protected LojaVirtual itemDetalhe = null;
	protected List<LojaVirtual> lista = null;
	
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
	// do Objeto LojaVirtual
	// Para listas usar itemCorrente.
	public LojaVirtual getItemDetalhe() {
		return itemDetalhe;
	}
	
	private LojaVirtual itemCorrente = null;
	
	//Possui 
	private	Produto correnteProduto;
	protected List<Produto> listaProduto = new ArrayList<Produto>();
	
	// Adicionado em 01-08-2016
	public void adicionaProduto(Produto itemLista) {
		itemLista.setIdLojaVirtualLe(itemDetalhe.getIdLojaVirtual());
		//ArquivoLog.getInstancia().salvaLog("LojaVirtual(adicionaCorrenteProduto):" + ProdutoDadosParseBase.displayLog(correnteProduto));
		listaProduto.add(itemLista);
	}
	
	
	
	@Deprecated
	public Produto getCorrenteProduto() {
		return correnteProduto;
	}
	@Deprecated
	public void adicionaCorrenteProduto() {
		correnteProduto.setIdLojaVirtualLe(itemDetalhe.getIdLojaVirtual());
		ArquivoLog.getInstancia().salvaLog("LojaVirtual(adicionaCorrenteProduto):" + ProdutoDadosParseBase.displayLog(correnteProduto));
		
		listaProduto.add(correnteProduto);
	}
	@Deprecated
	public void criaCorrenteProduto() {
		correnteProduto = FabricaVo.criaProduto();
	}
 		
	//Possui 
	private	CategoriaLoja correnteCategoriaLoja;
	protected List<CategoriaLoja> listaCategoriaLoja = new ArrayList<CategoriaLoja>();
	
	// Adicionado em 01-08-2016
	public void adicionaCategoriaLoja(CategoriaLoja itemLista) {
		itemLista.setIdLojaVirtualPa(itemDetalhe.getIdLojaVirtual());
		//ArquivoLog.getInstancia().salvaLog("LojaVirtual(adicionaCorrenteCategoriaLoja):" + CategoriaLojaDadosParseBase.displayLog(correnteCategoriaLoja));
		listaCategoriaLoja.add(itemLista);
	}
	
	
	
	@Deprecated
	public CategoriaLoja getCorrenteCategoriaLoja() {
		return correnteCategoriaLoja;
	}
	@Deprecated
	public void adicionaCorrenteCategoriaLoja() {
		correnteCategoriaLoja.setIdLojaVirtualPa(itemDetalhe.getIdLojaVirtual());
		ArquivoLog.getInstancia().salvaLog("LojaVirtual(adicionaCorrenteCategoriaLoja):" + CategoriaLojaDadosParseBase.displayLog(correnteCategoriaLoja));
		
		listaCategoriaLoja.add(correnteCategoriaLoja);
	}
	@Deprecated
	public void criaCorrenteCategoriaLoja() {
		correnteCategoriaLoja = FabricaVo.criaCategoriaLoja();
	}
 		
	//Oferece 
	private	LojaNatureza correnteLojaNatureza;
	protected List<LojaNatureza> listaLojaNatureza = new ArrayList<LojaNatureza>();
	
	// Adicionado em 01-08-2016
	public void adicionaLojaNatureza(LojaNatureza itemLista) {
		itemLista.setIdLojaVirtualRa(itemDetalhe.getIdLojaVirtual());
		//ArquivoLog.getInstancia().salvaLog("LojaVirtual(adicionaCorrenteLojaNatureza):" + LojaNaturezaDadosParseBase.displayLog(correnteLojaNatureza));
		listaLojaNatureza.add(itemLista);
	}
	
	
	
	@Deprecated
	public LojaNatureza getCorrenteLojaNatureza() {
		return correnteLojaNatureza;
	}
	@Deprecated
	public void adicionaCorrenteLojaNatureza() {
		correnteLojaNatureza.setIdLojaVirtualRa(itemDetalhe.getIdLojaVirtual());
		ArquivoLog.getInstancia().salvaLog("LojaVirtual(adicionaCorrenteLojaNatureza):" + LojaNaturezaDadosParseBase.displayLog(correnteLojaNatureza));
		
		listaLojaNatureza.add(correnteLojaNatureza);
	}
	@Deprecated
	public void criaCorrenteLojaNatureza() {
		correnteLojaNatureza = FabricaVo.criaLojaNatureza();
	}
 		
	//Possui 
	private	ContagemProduto correnteContagemProduto;
	protected List<ContagemProduto> listaContagemProduto = new ArrayList<ContagemProduto>();
	
	// Adicionado em 01-08-2016
	public void adicionaContagemProduto(ContagemProduto itemLista) {
		itemLista.setIdLojaVirtualRa(itemDetalhe.getIdLojaVirtual());
		//ArquivoLog.getInstancia().salvaLog("LojaVirtual(adicionaCorrenteContagemProduto):" + ContagemProdutoDadosParseBase.displayLog(correnteContagemProduto));
		listaContagemProduto.add(itemLista);
	}
	
	
	
	@Deprecated
	public ContagemProduto getCorrenteContagemProduto() {
		return correnteContagemProduto;
	}
	@Deprecated
	public void adicionaCorrenteContagemProduto() {
		correnteContagemProduto.setIdLojaVirtualRa(itemDetalhe.getIdLojaVirtual());
		ArquivoLog.getInstancia().salvaLog("LojaVirtual(adicionaCorrenteContagemProduto):" + ContagemProdutoDadosParseBase.displayLog(correnteContagemProduto));
		
		listaContagemProduto.add(correnteContagemProduto);
	}
	@Deprecated
	public void criaCorrenteContagemProduto() {
		correnteContagemProduto = FabricaVo.criaContagemProduto();
	}
 		
	
	public LojaVirtualDadosParseBase() {
		super();
		lista = new ArrayList<LojaVirtual>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public LojaVirtual getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(LojaVirtual item) {
		ArquivoLog.getInstancia().salvaLog("LojaVirtual(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(LojaVirtual item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("LojaVirtual(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaLojaVirtual();
	}


	public void setItemDetalhe(LojaVirtual item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em LojaVirtualDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em LojaVirtualDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getLojaVirtualDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getLojaVirtualDao();
			dao.setConexao(getConexao());
			List<LojaVirtual> listaBanco = dao.ListaCorrente();
			List<LojaVirtual> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<LojaVirtual> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<LojaVirtual> it = listaInclusao.iterator();
			while (it.hasNext()) {
				LojaVirtual item = it.next();
				System.out.println("LojaVirtual Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<LojaVirtual> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				LojaVirtual item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(LojaVirtual item, LojaVirtualDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(LojaVirtual item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(LojaVirtual item) {
		try {
			dao = DBB.getInstancia().getLojaVirtualDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<LojaVirtual> subtraiListaPorNome(List<LojaVirtual> listaMaior, List<LojaVirtual> listaMenor) {
		Iterator<LojaVirtual> itMaior = listaMaior.iterator();
		Iterator<LojaVirtual> itMenor = null;
		List<LojaVirtual> listaDiferenca = new ArrayList<LojaVirtual>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			LojaVirtual corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				LojaVirtual comparador = itMenor.next();
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
	protected boolean iguais(LojaVirtual item1, LojaVirtual item2) {
		throw new RuntimeException("Fazer override em LojaVirtualDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(LojaVirtual item) {
		return "Fazer override em LojaVirtualDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaProduto.clear();
		listaCategoriaLoja.clear();
		listaLojaNatureza.clear();
		listaContagemProduto.clear();
	
	}
	
	
	public void displayLogLista(List<LojaVirtual> lista, String codigo) {
		for (LojaVirtual item : lista) {
			ArquivoLog.getInstancia().salvaLog("LojaVirtual(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(LojaVirtual item) {
		StringBuffer display = new StringBuffer();
		display.append("LojaVirtual {");
		
		display.append("IdLojaVirtual:" + item.getIdLojaVirtual() + ";");
		
		display.append("NomeLojaVirtual:" + item.getNomeLojaVirtual() + ";");
		
		display.append("UrlInicialBrinquedo:" + item.getUrlInicialBrinquedo() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}