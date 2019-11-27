package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.ProdutoDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class ProdutoDadosParseBase extends DadosParseDao {

	protected ProdutoDao dao = null;
	protected Produto itemDetalhe = null;
	protected List<Produto> lista = null;
	
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
	// do Objeto Produto
	// Para listas usar itemCorrente.
	public Produto getItemDetalhe() {
		return itemDetalhe;
	}
	
	private Produto itemCorrente = null;
	
	//Possui 
	private	PrecoDiario correntePrecoDiario;
	protected List<PrecoDiario> listaPrecoDiario = new ArrayList<PrecoDiario>();
	
	// Adicionado em 01-08-2016
	public void adicionaPrecoDiario(PrecoDiario itemLista) {
		itemLista.setIdProdutoPa(itemDetalhe.getIdProduto());
		//ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrentePrecoDiario):" + PrecoDiarioDadosParseBase.displayLog(correntePrecoDiario));
		listaPrecoDiario.add(itemLista);
	}
	
	
	
	@Deprecated
	public PrecoDiario getCorrentePrecoDiario() {
		return correntePrecoDiario;
	}
	@Deprecated
	public void adicionaCorrentePrecoDiario() {
		correntePrecoDiario.setIdProdutoPa(itemDetalhe.getIdProduto());
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrentePrecoDiario):" + PrecoDiarioDadosParseBase.displayLog(correntePrecoDiario));
		
		listaPrecoDiario.add(correntePrecoDiario);
	}
	@Deprecated
	public void criaCorrentePrecoDiario() {
		correntePrecoDiario = FabricaVo.criaPrecoDiario();
	}
 		
	//ReferenteA 
	private	ModeloProdutoProduto correnteModeloProdutoProduto;
	protected List<ModeloProdutoProduto> listaModeloProdutoProduto = new ArrayList<ModeloProdutoProduto>();
	
	// Adicionado em 01-08-2016
	public void adicionaModeloProdutoProduto(ModeloProdutoProduto itemLista) {
		itemLista.setIdProdutoRa(itemDetalhe.getIdProduto());
		//ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrenteModeloProdutoProduto):" + ModeloProdutoProdutoDadosParseBase.displayLog(correnteModeloProdutoProduto));
		listaModeloProdutoProduto.add(itemLista);
	}
	
	
	
	@Deprecated
	public ModeloProdutoProduto getCorrenteModeloProdutoProduto() {
		return correnteModeloProdutoProduto;
	}
	@Deprecated
	public void adicionaCorrenteModeloProdutoProduto() {
		correnteModeloProdutoProduto.setIdProdutoRa(itemDetalhe.getIdProduto());
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrenteModeloProdutoProduto):" + ModeloProdutoProdutoDadosParseBase.displayLog(correnteModeloProdutoProduto));
		
		listaModeloProdutoProduto.add(correnteModeloProdutoProduto);
	}
	@Deprecated
	public void criaCorrenteModeloProdutoProduto() {
		correnteModeloProdutoProduto = FabricaVo.criaModeloProdutoProduto();
	}
 		
	//Possui 
	private	PrecoProduto correntePrecoProduto;
	protected List<PrecoProduto> listaPrecoProduto = new ArrayList<PrecoProduto>();
	
	// Adicionado em 01-08-2016
	public void adicionaPrecoProduto(PrecoProduto itemLista) {
		itemLista.setIdProdutoPa(itemDetalhe.getIdProduto());
		//ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrentePrecoProduto):" + PrecoProdutoDadosParseBase.displayLog(correntePrecoProduto));
		listaPrecoProduto.add(itemLista);
	}
	
	
	
	@Deprecated
	public PrecoProduto getCorrentePrecoProduto() {
		return correntePrecoProduto;
	}
	@Deprecated
	public void adicionaCorrentePrecoProduto() {
		correntePrecoProduto.setIdProdutoPa(itemDetalhe.getIdProduto());
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrentePrecoProduto):" + PrecoProdutoDadosParseBase.displayLog(correntePrecoProduto));
		
		listaPrecoProduto.add(correntePrecoProduto);
	}
	@Deprecated
	public void criaCorrentePrecoProduto() {
		correntePrecoProduto = FabricaVo.criaPrecoProduto();
	}
 		
	//Possui 
	private	CategoriaLojaProduto correnteCategoriaLojaProduto;
	protected List<CategoriaLojaProduto> listaCategoriaLojaProduto = new ArrayList<CategoriaLojaProduto>();
	
	// Adicionado em 01-08-2016
	public void adicionaCategoriaLojaProduto(CategoriaLojaProduto itemLista) {
		itemLista.setIdProdutoRa(itemDetalhe.getIdProduto());
		//ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrenteCategoriaLojaProduto):" + CategoriaLojaProdutoDadosParseBase.displayLog(correnteCategoriaLojaProduto));
		listaCategoriaLojaProduto.add(itemLista);
	}
	
	
	
	@Deprecated
	public CategoriaLojaProduto getCorrenteCategoriaLojaProduto() {
		return correnteCategoriaLojaProduto;
	}
	@Deprecated
	public void adicionaCorrenteCategoriaLojaProduto() {
		correnteCategoriaLojaProduto.setIdProdutoRa(itemDetalhe.getIdProduto());
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrenteCategoriaLojaProduto):" + CategoriaLojaProdutoDadosParseBase.displayLog(correnteCategoriaLojaProduto));
		
		listaCategoriaLojaProduto.add(correnteCategoriaLojaProduto);
	}
	@Deprecated
	public void criaCorrenteCategoriaLojaProduto() {
		correnteCategoriaLojaProduto = FabricaVo.criaCategoriaLojaProduto();
	}
 		
	//PodePossuir 
	private	OportunidadeDia correnteOportunidadeDia;
	protected List<OportunidadeDia> listaOportunidadeDia = new ArrayList<OportunidadeDia>();
	
	// Adicionado em 01-08-2016
	public void adicionaOportunidadeDia(OportunidadeDia itemLista) {
		itemLista.setIdProdutoRa(itemDetalhe.getIdProduto());
		//ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrenteOportunidadeDia):" + OportunidadeDiaDadosParseBase.displayLog(correnteOportunidadeDia));
		listaOportunidadeDia.add(itemLista);
	}
	
	
	
	@Deprecated
	public OportunidadeDia getCorrenteOportunidadeDia() {
		return correnteOportunidadeDia;
	}
	@Deprecated
	public void adicionaCorrenteOportunidadeDia() {
		correnteOportunidadeDia.setIdProdutoRa(itemDetalhe.getIdProduto());
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrenteOportunidadeDia):" + OportunidadeDiaDadosParseBase.displayLog(correnteOportunidadeDia));
		
		listaOportunidadeDia.add(correnteOportunidadeDia);
	}
	@Deprecated
	public void criaCorrenteOportunidadeDia() {
		correnteOportunidadeDia = FabricaVo.criaOportunidadeDia();
	}
 		
	//Possui 
	private	PalavraProduto correntePalavraProduto;
	protected List<PalavraProduto> listaPalavraProduto = new ArrayList<PalavraProduto>();
	
	// Adicionado em 01-08-2016
	public void adicionaPalavraProduto(PalavraProduto itemLista) {
		itemLista.setIdProdutoRa(itemDetalhe.getIdProduto());
		//ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrentePalavraProduto):" + PalavraProdutoDadosParseBase.displayLog(correntePalavraProduto));
		listaPalavraProduto.add(itemLista);
	}
	
	
	
	@Deprecated
	public PalavraProduto getCorrentePalavraProduto() {
		return correntePalavraProduto;
	}
	@Deprecated
	public void adicionaCorrentePalavraProduto() {
		correntePalavraProduto.setIdProdutoRa(itemDetalhe.getIdProduto());
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrentePalavraProduto):" + PalavraProdutoDadosParseBase.displayLog(correntePalavraProduto));
		
		listaPalavraProduto.add(correntePalavraProduto);
	}
	@Deprecated
	public void criaCorrentePalavraProduto() {
		correntePalavraProduto = FabricaVo.criaPalavraProduto();
	}
 		
	//DivulgadoPor 
	private	FacebookPost correnteFacebookPost;
	protected List<FacebookPost> listaFacebookPost = new ArrayList<FacebookPost>();
	
	// Adicionado em 01-08-2016
	public void adicionaFacebookPost(FacebookPost itemLista) {
		itemLista.setIdProdutoD(itemDetalhe.getIdProduto());
		//ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrenteFacebookPost):" + FacebookPostDadosParseBase.displayLog(correnteFacebookPost));
		listaFacebookPost.add(itemLista);
	}
	
	
	
	@Deprecated
	public FacebookPost getCorrenteFacebookPost() {
		return correnteFacebookPost;
	}
	@Deprecated
	public void adicionaCorrenteFacebookPost() {
		correnteFacebookPost.setIdProdutoD(itemDetalhe.getIdProduto());
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrenteFacebookPost):" + FacebookPostDadosParseBase.displayLog(correnteFacebookPost));
		
		listaFacebookPost.add(correnteFacebookPost);
	}
	@Deprecated
	public void criaCorrenteFacebookPost() {
		correnteFacebookPost = FabricaVo.criaFacebookPost();
	}
 		
	//Gerou 
	private	CompartilhamentoProduto correnteCompartilhamentoProduto;
	protected List<CompartilhamentoProduto> listaCompartilhamentoProduto = new ArrayList<CompartilhamentoProduto>();
	
	// Adicionado em 01-08-2016
	public void adicionaCompartilhamentoProduto(CompartilhamentoProduto itemLista) {
		itemLista.setIdProdutoRa(itemDetalhe.getIdProduto());
		//ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrenteCompartilhamentoProduto):" + CompartilhamentoProdutoDadosParseBase.displayLog(correnteCompartilhamentoProduto));
		listaCompartilhamentoProduto.add(itemLista);
	}
	
	
	
	@Deprecated
	public CompartilhamentoProduto getCorrenteCompartilhamentoProduto() {
		return correnteCompartilhamentoProduto;
	}
	@Deprecated
	public void adicionaCorrenteCompartilhamentoProduto() {
		correnteCompartilhamentoProduto.setIdProdutoRa(itemDetalhe.getIdProduto());
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrenteCompartilhamentoProduto):" + CompartilhamentoProdutoDadosParseBase.displayLog(correnteCompartilhamentoProduto));
		
		listaCompartilhamentoProduto.add(correnteCompartilhamentoProduto);
	}
	@Deprecated
	public void criaCorrenteCompartilhamentoProduto() {
		correnteCompartilhamentoProduto = FabricaVo.criaCompartilhamentoProduto();
	}
 		
	
	public ProdutoDadosParseBase() {
		super();
		lista = new ArrayList<Produto>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public Produto getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(Produto item) {
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(Produto item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("Produto(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaProduto();
	}


	public void setItemDetalhe(Produto item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em ProdutoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em ProdutoDadosParse";
 	}

	
	private LojaVirtual _lojaVirtual_LidoEm; 
	
	@Deprecated
	public void setLojaVirtual_LidoEm(LojaVirtual item) {
		_lojaVirtual_LidoEm = item;
	}
	@Deprecated
	public LojaVirtual getLojaVirtual_LidoEm() {
		return _lojaVirtual_LidoEm;
	}
 	
	private Marca _marca_Possui; 
	
	@Deprecated
	public void setMarca_Possui(Marca item) {
		_marca_Possui = item;
	}
	@Deprecated
	public Marca getMarca_Possui() {
		return _marca_Possui;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getProdutoDao();
			dao.setConexao(getConexao());
			List<Produto> listaBanco = dao.ListaCorrente();
			List<Produto> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<Produto> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<Produto> it = listaInclusao.iterator();
			while (it.hasNext()) {
				Produto item = it.next();
				System.out.println("Produto Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<Produto> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				Produto item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(Produto item, ProdutoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(Produto item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(Produto item) {
		try {
			dao = DBB.getInstancia().getProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<Produto> subtraiListaPorNome(List<Produto> listaMaior, List<Produto> listaMenor) {
		Iterator<Produto> itMaior = listaMaior.iterator();
		Iterator<Produto> itMenor = null;
		List<Produto> listaDiferenca = new ArrayList<Produto>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			Produto corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				Produto comparador = itMenor.next();
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
	protected boolean iguais(Produto item1, Produto item2) {
		throw new RuntimeException("Fazer override em ProdutoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(Produto item) {
		return "Fazer override em ProdutoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaPrecoDiario.clear();
		listaModeloProdutoProduto.clear();
		listaPrecoProduto.clear();
		listaCategoriaLojaProduto.clear();
		listaOportunidadeDia.clear();
		listaPalavraProduto.clear();
		listaFacebookPost.clear();
		listaCompartilhamentoProduto.clear();
	
	}
	
	
	public void displayLogLista(List<Produto> lista, String codigo) {
		for (Produto item : lista) {
			ArquivoLog.getInstancia().salvaLog("Produto(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(Produto item) {
		StringBuffer display = new StringBuffer();
		display.append("Produto {");
		
		display.append("IdProduto:" + item.getIdProduto() + ";");
		
		display.append("UrlOrigem:" + item.getUrlOrigem() + ";");
		
		display.append("ImagemLocal:" + item.getImagemLocal() + ";");
		
		display.append("DataInclusao:" + item.getDataInclusao() + ";");
		
		display.append("Url:" + item.getUrl() + ";");
		
		display.append("Nome:" + item.getNome() + ";");
		
		display.append("PosicaoProduto:" + item.getPosicaoProduto() + ";");
		
		display.append("Imagem:" + item.getImagem() + ";");
		
		display.append("VerificacaoNomeOk:" + item.getVerificacaoNomeOk() + ";");
		
		display.append("IdLojaVirtualLe:" + item.getIdLojaVirtualLe() + ";");
		
		display.append("IdMarcaP:" + item.getIdMarcaP() + ";");
		
		
		
		if (item.getLojaVirtualLidoEm(false)!=null) {
			display.append("LojaVirtual{");
			display.append(LojaVirtualDadosParse.displayLog(item.getLojaVirtualLidoEm(false)));
			display.append("}");
		}
 		
		if (item.getMarcaPossui(false)!=null) {
			display.append("Marca{");
			display.append(MarcaDadosParse.displayLog(item.getMarcaPossui(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}