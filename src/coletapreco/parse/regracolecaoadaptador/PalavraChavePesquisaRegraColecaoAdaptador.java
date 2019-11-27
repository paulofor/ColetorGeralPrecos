package coletapreco.parse.regracolecaoadaptador;

import java.util.Iterator;
import java.util.List;

import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.parse.callback.PalavraChavePesquisaListaCallbackHtml;
import coletapreco.parse.callback.PalavraChavePesquisaDetalheCallbackHtml;
import coletapreco.parse.dados.PalavraChavePesquisaDadosParse;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.ICallbackParse;

// Instnaciar um filho desse.
public abstract class PalavraChavePesquisaRegraColecaoAdaptador  {


	protected ExecutadorParse exec = null;
	protected ICallbackParse callbackLista = null;
	protected ICallbackParse callbackDetalhe = null;
	protected PalavraChavePesquisaDadosParse dadosParse = null;
	
	public PalavraChavePesquisaRegraColecaoAdaptador() {
		exec = new ExecutadorParse();
		dadosParse = new PalavraChavePesquisaDadosParse();
	}
	private ICallbackParse getCallbackLista() {
		if (callbackLista==null) {
			callbackLista = criaListaCallbackHtml();
		}
		if (callbackLista==null) {
			System.out.println("PalavraChavePesquisa ID:" + this.getItemRaiz().getIdObj() + " nao possui Callback em " + this.getClass().getSimpleName() + ".criaListaCallbackHtml()");
		}
		return callbackLista;
	}
	private ICallbackParse getCallbackDetalhe() {
		if (callbackDetalhe==null) {
			callbackDetalhe = criaDetalheCallbackHtml();
		}
		if (callbackDetalhe==null) {
			System.out.println("PalavraChavePesquisa ID:" + this.getItemRaiz().getIdObj() + " nao possui Callback em " + this.getClass().getSimpleName() + ".criaDetalheCallbackHtml()");
		}
		return callbackDetalhe;
	}
	protected ICallbackParse criaListaCallbackHtml() {
		return new PalavraChavePesquisaListaCallbackHtml();
	}
	protected ICallbackParse criaDetalheCallbackHtml() {
		return new PalavraChavePesquisaDetalheCallbackHtml();
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
	
	protected void preparaDadosLista(PalavraChavePesquisaDadosParse dados) {
	}
	
	// Atualiza todos os objetos do banco (retornado pelo dao.ListaCorrente )
	public void atualizaDetalhe(DaoConexao conexao) throws DaoException {
		PalavraChavePesquisaDao daoFonte = DBB.getInstancia().getPalavraChavePesquisaDao(); // 
		daoFonte.setConexao(conexao);
		List<PalavraChavePesquisa> lista = daoFonte.ListaCorrente();
		Iterator<PalavraChavePesquisa> itLista = lista.iterator();
		while (itLista.hasNext()) {
			PalavraChavePesquisa corrente = itLista.next();
			atualizaDetalhe(corrente,conexao);
			
		}
		return;
	}
	
	// Atualiza apenas um objeto
	public final void atualizaDetalhe(PalavraChavePesquisa itemRaiz, DaoConexao conexao) throws DaoException {
		dadosParse.setItemDetalhe(itemRaiz);
		dadosParse.setConexao(conexao);
		preparaDadosDetalhe(dadosParse);
		exec.setCallbackParse(getCallbackDetalhe()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
	}
	protected void preparaDadosDetalhe(PalavraChavePesquisaDadosParse dados) {
	}
	public PalavraChavePesquisa getItemRaiz() {
		return dadosParse.getItemDetalhe();
	}
	
	// Candidato para nao mais ser usado.
	private void atualizaItens(DaoConexao conexao) throws DaoException {
		// Passo 1 - Montagem do parse do objeto
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new PalavraChavePesquisaListaCallbackHtml();
		PalavraChavePesquisaDadosParse dadosParse = new PalavraChavePesquisaDadosParse();
		dadosParse.setConexao(conexao);
		exec.setCallbackParse(callback);
		
		// Passo 2 - Montagem da fonte das urls
		PalavraChavePesquisaDao daoFonte = DBB.getInstancia().getPalavraChavePesquisaDao(); // 
		daoFonte.setConexao(conexao);
		List<PalavraChavePesquisa> lista = daoFonte.ListaCorrente();
		Iterator<PalavraChavePesquisa> itLista = lista.iterator();
		while (itLista.hasNext()) {
			PalavraChavePesquisa corrente = itLista.next();
			dadosParse.setItemDetalhe(corrente);
			exec.setDadosParse(dadosParse);
			exec.executa();
		}
		return;
	} 

}