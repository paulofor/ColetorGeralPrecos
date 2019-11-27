package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.PalavraProdutoDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class PalavraProdutoDadosParseBase extends DadosParseDao {

	protected PalavraProdutoDao dao = null;
	protected PalavraProduto itemDetalhe = null;
	protected List<PalavraProduto> lista = null;
	
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
	// do Objeto PalavraProduto
	// Para listas usar itemCorrente.
	public PalavraProduto getItemDetalhe() {
		return itemDetalhe;
	}
	
	private PalavraProduto itemCorrente = null;
	
	
	public PalavraProdutoDadosParseBase() {
		super();
		lista = new ArrayList<PalavraProduto>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public PalavraProduto getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(PalavraProduto item) {
		ArquivoLog.getInstancia().salvaLog("PalavraProduto(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(PalavraProduto item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("PalavraProduto(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaPalavraProduto();
	}


	public void setItemDetalhe(PalavraProduto item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em PalavraProdutoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em PalavraProdutoDadosParse";
 	}

	
	private Palavra _palavra_RelaciondoA; 
	
	@Deprecated
	public void setPalavra_RelaciondoA(Palavra item) {
		_palavra_RelaciondoA = item;
	}
	@Deprecated
	public Palavra getPalavra_RelaciondoA() {
		return _palavra_RelaciondoA;
	}
 	
	private Produto _produto_RelaciondoA; 
	
	@Deprecated
	public void setProduto_RelaciondoA(Produto item) {
		_produto_RelaciondoA = item;
	}
	@Deprecated
	public Produto getProduto_RelaciondoA() {
		return _produto_RelaciondoA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getPalavraProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getPalavraProdutoDao();
			dao.setConexao(getConexao());
			List<PalavraProduto> listaBanco = dao.ListaCorrente();
			List<PalavraProduto> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<PalavraProduto> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<PalavraProduto> it = listaInclusao.iterator();
			while (it.hasNext()) {
				PalavraProduto item = it.next();
				System.out.println("PalavraProduto Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<PalavraProduto> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				PalavraProduto item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(PalavraProduto item, PalavraProdutoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(PalavraProduto item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(PalavraProduto item) {
		try {
			dao = DBB.getInstancia().getPalavraProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<PalavraProduto> subtraiListaPorNome(List<PalavraProduto> listaMaior, List<PalavraProduto> listaMenor) {
		Iterator<PalavraProduto> itMaior = listaMaior.iterator();
		Iterator<PalavraProduto> itMenor = null;
		List<PalavraProduto> listaDiferenca = new ArrayList<PalavraProduto>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			PalavraProduto corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				PalavraProduto comparador = itMenor.next();
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
	protected boolean iguais(PalavraProduto item1, PalavraProduto item2) {
		throw new RuntimeException("Fazer override em PalavraProdutoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(PalavraProduto item) {
		return "Fazer override em PalavraProdutoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<PalavraProduto> lista, String codigo) {
		for (PalavraProduto item : lista) {
			ArquivoLog.getInstancia().salvaLog("PalavraProduto(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(PalavraProduto item) {
		StringBuffer display = new StringBuffer();
		display.append("PalavraProduto {");
		
		display.append("IdPalavraProduto:" + item.getIdPalavraProduto() + ";");
		
		display.append("IdPalavraRa:" + item.getIdPalavraRa() + ";");
		
		display.append("IdProdutoRa:" + item.getIdProdutoRa() + ";");
		
		
		
		if (item.getPalavraRelaciondoA(false)!=null) {
			display.append("Palavra{");
			display.append(PalavraDadosParse.displayLog(item.getPalavraRelaciondoA(false)));
			display.append("}");
		}
 		
		if (item.getProdutoRelaciondoA(false)!=null) {
			display.append("Produto{");
			display.append(ProdutoDadosParse.displayLog(item.getProdutoRelaciondoA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}