package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.OportunidadeInteresseClienteDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class OportunidadeInteresseClienteDadosParseBase extends DadosParseDao {

	protected OportunidadeInteresseClienteDao dao = null;
	protected OportunidadeInteresseCliente itemDetalhe = null;
	protected List<OportunidadeInteresseCliente> lista = null;
	
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
	// do Objeto OportunidadeInteresseCliente
	// Para listas usar itemCorrente.
	public OportunidadeInteresseCliente getItemDetalhe() {
		return itemDetalhe;
	}
	
	private OportunidadeInteresseCliente itemCorrente = null;
	
	
	public OportunidadeInteresseClienteDadosParseBase() {
		super();
		lista = new ArrayList<OportunidadeInteresseCliente>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public OportunidadeInteresseCliente getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(OportunidadeInteresseCliente item) {
		ArquivoLog.getInstancia().salvaLog("OportunidadeInteresseCliente(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(OportunidadeInteresseCliente item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("OportunidadeInteresseCliente(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaOportunidadeInteresseCliente();
	}


	public void setItemDetalhe(OportunidadeInteresseCliente item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em OportunidadeInteresseClienteDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em OportunidadeInteresseClienteDadosParse";
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
			dao = DBB.getInstancia().getOportunidadeInteresseClienteDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getOportunidadeInteresseClienteDao();
			dao.setConexao(getConexao());
			List<OportunidadeInteresseCliente> listaBanco = dao.ListaCorrente();
			List<OportunidadeInteresseCliente> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<OportunidadeInteresseCliente> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<OportunidadeInteresseCliente> it = listaInclusao.iterator();
			while (it.hasNext()) {
				OportunidadeInteresseCliente item = it.next();
				System.out.println("OportunidadeInteresseCliente Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<OportunidadeInteresseCliente> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				OportunidadeInteresseCliente item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(OportunidadeInteresseCliente item, OportunidadeInteresseClienteDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(OportunidadeInteresseCliente item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(OportunidadeInteresseCliente item) {
		try {
			dao = DBB.getInstancia().getOportunidadeInteresseClienteDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<OportunidadeInteresseCliente> subtraiListaPorNome(List<OportunidadeInteresseCliente> listaMaior, List<OportunidadeInteresseCliente> listaMenor) {
		Iterator<OportunidadeInteresseCliente> itMaior = listaMaior.iterator();
		Iterator<OportunidadeInteresseCliente> itMenor = null;
		List<OportunidadeInteresseCliente> listaDiferenca = new ArrayList<OportunidadeInteresseCliente>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			OportunidadeInteresseCliente corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				OportunidadeInteresseCliente comparador = itMenor.next();
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
	protected boolean iguais(OportunidadeInteresseCliente item1, OportunidadeInteresseCliente item2) {
		throw new RuntimeException("Fazer override em OportunidadeInteresseClienteDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(OportunidadeInteresseCliente item) {
		return "Fazer override em OportunidadeInteresseClienteDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<OportunidadeInteresseCliente> lista, String codigo) {
		for (OportunidadeInteresseCliente item : lista) {
			ArquivoLog.getInstancia().salvaLog("OportunidadeInteresseCliente(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(OportunidadeInteresseCliente item) {
		StringBuffer display = new StringBuffer();
		display.append("OportunidadeInteresseCliente {");
		
		display.append("IdOportunidadeInteresseCliente:" + item.getIdOportunidadeInteresseCliente() + ";");
		
		display.append("IdProdutoClientePa:" + item.getIdProdutoClientePa() + ";");
		
		
		
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