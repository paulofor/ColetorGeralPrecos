package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.LojaNaturezaDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class LojaNaturezaDadosParseBase extends DadosParseDao {

	protected LojaNaturezaDao dao = null;
	protected LojaNatureza itemDetalhe = null;
	protected List<LojaNatureza> lista = null;
	
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
	// do Objeto LojaNatureza
	// Para listas usar itemCorrente.
	public LojaNatureza getItemDetalhe() {
		return itemDetalhe;
	}
	
	private LojaNatureza itemCorrente = null;
	
	
	public LojaNaturezaDadosParseBase() {
		super();
		lista = new ArrayList<LojaNatureza>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public LojaNatureza getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(LojaNatureza item) {
		ArquivoLog.getInstancia().salvaLog("LojaNatureza(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(LojaNatureza item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("LojaNatureza(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaLojaNatureza();
	}


	public void setItemDetalhe(LojaNatureza item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em LojaNaturezaDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em LojaNaturezaDadosParse";
 	}

	
	private LojaVirtual _lojaVirtual_ReferenteA; 
	
	@Deprecated
	public void setLojaVirtual_ReferenteA(LojaVirtual item) {
		_lojaVirtual_ReferenteA = item;
	}
	@Deprecated
	public LojaVirtual getLojaVirtual_ReferenteA() {
		return _lojaVirtual_ReferenteA;
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
			dao = DBB.getInstancia().getLojaNaturezaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getLojaNaturezaDao();
			dao.setConexao(getConexao());
			List<LojaNatureza> listaBanco = dao.ListaCorrente();
			List<LojaNatureza> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<LojaNatureza> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<LojaNatureza> it = listaInclusao.iterator();
			while (it.hasNext()) {
				LojaNatureza item = it.next();
				System.out.println("LojaNatureza Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<LojaNatureza> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				LojaNatureza item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(LojaNatureza item, LojaNaturezaDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(LojaNatureza item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(LojaNatureza item) {
		try {
			dao = DBB.getInstancia().getLojaNaturezaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<LojaNatureza> subtraiListaPorNome(List<LojaNatureza> listaMaior, List<LojaNatureza> listaMenor) {
		Iterator<LojaNatureza> itMaior = listaMaior.iterator();
		Iterator<LojaNatureza> itMenor = null;
		List<LojaNatureza> listaDiferenca = new ArrayList<LojaNatureza>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			LojaNatureza corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				LojaNatureza comparador = itMenor.next();
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
	protected boolean iguais(LojaNatureza item1, LojaNatureza item2) {
		throw new RuntimeException("Fazer override em LojaNaturezaDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(LojaNatureza item) {
		return "Fazer override em LojaNaturezaDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<LojaNatureza> lista, String codigo) {
		for (LojaNatureza item : lista) {
			ArquivoLog.getInstancia().salvaLog("LojaNatureza(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(LojaNatureza item) {
		StringBuffer display = new StringBuffer();
		display.append("LojaNatureza {");
		
		display.append("IdLojaNatureza:" + item.getIdLojaNatureza() + ";");
		
		display.append("UrlInicial:" + item.getUrlInicial() + ";");
		
		display.append("ParseCategoria:" + item.getParseCategoria() + ";");
		
		display.append("IdLojaVirtualRa:" + item.getIdLojaVirtualRa() + ";");
		
		display.append("IdNaturezaProdutoRa:" + item.getIdNaturezaProdutoRa() + ";");
		
		
		
		if (item.getLojaVirtualReferenteA(false)!=null) {
			display.append("LojaVirtual{");
			display.append(LojaVirtualDadosParse.displayLog(item.getLojaVirtualReferenteA(false)));
			display.append("}");
		}
 		
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