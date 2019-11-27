package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.OportunidadeDiaDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class OportunidadeDiaDadosParseBase extends DadosParseDao {

	protected OportunidadeDiaDao dao = null;
	protected OportunidadeDia itemDetalhe = null;
	protected List<OportunidadeDia> lista = null;
	
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
	// do Objeto OportunidadeDia
	// Para listas usar itemCorrente.
	public OportunidadeDia getItemDetalhe() {
		return itemDetalhe;
	}
	
	private OportunidadeDia itemCorrente = null;
	
	
	public OportunidadeDiaDadosParseBase() {
		super();
		lista = new ArrayList<OportunidadeDia>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public OportunidadeDia getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(OportunidadeDia item) {
		ArquivoLog.getInstancia().salvaLog("OportunidadeDia(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(OportunidadeDia item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("OportunidadeDia(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaOportunidadeDia();
	}


	public void setItemDetalhe(OportunidadeDia item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em OportunidadeDiaDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em OportunidadeDiaDadosParse";
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
 	
	private NaturezaProduto _naturezaProduto_PertenceA; 
	
	@Deprecated
	public void setNaturezaProduto_PertenceA(NaturezaProduto item) {
		_naturezaProduto_PertenceA = item;
	}
	@Deprecated
	public NaturezaProduto getNaturezaProduto_PertenceA() {
		return _naturezaProduto_PertenceA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getOportunidadeDiaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getOportunidadeDiaDao();
			dao.setConexao(getConexao());
			List<OportunidadeDia> listaBanco = dao.ListaCorrente();
			List<OportunidadeDia> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<OportunidadeDia> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<OportunidadeDia> it = listaInclusao.iterator();
			while (it.hasNext()) {
				OportunidadeDia item = it.next();
				System.out.println("OportunidadeDia Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<OportunidadeDia> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				OportunidadeDia item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(OportunidadeDia item, OportunidadeDiaDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(OportunidadeDia item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(OportunidadeDia item) {
		try {
			dao = DBB.getInstancia().getOportunidadeDiaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<OportunidadeDia> subtraiListaPorNome(List<OportunidadeDia> listaMaior, List<OportunidadeDia> listaMenor) {
		Iterator<OportunidadeDia> itMaior = listaMaior.iterator();
		Iterator<OportunidadeDia> itMenor = null;
		List<OportunidadeDia> listaDiferenca = new ArrayList<OportunidadeDia>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			OportunidadeDia corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				OportunidadeDia comparador = itMenor.next();
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
	protected boolean iguais(OportunidadeDia item1, OportunidadeDia item2) {
		throw new RuntimeException("Fazer override em OportunidadeDiaDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(OportunidadeDia item) {
		return "Fazer override em OportunidadeDiaDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<OportunidadeDia> lista, String codigo) {
		for (OportunidadeDia item : lista) {
			ArquivoLog.getInstancia().salvaLog("OportunidadeDia(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(OportunidadeDia item) {
		StringBuffer display = new StringBuffer();
		display.append("OportunidadeDia {");
		
		display.append("IdOportunidadeDia:" + item.getIdOportunidadeDia() + ";");
		
		display.append("UrlProduto:" + item.getUrlProduto() + ";");
		
		display.append("NomeProduto:" + item.getNomeProduto() + ";");
		
		display.append("DataInicioPrecoAtual:" + item.getDataInicioPrecoAtual() + ";");
		
		display.append("NomeMarca:" + item.getNomeMarca() + ";");
		
		display.append("UrlAfiliado:" + item.getUrlAfiliado() + ";");
		
		display.append("DataUltimaPrecoAnterior:" + item.getDataUltimaPrecoAnterior() + ";");
		
		display.append("ImagemLocal:" + item.getImagemLocal() + ";");
		
		display.append("UrlImagem:" + item.getUrlImagem() + ";");
		
		display.append("PosicaoProduto:" + item.getPosicaoProduto() + ";");
		
		display.append("PrecoVendaAnterior:" + item.getPrecoVendaAnterior() + ";");
		
		display.append("PrecoVendaAtual:" + item.getPrecoVendaAtual() + ";");
		
		display.append("PrecoBoletoAnterior:" + item.getPrecoBoletoAnterior() + ";");
		
		display.append("PrecoBoletoAtual:" + item.getPrecoBoletoAtual() + ";");
		
		display.append("PrecoParcelaAnterior:" + item.getPrecoParcelaAnterior() + ";");
		
		display.append("PrecoParcelaAtual:" + item.getPrecoParcelaAtual() + ";");
		
		display.append("QuantidadeParcelaAnterior:" + item.getQuantidadeParcelaAnterior() + ";");
		
		display.append("QuantidadeParcelaAtual:" + item.getQuantidadeParcelaAtual() + ";");
		
		display.append("PercentualAjusteVenda:" + item.getPercentualAjusteVenda() + ";");
		
		display.append("PercentualAjusteBoleto:" + item.getPercentualAjusteBoleto() + ";");
		
		display.append("NomeLojaVirtual:" + item.getNomeLojaVirtual() + ";");
		
		display.append("PrecoMinimo:" + item.getPrecoMinimo() + ";");
		
		display.append("PrecoMedio:" + item.getPrecoMedio() + ";");
		
		display.append("IdProdutoRa:" + item.getIdProdutoRa() + ";");
		
		display.append("IdNaturezaProdutoPa:" + item.getIdNaturezaProdutoPa() + ";");
		
		
		
		if (item.getProdutoReferenteA(false)!=null) {
			display.append("Produto{");
			display.append(ProdutoDadosParse.displayLog(item.getProdutoReferenteA(false)));
			display.append("}");
		}
 		
		if (item.getNaturezaProdutoPertenceA(false)!=null) {
			display.append("NaturezaProduto{");
			display.append(NaturezaProdutoDadosParse.displayLog(item.getNaturezaProdutoPertenceA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}