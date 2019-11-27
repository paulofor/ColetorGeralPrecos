package coletapreco.parse.regracolecaoadaptador;

import java.util.Iterator;
import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.ExecutadorParseApache;
import br.com.digicom.parse.ExecutadorParseApacheProxy;
import br.com.digicom.parse.callback.ICallbackParse;
import coletapreco.dao.CategoriaLojaDao;
import coletapreco.dao.DBB;
import coletapreco.modelo.CategoriaLoja;
import coletapreco.parse.callback.CategoriaLojaDetalheCallbackHtml;
import coletapreco.parse.callback.CategoriaLojaListaCallbackHtml;
import coletapreco.parse.dados.CategoriaLojaDadosParse;

// Instnaciar um filho desse.
public abstract class CategoriaLojaRegraColecaoAdaptador  {


	protected ExecutadorParseApache exec = null;
	protected ICallbackParse callbackLista = null;
	protected ICallbackParse callbackDetalhe = null;
	protected CategoriaLojaDadosParse dadosParse = null;
	
	public CategoriaLojaRegraColecaoAdaptador() {
		exec = new ExecutadorParseApache();
		dadosParse = new CategoriaLojaDadosParse();
	}
	private ICallbackParse getCallbackLista() {
		if (callbackLista==null) {
			callbackLista = criaListaCallbackHtml();
		}
		if (callbackLista==null) {
			System.out.println("CategoriaLoja ID:" + this.getItemRaiz().getIdObj() + " nao possui Callback em " + this.getClass().getSimpleName() + ".criaListaCallbackHtml()");
		}
		return callbackLista;
	}
	private ICallbackParse getCallbackDetalhe() {
		if (callbackDetalhe==null) {
			callbackDetalhe = criaDetalheCallbackHtml();
		}
		if (callbackDetalhe==null) {
			System.out.println("CategoriaLoja ID:" + this.getItemRaiz().getIdObj() + " nao possui Callback em " + this.getClass().getSimpleName() + ".criaDetalheCallbackHtml()");
		}
		return callbackDetalhe;
	}
	protected ICallbackParse criaListaCallbackHtml() {
		return new CategoriaLojaListaCallbackHtml();
	}
	protected ICallbackParse criaDetalheCallbackHtml() {
		return new CategoriaLojaDetalheCallbackHtml();
	}

	// Atualizar uma lista de objeto em uma p?gina sem referencia de objeto pai.
	// Exemplo Categorias em uma loja Virtual
	public final void atualizaLista(DaoConexao conexao)
			throws DaoException {
		
		dadosParse.setConexao(conexao);
		preparaDadosLista(dadosParse);
		exec.setCallbackParse(getCallbackLista()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
		return;
		
		/*
		// Passo 2 - Montagem da fonte das urls
		
		return;
		*/
	}
	
	protected void preparaDadosLista(CategoriaLojaDadosParse dados) {
	}
	
	// Atualiza todos os objetos do banco (retornado pelo dao.ListaCorrente )
	public void atualizaDetalhe(DaoConexao conexao) throws DaoException {
		CategoriaLojaDao daoFonte = DBB.getInstancia().getCategoriaLojaDao(); // 
		daoFonte.setConexao(conexao);
		List<CategoriaLoja> lista = daoFonte.ListaCorrente();
		Iterator<CategoriaLoja> itLista = lista.iterator();
		while (itLista.hasNext()) {
			CategoriaLoja corrente = itLista.next();
			atualizaDetalhe(corrente,conexao);
			
		}
		return;
	}
	
	// Atualiza apenas um objeto
	public final void atualizaDetalhe(CategoriaLoja itemRaiz, DaoConexao conexao) throws DaoException {
		dadosParse.setItemDetalhe(itemRaiz);
		dadosParse.setConexao(conexao);
		preparaDadosDetalhe(dadosParse);
		exec.setCallbackParse(getCallbackDetalhe()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
	}
	protected void preparaDadosDetalhe(CategoriaLojaDadosParse dados) {
	}
	public CategoriaLoja getItemRaiz() {
		return dadosParse.getItemDetalhe();
	}
	
	// Candidato para nao mais ser usado.
	private void atualizaItens(DaoConexao conexao) throws DaoException {
		// Passo 1 - Montagem do parse do objeto
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new CategoriaLojaListaCallbackHtml();
		CategoriaLojaDadosParse dadosParse = new CategoriaLojaDadosParse();
		dadosParse.setConexao(conexao);
		exec.setCallbackParse(callback);
		
		// Passo 2 - Montagem da fonte das urls
		CategoriaLojaDao daoFonte = DBB.getInstancia().getCategoriaLojaDao(); // 
		daoFonte.setConexao(conexao);
		List<CategoriaLoja> lista = daoFonte.ListaCorrente();
		Iterator<CategoriaLoja> itLista = lista.iterator();
		while (itLista.hasNext()) {
			CategoriaLoja corrente = itLista.next();
			dadosParse.setItemDetalhe(corrente);
			exec.setDadosParse(dadosParse);
			exec.executa();
		}
		return;
	} 

}