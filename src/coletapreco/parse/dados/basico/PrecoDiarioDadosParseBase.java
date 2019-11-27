package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.PrecoDiarioDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class PrecoDiarioDadosParseBase extends DadosParseDao {

	protected PrecoDiarioDao dao = null;
	protected PrecoDiario itemDetalhe = null;
	protected List<PrecoDiario> lista = null;
	
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
	// do Objeto PrecoDiario
	// Para listas usar itemCorrente.
	public PrecoDiario getItemDetalhe() {
		return itemDetalhe;
	}
	
	private PrecoDiario itemCorrente = null;
	
	
	public PrecoDiarioDadosParseBase() {
		super();
		lista = new ArrayList<PrecoDiario>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public PrecoDiario getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(PrecoDiario item) {
		ArquivoLog.getInstancia().salvaLog("PrecoDiario(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(PrecoDiario item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("PrecoDiario(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaPrecoDiario();
	}


	public void setItemDetalhe(PrecoDiario item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em PrecoDiarioDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em PrecoDiarioDadosParse";
 	}

	
	private Produto _produto_PertenceA; 
	
	@Deprecated
	public void setProduto_PertenceA(Produto item) {
		_produto_PertenceA = item;
	}
	@Deprecated
	public Produto getProduto_PertenceA() {
		return _produto_PertenceA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getPrecoDiarioDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getPrecoDiarioDao();
			dao.setConexao(getConexao());
			List<PrecoDiario> listaBanco = dao.ListaCorrente();
			List<PrecoDiario> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<PrecoDiario> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<PrecoDiario> it = listaInclusao.iterator();
			while (it.hasNext()) {
				PrecoDiario item = it.next();
				System.out.println("PrecoDiario Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<PrecoDiario> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				PrecoDiario item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(PrecoDiario item, PrecoDiarioDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(PrecoDiario item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(PrecoDiario item) {
		try {
			dao = DBB.getInstancia().getPrecoDiarioDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<PrecoDiario> subtraiListaPorNome(List<PrecoDiario> listaMaior, List<PrecoDiario> listaMenor) {
		Iterator<PrecoDiario> itMaior = listaMaior.iterator();
		Iterator<PrecoDiario> itMenor = null;
		List<PrecoDiario> listaDiferenca = new ArrayList<PrecoDiario>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			PrecoDiario corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				PrecoDiario comparador = itMenor.next();
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
	protected boolean iguais(PrecoDiario item1, PrecoDiario item2) {
		throw new RuntimeException("Fazer override em PrecoDiarioDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(PrecoDiario item) {
		return "Fazer override em PrecoDiarioDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<PrecoDiario> lista, String codigo) {
		for (PrecoDiario item : lista) {
			ArquivoLog.getInstancia().salvaLog("PrecoDiario(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(PrecoDiario item) {
		StringBuffer display = new StringBuffer();
		display.append("PrecoDiario {");
		
		display.append("IdPrecoDiario:" + item.getIdPrecoDiario() + ";");
		
		display.append("PrecoBoleto:" + item.getPrecoBoleto() + ";");
		
		display.append("DataHora:" + item.getDataHora() + ";");
		
		display.append("QuantidadeParcela:" + item.getQuantidadeParcela() + ";");
		
		display.append("PrecoParcela:" + item.getPrecoParcela() + ";");
		
		display.append("PrecoVenda:" + item.getPrecoVenda() + ";");
		
		display.append("PrecoRegular:" + item.getPrecoRegular() + ";");
		
		display.append("PosicaoProduto:" + item.getPosicaoProduto() + ";");
		
		display.append("IdProdutoPa:" + item.getIdProdutoPa() + ";");
		
		
		
		if (item.getProdutoPertenceA(false)!=null) {
			display.append("Produto{");
			display.append(ProdutoDadosParse.displayLog(item.getProdutoPertenceA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}