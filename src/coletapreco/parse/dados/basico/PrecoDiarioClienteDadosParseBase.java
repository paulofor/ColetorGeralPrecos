package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.PrecoDiarioClienteDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class PrecoDiarioClienteDadosParseBase extends DadosParseDao {

	protected PrecoDiarioClienteDao dao = null;
	protected PrecoDiarioCliente itemDetalhe = null;
	protected List<PrecoDiarioCliente> lista = null;
	
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
	// do Objeto PrecoDiarioCliente
	// Para listas usar itemCorrente.
	public PrecoDiarioCliente getItemDetalhe() {
		return itemDetalhe;
	}
	
	private PrecoDiarioCliente itemCorrente = null;
	
	
	public PrecoDiarioClienteDadosParseBase() {
		super();
		lista = new ArrayList<PrecoDiarioCliente>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public PrecoDiarioCliente getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(PrecoDiarioCliente item) {
		ArquivoLog.getInstancia().salvaLog("PrecoDiarioCliente(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(PrecoDiarioCliente item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("PrecoDiarioCliente(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaPrecoDiarioCliente();
	}


	public void setItemDetalhe(PrecoDiarioCliente item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em PrecoDiarioClienteDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em PrecoDiarioClienteDadosParse";
 	}

	
	private ProdutoCliente _produtoCliente_PertenceA; 
	
	@Deprecated
	public void setProdutoCliente_PertenceA(ProdutoCliente item) {
		_produtoCliente_PertenceA = item;
	}
	@Deprecated
	public ProdutoCliente getProdutoCliente_PertenceA() {
		return _produtoCliente_PertenceA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getPrecoDiarioClienteDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getPrecoDiarioClienteDao();
			dao.setConexao(getConexao());
			List<PrecoDiarioCliente> listaBanco = dao.ListaCorrente();
			List<PrecoDiarioCliente> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<PrecoDiarioCliente> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<PrecoDiarioCliente> it = listaInclusao.iterator();
			while (it.hasNext()) {
				PrecoDiarioCliente item = it.next();
				System.out.println("PrecoDiarioCliente Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<PrecoDiarioCliente> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				PrecoDiarioCliente item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(PrecoDiarioCliente item, PrecoDiarioClienteDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(PrecoDiarioCliente item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(PrecoDiarioCliente item) {
		try {
			dao = DBB.getInstancia().getPrecoDiarioClienteDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<PrecoDiarioCliente> subtraiListaPorNome(List<PrecoDiarioCliente> listaMaior, List<PrecoDiarioCliente> listaMenor) {
		Iterator<PrecoDiarioCliente> itMaior = listaMaior.iterator();
		Iterator<PrecoDiarioCliente> itMenor = null;
		List<PrecoDiarioCliente> listaDiferenca = new ArrayList<PrecoDiarioCliente>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			PrecoDiarioCliente corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				PrecoDiarioCliente comparador = itMenor.next();
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
	protected boolean iguais(PrecoDiarioCliente item1, PrecoDiarioCliente item2) {
		throw new RuntimeException("Fazer override em PrecoDiarioClienteDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(PrecoDiarioCliente item) {
		return "Fazer override em PrecoDiarioClienteDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<PrecoDiarioCliente> lista, String codigo) {
		for (PrecoDiarioCliente item : lista) {
			ArquivoLog.getInstancia().salvaLog("PrecoDiarioCliente(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(PrecoDiarioCliente item) {
		StringBuffer display = new StringBuffer();
		display.append("PrecoDiarioCliente {");
		
		display.append("IdPrecoDiarioClientte:" + item.getIdPrecoDiarioClientte() + ";");
		
		display.append("DataHora:" + item.getDataHora() + ";");
		
		display.append("PrecoVenda:" + item.getPrecoVenda() + ";");
		
		display.append("IdProdutoClientePa:" + item.getIdProdutoClientePa() + ";");
		
		display.append("IdUsuarioS:" + item.getIdUsuarioS() + ";");
		
		
		
		if (item.getProdutoClientePertenceA(false)!=null) {
			display.append("ProdutoCliente{");
			display.append(ProdutoClienteDadosParse.displayLog(item.getProdutoClientePertenceA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}