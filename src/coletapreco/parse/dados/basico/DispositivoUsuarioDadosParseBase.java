package coletapreco.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletapreco.dao.DispositivoUsuarioDao;
import coletapreco.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletapreco.parse.dados.*;
import coletapreco.modelo.*;
import coletapreco.log.ArquivoLog;
import org.json.JSONObject;



public abstract class DispositivoUsuarioDadosParseBase extends DadosParseDao {

	protected DispositivoUsuarioDao dao = null;
	protected DispositivoUsuario itemDetalhe = null;
	protected List<DispositivoUsuario> lista = null;
	
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
	// do Objeto DispositivoUsuario
	// Para listas usar itemCorrente.
	public DispositivoUsuario getItemDetalhe() {
		return itemDetalhe;
	}
	
	private DispositivoUsuario itemCorrente = null;
	
	
	public DispositivoUsuarioDadosParseBase() {
		super();
		lista = new ArrayList<DispositivoUsuario>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public DispositivoUsuario getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(DispositivoUsuario item) {
		ArquivoLog.getInstancia().salvaLog("DispositivoUsuario(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(DispositivoUsuario item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("DispositivoUsuario(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaDispositivoUsuario();
	}


	public void setItemDetalhe(DispositivoUsuario item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em DispositivoUsuarioDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em DispositivoUsuarioDadosParse";
 	}

	
	private Usuario _usuario_ReferenteA; 
	
	@Deprecated
	public void setUsuario_ReferenteA(Usuario item) {
		_usuario_ReferenteA = item;
	}
	@Deprecated
	public Usuario getUsuario_ReferenteA() {
		return _usuario_ReferenteA;
	}
 	
	private AppProduto _appProduto_Usa; 
	
	@Deprecated
	public void setAppProduto_Usa(AppProduto item) {
		_appProduto_Usa = item;
	}
	@Deprecated
	public AppProduto getAppProduto_Usa() {
		return _appProduto_Usa;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getDispositivoUsuarioDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getDispositivoUsuarioDao();
			dao.setConexao(getConexao());
			List<DispositivoUsuario> listaBanco = dao.ListaCorrente();
			List<DispositivoUsuario> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<DispositivoUsuario> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<DispositivoUsuario> it = listaInclusao.iterator();
			while (it.hasNext()) {
				DispositivoUsuario item = it.next();
				System.out.println("DispositivoUsuario Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<DispositivoUsuario> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				DispositivoUsuario item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(DispositivoUsuario item, DispositivoUsuarioDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(DispositivoUsuario item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(DispositivoUsuario item) {
		try {
			dao = DBB.getInstancia().getDispositivoUsuarioDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<DispositivoUsuario> subtraiListaPorNome(List<DispositivoUsuario> listaMaior, List<DispositivoUsuario> listaMenor) {
		Iterator<DispositivoUsuario> itMaior = listaMaior.iterator();
		Iterator<DispositivoUsuario> itMenor = null;
		List<DispositivoUsuario> listaDiferenca = new ArrayList<DispositivoUsuario>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			DispositivoUsuario corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				DispositivoUsuario comparador = itMenor.next();
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
	protected boolean iguais(DispositivoUsuario item1, DispositivoUsuario item2) {
		throw new RuntimeException("Fazer override em DispositivoUsuarioDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(DispositivoUsuario item) {
		return "Fazer override em DispositivoUsuarioDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<DispositivoUsuario> lista, String codigo) {
		for (DispositivoUsuario item : lista) {
			ArquivoLog.getInstancia().salvaLog("DispositivoUsuario(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(DispositivoUsuario item) {
		StringBuffer display = new StringBuffer();
		display.append("DispositivoUsuario {");
		
		display.append("IdDispositivoUsuario:" + item.getIdDispositivoUsuario() + ";");
		
		display.append("NumeroCelular:" + item.getNumeroCelular() + ";");
		
		display.append("CodigoDispositivo:" + item.getCodigoDispositivo() + ";");
		
		display.append("TipoAcesso:" + item.getTipoAcesso() + ";");
		
		display.append("MelhorPath:" + item.getMelhorPath() + ";");
		
		display.append("TokenGcm:" + item.getTokenGcm() + ";");
		
		display.append("TokenGcmMonitor:" + item.getTokenGcmMonitor() + ";");
		
		display.append("MicroSd:" + item.getMicroSd() + ";");
		
		display.append("DataChamada:" + item.getDataChamada() + ";");
		
		display.append("DataUltimoAcesso:" + item.getDataUltimoAcesso() + ";");
		
		display.append("DataCriacao:" + item.getDataCriacao() + ";");
		
		display.append("TemMudanca:" + item.getTemMudanca() + ";");
		
		display.append("Ativo:" + item.getAtivo() + ";");
		
		display.append("IdUsuarioRa:" + item.getIdUsuarioRa() + ";");
		
		display.append("IdAppProdutoU:" + item.getIdAppProdutoU() + ";");
		
		
		
		if (item.getUsuarioReferenteA(false)!=null) {
			display.append("Usuario{");
			display.append(UsuarioDadosParse.displayLog(item.getUsuarioReferenteA(false)));
			display.append("}");
		}
 		
		if (item.getAppProdutoUsa(false)!=null) {
			display.append("AppProduto{");
			display.append(AppProdutoDadosParse.displayLog(item.getAppProdutoUsa(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}