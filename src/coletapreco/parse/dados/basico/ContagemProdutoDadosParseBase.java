package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.ContagemProdutoDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class ContagemProdutoDadosParseBase extends DadosParseDao {

	protected ContagemProdutoDao dao = null;
	protected ContagemProduto itemDetalhe = null;
	protected List<ContagemProduto> lista = null;
	
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
	// do Objeto ContagemProduto
	// Para listas usar itemCorrente.
	public ContagemProduto getItemDetalhe() {
		return itemDetalhe;
	}
	
	private ContagemProduto itemCorrente = null;
	
	
	public ContagemProdutoDadosParseBase() {
		super();
		lista = new ArrayList<ContagemProduto>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public ContagemProduto getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(ContagemProduto item) {
		ArquivoLog.getInstancia().salvaLog("ContagemProduto(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(ContagemProduto item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("ContagemProduto(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaContagemProduto();
	}


	public void setItemDetalhe(ContagemProduto item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em ContagemProdutoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em ContagemProdutoDadosParse";
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
 	
	private LojaVirtual _lojaVirtual_ReferenteA; 
	
	@Deprecated
	public void setLojaVirtual_ReferenteA(LojaVirtual item) {
		_lojaVirtual_ReferenteA = item;
	}
	@Deprecated
	public LojaVirtual getLojaVirtual_ReferenteA() {
		return _lojaVirtual_ReferenteA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getContagemProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getContagemProdutoDao();
			dao.setConexao(getConexao());
			List<ContagemProduto> listaBanco = dao.ListaCorrente();
			List<ContagemProduto> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<ContagemProduto> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<ContagemProduto> it = listaInclusao.iterator();
			while (it.hasNext()) {
				ContagemProduto item = it.next();
				System.out.println("ContagemProduto Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<ContagemProduto> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				ContagemProduto item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(ContagemProduto item, ContagemProdutoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(ContagemProduto item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(ContagemProduto item) {
		try {
			dao = DBB.getInstancia().getContagemProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<ContagemProduto> subtraiListaPorNome(List<ContagemProduto> listaMaior, List<ContagemProduto> listaMenor) {
		Iterator<ContagemProduto> itMaior = listaMaior.iterator();
		Iterator<ContagemProduto> itMenor = null;
		List<ContagemProduto> listaDiferenca = new ArrayList<ContagemProduto>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			ContagemProduto corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				ContagemProduto comparador = itMenor.next();
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
	protected boolean iguais(ContagemProduto item1, ContagemProduto item2) {
		throw new RuntimeException("Fazer override em ContagemProdutoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(ContagemProduto item) {
		return "Fazer override em ContagemProdutoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<ContagemProduto> lista, String codigo) {
		for (ContagemProduto item : lista) {
			ArquivoLog.getInstancia().salvaLog("ContagemProduto(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(ContagemProduto item) {
		StringBuffer display = new StringBuffer();
		display.append("ContagemProduto {");
		
		display.append("IdContagemProduto:" + item.getIdContagemProduto() + ";");
		
		display.append("Quantidade:" + item.getQuantidade() + ";");
		
		display.append("Data:" + item.getData() + ";");
		
		display.append("PercentualDiferenca:" + item.getPercentualDiferenca() + ";");
		
		display.append("PossibilidadeErro:" + item.getPossibilidadeErro() + ";");
		
		display.append("IdNaturezaProdutoRa:" + item.getIdNaturezaProdutoRa() + ";");
		
		display.append("IdLojaVirtualRa:" + item.getIdLojaVirtualRa() + ";");
		
		
		
		if (item.getNaturezaProdutoReferenteA(false)!=null) {
			display.append("NaturezaProduto{");
			display.append(NaturezaProdutoDadosParse.displayLog(item.getNaturezaProdutoReferenteA(false)));
			display.append("}");
		}
 		
		if (item.getLojaVirtualReferenteA(false)!=null) {
			display.append("LojaVirtual{");
			display.append(LojaVirtualDadosParse.displayLog(item.getLojaVirtualReferenteA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}