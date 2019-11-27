package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.CompartilhamentoProdutoDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class CompartilhamentoProdutoDadosParseBase extends DadosParseDao {

	protected CompartilhamentoProdutoDao dao = null;
	protected CompartilhamentoProduto itemDetalhe = null;
	protected List<CompartilhamentoProduto> lista = null;
	
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
	// do Objeto CompartilhamentoProduto
	// Para listas usar itemCorrente.
	public CompartilhamentoProduto getItemDetalhe() {
		return itemDetalhe;
	}
	
	private CompartilhamentoProduto itemCorrente = null;
	
	
	public CompartilhamentoProdutoDadosParseBase() {
		super();
		lista = new ArrayList<CompartilhamentoProduto>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public CompartilhamentoProduto getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(CompartilhamentoProduto item) {
		ArquivoLog.getInstancia().salvaLog("CompartilhamentoProduto(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(CompartilhamentoProduto item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("CompartilhamentoProduto(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaCompartilhamentoProduto();
	}


	public void setItemDetalhe(CompartilhamentoProduto item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em CompartilhamentoProdutoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em CompartilhamentoProdutoDadosParse";
 	}

	
	private Usuario _usuario_PertenceA; 
	
	@Deprecated
	public void setUsuario_PertenceA(Usuario item) {
		_usuario_PertenceA = item;
	}
	@Deprecated
	public Usuario getUsuario_PertenceA() {
		return _usuario_PertenceA;
	}
 	
	private Produto _produto_ReferenteA; 
	
	@Deprecated
	public void setProduto_ReferenteA(Produto item) {
		_produto_ReferenteA = item;
	}
	@Deprecated
	public Produto getProduto_ReferenteA() {
		return _produto_ReferenteA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getCompartilhamentoProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getCompartilhamentoProdutoDao();
			dao.setConexao(getConexao());
			List<CompartilhamentoProduto> listaBanco = dao.ListaCorrente();
			List<CompartilhamentoProduto> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<CompartilhamentoProduto> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<CompartilhamentoProduto> it = listaInclusao.iterator();
			while (it.hasNext()) {
				CompartilhamentoProduto item = it.next();
				System.out.println("CompartilhamentoProduto Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<CompartilhamentoProduto> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				CompartilhamentoProduto item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(CompartilhamentoProduto item, CompartilhamentoProdutoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(CompartilhamentoProduto item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(CompartilhamentoProduto item) {
		try {
			dao = DBB.getInstancia().getCompartilhamentoProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<CompartilhamentoProduto> subtraiListaPorNome(List<CompartilhamentoProduto> listaMaior, List<CompartilhamentoProduto> listaMenor) {
		Iterator<CompartilhamentoProduto> itMaior = listaMaior.iterator();
		Iterator<CompartilhamentoProduto> itMenor = null;
		List<CompartilhamentoProduto> listaDiferenca = new ArrayList<CompartilhamentoProduto>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			CompartilhamentoProduto corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				CompartilhamentoProduto comparador = itMenor.next();
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
	protected boolean iguais(CompartilhamentoProduto item1, CompartilhamentoProduto item2) {
		throw new RuntimeException("Fazer override em CompartilhamentoProdutoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(CompartilhamentoProduto item) {
		return "Fazer override em CompartilhamentoProdutoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<CompartilhamentoProduto> lista, String codigo) {
		for (CompartilhamentoProduto item : lista) {
			ArquivoLog.getInstancia().salvaLog("CompartilhamentoProduto(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(CompartilhamentoProduto item) {
		StringBuffer display = new StringBuffer();
		display.append("CompartilhamentoProduto {");
		
		display.append("IdCompartilhamentoProduto:" + item.getIdCompartilhamentoProduto() + ";");
		
		display.append("DataHora:" + item.getDataHora() + ";");
		
		display.append("IdUsuarioPa:" + item.getIdUsuarioPa() + ";");
		
		display.append("IdProdutoRa:" + item.getIdProdutoRa() + ";");
		
		
		
		if (item.getUsuarioPertenceA(false)!=null) {
			display.append("Usuario{");
			display.append(UsuarioDadosParse.displayLog(item.getUsuarioPertenceA(false)));
			display.append("}");
		}
 		
		if (item.getProdutoReferenteA(false)!=null) {
			display.append("Produto{");
			display.append(ProdutoDadosParse.displayLog(item.getProdutoReferenteA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}