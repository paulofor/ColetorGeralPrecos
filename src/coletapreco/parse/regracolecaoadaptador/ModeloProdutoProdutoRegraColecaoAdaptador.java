package coletapreco.parse.regracolecaoadaptador;

import java.util.Iterator;
import java.util.List;

import coletapreco.dao.*;
import coletapreco.modelo.*;
import coletapreco.parse.callback.ModeloProdutoProdutoListaCallbackHtml;
import coletapreco.parse.callback.ModeloProdutoProdutoDetalheCallbackHtml;
import coletapreco.parse.dados.ModeloProdutoProdutoDadosParse;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.ICallbackParse;

// Instnaciar um filho desse.
public abstract class ModeloProdutoProdutoRegraColecaoAdaptador  {


	protected ExecutadorParse exec = null;
	protected ICallbackParse callbackLista = null;
	protected ICallbackParse callbackDetalhe = null;
	protected ModeloProdutoProdutoDadosParse dadosParse = null;
	
	public ModeloProdutoProdutoRegraColecaoAdaptador() {
		exec = new ExecutadorParse();
		dadosParse = new ModeloProdutoProdutoDadosParse();
	}
	private ICallbackParse getCallbackLista() {
		if (callbackLista==null) {
			callbackLista = criaListaCallbackHtml();
		}
		if (callbackLista==null) {
			System.out.println("ModeloProdutoProduto ID:" + this.getItemRaiz().getIdObj() + " nao possui Callback em " + this.getClass().getSimpleName() + ".criaListaCallbackHtml()");
		}
		return callbackLista;
	}
	private ICallbackParse getCallbackDetalhe() {
		if (callbackDetalhe==null) {
			callbackDetalhe = criaDetalheCallbackHtml();
		}
		if (callbackDetalhe==null) {
			System.out.println("ModeloProdutoProduto ID:" + this.getItemRaiz().getIdObj() + " nao possui Callback em " + this.getClass().getSimpleName() + ".criaDetalheCallbackHtml()");
		}
		return callbackDetalhe;
	}
	protected ICallbackParse criaListaCallbackHtml() {
		return new ModeloProdutoProdutoListaCallbackHtml();
	}
	protected ICallbackParse criaDetalheCallbackHtml() {
		return new ModeloProdutoProdutoDetalheCallbackHtml();
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
	
	protected void preparaDadosLista(ModeloProdutoProdutoDadosParse dados) {
	}
	
	// Atualiza todos os objetos do banco (retornado pelo dao.ListaCorrente )
	public void atualizaDetalhe(DaoConexao conexao) throws DaoException {
		ModeloProdutoProdutoDao daoFonte = DBB.getInstancia().getModeloProdutoProdutoDao(); // 
		daoFonte.setConexao(conexao);
		List<ModeloProdutoProduto> lista = daoFonte.ListaCorrente();
		Iterator<ModeloProdutoProduto> itLista = lista.iterator();
		while (itLista.hasNext()) {
			ModeloProdutoProduto corrente = itLista.next();
			atualizaDetalhe(corrente,conexao);
			
		}
		return;
	}
	
	// Atualiza apenas um objeto
	public final void atualizaDetalhe(ModeloProdutoProduto itemRaiz, DaoConexao conexao) throws DaoException {
		dadosParse.setItemDetalhe(itemRaiz);
		dadosParse.setConexao(conexao);
		preparaDadosDetalhe(dadosParse);
		exec.setCallbackParse(getCallbackDetalhe()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
	}
	protected void preparaDadosDetalhe(ModeloProdutoProdutoDadosParse dados) {
	}
	public ModeloProdutoProduto getItemRaiz() {
		return dadosParse.getItemDetalhe();
	}
	
	// Candidato para nao mais ser usado.
	private void atualizaItens(DaoConexao conexao) throws DaoException {
		// Passo 1 - Montagem do parse do objeto
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new ModeloProdutoProdutoListaCallbackHtml();
		ModeloProdutoProdutoDadosParse dadosParse = new ModeloProdutoProdutoDadosParse();
		dadosParse.setConexao(conexao);
		exec.setCallbackParse(callback);
		
		// Passo 2 - Montagem da fonte das urls
		ModeloProdutoProdutoDao daoFonte = DBB.getInstancia().getModeloProdutoProdutoDao(); // 
		daoFonte.setConexao(conexao);
		List<ModeloProdutoProduto> lista = daoFonte.ListaCorrente();
		Iterator<ModeloProdutoProduto> itLista = lista.iterator();
		while (itLista.hasNext()) {
			ModeloProdutoProduto corrente = itLista.next();
			dadosParse.setItemDetalhe(corrente);
			exec.setDadosParse(dadosParse);
			exec.executa();
		}
		return;
	} 

}