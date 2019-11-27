package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.InteresseProdutoDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class InteresseProdutoDadosParseBase extends DadosParseDao {

	protected InteresseProdutoDao dao = null;
	protected InteresseProduto itemDetalhe = null;
	protected List<InteresseProduto> lista = null;
	
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
	// do Objeto InteresseProduto
	// Para listas usar itemCorrente.
	public InteresseProduto getItemDetalhe() {
		return itemDetalhe;
	}
	
	private InteresseProduto itemCorrente = null;
	
	
	public InteresseProdutoDadosParseBase() {
		super();
		lista = new ArrayList<InteresseProduto>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public InteresseProduto getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(InteresseProduto item) {
		ArquivoLog.getInstancia().salvaLog("InteresseProduto(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(InteresseProduto item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("InteresseProduto(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaInteresseProduto();
	}


	public void setItemDetalhe(InteresseProduto item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em InteresseProdutoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em InteresseProdutoDadosParse";
 	}

	
	private ProdutoCliente _produtoCliente_ReferenteA; 
	
	@Deprecated
	public void setProdutoCliente_ReferenteA(ProdutoCliente item) {
		_produtoCliente_ReferenteA = item;
	}
	@Deprecated
	public ProdutoCliente getProdutoCliente_ReferenteA() {
		return _produtoCliente_ReferenteA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getInteresseProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getInteresseProdutoDao();
			dao.setConexao(getConexao());
			List<InteresseProduto> listaBanco = dao.ListaCorrente();
			List<InteresseProduto> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<InteresseProduto> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<InteresseProduto> it = listaInclusao.iterator();
			while (it.hasNext()) {
				InteresseProduto item = it.next();
				System.out.println("InteresseProduto Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<InteresseProduto> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				InteresseProduto item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(InteresseProduto item, InteresseProdutoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(InteresseProduto item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(InteresseProduto item) {
		try {
			dao = DBB.getInstancia().getInteresseProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<InteresseProduto> subtraiListaPorNome(List<InteresseProduto> listaMaior, List<InteresseProduto> listaMenor) {
		Iterator<InteresseProduto> itMaior = listaMaior.iterator();
		Iterator<InteresseProduto> itMenor = null;
		List<InteresseProduto> listaDiferenca = new ArrayList<InteresseProduto>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			InteresseProduto corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				InteresseProduto comparador = itMenor.next();
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
	protected boolean iguais(InteresseProduto item1, InteresseProduto item2) {
		throw new RuntimeException("Fazer override em InteresseProdutoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(InteresseProduto item) {
		return "Fazer override em InteresseProdutoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<InteresseProduto> lista, String codigo) {
		for (InteresseProduto item : lista) {
			ArquivoLog.getInstancia().salvaLog("InteresseProduto(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(InteresseProduto item) {
		StringBuffer display = new StringBuffer();
		display.append("InteresseProduto {");
		
		display.append("IdInteresseProduto:" + item.getIdInteresseProduto() + ";");
		
		display.append("Nota:" + item.getNota() + ";");
		
		display.append("Data:" + item.getData() + ";");
		
		display.append("Valor:" + item.getValor() + ";");
		
		display.append("Espera:" + item.getEspera() + ";");
		
		display.append("Monitora:" + item.getMonitora() + ";");
		
		display.append("VisualizacaoConcluida:" + item.getVisualizacaoConcluida() + ";");
		
		display.append("PrecoMedio:" + item.getPrecoMedio() + ";");
		
		display.append("PrecoMinimo:" + item.getPrecoMinimo() + ";");
		
		display.append("DataUltimaSincronizacao:" + item.getDataUltimaSincronizacao() + ";");
		
		display.append("Novo:" + item.getNovo() + ";");
		
		display.append("Mudanca:" + item.getMudanca() + ";");
		
		display.append("DiferencaAnterior:" + item.getDiferencaAnterior() + ";");
		
		display.append("MinhaAvaliacao:" + item.getMinhaAvaliacao() + ";");
		
		display.append("DataUltimaMudanca:" + item.getDataUltimaMudanca() + ";");
		
		display.append("DataUltimaVerificacao:" + item.getDataUltimaVerificacao() + ";");
		
		display.append("PrecoAnterior:" + item.getPrecoAnterior() + ";");
		
		display.append("EstagioVisualizacaoMudanca:" + item.getEstagioVisualizacaoMudanca() + ";");
		
		display.append("DataUltimaMudancaGmt:" + item.getDataUltimaMudancaGmt() + ";");
		
		display.append("MudancaNota:" + item.getMudancaNota() + ";");
		
		display.append("DataUltimaMudancaNota:" + item.getDataUltimaMudancaNota() + ";");
		
		display.append("DataUltimaMudancaNotaGmt:" + item.getDataUltimaMudancaNotaGmt() + ";");
		
		display.append("PrecoAtual:" + item.getPrecoAtual() + ";");
		
		display.append("IdProdutoClienteRa:" + item.getIdProdutoClienteRa() + ";");
		
		display.append("IdUsuarioS:" + item.getIdUsuarioS() + ";");
		
		
		
		if (item.getProdutoClienteReferenteA(false)!=null) {
			display.append("ProdutoCliente{");
			display.append(ProdutoClienteDadosParse.displayLog(item.getProdutoClienteReferenteA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}