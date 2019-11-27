package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.UsuarioPesquisaDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class UsuarioPesquisaDadosParseBase extends DadosParseDao {

	protected UsuarioPesquisaDao dao = null;
	protected UsuarioPesquisa itemDetalhe = null;
	protected List<UsuarioPesquisa> lista = null;
	
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
	// do Objeto UsuarioPesquisa
	// Para listas usar itemCorrente.
	public UsuarioPesquisa getItemDetalhe() {
		return itemDetalhe;
	}
	
	private UsuarioPesquisa itemCorrente = null;
	
	
	public UsuarioPesquisaDadosParseBase() {
		super();
		lista = new ArrayList<UsuarioPesquisa>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public UsuarioPesquisa getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(UsuarioPesquisa item) {
		ArquivoLog.getInstancia().salvaLog("UsuarioPesquisa(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(UsuarioPesquisa item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("UsuarioPesquisa(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaUsuarioPesquisa();
	}


	public void setItemDetalhe(UsuarioPesquisa item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em UsuarioPesquisaDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em UsuarioPesquisaDadosParse";
 	}

	
	private NaturezaProduto _naturezaProduto_Pesquisa; 
	
	@Deprecated
	public void setNaturezaProduto_Pesquisa(NaturezaProduto item) {
		_naturezaProduto_Pesquisa = item;
	}
	@Deprecated
	public NaturezaProduto getNaturezaProduto_Pesquisa() {
		return _naturezaProduto_Pesquisa;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getUsuarioPesquisaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getUsuarioPesquisaDao();
			dao.setConexao(getConexao());
			List<UsuarioPesquisa> listaBanco = dao.ListaCorrente();
			List<UsuarioPesquisa> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<UsuarioPesquisa> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<UsuarioPesquisa> it = listaInclusao.iterator();
			while (it.hasNext()) {
				UsuarioPesquisa item = it.next();
				System.out.println("UsuarioPesquisa Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<UsuarioPesquisa> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				UsuarioPesquisa item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(UsuarioPesquisa item, UsuarioPesquisaDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(UsuarioPesquisa item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(UsuarioPesquisa item) {
		try {
			dao = DBB.getInstancia().getUsuarioPesquisaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<UsuarioPesquisa> subtraiListaPorNome(List<UsuarioPesquisa> listaMaior, List<UsuarioPesquisa> listaMenor) {
		Iterator<UsuarioPesquisa> itMaior = listaMaior.iterator();
		Iterator<UsuarioPesquisa> itMenor = null;
		List<UsuarioPesquisa> listaDiferenca = new ArrayList<UsuarioPesquisa>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			UsuarioPesquisa corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				UsuarioPesquisa comparador = itMenor.next();
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
	protected boolean iguais(UsuarioPesquisa item1, UsuarioPesquisa item2) {
		throw new RuntimeException("Fazer override em UsuarioPesquisaDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(UsuarioPesquisa item) {
		return "Fazer override em UsuarioPesquisaDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<UsuarioPesquisa> lista, String codigo) {
		for (UsuarioPesquisa item : lista) {
			ArquivoLog.getInstancia().salvaLog("UsuarioPesquisa(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(UsuarioPesquisa item) {
		StringBuffer display = new StringBuffer();
		display.append("UsuarioPesquisa {");
		
		display.append("IdUsuarioPesquisa:" + item.getIdUsuarioPesquisa() + ";");
		
		display.append("IdUsuarioS:" + item.getIdUsuarioS() + ";");
		
		display.append("IdNaturezaProdutoP:" + item.getIdNaturezaProdutoP() + ";");
		
		
		
		if (item.getNaturezaProdutoPesquisa(false)!=null) {
			display.append("NaturezaProduto{");
			display.append(NaturezaProdutoDadosParse.displayLog(item.getNaturezaProdutoPesquisa(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}