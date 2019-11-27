package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.PrecoProdutoDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class PrecoProdutoDadosParseBase extends DadosParseDao {

	protected PrecoProdutoDao dao = null;
	protected PrecoProduto itemDetalhe = null;
	protected List<PrecoProduto> lista = null;
	
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
	// do Objeto PrecoProduto
	// Para listas usar itemCorrente.
	public PrecoProduto getItemDetalhe() {
		return itemDetalhe;
	}
	
	private PrecoProduto itemCorrente = null;
	
	
	public PrecoProdutoDadosParseBase() {
		super();
		lista = new ArrayList<PrecoProduto>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public PrecoProduto getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(PrecoProduto item) {
		ArquivoLog.getInstancia().salvaLog("PrecoProduto(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(PrecoProduto item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("PrecoProduto(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaPrecoProduto();
	}


	public void setItemDetalhe(PrecoProduto item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em PrecoProdutoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em PrecoProdutoDadosParse";
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
			dao = DBB.getInstancia().getPrecoProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getPrecoProdutoDao();
			dao.setConexao(getConexao());
			List<PrecoProduto> listaBanco = dao.ListaCorrente();
			List<PrecoProduto> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<PrecoProduto> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<PrecoProduto> it = listaInclusao.iterator();
			while (it.hasNext()) {
				PrecoProduto item = it.next();
				System.out.println("PrecoProduto Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<PrecoProduto> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				PrecoProduto item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(PrecoProduto item, PrecoProdutoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(PrecoProduto item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(PrecoProduto item) {
		try {
			dao = DBB.getInstancia().getPrecoProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<PrecoProduto> subtraiListaPorNome(List<PrecoProduto> listaMaior, List<PrecoProduto> listaMenor) {
		Iterator<PrecoProduto> itMaior = listaMaior.iterator();
		Iterator<PrecoProduto> itMenor = null;
		List<PrecoProduto> listaDiferenca = new ArrayList<PrecoProduto>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			PrecoProduto corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				PrecoProduto comparador = itMenor.next();
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
	protected boolean iguais(PrecoProduto item1, PrecoProduto item2) {
		throw new RuntimeException("Fazer override em PrecoProdutoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(PrecoProduto item) {
		return "Fazer override em PrecoProdutoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<PrecoProduto> lista, String codigo) {
		for (PrecoProduto item : lista) {
			ArquivoLog.getInstancia().salvaLog("PrecoProduto(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(PrecoProduto item) {
		StringBuffer display = new StringBuffer();
		display.append("PrecoProduto {");
		
		display.append("IdPrecoProduto:" + item.getIdPrecoProduto() + ";");
		
		display.append("PrecoBoleto:" + item.getPrecoBoleto() + ";");
		
		display.append("DataVisitaInicial:" + item.getDataVisitaInicial() + ";");
		
		display.append("QuantidadeParcela:" + item.getQuantidadeParcela() + ";");
		
		display.append("PrecoParcela:" + item.getPrecoParcela() + ";");
		
		display.append("PrecoVenda:" + item.getPrecoVenda() + ";");
		
		display.append("PrecoRegular:" + item.getPrecoRegular() + ";");
		
		display.append("DataUltimaVisita:" + item.getDataUltimaVisita() + ";");
		
		display.append("PercentualAjuste:" + item.getPercentualAjuste() + ";");
		
		display.append("Media2meses:" + item.getMedia2meses() + ";");
		
		display.append("Minimo3meses:" + item.getMinimo3meses() + ";");
		
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